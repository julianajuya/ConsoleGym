package views;

import java.util.Scanner;

import models.Gender;
import models.TypeDocument;
import utilities.Utilities;

public class IOManager {
	private Scanner console;

	public IOManager() {
		console = new Scanner(System.in);
	}

	public static final String FORMAT = "%1$-27s %2$-25s %3$-17s %4$-15s %5$-15s %6$-15s %7$-15s %8$-30s %9$-25s";
	public static final Object[] HEADERS = { "TIPO DE DOCUMENTO", "NÚMERO DE DOCUMENTO", "NOMBRES", "APELLIDOS",
			"GENERO", "PESO", "ALTURA", "INDICE DE MASA CORPORAL", "CLASIFICACIÓN" };
	public static final String MESSAGE_MAIN_MENU = "                GIMNASIO \n" + "================********================\n"
			+ "Ingrese la opcion que desea realizar \n" + "1. Agregar Cliente \n"
			+ "2. Solicitar información de un cliente \n" + "3. Modificar Cliente \n" + "4. Eliminar Cliente \n"
			+ "5. Mostrar Clientes \n" + "6. Mostrar Gráfico porcentaje Mujeres \n"
			+ "7. Mostrar Gráfico porcentaje Hombres \n" + "8. Salir \n";
	public static final String MESSAGE_SECONDARY_MENU = "GIMNASIO \n" + "=================*******================\n"
			+ "Ingrese la opcion que desea realizar \n" + "1. Editar Tipo de Documento \n"
			+ "2. Editar Número de Documento \n" + "3. Editar Nombre \n" + "4. Editar Apellido \n"
			+ "5. Editar Genero \n" + "6. Editar Peso \n" + "7. Editar Estatura \n"
			+ "8. Regresar al menú principal \n";
	public static final String MESSAGE_DOCUMENT_NUMBER = "Ingrese el número de documento";
	public static final String MESSAGE_FIRST_NAME = "Escriba su nombre";
	public static final String MESSAGE_LAST_NAME = "Escriba su apellido";
	public static final String MESSAGE_WEIGHT = "Ingrese su peso";
	public static final String MESSAGE_HEIGHT = "Ingrese su estatura";

	public static final String MESSAGE_DOCUMENT_NUMBER_SHOW = "Ingrese el número de documento del cliente del que desea ver la informaci�n";

	public static final String MESSAGE_NEW_DOCUMENT_NUMBER = "Ingrese el nuevo número de documento";
	public static final String MESSAGE_NEW_FIRST_NAME = "Escriba su nuevo nombre";
	public static final String MESSAGE_NEW_LAST_NAME = "Escriba su nuevo apellido";
	public static final String MESSAGE_NEW_WEIGHT = "Ingrese la variación de su peso";
	public static final String MESSAGE_NEW_HEIGHT = "Ingrese su cambio de estatura";

	public static final String MESSAGE_DOCUMENT_NUMBER_DELETE = "Ingrese el número de documento del cliente que desea eliminar";

	public static final String BAR_GRAPHIC = "****";
	public static final String VOID_GRAPHIC = "    ";
	public static final String SEPARATOR_TWO = "====================================================================";
	public static final String GRAPHIC_FOR_MAN = "Grafico de barras para porcentaje de Hombres";
	public static final String GRAPHIC_FOR_WOMAN = "Grafico de barras para porcentaje de Mujeres";
	public static final Object[] FOOTER = { "%", "PESO BAJO", "NORMAL", "SOBREPESO", "OBESIDAD" };
	public static final String FORMAT_TWO = "%1$-4s %2$-14s %3$-14s %4$-14s %5$-14s";

