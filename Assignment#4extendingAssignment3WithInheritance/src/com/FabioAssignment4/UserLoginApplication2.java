package com.FabioAssignment4;

import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication2 {

	static Scanner scanner = new Scanner(System.in);

	
	public static void main(String[] args) throws IOException {

		UserService2 userService = new UserService2();
			
		userService.userLoginInfo();
				
		for (int i = 1; i <= 5; i++) {
			String username = promptForInput("Please type your username: ");
			String password = promptForInput("Please type your password: ");
			User matchedUser = userService.compareUserInputToFile (username, password);
		
			if (matchedUser != null) {
				System.out.println("Welcome " + matchedUser.getName());
				break;
			}else if (i >= 5) {
				System.out.println("Too many failed login attempts, you are now locked out!");
				break;
			}else {
				System.out.println("Username and password are not valid! Please try again.");
			}
		}
	}

	
	public static String promptForInput(String promptMessage) {
		System.out.println(promptMessage);
		String property = scanner.nextLine();
		return property;
	}
	
}
