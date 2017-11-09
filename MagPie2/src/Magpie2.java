
public class Magpie2 {

	//Get a default greeting and return a greeting	
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * takes in a user statement
	 * returns a response based on given rules
	 */
	public String getResponse(String statement) {
		String response = "";
		if (statement.indexOf("Dwyer") >= 0
				|| statement.indexOf("Paul") >= 0
				|| statement.indexOf("Lira") >= 0) {
			response = "He sounds like a good teacher.";
		} else if (statement.indexOf("Dreyer") >= 0
				|| statement.indexOf("Peel") >= 0)
				{
			response = "She sounds like a good teacher.";
				}
		else if (statement.indexOf("hate") >= 0) {
			response = "hate is a strong word.";
		}
		else if (statement.indexOf("born") >= 0) {
			response = "I was born at mills.";
		}
		else if (statement.indexOf("love") >= 0) {
			response = "I wish I could love.";
		}else {
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * returns a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		}

		return response;
	}
}
