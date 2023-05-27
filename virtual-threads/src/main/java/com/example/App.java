package com.example;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static java.lang.Thread.*;

public class App {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("lower bound,upper bound, and number of threads are required arguments");
            System.exit(1);
        }

        int min = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        int numTasks = Integer.parseInt(args[2]);

        final Random random = new Random();
        final ThreadFactory factory = ofVirtual().name("Thread-", 1).factory();

        try (var executor = Executors.newThreadPerTaskExecutor(factory)) {
            System.out.printf("*%n* Results - %d Tasks%n*%n", numTasks);
            for (var i = 1; i <= numTasks; i++) {
                var nthPrime = random.nextInt(max - min) + min;
                var task = new Task(nthPrime);
                executor.submit(task);
            }
        }
    }

    static class Task implements Runnable {
        private final int nth;
        private int count = 0;
        private int prime;

        public Task(int nth) {
            this.nth = nth;
        }

        @Override
        public void run() {
            this.calcNthPrime();
            this.printResult();
        }

        private void calcNthPrime() {
            int num = 2;
            while (this.count != this.nth) {
                if (this.isPrime(num)) {
                    prime = num;
                    count += 1;
                }
                num += 1;
            }
        }

        private boolean isPrime(long number) {
            if (number == 1) {
                return false;
            }
            if (number == 2) {
                return true;
            }
            if (number % 2 == 0) {
                return false;
            }
            for (int d = 3; d <= (int) Math.sqrt(number); d++) {
                if (number % d == 0) {
                    return false;
                }
            }
            return true;
        }

        private void printResult() {
            String tmpl = "%s returned %,d as the %,d%s prime%n";
            System.out.printf(tmpl, Thread.currentThread().getName(), this.prime, this.nth, this.getSuffix(nth));
        }

        private String getSuffix(long nth) {
            int lastDigit = (int) nth % 10;
            return switch (lastDigit) {
                case 1 -> "st";
                case 2 -> "nd";
                case 3 -> "rd";
                default -> "th";
            };
        }
    }
}
