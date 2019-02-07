package conexioBBDD;

import java.sql.Date;

public class Employees {
	private int emp_no;
	private Date birth_date;
	private String first_name;
	private String last_name;
	
	public Employees(int emp_no, Date birth_date, String first_name, String last_name) {
		this.emp_no = emp_no;
		this.birth_date = birth_date;
		this.first_name = first_name;
		this.last_name = last_name;
	}
}
