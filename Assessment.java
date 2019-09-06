package com.qa.javaAssessment;

import java.util.Arrays;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""
	
	
	// Counts the instances of "bert" in input
	
	public int findBerts(String input) {
		int index = 0;
	    int count = 0;

	    while(index != -1){

	        index = input.indexOf("bert",index);

	        if(index != -1){
	            count ++;
	            index += "bert".length();
	        }
	    }
	    
	   return count;
	}

	// Converts to lowercase, checks for two instances of "bert"
	
	public String getBert(String input) {
		String lcword = input.toLowerCase();
		if (findBerts(lcword)!=2) {
		    return "";
		}

	// trims either side of the input based on "berts" then reverses
		
		else {
		String lstrim = lcword.substring(lcword.indexOf("bert")+4);
		String rstrim = lstrim.substring(0, lstrim.indexOf("bert"));
		String reversed = "";
	    for(int i=rstrim.length()-1; i>=0; i--) {
	       reversed = reversed + rstrim.charAt(i);
	    }   
		return reversed;
		}
	}
		
	

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		int numbers [] = {a,b,c};
		
	// converts input to an array then sorts into ascending order	
		
		Arrays.sort(numbers);
		
	// checks if difference between large and med equals med and small 	
		
		if (numbers[2] - numbers[1] == numbers[1] - numbers[0]) {
		    return true;
		}
		
		else {
		return false;
		}
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		int b = input.length();
		
	// makes sure both the input size and 'middle' size are odd	
		
		if (b > a && b % 2 + a % 2 == 2) {
			
	// finds index of upper and lower bounds		
			
		int lowerBound = b/2 - a/2;	
		int upperBound = b/2 + a/2 + 1;
		
	// trims based on bounds, then concatenates
		
		String front = input.substring(0, lowerBound);
		String back = input.substring(upperBound, b);
		
		return front + back;
		}
		
		else {
		return "";
		}
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		int count = 1;
		int highestCount = 0;
		
	// count automatically 1 if the input is not ""
		
		for (int i = 0; i< input.length()-1; i++) {
			if (count >= highestCount) {
				highestCount = count;
			}
			
	// increase count if ith letter is equal to i+1		
			
			if (input.charAt(i) == input.charAt(i+1)) {
				count ++;			
            }
			
	// set count back to 1 otherwise		
			
			else {
				count = 1;
			}
		}
		
		return highestCount;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		
	// only finds "am" between spaces, so have added spaces to either side of lower cased input	
		
		String lcword = " " + arg1.toLowerCase() + " ";
		int index = 0;
	    int count = 0;

	    while(index != -1){

	        index = lcword.indexOf(" am ",index);
	        
	 // increases count, but importantly only cycles through " am" rather than " am "
	 // means that instances of repeated "am"s will still be counted       

	        if(index != -1){
	            count ++;
	            index += " am".length();
	        }
	    }
	    
    
	    return count;
	}
	
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		if (arg1 % 3 == 0 && arg1 % 5 == 0) {
			return "fizzbuzz";
		}
		if (arg1 % 3 == 0) {
			return "fizz";
		}
		if (arg1 % 5 == 0) {
			return "buzz";
		}
		else {
		return null;
		}
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	
	// small function to add digits using mod 10 arithmetic
	
	
	public int addDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum; 
}
	
	
	public int largest(String arg1) {
		
		// converts string into array
		
		String[] stringArray = arg1.split(" ");
	      int[] intArray = new int[stringArray.length];
	      for (int i = 0; i < stringArray.length; i++) {
	         String numberAsString = stringArray[i];
	         intArray[i] = Integer.parseInt(numberAsString);
	      }
	      
	    // creates array of the digit sums using the addDigits function  
	      
	      int[] digitSumArray = new int[intArray.length];
	      
	      for (int i = 0; i < intArray.length; i++) {
	    	  digitSumArray[i] = addDigits(intArray[i]);
	      }
	    
	   // sorts into ascending order then returns final entry in array  
	      
	      Arrays.sort(digitSumArray);
	      
	      
	      return digitSumArray[(digitSumArray.length)-1];
	}

}
