package models;

public enum TypeDocument {
	ID("Cédula de Ciudadanía"), IC("Tajeta de Identidad"), FOREING_ID("Cédula de Extranjería");

	private String type;

	private TypeDocument(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}