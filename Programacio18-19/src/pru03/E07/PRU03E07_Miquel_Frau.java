package pru03.E07;
import java.util.ArrayList;
import java.util.Scanner;

public class PRU03E07_Miquel_Frau {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        boolean repetir = true;
        int seleccio;

        ArrayList articles = new ArrayList<Article>(Article);
        do{
            System.out.println("Benvingut a StorageManagement V1.0. Per favor, trii una de les opcions que es mostren a continuacio:");
            System.out.println("1. Llistat.");
            System.out.println("2. Alta.");
            System.out.println("3. Baixa.");
            System.out.println("4. Modificació.");
            System.out.println("5. Entrada de mercaderia.");
            System.out.println("6. Sortida de mercaderia.");
            System.out.println("7. Sortir.");

            seleccio = sc.nextInt();

            switch(seleccio) {
                case 1: 
                        for (int i = 0; i<articles.size(); i++){
                            System.out.print(articles.get(i) + "\t");
                        }
                        break;
                case 2: Article objeto;
                        articles.add(objeto);
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                default: 
            }
        } while (repetir);
    }
}