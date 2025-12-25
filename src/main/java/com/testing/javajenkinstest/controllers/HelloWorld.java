package com.testing.javajenkinstest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	public int add(int a,int b){
        return a+b;
    }
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World";
	}

    @GetMapping("/add")
    public String addContorller(@RequestParam int a,@RequestParam int b){
        return "Total "+add(a,b);
    }
	
}
