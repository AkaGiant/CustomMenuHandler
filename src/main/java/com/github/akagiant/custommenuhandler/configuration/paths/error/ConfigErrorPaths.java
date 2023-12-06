package com.github.akagiant.custommenuhandler.configuration.paths.error;

public class ConfigErrorPaths {

	private ConfigErrorPaths() {
		//no instance
	}
	
	public static String string = "String ('your text here')";
	public static String[] strings = new String[]{"'line 1'", "'line 2'", "'line 3'"};
	public static String wholeNumber = "Whole Number E.G. 1, 2, 3";
	public static String decimalNumber = "Decimal or Whole Number E.G. 1, 1.0, 4.23";
	public static String valueMissing = "The value expected at the current path is missing.";
	public static String valueNotValid = "The value inputted at the current path is not valid.";
	public static String expectedStringList = "Hmm... I was expecting to find a list of string but found nothing...";
	public static String expectedString = "Hmm... I was expecting to find a string but found nothing...";
	public static String expectedSound = "Hmm... I was expecting to find a valid SOUND here...";

}
