package pru03.E07;
import java.util.ArrayList;
import java.util.Scanner;

public class PRU03E07_Miquel_Frau {
	public static void main (String[] args) throws Exception{
		
		/* Se crea el Scanner y se crean las variables principales. */
		
		Scanner sc = new Scanner(System.in);

		boolean repetir = true;
		boolean repetir_alta_codi;
		boolean repetir_alta_desc;
		boolean flag_repetir_alta_desc;
		boolean repetir_alta_stock;
		boolean repetir_borrar;
		boolean flag_borrado;
		boolean flag_encontrado;
		boolean repetir_modificar;
		boolean flag_modificado;
		boolean flag_repetir_borrar;
		boolean repetir_seleccio_modificar;
		int seleccio;
		String codi_objeto;
		String desc_objeto;
		String codi_objeto_retirar;
		String codi_objeto_modificar;
		double preuCompra_objeto;
		double preuVenda_objeto;
		int stock;
		int seleccio_modificar;

		/* Se crea una ArrayList de Articulos para almacenar todos los artículos que se van creando. Todo el código está envuelto en un bucle do while para controlar
		 * cuando se ha de dejar de mostrar el menú. */
		
		ArrayList<Article> articles = new ArrayList<Article>();
		do{
			System.out.println("\nBenvingut a StorageManagement V1.4. Per favor, trii una de les opcions que es mostren a continuacio:");
			System.out.println("1. Llistat.");
			System.out.println("2. Alta.");
			System.out.println("3. Baixa.");
			System.out.println("4. Modificació.");
			System.out.println("5. Entrada de mercaderia.");
			System.out.println("6. Sortida de mercaderia.");
			System.out.println("7. Sortir.");

			/* Pedimos al usuario que nos seleccione una de las opciones mostradas anteriormente y la introducimos a la variable seleccio, que se evalúa en un switch
			 * para determinar qué debe hacer el programa. En caso de no introducir ninguno de los números mostrados en el menú, da un mensaje de error, diciendo que
			 * no se ha introducido ninguna opción correcta.*/
			
			seleccio = sc.nextInt();

			switch(seleccio) {
			case 1:
				
				/*Sacamos una lista de todos los artículos que hay. Primeramente, comprobamos si hay algún artículo en la ArrayList. En caso de que no haya ninguno,
				 * indicamos que no hay ninguna entrada para mostrar. En caso contrario, entramos en un bucle for que irá pasando por las distintas entradas de la
				 * ArrayList e irá mostrándolas por pantalla.*/
				
				if (articles.size() == 0) {
					System.out.println("No hi ha cap entrada per mostrar.");
				}
				else {
				for (int i = 0; i<articles.size(); i++){
					System.out.print(articles.get(i) + "\t");
				}
				}
				break;
				
			case 2: 
				
				/* Introducimos un nuevo artículo. Lo primero que hacemos, es inicializar variables locales del caso, en su gran mayoría, booleans para ir controlando
				 * las acciones que se realizan. Limpiamos el scanner y entramos en un bucle do while, para poder repetir el bucle en caso de que en algún punto haya
				 * fallado algo.*/
				
			repetir_alta_codi = true;
			repetir_alta_desc = true;
			repetir_alta_stock = true;
			flag_repetir_alta_desc = true;
			boolean flag_mismo_articulo = false;
			boolean flag_misma_desc = false;
			boolean repetir_alta_preuVenda = true;
			boolean repetir_alta_preuCompra = true;
			sc.nextLine();
			do {
				
				/*Inicializamos una variable llamada flag_mismo_articulo en false, para asegurarnos de que cada vez que se ejecuta el bucle, siempre empiece en false.
				 * Esto se debe a que esa variable controla si se ha detectado que el código que se ha introducido ya pertenece a algún artículo. El sistema le pide
				 * al usuario que introduzca el código del artículo que quiere añadir. Esto lo almacena en una variable y entra en un bucle for, que va revisando toda
				 * la ArrayList mirando si ya hay algún artículo con el mismo código. Si no hay ningún artículo con el mismo código ya introducido, paramos el bucle de
				 * repetir el código y enviamos un mensaje de confirmación */
				
				flag_mismo_articulo = false;
				System.out.println("Per favor, introdugui el codi de l'article.\n");
				codi_objeto = sc.nextLine();
				for (int i = 0; i<articles.size(); i++) {
					if (articles.get(i).getCodi().equals(codi_objeto)) {
						System.out.print("Ha introduit un codi que ja pertany a un article. ");
						flag_mismo_articulo = true;
					}
				}
				if (!(flag_mismo_articulo)) {
					repetir_alta_codi = false;
				}
			} while(repetir_alta_codi);
			System.out.print("\nHa introduit: \""+codi_objeto+"\" com a codi satisfactòriament. ");
			
			/* Inicializamos flag_misma_desc en false para después comprobar si hay algún artículo con esa exacta descripción. En lugar de tacharla de error directamente,
			 * se le pregunta al usuario si es correcto que haya dos descripciones iguales o no. Si dice que es correcto se termina el bucle de pedir la descripción y
			 * si dice que no es correcto se repite que introduzca la descripción. Comprueba también si ha introducido una descripción diferente a las que ya hay y si es
			 * así, para el bucle y envía un mensaje de confirmación.*/
			
			do {
				flag_misma_desc = false;
				System.out.print("Per favor, introdugui la descripció de l'article.\n");
				desc_objeto = sc.nextLine();
				for (int i = 0; i<articles.size(); i++) {
					if (articles.get(i).getDescripcio().equals(desc_objeto)) {
						flag_misma_desc = true;
						System.out.print("Ha introduit una descripció que ja pertany a un article. És això correcte? (S/N)");
						String desc_objeto_check = sc.nextLine();
						do {
							if (desc_objeto_check.equals("S")){
								repetir_alta_desc = false;
								flag_repetir_alta_desc = false;
							} else if (desc_objeto_check.equals("N")){
								flag_repetir_alta_desc = false;
							}
							else {
								flag_repetir_alta_desc = true;
								System.out.println("No t'he entés. Per favor, torni a introduir si les dades son correctes (S) o no ho son (N).");
								desc_objeto_check = sc.nextLine();
							}
						} while (flag_repetir_alta_desc);
					}
				}
				if (!(flag_misma_desc)) {
					repetir_alta_desc = false;
				}
			} while(repetir_alta_desc);
			System.out.print("\nHa introduit: \""+desc_objeto+"\" com a descripció satisfactòriament. ");
			
			/* Se verifica en dos do while los precios de compra y de venta respectivamente que se introducen. En ambos, se revisa que no se introduzca
			 * un valor negativo (en dicho caso salta un mensaje de error y repite la solicitud) hasta que introduce un número positivo. Al hacerlo, envía mensaje de
			 * confirmación de valores.*/
			
			do {
				System.out.print("Per favor, introdugui el preu de compra de l'article.\n");
				preuCompra_objeto = sc.nextDouble();
				if (preuCompra_objeto >= 0){
					System.out.print("\nHas introduit: \""+preuCompra_objeto+"\" com a preu de compra satisfactòriament. ");
					repetir_alta_preuCompra = false;
				}
				else {
					System.out.print("Has introduit un nombre negatiu i això no està acceptat.");
				}
			} while (repetir_alta_preuCompra);

			do {
				System.out.print("Per favor, introdugui el preu de venda de l'article.\n");
				preuVenda_objeto = sc.nextDouble();
				if (preuVenda_objeto >= 0) {
					System.out.print("\nHas introduit: \""+preuVenda_objeto+"\" com a preu de compra satisfactòriament. ");
					repetir_alta_preuVenda = false;
				}
				else {
					System.out.print("Has introduit un nombre negatiu i això no està acceptat. ");
				}
			} while (repetir_alta_preuVenda);
			
			/*Se solicita el stock del artículo en cuestión y se revisa que no sea un número negativo. Se confirma al finalizar */
			
			do {
				System.out.print("Per favor, introdugui l'stock de l'article.\n");
				stock = sc.nextInt();
				if (stock <= 0) {
					System.out.print("Has introduit un stock negatiu. No s'accepten valors negatius. ");
				}
				else {
					repetir_alta_stock = false;
				}
			} while(repetir_alta_stock);
			System.out.print("\nHas introduit: \""+stock+"\" com a stock satisfactòriament. ");
			
			/*Una vez introducidos todos los datos necesarios, se añade a la ArrayList una nueva instancia de articulo. En el for, se navega por la ArrayList en busca
			 * de una posición que tenga como código "LLIURE", que será la nueva instancia que se ha creado. Al haber encontrado ese código, se utilizan los setters
			 * para añadir todos los datos introducidos anteriormente. */
			
			articles.add(new Article());
			for (int i = 0; i<articles.size(); i++) {
				if (articles.get(i).getCodi().equals("LLIURE")) {
					articles.get(i).setCodi(codi_objeto);
					articles.get(i).setDescripcio(desc_objeto);
					articles.get(i).setPreuDeCompra(preuCompra_objeto);
					articles.get(i).setPreuDeVenda(preuVenda_objeto);
					articles.get(i).setStock(stock);
				}
			}
			break;                        
			case 3: 
				
				/*Se inicializan las variables locales y se limpia el Scanner. Se le pide al usuario que introduzca el código del artículo que quiere retirar. Se revisa
				 * si hay una coincidencia y si la hay, se borra y se da mensaje de confirmación, si no, solicita al usuario si quiere buscar otro código.*/
				
				repetir_borrar = true;
				flag_repetir_borrar = true;
				sc.nextLine();
				do {
					flag_borrado = false;
					System.out.println("Introdugui el codi de l'article que vol retirar.");
					codi_objeto_retirar = sc.nextLine();
					for (int i = 0; i<articles.size(); i++) {
						if (articles.get(i).getCodi().equals(codi_objeto_retirar)) {
							flag_borrado = true;
							articles.remove(i);
						}
					}
					if (flag_borrado) {
						System.out.println("L'article s'ha borrat amb èxit.");
						repetir_borrar = false;
					}
					else {
						System.out.print("No s'ha trobat l'article que està cercant. Vol tornar a cercar? (S/N)");
						String borrar_check = sc.nextLine();
						do {
							if (borrar_check.equals("S")){
								flag_repetir_borrar = false;
							} else if (borrar_check.equals("N")){
								repetir_borrar = false;
								flag_repetir_borrar = false;
							}
							else {
								flag_repetir_alta_desc = true;
								System.out.println("No t'he entés. Per favor, torni a introduir si les dades son correctes (S) o no ho son (N).");
								borrar_check = sc.nextLine();
							}
						} while (flag_repetir_borrar);
					}
				} while (repetir_borrar);
				break;
			case 4:
				
				/*Modificar un artículo ya existente. Se inicializan variables y se limpia Scanner. Se solicita a usuario que introduzca el código del artículo que quiere
				 * modificar. Se verifica que ese artículo exista y se muestra un menú, en el que el usuario debe seleccionar la acción que quiere realizar.*/
				repetir_modificar = true;
				flag_modificado = false;
				repetir_seleccio_modificar = true;
				sc.nextLine();
				do {
					System.out.println("Introdugui el codi de l'article que vol modificar.");
					codi_objeto_modificar = sc.nextLine();
					for (int i = 0; i<articles.size(); i++) {
						if (articles.get(i).getCodi().equals(codi_objeto_modificar)) {
							flag_modificado = true;
							do { 
								boolean repetir_modificar_nou;
								System.out.print("\nSeleccioni el que vulgui modificar de la seguent llista: \n1. Codi\n2. Descripcio\n3. Preu de compra\n4. Preu de venda\n5. Sortir");
								seleccio_modificar = sc.nextInt();

								switch(seleccio_modificar){
								case 1: 
									/*Cambiar el código del artículo. Se revisa que el código nuevo no sea el mismo que el de otro artículo, en cuyo caso da un mensaje de error. Si no
									 * coincide con otro artículo, solicita al usuario si quiere hacer otra búsqueda.*/
									repetir_modificar_nou = true;
									sc.nextLine();
									do {
										String modificar_nou_codi;
										boolean flag_modificado_nou = false;
										System.out.print("\nPer favor, introdugui el nou codi.");
										modificar_nou_codi = sc.nextLine();
										for (int a = 0; a<articles.size(); a++ ){
											if(articles.get(a).getCodi().equals(modificar_nou_codi)){
												System.out.println("Ja hi ha un article amb aquest codi.");
												flag_modificado_nou = true;
											}
										}
										if (!(flag_modificado_nou)){
											articles.get(i).setCodi(modificar_nou_codi);
											repetir_modificar_nou = false;
										}
									} while(repetir_modificar_nou);
									repetir_seleccio_modificar = false;
									repetir_modificar = false;
									break;
								case 2:
									
									/*Cambiar la descripción actual por una nueva. */
									
									sc.nextLine();
									System.out.println("Per favor, introdugui la nova descripció.");
									String modificar_nou_desc = sc.nextLine();
									articles.get(i).setDescripcio(modificar_nou_desc);
									repetir_seleccio_modificar = false;
									repetir_modificar = false;
									break;
								case 3: 
									
									/*Cambiar el precio de compra. Verifica que no se haya introducido un número negativo.*/
									
									System.out.println("Per favor, introdugui el nou preu de compra");
									double modificar_nou_preuCompra = sc.nextDouble();
									if (modificar_nou_preuCompra < 0){
										System.out.println("No es pot possar un nombre negatiu com a preu de compra");
									}
									else {
										articles.get(i).setPreuDeCompra(modificar_nou_preuCompra);	
										repetir_seleccio_modificar = false;
										repetir_modificar = false;
									}									
									break;
								case 4:
									
									/*Cambiar el precio de venta. Verifica que no se haya introducido un número negativo.*/
									
									System.out.println("Per favor, introdugui el nou preu de venda");
									double modificar_nou_preuVenda = sc.nextDouble();
									if (modificar_nou_preuVenda < 0) {
										System.out.println("No es pot possar un nombre negatiu com a preu de venda");
									}
									else {
										articles.get(i).setPreuDeVenda(modificar_nou_preuVenda);
										repetir_seleccio_modificar = false;
										repetir_modificar = false;
									}									
									
									break;
								case 5: 
									/*Salir del menú de modificación*/
									repetir_seleccio_modificar = false;
									repetir_modificar = false;
									break;
								default: System.out.println("No has introduit cap opció correcta");
								}
							} while(repetir_seleccio_modificar);
						}
					}
					if (!(flag_modificado)) {
						boolean flag_repetir_modificar = true;
						System.out.println("No s'ha trobat l'article que vols modificar. Vols tornar a intentar amb un altre codi? (S/N)");
						String modificar_check = sc.nextLine();
						do {
							if (modificar_check.equals("S")){
								flag_repetir_modificar = false;
							} else if (modificar_check.equals("N")){
								repetir_modificar = false;
								flag_repetir_modificar = false;
							}
							else {
								flag_repetir_modificar = true;
								System.out.println("No t'he entés. Per favor, torni a introduir si les dades son correctes (S) o no ho son (N).");
								modificar_check = sc.nextLine();
							}
						} while (flag_repetir_modificar);
					}
				} while (repetir_modificar);
				break;
			case 5: 
				
				/*Entrada de mercancía. Inicializa variables y limpia Scanner. Solicita al usuario el código del artículo al que le quiere añadir mercancía. Si encuentra el código,
				 * pide al usuario cuanta mercancía ha entrado. Comprueba que no sea un número negativo y la introduce y da un mensaje afirmativo si todo ha salido bien. Si no se ha
				 * encontrado el código del artículo al que le entra la mercancía, solicita al usuario si quiere introducir otro o no. */
				
				boolean flag_repetir_entrada = false;
				boolean repetir_entrada = true;
				boolean flag_entrada = false;
				int entrada_stock = 0;
				sc.nextLine();
				do {
					System.out.println("Introdueix el codi de l'objecte al qual li ha entrat mercaderia.");
					String codi_entrada_mercaderia = sc.nextLine();
					for (int i = 0; i<articles.size(); i++) {
						if (articles.get(i).getCodi().equals(codi_entrada_mercaderia))  {
							System.out.println("Introdueix la quantitat de mercancia que ha arribat");
							entrada_stock = sc.nextInt();
							if (entrada_stock < 0) {
								System.out.println("No es pot introduir un nombre negatiu");
							}
							else {
								articles.get(i).setStock((articles.get(i).getStock()+entrada_stock));
								flag_entrada = true;
							}
						}
					}
					if (flag_entrada) {
						System.out.println("L'stock s'ha modificat positivament amb èxit");
						repetir_entrada = false;
					}
					else {
						flag_repetir_entrada = true;
						System.out.println("No s'ha trobat l'article que vols modificar. Vols tornar a intentar amb un altre codi? (S/N)");
						String entrada_check = sc.nextLine();
						do {
							if (entrada_check.equals("S")){
								flag_repetir_entrada = false;
							} else if (entrada_check.equals("N")){
								repetir_entrada = false;
								flag_repetir_entrada = false;
							}
							else {
								flag_repetir_entrada = true;
								System.out.println("No t'he entés. Per favor, torni a introduir si les dades son correctes (S) o no ho son (N).");
								entrada_check = sc.nextLine();
							}
						} while (flag_repetir_entrada);
					}
				} while (repetir_entrada);
				break;
			case 6:
				
				/* Salida de mercancía. Inicializa variables y limpia Scanner. Solicita al usuario el código del artículo al que le quiere sustraer mercancía. Si encuentra el código,
				 * pide al usuario cuanta mercancía ha salido. Comprueba que no sea un número negativo y que la mercancia que se quiere retirar no sea mayor a la mercancía que hay en stock,
				 * la introduce y da un mensaje afirmativo si todo ha salido bien. Si no se ha encontrado el código del artículo al que le entra la mercancía, solicita al 
				 * usuario si quiere introducir otro o no. */
				
				boolean flag_repetir_salida = true;
				boolean repetir_salida = true;
				boolean flag_salida = false;
				int salida_stock = 0;
				boolean flag_numero_erroneo = false;
				sc.nextLine();
				do {
					System.out.println("Introdueix el codi de l'objecte al qual li ha sortit mercaderia.");
					String codi_sortida_mercaderia = sc.nextLine();
					for (int i = 0; i<articles.size(); i++) {
						if (articles.get(i).getCodi().equals(codi_sortida_mercaderia))  {
							System.out.println("Introdueix quanta mercancia ha sortit.");
							salida_stock = sc.nextInt();
							if (salida_stock < 0 ) {
								System.out.println("No pots introduir stock negatiu.");
								flag_numero_erroneo = true;
							}
							else {
								if ((articles.get(i).getStock()-salida_stock) >= 0) {
								articles.get(i).setStock((articles.get(i).getStock()-salida_stock));
								flag_salida = true;
								}
								else {
									System.out.println("No pots introduir una sortida de mercancia més gran que la mercancia que hi ha.");
									flag_numero_erroneo = true;
								}
							}
						}
					}
					if (flag_salida) {
						System.out.println("L'stock s'ha modificat negativament amb èxit");
						repetir_salida = false;
					}
					else if (flag_salida && !(flag_numero_erroneo)) {
						flag_repetir_salida = true;
						System.out.println("No s'ha trobat l'article que vols modificar. Vols tornar a intentar amb un altre codi? (S/N)");
						String salida_check = sc.nextLine();
						do {
							if (salida_check.equals("S")){
								flag_repetir_salida = false;
							} else if (salida_check.equals("N")){
								repetir_salida = false;
								flag_repetir_salida = false;
							}
							else {
								flag_repetir_entrada = true;
								System.out.println("No t'he entés. Per favor, torni a introduir si les dades son correctes (S) o no ho son (N).");
								salida_check = sc.nextLine();
							}
						} while (flag_repetir_salida);
					}
				} while (repetir_salida);
				break;
			case 7: 
				
				/*Salir. Pone la variable que controla el bucle principal en false, para terminar el bucle y que acabe el programa.*/
				
				repetir = false;
			break;
			default: System.out.println("No has introduit cap opció correcta. Torna a introduir una opció.");
			}
		} while (repetir);
	}
}