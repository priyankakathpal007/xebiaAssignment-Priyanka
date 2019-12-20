package com.problem2.sendingmails;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SendingMails {
	public static void main(String[] args) {
		String emailAddress = "email1";
		String message = "Hi Guys";
		String[][] friendsArray = new String[3][2];
		friendsArray[0][0] = "email1";
		friendsArray[0][1] = "email3,email5,email10";
		friendsArray[1][0] = "email2";
		friendsArray[1][1] = "email1,email3,email8";
		friendsArray[2][0] = "email3";
		friendsArray[2][1] = "email1,email4,email7,email9";

		SendingMails sm = new SendingMails();
		sm.sendMail(emailAddress, message, friendsArray);
	}

	void sendMail(String emailAddress, String message, String[][] friendsArray) {
		List<String> sendEmailList = new ArrayList<String>();
		Set<String> sentEmailList = new HashSet<String>();
		Boolean continueProcess = true;
		List<String> friendsList = new ArrayList<String>();

		sendEmailList.add(emailAddress);

		while (continueProcess) {
			for (String email : sendEmailList) {
				if (!sentEmailList.contains(email)) {
					sendMail(email, message);
					friendsList.addAll(findAndAddFriends(email, friendsArray));
					sentEmailList.add(email);
				}
			}
			if (friendsList.size() > 0) {
				sendEmailList.addAll(friendsList);
				friendsList = new ArrayList<String>();
			} else {
				continueProcess = false;
			}
		}
	}

	public static void sendMail(String emailAddress, String message) {
		System.out.println("Sending Email to : " + emailAddress + " and message : " + message);
	}

	public static List<String> findAndAddFriends(String email, String[][] friendsArray) {
		List<String> friendsList = new ArrayList<String>();
		for (int row = 0; row < friendsArray.length; row++) {
			if (friendsArray[row][0].equals(email)) {
				String[] friends = friendsArray[row][1].split(",");
				for (String friend : friends) {
					friendsList.add(friend);
				}
				break;
			}
		}
		return friendsList;
	}
}
