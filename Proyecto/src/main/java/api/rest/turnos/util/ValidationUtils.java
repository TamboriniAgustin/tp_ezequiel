package api.rest.turnos.util;

import java.util.regex.Pattern;

public class ValidationUtils {
	public static boolean stringEmptyOrNull(String text) {
		return text == null || text.isEmpty();
	}
	
	public static boolean stringWithEmailFormat(String text) {
		//RegExp sacada de: https://www.baeldung.com/java-email-validation-regex
		String emailRegExp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		return Pattern.compile(emailRegExp).matcher(text).matches();
	}
	
	public static boolean stringWithPasswordFormat(String text) {
		String passwordRegExp = "^[a-zA-Z0-9]{20,40}$";
		return Pattern.compile(passwordRegExp).matcher(text).matches();
	}
	
	public static boolean stringWithDateTimeFormat(String text) {
		String dateRegExp = "^[0-9]{4}-[0-1][0-9]-[0-3][0-9] [0-9]{2}:[0-9]{2}$";
		return Pattern.compile(dateRegExp).matcher(text).matches();
	}
}