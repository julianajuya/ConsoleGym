package src.models;

import src.exceptions.DocumentNotFoundException;
import src.exceptions.EmptyListException;

public class FitnessCenter {
	
	private Client[] clientList;
	public static int position;
	public static final int PERCENT = 100;

	public FitnessCenter() {
		clientList = new Client[0];
		position = 0;
	}

	public void resizeArray() {
		Client[] clientListAux = new Client[clientList.length + 1];
		for (int i = 0; i < clientList.length; i++) {
			clientListAux[i] = clientList[i];
		}
		clientList = clientListAux;
	}

	public void addClient(Client client) {
		resizeArray();
		if (position < clientList.length && clientList[position] == null) {
			clientList[position] = client;
			position++;
		}
	}

	public Object[] searchClient(String documentNumber) throws DocumentNotFoundException {
//		Object[] clientReturn = null;
		for (int i = 0; i < clientList.length; i++) {
			if (clientList[i].getNumberDocument().equals(documentNumber)) {
				return clientList[i].toObjectVector();
			}
		}
		throw new DocumentNotFoundException();
	}

	public void editTypeDocument(String documentNumber, TypeDocument newDocumentType) {
		for (int i = 0; i < clientList.length; i++) {
			if (documentNumber.equals(clientList[i].getNumberDocument())) {
				clientList[i].setTypeDocument(newDocumentType);
			}
		}
	}

	public void editDocumentNumber(String documentNumber, String newNumberDocument) {
		for (int i = 0; i < clientList.length; i++) {
			if (documentNumber.equals(clientList[i].getNumberDocument())) {
				clientList[i].setNumberDocument(newNumberDocument);
			}
		}
	}

	public void editFirstName(String documentNumber, String name) {
		for (int i = 0; i < clientList.length; i++) {
			if (documentNumber.equals(clientList[i].getNumberDocument())) {
				clientList[i].setFirstName(name);
			}
		}
	}

	public void editLastName(String documentNumber, String surname) {
		for (int i = 0; i < clientList.length; i++) {
			if (documentNumber.equals(clientList[i].getNumberDocument())) {
				clientList[i].setLastName(surname);
			}
		}
	}

	public void editGender(String documentNumber, Gender genderChange) {
		for (int i = 0; i < clientList.length; i++) {
			if (documentNumber.equals(clientList[i].getNumberDocument())) {
				clientList[i].setGender(genderChange);
			}
		}
	}

	public void editWeight(String documentNumber, float weight) {
		for (int i = 0; i < clientList.length; i++) {
			if (documentNumber.equals(clientList[i].getNumberDocument())) {
				clientList[i].setWeight(weight);
			}
		}
	}

	public void editHeight(String documentNumber, float height) {
		for (int i = 0; i < clientList.length; i++) {
			if (documentNumber.equals(clientList[i].getNumberDocument())) {
				clientList[i].setHeight(height);
			}
		}
	}

	public void deleteClient(String numberDocument) throws DocumentNotFoundException {
		int positionFound = searchPositionClientByDocument(numberDocument);
		if (positionFound > 0) {
			Client[] clientsListAux = new Client[clientList.length - 1];
			for (int i = 0; i < clientList.length - 1; i++) {
				if (i < positionFound) {
					clientsListAux[i] = clientList[i];
				} else {
					clientsListAux[i] = clientList[i + 1];
				}
			}
			position--;
			clientList = clientsListAux;
		}
	}

	public Object[][] showClients() throws EmptyListException {
		int sizeDatas = clientList[0].toObjectVector().length;
		Object[][] datasMatrix = new Object[position][sizeDatas];
		for (int i = 0; i < datasMatrix.length; i++) {
			datasMatrix[i] = clientList[i].toObjectVector();
		}
		return datasMatrix;
	}

	public int searchPositionClientByDocument(String numberDocument) throws DocumentNotFoundException {
//		int positionFound = 0;
		for (int i = 0; i < clientList.length; i++) {
			if (clientList[i].getNumberDocument().equalsIgnoreCase(numberDocument)) {
				return i;
			}
		}
		throw new DocumentNotFoundException();
	}

	public short calculateNumberOfWomen() {
		short quantity = 0;
		for (int i = 0; i < clientList.length; i++) {
			if (clientList[i].getGender() == Gender.FEMALE) {
				quantity++;
			}
		}
		return quantity;
	}

