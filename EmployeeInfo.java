package employeeInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeInfo {
static	Scanner sc=new Scanner(System.in);
 static Connection insert=null;
 static Connection retrieve=null;
 
 static {
	 try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","sunday");
		 PreparedStatement insert=con.prepareStatement("insert into EmployeeInfo values(?,?,?,?,?,?)");
		 PreparedStatement retrieve=con.prepareStatement("select * from EmployeeInfo");	 
	 }catch (Exception e) {
		e.printStackTrace();
	}
 }
 
 
 public static void insert() {
	 try {
		System.out.println("***Enter the EmployeeInformation***");
	    System.out.println("Enter the empId");
		int id=sc.nextInt();
	    System.out.println("Enter the EmpName:");
	    int empName=sc.nextInt();
	    System.out.println("***Enter the EmpSalary: ");
	    int empSalary=sc.nextInt();
	    System.out.println("***Enter the EmpAddress :");
	    int empAddress=sc.nextInt();
	    System.out.println("***Enter the EmpMailId :");
	    int empMailId=sc.nextInt();
	    System.out.println("***Enter the EmpPhNo :");
	    int empPhNo=sc.nextInt();
	    
	 }catch (Exception e) {
		
	}
	 
	 
 }
 static class empInner{
	 Integer empId;
	 String empName;
	 Double empSalary;
	 String empAddress;
	 String empMailId;
	 Long empPhNo;
	
	 public empInner(Integer empId, String empName, Double empSalary, String empAddress, String empMailId,
			Long empPhNo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empAddress = empAddress;
		this.empMailId = empMailId;
		this.empPhNo = empPhNo;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpMailId() {
		return empMailId;
	}

	public void setEmpMailId(String empMailId) {
		this.empMailId = empMailId;
	}

	public Long getEmpPhNo() {
		return empPhNo;
	}

	public void setEmpPhNo(Long empPhNo) {
		this.empPhNo = empPhNo;
	}
	 
	 
	 
 }
 
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 
}
