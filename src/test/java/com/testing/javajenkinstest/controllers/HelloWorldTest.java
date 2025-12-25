package com.testing.javajenkinstest.controllers;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldTest {
    @Test
    public void check_add(){
        HelloWorld h=new HelloWorld();
        int res=h.add(1,2);
        assertEquals(3,res,"It is correct");
        System.out.println("It is correct");
    }
}
