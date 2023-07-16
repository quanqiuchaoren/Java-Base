package com.lhy.java.base.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SkipTest {
    @Test
    void skip(){
        Arrays.stream(new int[]{1, 2, 3, 4, 5}).skip(1).forEach(System.out::println);
    }
}
