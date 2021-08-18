package chess;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInput {
	
	//This method requires your input
	public boolean checkCoordinateValidity(String input){

		boolean validity = false;
		Pattern inputRegex = Pattern.compile("^[1-8][a-h]$");
		Matcher matcher = inputRegex.matcher(input);
		validity = matcher.find();
		return validity;
	}

}
