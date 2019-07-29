package com.github.bingoohuang.execjar;

import lombok.SneakyThrows;

/**
 * Just a main class.
 */
public class Main {

    /**
     * A main method of this program which finds two classes and prints their names
     * from guava and guice, respectively.
     *
     * @param args command line arguments.
     */
    @SneakyThrows
    public static void main(String[] args) {
        System.out.println(Class.forName("com.google.common.io.BaseEncoding"));
    }
}
