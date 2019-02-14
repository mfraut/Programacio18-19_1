package pru05.e01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class PRU05E01e1_Miquel_Frau {
	
	private Connection conexio = null;
	private Statement sentencia = null;
	private ResultSet resultat = null;
	
	public void llegirDatabase() throws Exception {
		try {
			conexio = DriverManager.getConnection("jdbc:mysql://localhost/employees?user=root&password=cide");
			sentencia = conexio.createStatement();
			resultat = sentencia.executeQuery("SELECT * FROM departments");
			escriureResultat(resultat);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	private void escriureResultat(ResultSet resultat) throws SQLException {
		
		while (resultat.next()) {
			String dept_no = resultat.getString("dept_no");
			String department_name = resultat.getString("dept_name");
			
			System.out.println("El nombre del departament és: " + dept_no +".\nEl departament és: "+department_name+".");
			System.out.println("================================");
		}
	}
	

	public static void main(String[] args) {
		
		PRU05E01e1_Miquel_Frau database = new PRU05E01e1_Miquel_Frau();
		
		try {
			database.llegirDatabase();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

