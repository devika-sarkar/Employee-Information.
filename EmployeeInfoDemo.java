package product;

import java.util.Scanner;

public class EmployeeInfoDemo {
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

