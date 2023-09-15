package src.models;

public enum ClasificationBodyMass {
	LOW("Peso Bajo"), NORMAL("Peso Ideal"), OVERWEIGHT("Sobrepeso"), OBESITY("Obesidad");

	private String clasification;

	private ClasificationBodyMass(String clasification) {
		this.clasification = clasification;
	}

	public String getClasification() {
		return clasification;
	}
}