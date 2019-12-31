package Ejercicio7;

/**
 * @author JhonnyVera
 * 
 * Est�s en un vestuario con 100 casilleros abiertos, 
 * numerados del 1 al 100. Cambia todos los casilleros que sean pares. 
 * Por alternar , nos referimos a cerrar si est� abierto y abrir si est� cerrado. 
 * Ahora alterna todos los casilleros que son m�ltiplos de tres. Repita con m�ltiplos de 4, 5,
 *  hasta 100.
 * �Cu�ntos casilleros est�n abiertos? Respuesta : 
 * los casilleros 1, 4, 9, 16, 25, ..., 100 estar�n abiertos. 
 * Supongo que no necesita una matriz una vez que vea el patr�n.
 */

public class Locker {

		public static void abrirCasilleros(boolean[] array) {
			for (int i = 0; i < array.length; i++) {
				array[i] = true;
			}
		}

		public static void alternarCasilleros(boolean[] array) {
			for (int multiplo = 2; multiplo <= 100; multiplo++) {
				for (int i = 0; i < array.length; i++) {
					if ((i + 1) % multiplo == 0) {
						array[i] = !array[i];
					}
				}
			}
		}

		public static int contarCasilleros(boolean[] array) {
			int cont = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i]) {
					cont++;
				}
			}
			return cont;
		}

		public static void main(String[] args) {

			// abierto = true
			// cerrado = false

			boolean casilleros[] = new boolean[100];

			abrirCasilleros(casilleros);
			alternarCasilleros(casilleros);

			for (int i = 0; i < casilleros.length; i++) {
				if (casilleros[i]) {
					System.out.printf("\n El casillero %s esta abierto", i + 1);
				} else
					System.out.printf("\n El casillero %s esta cerrado", i + 1);
			}
			System.out.printf("\n La cantidad de casilleros abiertos es: %s",
					contarCasilleros(casilleros));
		}
}