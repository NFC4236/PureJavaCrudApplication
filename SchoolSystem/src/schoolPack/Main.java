package schoolPack;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Schools obj = new Schools();
		Classes obj1 = new Classes();
		Principals obj2  = new Principals();
		Students obj3 = new Students();
		Courses obj4 = new Courses();		
		
		while(true){
			String message  = "1- School Data \n 2- Class Data \n 3- Principal Data \n 4- Student Data \n 5- Course Data";
			System.out.println(message);
			
			Scanner input = new Scanner(System.in);
			
			int choice = input.nextInt();
			
			switch(choice) {
			
			case 1:
				message  = "1- Insert Data  \n 2- Get Single Data \n 3-Get All Data \n 4- Delete Single Data \n 5- Delete All Data \n 6- Update Data";
				System.out.println(message);
				int choice1 = input.nextInt();
				
				if(choice1 == 1) {
					obj.setInsert();
				}
				else  if(choice1 == 2) {
					obj.getValues();
				}
				else if(choice1 == 3) {
					obj.getAllData();
				}
				else if(choice1 == 4) {
					obj.deleteData();
				}
				else if(choice1 == 5) {
					obj.deleteAllData();
				}
				
				else if(choice1 == 6) {
					obj.updateData();
				}
				else {
					 System.out.println("Wrong choice, please correct the input");
	            	 System.out.println("-------------------------------------------------");
				}
				
				break;
				
			case 2:
				
				message  = "1- Insert Data  \n 2- Get Single Data \n 3-Get All Data \n 4- Delete Single Data \n 5- Delete All Data \n 6- Update Data";
				System.out.println(message);
				int choice2 = input.nextInt();
				
				if(choice2 == 1) {
					obj1.setInsert();
				}
				else  if(choice2 == 2) {
					obj1.getValues();
				}
				else if(choice2 == 3) {
					obj1.getAllData();
				}
				else if(choice2 == 4) {
					obj1.deleteData();
				}
				else if(choice2 == 5) {
					obj1.deleteAllData();
				}
				
				else if(choice2 == 6) {
					obj1.updateData();
				}
				else {
					 System.out.println("Wrong choice, please correct the input");
	            	 System.out.println("-------------------------------------------------");
				}
				
				break;
				
			case 3:
				
				message  = "1- Insert Data  \n 2- Get Single Data \n 3-Get All Data \n 4- Delete Single Data \n 5- Delete All Data \n 6- Update Data";
				System.out.println(message);
				int choice3 = input.nextInt();
				
				if(choice3 == 1) {
					obj2.setInsert();
				}
				else  if(choice3 == 2) {
					obj2.getValues();
				}
				else if(choice3 == 3) {
					obj2.getAllData();
				}
				else if(choice3 == 4) {
					obj2.deleteData();
				}
				else if(choice3 == 5) {
					obj2.deleteAllData();
				}
				
				else if(choice3 == 6) {
					obj2.updateData();
				}
				else {
					 System.out.println("Wrong choice, please correct the input");
	            	 System.out.println("-------------------------------------------------");
				}
				
				break;
				
			case 4:
			
				message  = "1- Insert Data  \n 2- Get Single Data \n 3-Get All Data \n 4- Delete Single Data \n 5- Delete All Data \n 6- Update Data";
				System.out.println(message);
				int choice4 = input.nextInt();
				
				if(choice4 == 1) {
					obj3.setInsert();
				}
				else  if(choice4 == 2) {
					obj3.getValues();
				}
				else if(choice4 == 3) {
					obj3.getAllData();
				}
				else if(choice4 == 4) {
					obj3.deleteData();
				}
				else if(choice4 == 5) {
					obj3.deleteAllData();
				}
				
				else if(choice4 == 6) {
					obj3.updateData();
				}
				else {
					 System.out.println("Wrong choice, please correct the input");
	            	 System.out.println("-------------------------------------------------");
				}
				
				break;
				
			case 5:
				
				message  = "1- Insert Data  \n 2- Get Single Data \n 3-Get All Data \n 4- Delete Single Data \n 5- Delete All Data \n 6- Update Data";
				System.out.println(message);
				int choice5 = input.nextInt();
				
				if(choice5 == 1) {
					obj4.setInsert();
				}
				else  if(choice5 == 2) {
					obj4.getValues();
				}
				else if(choice5 == 3) {
					obj4.getAllData();
				}
				else if(choice5 == 4) {
					obj4.deleteData();
				}
				else if(choice5 == 5) {
					obj4.deleteAllData();
				}
				
				else if(choice5 == 6) {
					obj4.updateData();
				}
				else {
					 System.out.println("Wrong choice, please correct the input");
	            	 System.out.println("-------------------------------------------------");
				}
				
				break;
				
			default:
				
				 System.out.println("Wrong choice, please correct the input");
            	 System.out.println("-------------------------------------------------");
				break;
			}
			
		}
		

		
		
		
		
		//obj1.setInsert();
		//obj1.getValues();
		//obj1.getAllData();
		//obj1.deleteData();
		//obj1.deleteAllData();
		//obj1.updateData();
		
		//obj2.setInsert();
		//obj2.getValues();
		//obj2.getAllData();
		//obj2.deleteData();
		//obj2.deleteAllData();
		//obj2.updateData();
		
		
	}

}
