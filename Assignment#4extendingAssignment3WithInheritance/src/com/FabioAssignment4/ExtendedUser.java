package com.FabioAssignment4;

import java.io.IOException;
import java.util.Arrays;

public class ExtendedUser extends User {

	UserService2 userService = new UserService2();
	User[] userCredentialsArray = UserService2.userCredentialsArray;
	User matchedUser;

	public boolean verifySuperUser(User matchedUser) {

		String superUser = matchedUser.getRole();

		if (superUser.equals("super_user")) {
			return true;
		}
		return false;
	}

	public void usernameChange(String username, User matchedUser) throws IOException {
		String correctedUsername = username;
		matchedUser.setUsername(correctedUsername);
		System.out.println("The updated users is as follows: " + matchedUser.getUsername() + matchedUser.getPassword()
				+ matchedUser.getName());
		Arrays.sort(userCredentialsArray);
		System.out.println("-----Sorted-----");
		for (int i = 0; i < UserService2.userCredentialsArray.length; i++) {
			System.out.println((userCredentialsArray[i].getUsername()) + " " + (userCredentialsArray[i].getPassword())
					+ " " + (userCredentialsArray[i].getName()) + " " + (userCredentialsArray[i].getRole()));
		}
		userService.userLoginWriting(userCredentialsArray);
	}

	public void passwordChange(String password, User matchedUser) throws IOException {
		String correctedPassword = password;
		matchedUser.setPassword(correctedPassword);
		System.out.println("The updated users is as follows: " + matchedUser.getUsername() + matchedUser.getPassword()
				+ matchedUser.getName());
		Arrays.sort(userCredentialsArray);
		System.out.println("-----Sorted-----");
		for (int i = 0; i < UserService2.userCredentialsArray.length; i++) {
			System.out.println((userCredentialsArray[i].getUsername()) + " " + (userCredentialsArray[i].getPassword())
					+ " " + (userCredentialsArray[i].getName()) + " " + (userCredentialsArray[i].getRole()));
		}
		userService.userLoginWriting(userCredentialsArray);
	}

	public void nameChange(String name, User matchedUser) throws IOException {
		String correctedName = name;
		matchedUser.setName(correctedName);
		System.out.println("The updated users is as follows: " + matchedUser.getUsername() + matchedUser.getPassword()
				+ matchedUser.getName());
		Arrays.sort(userCredentialsArray);
		System.out.println("-----Sorted-----");
		for (int i = 0; i < UserService2.userCredentialsArray.length; i++) {
			System.out.println((userCredentialsArray[i].getUsername()) + " " + (userCredentialsArray[i].getPassword())
					+ " " + (userCredentialsArray[i].getName()) + (userCredentialsArray[i].getRole()));
		}
		userService.userLoginWriting(userCredentialsArray);
	}

}