package Ejercicio8;

/**
 * @author JhonnyVera
 *
 *Suponga que tiene N tareas para programar.
 *Cada tarea toma 1 unidad de tiempo y tiene una fecha límite en la cual se espera que termine.
 *Si una tarea no se completa antes de la fecha límite, usted paga una multa de $ 1,000.
 *Encuentre un horario que minimice la pena. 
 *Sugerencia : programe las tareas en el orden de su fecha límite,
 * pero no se moleste con ninguna tarea que no termine en la fecha límite.
 */

public class SchedulingWithDeadline {

	public static void mostrarActividades(int n, int c[], int f[])

	{

		for (int i = 0; i < n; i++) {
			do { 
				System.out.printf("\n Actividad %s", i + 1);
				System.out.printf("\n Iicio %s", c[i]);
				System.out.printf("\n Final %s", f[i]);

			} while (c[i] > f[i]);

		}

	}

	public static void mostrarDatos(int n, int c[], int f[]) {
		System.out.printf(" \n ------Actividades ingresadas------ \n ");

		System.out.printf("EXISTEN    :  ");

		for (int i = 0; i < n; i++)
			System.out.printf((i + 1) + " ");

		System.out.printf("\n \t-------------------------");

		System.out.printf("\n INICIO :  ");

		for (int i = 0; i < n; i++)
			System.out.printf(c[i] + " ");

		System.out.printf("\n FIN    :  ");

		for (int i = 0; i < n; i++)
			System.out.printf(f[i] + " ");

	}

	public static void ordenar(int n, int c[], int f[]) {
		int aux1, aux2, band = 1;

		for (int i = n - 1; i > 0 && band == 1; i--) {
			band = 0;

			for (int j = 0; j < i; j++) {
				if (f[j] > f[j + 1]) {
					aux1 = f[j];
					f[j] = f[j + 1];
					f[j + 1] = aux1;

					aux2 = c[j];
					c[j] = c[j + 1];
					c[j + 1] = aux2;

					band = 1;
				}
			}
		}

		mostrarDatos(n, c, f);

	}

	public static void devolverSolucion(int n, int c[], int f[]) {
		ordenar(n, c, f);
		int S[] = new int[n];
		int z, k = 1;

		z = 0;

		for (int i = 1; i < n; i++) {
			if (c[i] >= f[z]) {
				S[k] = i;
				z = i;
				k++;
			}
		}

		System.out.printf("\n\n EL HORARIO OPTIMO QUE MINIMIZA LA MULTA ES: ");

		int i = 0;

		while (true) {
			System.out.printf("A" + (S[i] + 1) + " ");
			i++;

			if (S[i] == 0)
				break;

		}
	}

	public static void main(String[] args) {

		int c[] = { 1, 0, 5, 3, 6, 8, 8, 12 };
		int f[] = { 4, 6, 7, 9, 10, 11, 12, 16 };
		int N = c.length;

		mostrarActividades(N, c, f);
		devolverSolucion(N, c, f);

	}
}
