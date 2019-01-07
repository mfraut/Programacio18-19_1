package pru03.exercicis_clase;
import java.util.Scanner;
public class PRU03ExercicisClase_Miquel_Frau {

	public void numberDecompose (int n) {
		String n_string = Integer.toString(n);
		int[] numbers = new int[n_string.length()];
		for (int i = 0; i<n_string.length(); i++) {
			numbers[i] = n_string.charAt(i);
		}
		for (int i = 0; i<n_string.length(); i++) {
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero;
		do {
		System.out.println("Please, introduce a number.");
		
		numero = sc.nextInt();
		} while (numero != -1);

	}

}
