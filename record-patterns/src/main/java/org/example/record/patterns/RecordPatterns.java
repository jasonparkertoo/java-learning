package org.example.record.patterns;

public class RecordPatterns {

    public int java16PatternMatching(Object obj) {
        int n1 = 0, n2 = 0;
        if (obj instanceof Input in) {
            n1 = in.n1();
            n2 = in.n2();
        }
        return n1 + n2;
    }

    public int recordDeconstruction(Object obj) {
        int result = 0;
        if (obj instanceof Input(int n1, int n2)) {
            result = n1 + n2;
        }
        return result;
    }

    record Input(int n1, int n2) {
    }
}

