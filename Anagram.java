/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare    ","I am a weakish speller   ")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// I created 2 new strings that are the result of the original strings after
		// the preProcess function.
		String str3 = preProcess(str1);
		String str4 = preProcess(str2);
		boolean anagram = true;
		// If the 2 anagrams are empty the function returns true, but if only one of them
		// is empty it returns false
		if ((str3 == "") && (str4 == "")) {
			return true;
		} else if (((str3 == "") && (str4 != "")) || ((str3 != "") && (str4 == ""))) {
			anagram = false;
		}
		
		// If the number of characters in both the string are equal the function returns true,
		// otherwise it returns false
        for (int i = 0; i < str4.length(); i++) {
            if (countChar(str4, str4.charAt(i)) != countChar(str3, str4.charAt(i))) {
                anagram = false;
                break;
            }
        }
		return anagram;
	}

	// Returns the number of times a char appears in the given string.
	public static int countChar (String str, char c) {
        int count = 0;
		if (c == ' ') {
			return 0;
		}
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

	// I created a function that turn the string into only lowercase letters
	// by using the characters ascii numbers and checking if they are in the 
	// Uppercase range, and if so, i add 32 to make them their lowercase alternative
	public static String lowerCase(String str) {
		String newstr = "";
		for (int i = 0; i <= str.length()-1; i++) {
			char c = str.charAt(i);
			if ((c >= 65) && (c <= 90)) {
				c += 32;
			} 
			newstr += c;
		}
		return newstr;
	}

	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String str3 = lowerCase(str);
		// I created a string that has all the punctuation marks, so that i can compare
		// it to the string.
		String punctuation = ",:/.;?!-*_()[]*\\\"\\'&@$~^|\"";
		String finalString1 = "";

		// Only if the character in the string isn't a punctuation mark, I add it to 
		// the finalstring
		// 
		for(int i = 0; i <= str3.length() - 1; i++) {
			if (punctuation.indexOf(str3.charAt(i)) == -1) {        
				finalString1 += str3.charAt(i);
			}
		}
		return finalString1;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String str1 = str;
		String randomAnagram = "";
        String work = "";
        while (str1.length() > 0) {
			// I generated a random index of the string that ranges between 0 and the length of 
			// the string minus 1
            int randomIndex = (int)(Math.random() * (str1.length() - 1));
            char c = str1.charAt(randomIndex);
            randomAnagram += c;
			// I saved the string into a string "work" so that when i make the original string
			// a substring of itself, i dont lose the other part of the string
            work = str1;
			// I removed the random index i generated from the string
            str1 = work.substring(0, randomIndex);
            str1 += work.substring(randomIndex + 1);
        }
		return randomAnagram;
	}

	
}
