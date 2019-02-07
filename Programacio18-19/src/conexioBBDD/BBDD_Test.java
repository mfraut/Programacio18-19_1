package conexioBBDD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BBDD_Test {

	private Connection conectar = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private ResultSet contador = null;
	private Employees[] empleats;
	public void readDatabase() throws Exception {
		try {
			conectar = DriverManager.getConnection("jdbc:mysql://localhost/ejercicio25?user=root&password=cide");
			statement = conectar.createStatement();
			contador = statement.executeQuery("count(*)");
			resultSet = statement.executeQuery("select emp_no,birth_date,first_name,last_name from employees limit 2");
			writeResultSet(resultSet);

		}
		catch (Exception e) {
			throw e;
		}
		finally {
			close();
		}
	}
	
private void writeResultSet(ResultSet resultSet) throws SQLException {
	
		int contador = 0;
        while (resultSet.next()) {        	
        	
        	
        	int emp_no = resultSet.getInt("emp_no");
            Date birth_date = resultSet.getDate("birth_date");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            
      
            
            Employees empleat = new Employees(emp_no, birth_date, first_name, last_name);
            
            fillArray(empleat, empleats, contador);
            contador++;
           
        }
    }
	
	private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (conectar != null) {
                conectar.close();
            }
        } catch (Exception e) {
        	
        }
    }
	
	private void fillArray(Employees empleat, Employees[] empleats, int contador) {
		
		empleats[contador] = empleat;
		
	}
	
	public static void main(String[] args) throws Exception {
		BBDD_Test bbdd = new BBDD_Test();
		bbdd.readDatabase();

	}

}