	public short calculateNumberOfMen() {
		short quantity = 0;
		for (int i = 0; i < clientList.length; i++) {
			if (clientList[i].getGender() == Gender.MALE) {
				quantity++;
			}
		}
		return quantity;
	}

	public double calculateAverageWomenByClassificationLow() {
		short quantity = 0;
		short numberOfWomen = calculateNumberOfWomen();
		for (int i = 0; i < clientList.length; i++) {
			if (clientList[i].clasification().equals(ClasificationBodyMass.LOW)
					&& clientList[i].getGender().equals(Gender.FEMALE)) {
				quantity++;
			}
		}
		int average = (quantity * 100) / numberOfWomen;
		return average;
	}

	public double calculateAverageWomenByClassificationNormal() {
		short quantity = 0;
		short numberOfWomen = calculateNumberOfWomen();
		for (int i = 0; i < clientList.length; i++) {
			if (clientList[i].clasification().equals(ClasificationBodyMass.NORMAL)
					&& clientList[i].getGender().equals(Gender.FEMALE)) {
				quantity++;
			}
		}
		int average = (quantity * 100) / numberOfWomen;
		return average;
	}

	public double calculateAverageWomenByClassificationOverweight() {
		short quantity = 0;
		short numberOfWomen = calculateNumberOfWomen();
		for (int i = 0; i < clientList.length; i++) {
			if (clientList[i].clasification().equals(ClasificationBodyMass.OVERWEIGHT)
					&& clientList[i].getGender().equals(Gender.FEMALE)) {
				quantity++;
			}
		}
		int average = (quantity * 100) / numberOfWomen;
		return average;
	}

	public double calculateAverageWomenByClassificationObesity() {
		short quantity = 0;
		short numberOfWomen = calculateNumberOfWomen();
		for (int i = 0; i < clientList.length; i++) {
			if (clientList[i].clasification().equals(ClasificationBodyMass.OBESITY)
					&& clientList[i].getGender().equals(Gender.FEMALE)) {
				quantity++;
			}
		}
		int average = (quantity * 100) / numberOfWomen;
		return average;
	}

	public double[] convertPercentageOfWomanToVector() {
		return new double[] { calculateAverageWomenByClassificationLow(), calculateAverageWomenByClassificationNormal(),
				calculateAverageWomenByClassificationOverweight(), calculateAverageWomenByClassificationObesity() };
	}

	public double calculateAverageMenByClassificationLow() {
		short quantity = 0;
		short numberOfMen = calculateNumberOfMen();
		for (int i = 0; i < clientList.length; i++) {
			if (clientList[i].clasification().equals(ClasificationBodyMass.LOW)
					&& clientList[i].getGender().equals(Gender.MALE)) {
				quantity++;
			}
		}
		int average = (quantity * 100) / numberOfMen;
		return average;
	}

	public double calculateAverageMenByClassificationNormal() {
		short quantity = 0;
		short numberOfMen = calculateNumberOfMen();
		for (int i = 0; i < clientList.length; i++) {
			if (clientList[i].clasification().equals(ClasificationBodyMass.NORMAL)
					&& clientList[i].getGender().equals(Gender.MALE)) {
				quantity++;
			}
		}
		int average = (quantity * 100) / numberOfMen;
		return average;
	}

	public double calculateAverageMenByClassificationOverweight() {
		short quantity = 0;
		short numberOfMen = calculateNumberOfMen();
		for (int i = 0; i < clientList.length; i++) {
			if (clientList[i].clasification().equals(ClasificationBodyMass.OVERWEIGHT)
					&& clientList[i].getGender().equals(Gender.MALE)) {
				quantity++;
			}
		}
		int average = (quantity * 100) / numberOfMen;
		return average;
	}

	public double calculateAverageMenByClassificationObesity() {
		short quantity = 0;
		short numberOfMen = calculateNumberOfMen();
		for (int i = 0; i < clientList.length; i++) {
			if (clientList[i].clasification().equals(ClasificationBodyMass.OBESITY)
					&& clientList[i].getGender().equals(Gender.MALE)) {
				quantity++;
			}
		}
		int average = (quantity * 100) / numberOfMen;
		return average;
	}

	public double[] convertPercentageOfManToVector() {
		return new double[] { calculateAverageMenByClassificationLow(), calculateAverageMenByClassificationNormal(),
				calculateAverageMenByClassificationOverweight(), calculateAverageMenByClassificationObesity() };
	}

}