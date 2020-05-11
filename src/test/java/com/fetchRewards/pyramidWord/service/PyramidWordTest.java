package com.fetchRewards.pyramidWord.service;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PyramidWordTest {
    PyramidWord pyramidWord = new PyramidWord();

    @Test
    public void pyramid(){
        String word = "banana";
        assertTrue(pyramidWord.isPyramid(word));
        word = "bandana";
        assertFalse(pyramidWord.isPyramid(word));
        word = "appbbb";
        assertTrue(pyramidWord.isPyramid(word));
        word = "a";
        assertTrue(pyramidWord.isPyramid(word));
        assertFalse(pyramidWord.isPyramid(null));
        // starting with 1 and continuing without gaps and without duplicates.
        word = "aana";
        assertFalse(pyramidWord.isPyramid(word));
        word = "aanna";
        assertFalse(pyramidWord.isPyramid(word));
    }
}
