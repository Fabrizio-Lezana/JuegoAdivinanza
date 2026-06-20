package juegoAdivinanza;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n===== MENÚ PRINCIPAL =====");
			System.out.println("1. Jugar");
			System.out.println("2. Mostrar reglas");
			System.out.println("3. Salir");
			System.out.print("Seleccione una opción: ");
			// Mensaje de error si no ingresa un número
			while (!teclado.hasNextInt()) {
				System.out.println("Error: debe ingresar un número.");
				teclado.next();
				System.out.print("Seleccione una opción: ");
			}
			opcion = teclado.nextInt();
			switch (opcion) {
			case 1:
				GestorJuego juego = new GestorJuego(5);
				juego.Jugar();
				break;

			case 2:
				System.out.println("\nREGLAS:");
				System.out.println("- Debes adivinar un número entre 1 y 100.");
				System.out.println("- Tienes 5 intentos.");
				System.out.println("- El juego te indicará si el número es mayor o menor.");
				break;

			case 3:
				System.out.println("\nGracias por jugar.");
				break;

			default:
				System.out.println("\nOpción inválida. Debe ingresar una opción entre 1 y 3");
			}

		} while (opcion != 3);

		teclado.close();
	}

}
