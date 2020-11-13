package testCases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {
	
//	a. \d implies digit.
//	b. + sign implies one or more occurance of previous character.
//	c. \. -> since . is a special character in regex, we have to escape it with \.
//	d. Also, \ is a special escape character in java , hence from java perspective we need to add an additional \ to escape the backslash (\).

	public static void main(String[] args) {
//		Pattern patt = Pattern.compile("(\\w+)\\s(\\d+)");
//		Matcher matcher = patt.matcher("Bananas 123");
//		matcher.lookingAt();
//		System.out.println("Name: " + matcher.group(1));
//		System.out.println("Number: " + matcher.group(2));
//
//		Pattern pat = Pattern.compile("e.+?d");
//		Matcher mat = pat.matcher("extend cup end table");
//
//		while (mat.find())
//			System.out.println("Match: " + mat.group());

		Pattern patt;
		Matcher matt;
		boolean found;

		patt = Pattern.compile("Java");
		matt = patt.matcher("Java");

		found = matt.matches();

		if (found)
			System.out.println("Matches");
		else
			System.out.println("No Match");

		System.out.println();

		matt = patt.matcher("Java 2");

		found = matt.matches();

		if (found)
			System.out.println("Matches");
		else
			System.out.println("No Match");

		/*
		 * Output: Match: www Match: java Match: s Match: com
		 * 
		 */

		// Match lowercase words.
		Pattern pat = Pattern.compile("[a-z]+");
		Matcher mat = pat.matcher("www.java2s.com.");

		while (mat.find())
			System.out.println("Match: " + mat.group());

		/*
		 * gal matches input gal gal matches input e?gal gal does not match input e?gal
		 * gal does not match input e'gal gal does not match input egal
		 */

		/**
		 * CanonEqDemo - show use of Pattern.CANON_EQ, by comparing varous ways of
		 * entering the Spanish word for "equal" and see if they are considered equal by
		 * the RE-matching engine.
		 * 
		 * @version $Id: CanonEqDemo.java,v 1.3 2004/03/21 20:06:20 ian Exp $
		 */

		String pattStr = "\u00e9gal"; // gal
		String[] input = { "\u00e9gal", // gal - this one had better match :-)
				"e\u0301gal", // e + "Combining acute accent"
				"e\u02cagal", // e + "modifier letter acute accent"
				"e'gal", // e + single quote
				"e\u00b4gal", // e + Latin-1 "acute"
		};
		Pattern pattern = Pattern.compile(pattStr, Pattern.CANON_EQ);
		for (int i = 0; i < input.length; i++) {
			if (pattern.matcher(input[i]).matches()) {
				System.out.println(pattStr + " matches input " + input[i]);
			} else {
				System.out.println(pattStr + " does not match input " + input[i]);
			}
		}
		/*
		 * ****
		 */
		Pattern myRE = Pattern.compile("d.*ian");
		Matcher matcher = myRE.matcher("danian devonian dan");
		matcher.lookingAt();
		String result = matcher.group(0);
		System.out.println(result);

		/*
		 * Output: Next token: www Next token: java2s Next token: com Next token: java
		 * Next token: javascript Next token: API Next token: example
		 */
		// split ==> Cut a String // Divide a string
		Pattern pattern1 = Pattern.compile("[ ,.!]");

		String strs[] = pattern1.split("www.java2s.com java javascript API example.");

		for (int i = 0; i < strs.length; i++)
			System.out.println("Next token: " + strs[i]);

		/*
		 * IGNORE_CASE match true MATCH_NORMAL match was false
		 */
		String pattern2 = "^q[^u]\\d+\\.";
		String input2 = "QA777. is the next flight.";

		Pattern reCaseInsens = Pattern.compile(pattern2, Pattern.CASE_INSENSITIVE);
		Pattern reCaseSens = Pattern.compile(pattern2);

		boolean found2;
		Matcher m;
		m = reCaseInsens.matcher(input2); // will match any case
		found2 = m.lookingAt(); // will match any case
		System.out.println("IGNORE_CASE match " + found2);

		m = reCaseSens.matcher(input2); // Get matcher w/o case-insens flag
		found2 = m.lookingAt(); // will match case-sensitively
		System.out.println("MATCH_NORMAL match was " + found2);

	}
}
