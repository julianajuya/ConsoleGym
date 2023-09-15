package controller;

import exceptions.DocumentNotFoundException;
import exceptions.EmptyListException;
import models.Client;
import models.FitnessCenter;
import models.Gender;
import models.TypeDocument;
import views.IOManager;

public class Controller {
	IOManager view;
	FitnessCenter fitnessCenter;

	public Controller() {
		view = new IOManager();
		fitnessCenter = new FitnessCenter();
		createdClients();
		run();
	}

	public void run() {
		int opt = 0;
		do {
			opt = view.showMenu();
			switch (opt) {
			case 1:
				fitnessCenter.addClient(createdClient());
				break;

			case 2:
				managerSearch();
				break;

			case 3:
				inIt();
				break;

			case 4:
				managerDelete();
				break;

			case 5:
				managerShowClients();
				break;

			case 6:
				showGraphicWoman();
				break;

			case 7:
				showGraphicMan();
				break;

			case 8:
				System.exit(0);
				break;
			}
		} while (opt <= 8);
	}

	public Client createdClient() {
		TypeDocument typeDocument = view.readTypeDocument();
		String documentNumber = view.readDocumentNumber();
		String firstName = view.readFirstName();
		String lastName = view.readLastName();
		Gender gender = view.readGender();
		float weight = view.readWeight();
		float height = view.readHeight();
		return new Client(typeDocument, documentNumber, firstName, lastName, gender, weight, height);
	}

	public void createdClients() {
		fitnessCenter.addClient(new Client(TypeDocument.IC, "6543131", "Camila", "Velandia", Gender.FEMALE, 52, 1.56f));
		fitnessCenter.addClient(new Client(TypeDocument.ID, "12384", "Manuel", "Abril", Gender.MALE, 45, 1.40f));
		fitnessCenter.addClient(new Client(TypeDocument.IC, "4566548", "David", "Sánchez", Gender.MALE, 56, 1.60f));
		fitnessCenter.addClient(new Client(TypeDocument.FOREING_ID, "789", "Camilo", "García", Gender.MALE, 68, 1.52f));
		fitnessCenter
				.addClient(new Client(TypeDocument.ID, "101112", "Carmela", "Bustamante", Gender.FEMALE, 45, 1.52f));
		fitnessCenter.addClient(new Client(TypeDocument.ID, "131415", "Bertha", "Arias", Gender.FEMALE, 82, 1.53f));
		fitnessCenter.addClient(new Client(TypeDocument.IC, "963", "José", "Quiroga", Gender.MALE, 78, 1.80f));
		fitnessCenter.addClient(new Client(TypeDocument.IC, "741", "Felipe", "Rinc;ón", Gender.MALE, 65, (float) 1.72));
		fitnessCenter.addClient(new Client(TypeDocument.IC, "852", "Mariana", "Martinez", Gender.FEMALE, 49, 1.36f));
		fitnessCenter.addClient(new Client(TypeDocument.IC, "161718", "Andrea", "Fernández", Gender.FEMALE, 51, 1.55f));
		fitnessCenter.addClient(new Client(TypeDocument.IC, "192021", "Nicolás", "Jiménez", Gender.MALE, 85, 1.64f));
		fitnessCenter
				.addClient(new Client(TypeDocument.FOREING_ID, "192022", "Bernardo", "Moreno", Gender.MALE, 31, 1.62f));
		fitnessCenter.addClient(new Client(TypeDocument.IC, "192023", "Edward", "Diaz", Gender.MALE, 54, 1.69f));
		fitnessCenter.addClient(new Client(TypeDocument.ID, "202568", "Paula", "Muñoz", Gender.FEMALE, 79, 1.56f));
		fitnessCenter.addClient(new Client(TypeDocument.IC, "30268", "Jeimy", "Navarro", Gender.FEMALE, 77, 1.55f));
		fitnessCenter.addClient(new Client(TypeDocument.IC, "78964", "Sebastián", "Blanco", Gender.MALE, 68, 1.70f));
		fitnessCenter.addClient(new Client(TypeDocument.ID, "67526", "Andrés", "Serrano", Gender.MALE, 69, 1.82f));
		fitnessCenter.addClient(new Client(TypeDocument.IC, "785326", "Isabella", "Forero", Gender.FEMALE, 58, 1.46f));
		fitnessCenter.addClient(new Client(TypeDocument.IC, "75316", "Fernando", "Ortega", Gender.MALE, 63, 1.63f));
		fitnessCenter
				.addClient(new Client(TypeDocument.FOREING_ID, "15987", "Jerónimo", "Sanz", Gender.MALE, 48, 1.56f));
	}

	public void managerSearch() {
		try {
			view.showInformationClient(fitnessCenter.searchClient(view.readDocumentNumberOfClientShow()));
		} catch (DocumentNotFoundException e) {
			view.showDocumentNotFound(e.getMessage());
		}
	}

	public void inIt() {
		int opt = 0;
		managerSearch();
		do {
			opt = view.showMenu2();
			switch (opt) {
			case 1:
				managerEditTypeDocument();
				break;

			case 2:
				managerEditNumberDocument();
				break;

			case 3:
				managerEditFirstName();
				break;

			case 4:
				managerEditLastName();
				break;

			case 5:
				managerEditGender();
				break;

			case 6:
				managerEditWeight();
				break;

			case 7:
				managerEditHeight();
				break;

			case 8:
				run();
				break;
			}
		} while (opt <= 8);
	}

	public void managerEditTypeDocument() {
		fitnessCenter.editTypeDocument(view.readDocumentNumber(), view.readNewTypeDocument());
	}

	public void managerEditNumberDocument() {
		fitnessCenter.editDocumentNumber(view.readDocumentNumber(), view.readNewDocumentNumber());
	}

	public void managerEditFirstName() {
		fitnessCenter.editFirstName(view.readDocumentNumber(), view.readNewFirstName());
	}

	public void managerEditLastName() {
		fitnessCenter.editLastName(view.readDocumentNumber(), view.readNewLastName());
	}

	public void managerEditGender() {
		fitnessCenter.editGender(view.readDocumentNumber(), view.readNewGender());
	}

	public void managerEditWeight() {
		fitnessCenter.editWeight(view.readDocumentNumber(), view.readNewWeight());
	}

	public void managerEditHeight() {
		fitnessCenter.editHeight(view.readDocumentNumber(), view.readNewHeight());
	}

	private void managerDelete() {
		try {
			fitnessCenter.deleteClient(view.readDocumentNumberClientDelete());
		} catch (DocumentNotFoundException e) {
			view.showDocumentNotFound(e.getMessage());
		}
	}

	private void managerShowClients() {
		try {
			view.showListDatas(fitnessCenter.showClients());
		} catch (EmptyListException e) {
			view.showEmptyList(e.getMessage());
		}
	}

	private void showGraphicWoman() {
		view.printGraphicsForWoman(fitnessCenter.convertPercentageOfWomanToVector());
	}

	private void showGraphicMan() {
		view.printGraphicsForMan(fitnessCenter.convertPercentageOfManToVector());
	}

	public static void main(String[] args) {
		new Controller();
	}
}