	public void generateHeader() {
		System.out.println(String.format(FORMAT, HEADERS));
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	public void showListDatas(Object[][] datasList) {
		System.out.println("");
		generateHeader();
		for (Object[] datasObject : datasList) {
			System.out.println(String.format(FORMAT, datasObject));
		}
	}

	public void showInformationClient(Object[] client) {
		System.out.println("");
		generateHeader();
		Object[] datasObject = client;
		System.out.println(String.format(FORMAT, datasObject));
		System.out.println("");
	}

	public byte showMenu() {
		System.out.println("");
		System.out.println(MESSAGE_MAIN_MENU);
		return Byte.parseByte(console.nextLine());
	}

	public byte showMenu2() {
		System.out.println("");
		System.out.println(MESSAGE_SECONDARY_MENU);
		return Byte.parseByte(console.nextLine());
	}

	public TypeDocument readTypeDocument() {
		System.out.println("");
		System.out.println("Para seleccionar el tipo de documento, seleccione: ");
		System.out.println(
				"1. Cédula de Ciudadanía " + '\n' + "2. Tarjeta de Identidad " + '\n' + "3. Cédula de Extranjería ");
		return Utilities.getDocumentType(Integer.parseInt(console.nextLine()));
	}

	public String readDocumentNumber() {
		System.out.println("");
		System.out.println(MESSAGE_DOCUMENT_NUMBER);
		return console.nextLine();
	}

	public String readFirstName() {
		System.out.println("");
		System.out.println(MESSAGE_FIRST_NAME);
		return console.nextLine();
	}

	public String readLastName() {
		System.out.println("");
		System.out.println(MESSAGE_LAST_NAME);
		return console.nextLine();
	}

	public Gender readGender() {
		System.out.println("");
		System.out.println("Seleccione género: ");
		System.out.println("1. Femenino" + '\n' + "2. Masculino");
		return Utilities.getGender(Integer.parseInt(console.nextLine()));
	}

	public float readWeight() {
		System.out.println("");
		System.out.println(MESSAGE_WEIGHT);
		return Float.parseFloat(console.nextLine());
	}

	public float readHeight() {
		System.out.println("");
		System.out.println(MESSAGE_HEIGHT);
		return Float.parseFloat(console.nextLine());
	}

	public String readDocumentNumberOfClientShow() {
		System.out.println("");
		System.out.println(MESSAGE_DOCUMENT_NUMBER_SHOW);
		return console.nextLine();
	}

	public TypeDocument readNewTypeDocument() {
		System.out.println("");
		System.out.println("Para cambiar el tipo de documento, seleccione: ");
		System.out.println(
				"1. Cédula de Extranjería " + '\n' + "2. Tarjeta de Identidad " + '\n' + "3. Cédula de Ciudadanía ");
		return Utilities.getDocumentType(Integer.parseInt(console.nextLine()));
	}

	public String readNewDocumentNumber() {
		System.out.println("");
		System.out.println(MESSAGE_NEW_DOCUMENT_NUMBER);
		return console.nextLine();
	}

	public String readNewFirstName() {
		System.out.println("");
		System.out.println(MESSAGE_NEW_FIRST_NAME);
		return console.nextLine();
	}

	public String readNewLastName() {
		System.out.println("");
		System.out.println(MESSAGE_NEW_LAST_NAME);
		return console.nextLine();
	}

	public Gender readNewGender() {
		System.out.println("");
		System.out.println("Para cambiar género. seleccione: ");
		System.out.println("1. Femenino" + '\n' + "2. Masculino");
		return Utilities.getGender(Integer.parseInt(console.nextLine()));
	}

	public float readNewWeight() {
		System.out.println("");
		System.out.println(MESSAGE_NEW_WEIGHT);
		return Float.parseFloat(console.nextLine());
	}

	public float readNewHeight() {
		System.out.println("");
		System.out.println(MESSAGE_NEW_HEIGHT);
		return Float.parseFloat(console.nextLine());
	}

	public String readDocumentNumberClientDelete() {
		System.out.println("");
		System.out.println(MESSAGE_DOCUMENT_NUMBER_DELETE);
		System.out.println("");
		return console.nextLine();
	}

	public void printGraphicsForMan(double[] vectorOfAverages) {
		System.out.println("");
		System.out.println(SEPARATOR_TWO);
		System.out.println(GRAPHIC_FOR_MAN);
		graphicGenerator(vectorOfAverages);
		generateFooter();
	}

	public void printGraphicsForWoman(double[] vectorOfAverages) {
		System.out.println("");
		System.out.println(SEPARATOR_TWO);
		System.out.println(GRAPHIC_FOR_WOMAN);
		graphicGenerator(vectorOfAverages);
		generateFooter();
	}

	private void generateFooter() {
		System.out.println("");
		System.out.println(SEPARATOR_TWO);
		System.out.println(String.format(FORMAT_TWO, FOOTER));
		System.out.println(SEPARATOR_TWO);
	}

	private void graphicGenerator(double[] vectorOfAverages) {
		int biggerAverage = getBiggerAverage(vectorOfAverages);
		for (int i = biggerAverage; i > 0; i--) {
			System.out.println(String.format(FORMAT_TWO, getRow(biggerAverage, vectorOfAverages)));
			biggerAverage--;
		}

	}

	private Object[] getRow(int biggerAverage, double[] vectorOfAverages) {
		Object[] row = new Object[FORMAT_TWO.length()];
		row[0] = biggerAverage;
		for (int i = 0; i < vectorOfAverages.length; i++) {
			if (vectorOfAverages[i] >= biggerAverage) {
				row[i + 1] = BAR_GRAPHIC;
			} else {
				row[i + 1] = VOID_GRAPHIC;
			}
		}
		return row;
	}

	private int getBiggerAverage(double[] vectorOfAverages) {
		int biggerAverage = 0;
		for (int i = 0; i < vectorOfAverages.length; i++) {
			if (biggerAverage < vectorOfAverages[i]) {
				biggerAverage = (int) vectorOfAverages[i];
			}
		}
		return biggerAverage + 2;
	}

	public void showDocumentNotFound(String message) {
		System.out.println("");
		System.err.println(message);
	}

	public void showEmptyList(String message) {
		System.out.println("");
		System.err.println(message);
	}
}