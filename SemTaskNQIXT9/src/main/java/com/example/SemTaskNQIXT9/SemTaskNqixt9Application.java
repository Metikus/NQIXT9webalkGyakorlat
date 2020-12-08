package com.example.SemTaskNQIXT9;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SemTaskNqixt9Application {

	public static void main(String[] args) {
		SpringApplication.run(SemTaskNqixt9Application.class, args);
		
		System.out.println("Press 'Enter' to terminate");
        new Scanner(System.in).nextLine();
        System.out.println("Exiting");
        System.exit(1);
	}

}