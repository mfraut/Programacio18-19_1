package pru03.E06;
import java.util.Scanner;
public class PRU03E06Tickets_Miquel_Frau {
    public static void main (String[] args){
        Zona platea = new Zona(1000);
        Zona amfiteatre = new Zona(200);
        Zona vip = new Zona(25);
        boolean repetir = true;
        boolean repetir_entradas_libres = true;
        boolean repetir_venta_entradas = true;
        Scanner sc = new Scanner(System.in);
        int seleccion, seleccion_entradas_libres, seleccion_venta_entradas;
        int compra_entradas = 0;


        System.out.println("Gràcies per el seu interés en la compra de les entrades. A continuació, se'ls mostrará un seguit d'opcions. Trii la opció que vulgui efectuar.");
        System.out.println("");

        do {
        
        System.out.println("1. Mostrar nombre d'entrades lliures.");
        System.out.println("2. Vendre entrades.");
        System.out.println("3. Sortir.");

        seleccion = sc.nextInt();

        switch(seleccion){
            case 1:         repetir_entradas_libres = true;
                            do {
                            System.out.println("");
                            System.out.println("A continuació, seleccioni de quina zona vol mostrar el nombre d'entrades disponibles.");
                            System.out.println("1. Platea.");
                            System.out.println("2. Amfiteatre.");
                            System.out.println("3. VIP.");
                            System.out.println("4. Cancelar.");
                            
                            seleccion_entradas_libres = sc.nextInt();
                            
                            switch(seleccion_entradas_libres) {
                                case 1: System.out.println(platea.getEntradesPerVendre());
                                		repetir_entradas_libres = false;
                                        break;
                                case 2: System.out.println(amfiteatre.getEntradesPerVendre());
                                		repetir_entradas_libres = false;
                                        break;
                                case 3: System.out.println(vip.getEntradesPerVendre());
                                		repetir_entradas_libres = false;
                                        break;
                                case 4: repetir_entradas_libres = false;
                                        break;                                
                                default: System.out.println("No has introduit cap opció correcta. Per favor, introdugui una opció correcta.");
                            }
                            } while (repetir_entradas_libres);
                            break;
            case 2:             repetir_venta_entradas = true;
                                do {
                                System.out.println("");
                                System.out.println("A continuació, seleccioni de quina zona vol comprar les entrades.");
                                System.out.println("1. Platea.");
                                System.out.println("2. Amfiteatre.");
                                System.out.println("3. VIP.");
                                System.out.println("4. Cancelar.");

                                seleccion_venta_entradas = sc.nextInt();

                                switch(seleccion_venta_entradas) {
                                    case 1: System.out.println("Per favor, introdugui la quantitat de tickets que vol comprar.");
                                            compra_entradas = sc.nextInt();
                                            if (compra_entradas > 0) {
                                            	platea.vendre(compra_entradas);	
                                            }
                                            else {
                                            	System.out.println("Error: Has introduit un nombre negatiu o has intentat comprar 0 entrades.");
                                            }
                                            repetir_venta_entradas = false;
                                            break;
                                    case 2: System.out.println("Per favor, introdugui la quantitat de tickets que vol comprar.");
                                            compra_entradas = sc.nextInt();
                                            if (compra_entradas > 0) {
                                            	amfiteatre.vendre(compra_entradas);	
                                            }
                                            else {
                                            	System.out.println("Error: Has introduit un nombre negatiu o has intentat comprar 0 entrades.");
                                            }
                                            repetir_venta_entradas = false;
                                            break;
                                    case 3: System.out.println("Per favor, introdugui la quantitat de tickets que vol comprar.");
                                            compra_entradas = sc.nextInt();
                                            if (compra_entradas > 0) {
                                            	vip.vendre(compra_entradas);	
                                            }
                                            else {
                                            	System.out.println("Error: Has introduit un nombre negatiu o has intentat comprar 0 entrades.");
                                            }
                                            repetir_venta_entradas = false;
                                            break;
                                    case 4: repetir_venta_entradas = false;
                                            break;
                                    default: System.out.println("No has introduit cap opció correcta. Per favor, introdugui una opció correcta.");
                                }
                            } while(repetir_venta_entradas);
                              break;
            case 3: repetir = false;
                              break;
            default: System.out.println("No has introduit cap opció correcta. Per favor, introdugui una opció correcta.");
        }

        } while (repetir);
    }
}