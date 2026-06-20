package juegoAdivinanza;

import java.util.Scanner;
import java.util.Random;

public class GestorJuego {

	private int numeroSecreto;
	private int intentosMaximos;

	public GestorJuego(int intentosMaximos) {
		Random numRandom = new Random();
		this.numeroSecreto = numRandom.nextInt(100) + 1; // Número entre 1 y 100
		this.intentosMaximos = intentosMaximos;
	}

	public void Jugar() {
		Scanner teclado = new Scanner(System.in);
		int numero;
		int intentos = 0;
		boolean adivino = false;

		System.out.println("\n=== JUEGO: ADIVINA EL NÚMERO ===");
		System.out.println("Debes adivinar un número entre 1 y 100.");
		System.out.println("Tienes " + intentosMaximos + " intentos.");

		while (intentos < intentosMaximos && !adivino) {
			System.out.print("Ingrese un número: ");
			if (teclado.hasNextInt()) {
				numero = teclado.nextInt();
				teclado.nextLine();
				// Validar que ingrese numeros entre 1 y 100
				while (numero < 1 || numero > 100) {
					System.out.print("Ingrese un número entre 1 y 100: ");
					numero = teclado.nextInt();
				}
				intentos++;

				if (numero == numeroSecreto) {
					adivino = true;
					System.out.println("¡Felicitaciones! Adivinaste el número.");
				} else if (numero < numeroSecreto) {
					System.out.println("El número es más alto.");
				} else {
					System.out.println("El número es más bajo.");
				}

				System.out.println("Intentos restantes: " + (intentosMaximos - intentos));
			} else {

				// Mensaje de error si no ingresa un número
				System.out.println("Error: debe ingresar un número.");
				teclado.next();
			}
		}
		if (!adivino) {
			System.out.println("\nPerdiste. El número era: " + numeroSecreto);
		}
	}
}
