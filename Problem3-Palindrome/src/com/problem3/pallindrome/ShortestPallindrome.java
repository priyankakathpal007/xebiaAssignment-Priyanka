package com.problem3.pallindrome;

import java.util.Scanner;

public class ShortestPallindrome {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
	    System.out.printf("Please specify how many lines you want to enter: ");        
	    String[] textStrings = new String[scan.nextInt()];
	    scan.nextLine();

	    for (int i = 0; i < textStrings.length; i++) {
	    	textStrings[i] = scan.nextLine();
	    }
	    
	    System.out.printf("Output:\n");
	    for (String s : textStrings) {
	    	if(isPalindrome(s)){
	    		System.out.printf(s);
	    	}else {
	    		System.out.printf(s);
	    		for(int i = s.length()-2;i>=0;i--) {
	    			System.out.print(s.charAt(i));
	    		}
	    	}
	    	System.out.printf("\n");
	    }
	}
	
	public static Boolean isPalindrome(String s) {
		Boolean isPalindrome = true;
		for(int i=0;i<Math.floor(s.length()/2);i++) {
			if(s.charAt(i) != s.charAt(s.length()-i-1)) {
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}

}
