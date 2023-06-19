package org.example.record.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecordPatternsTest {

    RecordPatterns recordPatterns = new RecordPatterns();

    @Test
    void java16PatternMatching() {
        int result = recordPatterns.java16PatternMatching(new RecordPatterns.Input(1, 2));
        assertEquals(3, result);
    }

    @Test
    void recordDeconstruction() {
        int result = recordPatterns.recordDeconstruction(new RecordPatterns.Input(1, 2));
        assertEquals(3, result);
    }
}