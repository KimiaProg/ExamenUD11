package presentacion;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		
		System.out.println("Hasta la próxima. Gracias por su confianza");

	}
	

	@SuppressWarnings("resource")
	static int leerEntero() {
		Scanner teclado = new Scanner(System.in);
		return teclado.nextInt();
	}
	
	static int leerEntero(String prompt) {
		System.out.println(prompt);
		return leerEntero();
	}


	@SuppressWarnings("resource")
	static String leerLinea() {
		Scanner teclado = new Scanner(System.in);
		return teclado.nextLine();
	}

	static String leerLinea(String prompt) {
		System.out.println(prompt);
		return leerLinea();
	}

}
