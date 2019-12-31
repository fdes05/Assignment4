package com.FabioAssignment4;

import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication2 {

	static Scanner scanner = new Scanner(System.in);
	private static int superUserInput = -1;
	private static int normalUserInput = -1;
	static ExtendedUser extendedUser = new ExtendedUser();
	static User matchedUser;

	public static void main(String[] args) throws IOException {

		UserService2 userService = new UserService2();

		userService.userLoginInfo();

		for (int i = 1; i <= 5; i++) {
			String username = promptForInput("Please type your username: ");
			String password = promptForInput("Please type your password: ");
			matchedUser = userService.compareUserInputToFile(username, password);

			if (matchedUser != null) {
				System.out.println("Welcome " + matchedUser.getName());

				boolean superUserLevel = extendedUser.verifySuperUser(matchedUser);
				while (superUserLevel == true) {
					superUserInput = superUserPrompt();
					if (superUserInput == 0) {
						String normalUser = promptForInput2("Which user would you like to login as?");
						String normalUserName = normalUserNameVerification(normalUser);
						String normalUserPassword = normalUserPasswordVerification(normalUser);
						if (normalUserName != null) {
							System.out.println("Welcome: " + normalUserName);
							normalUserInput = 10;
							matchedUser = userService.compareUserInputToFile(normalUser, normalUserPassword);
							superUserLevel = false;
							break;
						} else {
							System.out.println("There is no such user!");
							System.out.println("Exiting...");
							System.exit(0);
						}

					} else if (superUserInput == 1) {
						System.out.println("Please type the new username");
						scanner.nextLine();
						String newUsername = scanner.nextLine();
						extendedUser.usernameChange(newUsername, matchedUser);

					} else if (superUserInput == 2) {
						System.out.println("Please type the new password");
						scanner.nextLine();
						String newPassword = scanner.nextLine();
						extendedUser.passwordChange(newPassword, matchedUser);

					} else if (superUserInput == 3) {
						System.out.println("Please type the new name");
						scanner.nextLine();
						String newName = scanner.nextLine();
						extendedUser.nameChange(newName, matchedUser);

					} else if (superUserInput == 4) {
						System.out.println("Exiting...");
						System.exit(0);
					} else {
						System.out.println("This is not a valid option! Please try again.");
					}

				}

				while (superUserLevel != true) {
					normalUserInput = normalUserPrompt();
					if (normalUserInput == 0) {
						System.out.println("Please type the new username");
						scanner.nextLine();
						String newUsername = scanner.nextLine();
						extendedUser.usernameChange(newUsername, matchedUser);

					} else if (normalUserInput == 1) {
						System.out.println("Please type the new password");
						scanner.nextLine();
						String newPassword = scanner.nextLine();
						extendedUser.passwordChange(newPassword, matchedUser);

					} else if (normalUserInput == 2) {
						System.out.println("Please type the new name");
						scanner.nextLine();
						String newName = scanner.nextLine();
						extendedUser.nameChange(newName, matchedUser);

					} else if (normalUserInput == 3) {
						System.out.println("Exiting...");
						System.exit(0);
					} else if (normalUserInput == 10) {

					} else {
						System.out.println("This is not a valid option! Please try again.");
					}

				}

			} else if (i >= 5) {
				System.out.println("Too many failed login attempts, you are now locked out!");
				break;
			} else {
				System.out.println("Username and password are not valid! Please try again.");
			}
		}

	}

	private static String normalUserNameVerification(String normalUser) {
		for (User users : UserService2.userCredentialsArray) {
			if (users.getUsername().equals(normalUser)) {
				return users.getName();
			}
		}
		return null;
	}
	
	private static String normalUserPasswordVerification(String normalUser) {
		for (User users : UserService2.userCredentialsArray) {
			if (users.getUsername().equals(normalUser)) {
				return users.getPassword();
			}
		}
		return null;
	}

	public static String promptForInput(String promptMessage) {
		System.out.println(promptMessage);
		String property = scanner.nextLine();
		return property;
	}

	public static String promptForInput2(String promptMessage) {
		System.out.println(promptMessage);
		scanner.nextLine();
		String property = scanner.nextLine();
		return property;
	}

	public static int superUserPrompt() {
		System.out.println("Please choose from the following options:\n" + "(0)Log in as another user\n"
				+ "(1)Update username\n" + "(2)Update password\n" + "(3)Update name\n" + "(4)Exit");

		int answer = scanner.nextInt();
		if (answer >= 0 && answer <= 4) {
			return answer;
		}
		return -1;
	}

	public static int normalUserPrompt() {
		System.out.println("Please choose from the following options:\n" + "(0)Update username\n"
				+ "(1)Update password\n" + "(2)Update name\n" + "(3)Exit");
		int answer = scanner.nextInt();
		if (answer >= 0 && answer <= 3) {
			return answer;
		}
		return -1;

	}

}
