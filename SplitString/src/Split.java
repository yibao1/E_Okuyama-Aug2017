
/*
 * Emi Okuyama
 * October 26th, 2017
 */

import java.util.Arrays;

public class Split {
	/*
	 * Write a method that take in a string like
	 * "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a
	 * sandwich use String.split to split up the sandwich by the word "bread" and
	 * return what's in the middle of the sandwich and ignores what's on the outside
	 * What if it's a fancy sandwich with multiple pieces of bread?
	 */
	public static String[] splitSandwich(String ingredients) {
		// if there is only one bread return an empty array
		if (ingredients.indexOf("bread") == ingredients.lastIndexOf("bread")) {
			String[] result = {};
			return result;
		}
		// split at bread
		String[] parts = ingredients.split("bread");
		// if there are no ingredients in the sandwich then return an empty array
		if (parts.length <= 1) {
			String[] result = {};
			return result;
		}

		// if the string contains ingredients after the final bread then we need to
		// remove them.
		int endOfParts;
		if (ingredients.endsWith("bread")) {
			endOfParts = parts.length;
		} else {
			endOfParts = parts.length - 1;
		}
		return Arrays.copyOfRange(parts, 1, endOfParts);
	}

	/*
	 * Write a method that take in a string like
	 * "apples pineapples bread lettus tomato bacon mayo ham bread cheese"
	 * describing a sandwich use String.split to split up the sandwich at the
	 * spaces, " ", and return what's in the middle of the sandwich and ignores
	 * what's on the outside Again, what if it's a fancy sandwich with multiple
	 * pieces of bread?
	 */
	public static String splitSandwichWithSpaces(String ingredients) {
		// split at " "
		String[] parts = ingredients.split(" ");
		String result = "";
		int firstBread = -1;
		int lastBread = -1;
		for (int i = 0; i < parts.length; i++) {
			if (parts[i].equals("bread")) {
				if (firstBread == -1) {
					firstBread = i;
				} else {
					lastBread = i;
				}
			}
		}
		for (int j = firstBread + 1; j < lastBread; j++) {
			if (!parts[j].equals("bread")) {
				result += parts[j] + " ";
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("task1:");
		System.out.println(Arrays.toString(splitSandwich("airbreadcheesebreadmeatbreadplate")));
		System.out.println(Arrays.toString(splitSandwich("airbreadcheesebreadmeatbreadplatetable")));
		System.out.println(Arrays.toString(splitSandwich("applespineapplesbreadlettustomatobaconmayohambreadcheese")));
		System.out.println(Arrays.toString(splitSandwich("")));
		System.out.println(Arrays.toString(splitSandwich("airbreadplate")));
		System.out.println(Arrays.toString(splitSandwich("breadhambread")));
		System.out.println(Arrays.toString(splitSandwich("breadbread")));
		System.out.println("task2:");
		System.out.println(splitSandwichWithSpaces("bread ham bread"));
		System.out
				.println(splitSandwichWithSpaces("apples pineapples bread lettus tomato bacon mayo ham bread cheese"));
		System.out.println(
				splitSandwichWithSpaces("apples pineapples bread lettus tomato bread bacon mayo ham bread cheese"));
		System.out.println(splitSandwichWithSpaces("bread bread"));
		System.out.println(splitSandwichWithSpaces(""));
		System.out.println(splitSandwichWithSpaces("bread ham"));
	}

}