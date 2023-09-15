package models;

public class Client {

	private TypeDocument typeDocument;
	private String numberDocument;
	private String firstName;
	private String lastName;
	private Gender gender;
	private float weight;
	private float height;

	public Client(TypeDocument typeDocument, String numberDocument, String firstName, String lastName, Gender gender,
			float weight, float height) {
		this.typeDocument = typeDocument;
		this.numberDocument = numberDocument;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
	}

	public TypeDocument getTypeDocument() {
		return typeDocument;
	}

	public void setTypeDocument(TypeDocument typeDocument) {
		this.typeDocument = typeDocument;
	}

	public String getNumberDocument() {
		return numberDocument;
	}

	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Object[] toObjectVector() {
		return new Object[] { typeDocument.getType(), numberDocument, firstName, lastName, gender.getGender(), weight,
				height, calculateBodyMassIndex(), clasification().getClasification() };
	}

	public float calculateBodyMassIndex() {
		float bodyMassIndex = (float) (weight / Math.pow(height, 2));
		return bodyMassIndex;
	}

	public ClasificationBodyMass clasification() {
		float value = calculateBodyMassIndex();
		ClasificationBodyMass clasification;
		if (value < 18) {
			clasification = ClasificationBodyMass.LOW;
		} else if (value >= 18 && value <= 24.9) {
			clasification = ClasificationBodyMass.NORMAL;
		} else if (value >= 25 && value <= 26.9) {
			clasification = ClasificationBodyMass.OVERWEIGHT;
		} else {
			clasification = ClasificationBodyMass.OBESITY;
		}
		return clasification;
	}
}