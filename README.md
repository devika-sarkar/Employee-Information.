# Employee-Information.
//BLC class

package product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

 public class Employee_Info {
    static Scanner sc=new Scanner(System.in);
	static Connection con=null;
    static PreparedStatement insert=null;
    static PreparedStatement retrieve=null;
    static PreparedStatement RetrievebyS=null;
    static PreparedStatement salary=null;
    static PreparedStatement UpdateWithId=null;
    static PreparedStatement deleteSalary=null;
    static PreparedStatement deleteend=null;
   
 
 static {
	
	 try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","sunday");
		insert = con.prepareStatement("insert into employeeInfo values(?,?,?,?,?,?)");	
		retrieve = con.prepareStatement("select * from employeeInfo");	
		RetrievebyS=con.prepareStatement("select * from employeeInfo where empName like 's%'");
	   salary=con.prepareStatement("select * from employeeInfo where empSalary between 100 AND 200");
	  UpdateWithId=con.prepareStatement("update employeeInfo set empsalary=? where empId=?");
	 deleteSalary=con.prepareStatement("delete employeeInfo where empSalary=(select max(empSalary)from employeeInfo)");
	 deleteend=con.prepareStatement("delete employeeInfo where empName like 'a%'");


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
	    String empName=sc.next();
	    
	    System.out.println("Enter the EmpSalary: ");
	    Double empSalary=sc.nextDouble();
	    
	    System.out.println("Enter the EmpAddress :");
	    String empAddress=sc.next();
	    
	    System.out.println("Enter the EmpMailId :");
	    String empMailId=sc.next();
	    
	    System.out.println("Enter the EmpPhNo :");
	    Long empPhNo=sc.nextLong();
     
	    insert.setInt(1, id);
	    insert.setString(2, empName);
	    insert.setDouble(3, empSalary);
	    insert.setString(4, empAddress);
	    insert.setString(5, empMailId);
	    insert.setLong(6, empPhNo);
	    insert.executeUpdate();
	    System.out.println("Data Added Successfully :");
	    }catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	    
 }
 public static void Retrieve(){
	 try {
		// System.out.println("Retrieve/View the EmployeeInformation ");
		 ResultSet eq = retrieve.executeQuery();
		 while(eq.next()) {
			 System.out.println(eq.getInt(1)+"\t"+eq.getString(2)+"\t"+eq.getDouble(3)+"\t"+eq.getString(4)+"\t"+eq.getString(5)+"\t"+eq.getLong(6));
			 
		 }
		 
	 }catch (Exception e) {
		e.printStackTrace();
	}
 }
 public static void RetrievebyS() {
	// System.out.println("Enter the EmployeeName whose name started with 'S':");
	 
	 try {
	
		 ResultSet eq = RetrievebyS.executeQuery();
		while(eq.next()) {
			 System.out.println(eq.getInt(1)+"\t"+eq.getString(2)+"\t"+eq.getDouble(3)+"\t"+eq.getString(4)+"\t"+eq.getString(5)+"\t"+eq.getLong(6));

		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	 
 }
 
 public static void salary() {
	// System.out.println("Enter the whose salary between 10000 to 20000");
	 
	 try {
		
		 ResultSet eq = RetrievebyS.executeQuery();
		while(eq.next()) {			
				System.out.println(eq.getInt(1)+"\t"+eq.getString(2)+"\t"+eq.getDouble(3)+"\t"+eq.getString(4)+"\t"+eq.getString(5)+"\t"+eq.getLong(6));

		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	 
 }
 public static void UpdateWithId(int id)  {
	 try {
	 //System.out.println("Update employee salary with the help of eid.");
	System.out.println("Enter emp_Salary :");
	 double empSalary=sc.nextDouble();
	
	 UpdateWithId.setDouble(1,empSalary );//update sal
	 UpdateWithId.setInt(2, id);//check id
	 int eu = UpdateWithId.executeUpdate();
	 if(eu>0) {
		 System.out.println("Salary updated");
	 }
 }
	 catch (Exception e) {
		e.printStackTrace();
	}
 }
 
 public static void deleteSalary()  {
	 try {		
			
			 int eu = deleteSalary.executeUpdate();
			 
			 if(eu>0) {
				 System.out.println("max salary deleted...");
			 }else {
				 System.out.println("invalid max salary..");
			 }
			 
		
		}
	 
	 catch (Exception e) {
		e.printStackTrace();
	}
 }
 
 public static void deleteend() {
	 try {
	 
	 int eu = deleteend.executeUpdate();
	 if(eu>0) {
		 System.out.println("deleted successfully whose name start with 'a'");
	 }
	 
 }catch (Exception e) {
	e.printStackTrace();
}
 }
 
 public class EmployeeInfoDemo 
 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Employee_Info emp=new Employee_Info();
		
		try {
			
		while(true) {
			System.out.println("\t1.Insert data into Employee Table.");
			System.out.println("\t2.Retrieve all Employee data.");
			System.out.println("\t3.Retrieve employee whose name stats with 'S'.");
			System.out.println("\t4.Retrieve employees whose salary between 10000 to 20000.");
			System.out.println("\t5.Update employee salary with the help of eid.");
			System.out.println("\t6.delete employee who is getting maximum salary.");
			System.out.println("\t7.delete employee whose name ends with 'a';");
			System.out.println("\t8.Exit.");
			
			System.out.println("..........Enter Choice........");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				Employee_Info.insert();
				break;
			case 2:
				Employee_Info.Retrieve();
				break;
			case 3:
				Employee_Info.RetrievebyS();
				break;
			case 4:
				Employee_Info.salary();
				break;
			case 5:
				System.out.println("enter eid u want to update");
				int id=sc.nextInt();
				Employee_Info.UpdateWithId(id);
				break;
			case 6:
				Employee_Info.deleteSalary();
				break;
			case 7:
				Employee_Info.deleteend();
				break;
			case 8:
				System.exit(0);
				
			}
			
		}
		
		
      }catch (Exception e) {
			e.printStackTrace();
		}
      }
}


 
  
  
  
  
  
}
