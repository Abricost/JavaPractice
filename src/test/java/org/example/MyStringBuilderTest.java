package org.example;

import org.example.core.MyStringBuilder;
import org.junit.jupiter.api.Test;

class MyStringBuilderTest {

    @Test
    void myTest() {
        MyStringBuilder myStringBuilder = new MyStringBuilder("hello1");
        System.out.println(myStringBuilder);

        System.out.println(myStringBuilder.undo());

        System.out.println(myStringBuilder.append("hello2"));
        System.out.println(myStringBuilder.append("hello3"));

        System.out.println(myStringBuilder.undo());
        System.out.println(myStringBuilder.undo());
    }
}