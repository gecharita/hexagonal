package com.gecharita;

import com.gecharita.hexagonal.adapters.primary.console.PersonConsole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

@SpringBootApplication
public class DDDApplication { //implements CommandLineRunner {



//	private final PersonConsole personConsole;

	public static void main(String[] args) {
		SpringApplication.run(DDDApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Enter word!");
//		try (Scanner scanner = new Scanner(System.in)){
//			String line = scanner.nextLine();
//			LOG.info(line);
//			String[] fields = line.split("-");
//			String name = fields[0];
//			String address = fields[1];
//			String age = fields[2];
//			personConsole.create(name, address, Integer.parseInt(address));
//		}
//	}
}
