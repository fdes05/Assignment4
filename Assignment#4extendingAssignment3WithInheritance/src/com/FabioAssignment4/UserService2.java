package com.FabioAssignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserService2 {

	static User[] userCredentialsArray = new User[20];

	public User createUser(String username, String password, String name, String role) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setRole(role);
		return user;
	}

	public void userLoginInfo() throws IOException {

		String[] userCredentials = null;

		BufferedReader fileReader = null;

		try {
			fileReader = new BufferedReader(new FileReader("users.txt"));

			String line = "";
			int i = 0;
			while ((line = fileReader.readLine()) != null) {

				userCredentials = line.split(", ");
				String username = (userCredentials[0]);
				String password = (userCredentials[1]);
				String name = (userCredentials[2]);
				String role = (userCredentials[3]);

				userCredentialsArray[i] = createUser(username, password, name, role);
				i++;
			}

		} catch (FileNotFoundException e) {
			System.out.println("File was not found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("I/O Exception");
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
		}

		for (int i = 0; i < userCredentialsArray.length; i++) {
			System.out.println((userCredentialsArray[i].getUsername()) + " " + (userCredentialsArray[i].getPassword())
					+ " " + (userCredentialsArray[i].getName()) + " " + (userCredentialsArray[i].getRole()));
		}

	}

	public User compareUserInputToFile(String username, String password) {

		String usernameInput = username;
		String passwordInput = password;

		for (int i = 0; i < userCredentialsArray.length; i++) {
			String usernameA = userCredentialsArray[i].getUsername();
			String passwordA = userCredentialsArray[i].getPassword();

			if (usernameA.equalsIgnoreCase(usernameInput) && passwordA.equals(passwordInput)) {
				return userCredentialsArray[i];
			}

		}
		return null;

	}

	public void userLoginWriting(User[] userCredentials) throws IOException {

		BufferedWriter fileWriter = null;

		try {
			fileWriter = new BufferedWriter(new FileWriter("users.txt"));

			String line = "";
			String username;
			String password;
			String name;
			String role;

			for (int i = 0; i < userCredentials.length; i++) {
				username = userCredentials[i].getUsername();
				password = userCredentials[i].getPassword();
				name = userCredentials[i].getName();
				role = userCredentials[i].getRole();
				line = username + ", " + password + ", " + name + ", " + role;
				fileWriter.write(line + "\n");
			}

		} catch (FileNotFoundException e) {
			System.out.println("File was not found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("I/O Exception");
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				fileWriter.close();
			}
		}

		for (int i = 0; i < userCredentialsArray.length; i++) {
			System.out.println(("Line has been writen to file: " + userCredentialsArray[i].getUsername()) + " "
					+ (userCredentialsArray[i].getPassword()) + " " + (userCredentialsArray[i].getName()) + " "
					+ (userCredentialsArray[i].getRole()));
		}
	}

}
