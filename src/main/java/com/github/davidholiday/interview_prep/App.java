package com.github.davidholiday.interview_prep;


import com.github.davidholiday.interview_prep.com.github.davidholiday.interview_prep.springboot.HelloApplication;
import org.springframework.boot.SpringApplication;

public class App {

    public static void main( String[] args ) {
        //System.out.println( "main doesn't do anything -- try running the JUnit suite..." );
        SpringApplication.run(HelloApplication.class, args);
    }

}
