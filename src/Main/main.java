package Main;

import java.util.Scanner;

import Controller.StudentController;

public class main {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		String choose = null;
		boolean exit = false;
		StudentController studentManager = new StudentController();
		int studentId;
		String name;

		// show menu
		showMenu();
		while (true) {
			choose = scanner.nextLine();
			switch (choose) {
			case "1":
				studentManager.addNew();
				System.out.println("Add Success !");
				break;
			case "2":
				System.out.println("Enter ID to update :");
				studentId = studentManager.enterID();
				studentManager.edit(studentId);
				break;
			case "3":
				studentId = studentManager.enterID();
				studentManager.delete(studentId);
				break;
			case "4":
				System.out.println("Enter ID to find :");
				studentId = studentManager.enterID();
				studentManager.findStudent(studentId);
				break;
			case "10":
				System.out.println("Enter Name to find :");
				name = studentManager.enterName();
				studentManager.findStudentbyName(name);
				break;
			case "5":
				studentManager.sortstudent();
				studentManager.dupicatename();
				break;
			case "6":
				studentManager.sortbygpa();
				break;
			case "7":
				studentManager.printcountStudent();
				break;
			case "8":
				studentManager.wheretopbot();
				break;
			case "9":
				studentManager.show();
				break;
			case "11":
				studentManager.findDuplicatemonth();
				break;
			case "0":
				System.out.println("exited!");
				exit = true;
				break;
			default:
				System.out.println("invalid! please choose action in below menu:");
				break;
			}
			if (exit) {
				break;
			}
			// show menu
			showMenu();
		}
	}


	public static void showMenu() {
		System.out.println("-----------Menu------------");
		System.out.println("1. Add student.");
		System.out.println("2. Edit student by id.");
		System.out.println("3. Delete student by id.");
		System.out.println("4. Find student by id .");
		System.out.println("5. Sort by Name/ Duplicate Name");
		System.out.println("6. Sort by GPA.");
		System.out.println("7. Show Count Student by Ability ");
		System.out.println("8. Where Top bot student .");
		System.out.println("9. Show student.");
		System.out.println("10.Find by name ");
		System.out.println("11.Duplicate monthofbirth. ");
		System.out.println("0. exit.");
		System.out.println("---------------------------");
		System.out.print("Please choose: ");
	}
}