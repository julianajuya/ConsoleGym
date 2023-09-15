package utilities;

import models.Gender;
import models.TypeDocument;

public class Utilities {

	public static TypeDocument getDocumentType(int opt) {
		switch (opt) {
		case 1:
			return TypeDocument.ID;
		case 2:
			return TypeDocument.IC;
		default:
			return TypeDocument.FOREING_ID;
		}
	}

	public static Gender getGender(int opt) {
		switch (opt) {
		case 1:
			return Gender.FEMALE;
		default:
			return Gender.MALE;
		}
	}
}
