package com.example.wsbenchmark;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class TempTest {

    @Test
    void name() {
        String[] args = new String[]{"1", "2"};

        System.out.println(Arrays.toString(args));
        System.out.println(Arrays.toString(args.clone()));
    }
}
