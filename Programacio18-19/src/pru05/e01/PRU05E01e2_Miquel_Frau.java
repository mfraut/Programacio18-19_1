package pru05.e01;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Scanner;


public class PRU05E01e2_Miquel_Frau {

	private Connection conexio = null;
	private Statement sentencia = null;
	private Statement sentencia2 = null;
	private ResultSet resultat = null;
	
	public void llegirDatabase(String codi) throws Exception{
		try {
			conexio = DriverManager.getConnection("jdbc:mysql://localhost/employees?user=root&password=cide");
			sentencia = conexio.createStatement();
			sentencia2 = conexio.createStatement();
			resultat = sentencia.executeQuery("select dept_no from departments");
			modificarNom(resultat, codi);
			
		} catch (SQLException e) {
			throw e;
		}
		finally {
			close();
		}
		
	}
	
	private void modificarNom(ResultSet resultat, String codi) throws SQLException{
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Per favor, introdueix el nou nom de departament");
		String nou_nom = sc.nextLine();
		
		while (resultat.next()) {
			
			String dept_no = resultat.getString("dept_no");
			if (dept_no.equals(codi)) {
				sentencia2.execute("delete from departments where dept_no = '"+dept_no+"';");
				sentencia2.execute("insert into departments(dept_no, dept_name) values ('"+dept_no+"', '"+nou_nom+"')");
				System.out.println("S'ha modificat el nom del departament nombre "+dept_no+" al nom: "+nou_nom);
			}
			
		}
	}
	
	private void close() {
        try {
            if (resultat != null) {
                resultat.close();
            }

            if (sentencia != null) {
                sentencia.close();
            }

            if (conexio != null) {
                conexio.close();
            }
        } catch (Exception e) {
        	
        }
    }
	
	
	public static void main(String[] args) {
		PRU05E01e2_Miquel_Frau database = new PRU05E01e2_Miquel_Frau();
		try {
			database.llegirDatabase(args[0]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
