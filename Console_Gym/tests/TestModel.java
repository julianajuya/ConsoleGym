package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exceptions.DocumentNotFoundException;
import models.ClasificationBodyMass;
import models.Client;
import models.FitnessCenter;
import models.Gender;
import models.TypeDocument;

class TestModel {

	FitnessCenter fitnessCenter = new FitnessCenter();
	Client client;
	Client client1; 
	
	@BeforeEach
	public void setUp() {
		client = new Client(null, null, null, null, null, 30, 1.42f);
		client1 = new Client(TypeDocument.IC, "123", "Julian", "López", Gender.MALE, 25, 1.0f);
		Client client2 = new Client(TypeDocument.ID, "254654", "Fernanda", "Juya", Gender.FEMALE, 50, 1.55f);
		Client client3 = new Client(TypeDocument.IC, "25465", "Valentina", "Juya", Gender.FEMALE, 35, 1.55f);
		Client client4 = new Client(TypeDocument.IC, "145", "David", "Rodriguez", Gender.MALE, 25, 1.0f);
		Client client5 = new Client(TypeDocument.IC, "654", "Sebastian", "López", Gender.MALE, 10, 1.0f);
		fitnessCenter.addClient(client1);
		fitnessCenter.addClient(client2);
		fitnessCenter.addClient(client3);
		fitnessCenter.addClient(client4);
		fitnessCenter.addClient(client5);
	}

	@DisplayName("Verification of the method that calculates the body mass index")
	@Test
	void test1() {
		assertEquals(14.87800121307373, client.calculateBodyMassIndex());
	}

	@DisplayName("Verification of the method for counting men")
	@Test
	void test2() {
		assertEquals(3, fitnessCenter.calculateNumberOfMen());
	}
	
	@DisplayName("Verification of the method for counting women")
	@Test
	void test3() {
		assertEquals(2, fitnessCenter.calculateNumberOfWomen());
	}
	
	@DisplayName("Verification of the method that calculates the average number of men by overweight classification")
	@Test
	void test4() {
		assertEquals(66.0, fitnessCenter.calculateAverageMenByClassificationOverweight());
	}
	
	@DisplayName("Verification of the method that calculates the average number of women by low classification")
	@Test
	void test5() {
		assertEquals(50, fitnessCenter.calculateAverageWomenByClassificationLow());
	}
	
	@DisplayName("Verification of the method that calculates the average number of men by low classification")
	@Test
	void test6() {
		assertEquals(33.0, fitnessCenter.calculateAverageMenByClassificationLow());
	}
	
	@DisplayName("Verification of the method that determines the classification of body mass")
	@Test
	void test7() {
		assertEquals(ClasificationBodyMass.OVERWEIGHT, client1.clasification());
	}
	
	@DisplayName("Verification of the method that calculates the body mass index")
	@Test
	void test8() {
		assertEquals(25, client1.calculateBodyMassIndex());
	}

	@DisplayName("Verification of the method that searches for a client's position based on the document number")
	@Test
	void test9() throws DocumentNotFoundException {
		assertEquals(0, fitnessCenter.searchPositionClientByDocument("123"));
	}
}