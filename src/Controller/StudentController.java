package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import Model.Student;

public class StudentController {
	private static final String STUDENT_FILE_NAME = "D:\\Workspace-Eclipse\\Student Management\\data.csv";

	public static Scanner scanner = new Scanner(System.in);

	public void addNew() throws Exception {
		int id = enterID();
		if (validateID(id) == false) {
			System.out.println("Exist Student ID, Please enter another ID !");
			id = enterID();
		}
		String name = enterName();
		String dateofbirth = enterDOB();
		String address = enterAddress();
		boolean sex = enterSex();
		float math = inputMath();
		float english = inputEng();
		float lit = inputLit();
		Student student = new Student(id, name, dateofbirth, address, sex, math, english, lit);
		FileOutputStream fos = new FileOutputStream(STUDENT_FILE_NAME, true);
		PrintWriter pw = new PrintWriter(fos);
		String bw = student.getStudentID() + "," + student.getName() + "," + student.getLocation() + ","
				+ student.getDateofBirth() + "," + student.isSex() + "," + student.getMathMark() + ","
				+ student.getEngMark() + "," + student.getLiteratureMark();
		StringBuilder sb = new StringBuilder();
		sb.append(bw);

		pw.println(sb);
		pw.close();
	}

	public boolean validateID(int id) {
		String line = "";
		String splitBy = ",";
		try {
			BufferedReader br = new BufferedReader(new FileReader(STUDENT_FILE_NAME));

			while ((line = br.readLine()) != null)
			// returns a Boolean value
			{
				String[] studentt = line.split(splitBy);
				for (int i = 1; i <= studentt.length; i++) {
					if (Integer.parseInt(studentt[0]) == id) {
						return false;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;

	}

	public void findStudent(int id) throws Exception {
		if (validateID(id) == false) {
			String line = "";
			String splitBy = ",";
			File file = new File(STUDENT_FILE_NAME);
			BufferedReader br = new BufferedReader(new FileReader(file));
			BufferedWriter wr = new BufferedWriter(new FileWriter(file, true));
			float math = 0;
			float english = 0;
			float lit = 0;
			float gpa = 0;
			try {
				while ((line = br.readLine()) != null)
				// returns a Boolean value
				{
					String[] studentt = line.split(splitBy);
					for (int i = 1; i <= studentt.length; i++) {
						if (Integer.parseInt(studentt[0]) == id) {
							math = Float.parseFloat(studentt[5]);
							english = Float.parseFloat(studentt[6]);
							lit = Float.parseFloat(studentt[7]);
							System.out.println(studentt[0] + "," + studentt[1] + "," + studentt[2] + ", " + studentt[3]
									+ ",  " + studentt[4] + ", " + studentt[5] + ", " + studentt[6] + ","
									+ studentt[7]);
							gpa = (math + english + lit) / 3;
							break;
						}
					}

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(checkStudent(gpa));
		} else {
			System.out.println("ID not found !, try again !");
			id = enterID();
		}
	}

	public void printcountStudent() throws Exception {
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(STUDENT_FILE_NAME));
		String line = null;
		String line1 = null;
		String splitBy = ",";
		float math = 0;
		float english = 0;
		float lit = 0;
		float gpa = 0;
		int n = 0;
		while ((line1 = reader.readLine()) != null) {
			n++;
		}
		float[] sb = new float[n];
		int i1 = 0;
		BufferedReader reader1 = null;
		reader1 = new BufferedReader(new FileReader(STUDENT_FILE_NAME));
		while ((line = reader1.readLine()) != null) {
			String[] studentt = line.split(splitBy);

			math = Float.parseFloat(studentt[5]);
			english = Float.parseFloat(studentt[6]);
			lit = Float.parseFloat(studentt[7]);
			gpa = (math + lit + english) / 3;
			sb[i1] = gpa;
			i1++;
			System.out.println(studentt[0] + "," + studentt[1] + "," + studentt[2] + ", " + studentt[3] + ",  "
					+ studentt[4] + ", " + studentt[5] + ", " + studentt[6] + "," + studentt[7] + "," + gpa);

		}
		for (int j = 0; j < sb.length; j++) {
			Arrays.sort(sb);
		}
		countstudent(sb);
	}

	public String checkStudent(float gpa) {
		if (gpa < 3) {
			return "Weak!";
		} else if (gpa < 5) {
			return "BelowAverage !";
		} else if (gpa < 6.5) {
			return "Average !";
		} else if (gpa < 8) {
			return "Good !";
		} else
			return "Excellent";
	}

	public void edit(int id) throws Exception {
		String line = "";
		String splitBy = ",";
		String name = enterName();
		String dateofbirth = enterDOB();
		String address = enterAddress();
		boolean sex = enterSex();
		float math = inputMath();
		float english = inputEng();
		float lit = inputLit();
		File file = new File(STUDENT_FILE_NAME);
		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter wr = new BufferedWriter(new FileWriter(file, true));
		try {
			while ((line = br.readLine()) != null)
			// returns a Boolean value
			{
				String[] studentt = line.split(splitBy);
				for (int i = 1; i <= studentt.length; i++) {
					if (Integer.parseInt(studentt[0]) == id) {
						studentt[1] = name;
						studentt[2] = dateofbirth;
						studentt[3] = address;
						studentt[4] = String.valueOf(sex);
						studentt[5] = String.valueOf(math);
						studentt[6] = String.valueOf(english);
						studentt[7] = String.valueOf(lit);
					}
				}
				System.out.println(studentt[0] + "," + studentt[1] + "," + studentt[2] + ", " + studentt[3] + ",  "
						+ studentt[4] + ", " + studentt[5] + ", " + studentt[6] + "," + studentt[7]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void duplicateMonth(List<Student> list) throws Exception{
		System.out.println("\n");
		System.out.println("List Student duplicate month");
		for (int i = 0; i < list.size()-1; i++) {
			String mont1[] = list.get(i).getDateofBirth().split("/");
			for (int j = i + 1; j < list.size(); j++) {
				String mont2[] = list.get(j).getDateofBirth().split("/");
				if (mont1[1].equals(mont2[1])) {
					System.out.println(list.get(i).getStudentID() + "," + list.get(i).getName() + ","
							+ list.get(i).getDateofBirth() + ", " + list.get(i).getLocation() + ",  "
							+ list.get(i).isSex() + "," + list.get(i).getGpa());
					System.out.println(list.get(j).getStudentID() + "," + list.get(j).getName() + ","
							+ list.get(j).getDateofBirth() + ", " + list.get(j).getLocation() + ",  "
							+ list.get(j).isSex() + "," + list.get(j).getGpa() + "\n");
				}
			}
		}
	}
	public void findDuplicatemonth() throws Exception {
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(STUDENT_FILE_NAME));
		String line = null;
		String splitBy = ",";
		float math = 0;
		float english = 0;
		float lit = 0;
		float gpa = 0;
		List<Student> listStu = new ArrayList<Student>();
		while ((line = reader.readLine()) != null) {
			String[] studentt = line.split(splitBy);
			int idstu = Integer.parseInt(studentt[0]);
			String namestu = studentt[1].toString();
			String dateofbir = studentt[2].toString();
			String loc = studentt[3].toString();
			Boolean gender = Boolean.valueOf(studentt[4]);
			math = Float.parseFloat(studentt[5]);
			english = Float.parseFloat(studentt[6]);
			lit = Float.parseFloat(studentt[7]);
			gpa = (math + lit + english) / 3;
			Student stu = new Student(idstu, namestu, dateofbir, loc, gender, math, english, lit);
			listStu.add(stu);
		}
		duplicateMonth(listStu);
	}
	public void sortstudent() throws Exception {
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(STUDENT_FILE_NAME));
		String line = null;
		String splitBy = ",";
		float math = 0;
		float english = 0;
		float lit = 0;
		float gpa = 0;
		List<Student> listStu = new ArrayList<Student>();
		while ((line = reader.readLine()) != null) {
			String[] studentt = line.split(splitBy);
			int idstu = Integer.parseInt(studentt[0]);
			String namestu = studentt[1].toString();
			String dateofbir = studentt[2].toString();
			String loc = studentt[3].toString();
			Boolean gender = Boolean.valueOf(studentt[4]);
			math = Float.parseFloat(studentt[5]);
			english = Float.parseFloat(studentt[6]);
			lit = Float.parseFloat(studentt[7]);
			gpa = (math + lit + english) / 3;
			Student stu = new Student(idstu, namestu, dateofbir, loc, gender, math, english, lit);
			listStu.add(stu);
		}
		Collections.sort(listStu, new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return s1.getName().compareToIgnoreCase(s2.getName());
			}
		});
		printListbyName(listStu);
	}

	public void wheretopbot() throws Exception {
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(STUDENT_FILE_NAME));
		String line = null;
		String splitBy = ",";
		float math = 0;
		float english = 0;
		float lit = 0;
		float gpa = 0;
		List<Student> listStuu = new ArrayList<Student>();
		while ((line = reader.readLine()) != null) {
			String[] studentt = line.split(splitBy);
			int idstu = Integer.parseInt(studentt[0]);
			String namestu = studentt[1].toString();
			String dateofbir = studentt[2].toString();
			String loc = studentt[3].toString();
			Boolean gender = Boolean.valueOf(studentt[4]);
			math = Float.parseFloat(studentt[5]);
			english = Float.parseFloat(studentt[6]);
			lit = Float.parseFloat(studentt[7]);
			gpa = (math + lit + english) / 3;
			Student stu = new Student(idstu, namestu, dateofbir, loc, gender, math, english, lit, gpa);
			listStuu.add(stu);
		}
		Collections.sort(listStuu, new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return Float.valueOf(s1.getGpa()).compareTo(Float.valueOf(s2.getGpa()));
			}
		});
		topbotStu(listStuu);
	}

	public void dupicatename() throws Exception {
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(STUDENT_FILE_NAME));
		String line = null;
		String splitBy = ",";
		float math = 0;
		float english = 0;
		float lit = 0;
		float gpa = 0;
		List<Student> listStuu = new ArrayList<Student>();
		while ((line = reader.readLine()) != null) {
			String[] studentt = line.split(splitBy);
			int idstu = Integer.parseInt(studentt[0]);
			String namestu = studentt[1].toString();
			String dateofbir = studentt[2].toString();
			String loc = studentt[3].toString();
			Boolean gender = Boolean.valueOf(studentt[4]);
			math = Float.parseFloat(studentt[5]);
			english = Float.parseFloat(studentt[6]);
			lit = Float.parseFloat(studentt[7]);
			gpa = (math + lit + english) / 3;
			Student stu = new Student(idstu, namestu, dateofbir, loc, gender, math, english, lit, gpa);
			listStuu.add(stu);
		}
		
		printDupliName(listStuu);
	}

	public void sortbygpa() throws Exception {
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(STUDENT_FILE_NAME));
		String line = null;
		String splitBy = ",";
		float math = 0;
		float english = 0;
		float lit = 0;
		float gpa = 0;
		List<Student> listStuu = new ArrayList<Student>();
		while ((line = reader.readLine()) != null) {
			String[] studentt = line.split(splitBy);
			int idstu = Integer.parseInt(studentt[0]);
			String namestu = studentt[1].toString();
			String dateofbir = studentt[2].toString();
			String loc = studentt[3].toString();
			Boolean gender = Boolean.valueOf(studentt[4]);
			math = Float.parseFloat(studentt[5]);
			english = Float.parseFloat(studentt[6]);
			lit = Float.parseFloat(studentt[7]);
			gpa = (math + lit + english) / 3;
			Student stu = new Student(idstu, namestu, dateofbir, loc, gender, math, english, lit, gpa);
			listStuu.add(stu);
		}
		Collections.sort(listStuu, new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return Float.valueOf(s1.getGpa()).compareTo(Float.valueOf(s2.getGpa()));
			}
		});
		printListgpa(listStuu);
	}

	public void topbotStu(List<Student> listStu) {
		System.out.println("Top : " + listStu.get(listStu.size() - 1).getStudentID() + ","
				+ listStu.get(listStu.size() - 1).getName() + "," + listStu.get(listStu.size() - 1).getDateofBirth()
				+ ", " + listStu.get(listStu.size() - 1).getLocation() + ",  " + listStu.get(listStu.size() - 1).isSex()
				+ "," + listStu.get(listStu.size() - 1).getGpa());

		System.out.println("Bot : " + listStu.get(0).getStudentID() + "," + listStu.get(0).getName() + ","
				+ listStu.get(0).getDateofBirth() + ", " + listStu.get(0).getLocation() + ",  " + listStu.get(0).isSex()
				+ "," + listStu.get(0).getGpa());

	}

	public void printListbyName(List<Student> listStu) {
		System.out.println("\n");
		System.out.println("List Student by name");
		for (int i = 0; i < listStu.size(); i++) {
			System.out.println(listStu.get(i).getStudentID() + "," + listStu.get(i).getName() + ","
					+ listStu.get(i).getDateofBirth() + ", " + listStu.get(i).getLocation() + ",  "
					+ listStu.get(i).isSex() + ", " + listStu.get(i).getMathMark() + ", " + listStu.get(i).getEngMark()
					+ "," + listStu.get(i).getLiteratureMark());
		}
	}

	public void printListbyid(List<Student> listStu) {
		System.out.println("\n");
		System.out.println("List Student");
		for (int i = 0; i < listStu.size(); i++) {
			System.out.println(listStu.get(i).getStudentID() + "," + listStu.get(i).getName() + ","
					+ listStu.get(i).getDateofBirth() + ", " + listStu.get(i).getLocation() + ",  "
					+ listStu.get(i).isSex() + ", " + listStu.get(i).getMathMark() + ", " + listStu.get(i).getEngMark()
					+ "," + listStu.get(i).getLiteratureMark());
		}
	}

	public void printDupliName(List<Student> list) {
		System.out.println("\n");
		System.out.println("List Student duplicate Name");
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).getName().equals(list.get(j).getName())) {
					System.out.println(list.get(i).getStudentID() + "," + list.get(i).getName() + ","
							+ list.get(i).getDateofBirth() + ", " + list.get(i).getLocation() + ",  "
							+ list.get(i).isSex() + "," + list.get(i).getGpa());
					System.out.println(list.get(j).getStudentID() + "," + list.get(j).getName() + ","
							+ list.get(j).getDateofBirth() + ", " + list.get(j).getLocation() + ",  "
							+ list.get(j).isSex() + "," + list.get(j).getGpa() + "\n");
				}
			}
		}
	}

	public void printListgpa(List<Student> listStu) {
		System.out.println("\n");
		System.out.println("List Student by GPA");
		for (int i = 0; i < listStu.size(); i++) {
			System.out.println(listStu.get(i).getStudentID() + "," + listStu.get(i).getName() + ","
					+ listStu.get(i).getDateofBirth() + ", " + listStu.get(i).getLocation() + ",  "
					+ listStu.get(i).isSex() + "," + listStu.get(i).getGpa());
		}
	}

	public void delete(int id) throws Exception {
		String line = "";
		String splitBy = ",";
		String splitit = "@";
		try {
			BufferedReader br = new BufferedReader(new FileReader(STUDENT_FILE_NAME));
			while ((line = br.readLine()) != null) {
				String[] studentt = line.split(splitBy);
				if (Integer.parseInt(studentt[0]) == id)
					continue;
				System.out.println(studentt[0] + "," + studentt[1] + "," + studentt[2] + ", " + studentt[3] + ",  "
						+ studentt[4] + ", " + studentt[5] + ", " + studentt[6] + ", " + studentt[7]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void countstudent(float[] a) {
		int gioi = 0, kha = 0, trung = 0, yeu = 0, kem = 0, sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (checkStudent(a[i]).equals("Weak!")) {
				kem++;
			} else if (checkStudent(a[i]).equals("BelowAverage !")) {
				yeu++;
			} else if (checkStudent(a[i]).equals("Average !")) {
				trung++;
			} else if (checkStudent(a[i]).equals("Good !")) {
				kha++;
			} else {
				gioi++;
			}
		}
		sum = gioi + kha + trung + yeu + kem;
		System.out.println("Have " + kem + "Weak !");
		System.out.println("Have " + yeu + "BelowAverage !");
		System.out.println("Have " + trung + "Average !");
		System.out.println("Have " + kha + "Good !");
		System.out.println("Have " + gioi + "Excellent !");

		System.out.println("Excellent:" + (float) (gioi * 100 / sum) + "%");
		System.out.println("Good:" + (float) (kha * 100 / sum) + "%");
		System.out.println("Average:" + (float) (trung * 100 / sum) + "%");
		System.out.println("BelowAverage:" + (float) (yeu * 100 / sum) + "%");
		System.out.println("Weak:" + (float) (kem * 100 / sum) + "%");

	}

	private float inputMath() {
		System.out.print("Input student Math mark: ");
		while (true) {
			try {
				float gpa = Float.parseFloat((scanner.nextLine()));
				if (gpa < 0.0 && gpa > 10.0) {
					throw new NumberFormatException();
				}
				return gpa;
			} catch (NumberFormatException ex) {
				System.out.print("invalid! Input student gpa again: ");
			}
		}
	}

	private float inputEng() {
		System.out.print("Input student English mark: ");
		while (true) {
			try {
				float gpa = Float.parseFloat((scanner.nextLine()));
				if (gpa < 0.0 && gpa > 10.0) {
					throw new NumberFormatException();
				}
				return gpa;
			} catch (NumberFormatException ex) {
				System.out.print("invalid! Input student gpa again: ");
			}
		}
	}

	private float inputLit() {
		System.out.print("Input student Lit marr: ");
		while (true) {
			try {
				float gpa = Float.parseFloat((scanner.nextLine()));
				if (gpa < 0.0 && gpa > 10.0) {
					throw new NumberFormatException();
				}
				return gpa;
			} catch (NumberFormatException ex) {
				System.out.print("invalid! Input student gpa again: ");
			}
		}
	}

	public void show() throws Exception {
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(STUDENT_FILE_NAME));
		String line = null;
		String splitBy = ",";
		float math = 0;
		float english = 0;
		float lit = 0;
		float gpa = 0;
		List<Student> listStuu = new ArrayList<Student>();
		while ((line = reader.readLine()) != null) {
			String[] studentt = line.split(splitBy);
			int idstu = Integer.parseInt(studentt[0]);
			String namestu = studentt[1].toString();
			String dateofbir = studentt[2].toString();
			String loc = studentt[3].toString();
			Boolean gender = Boolean.valueOf(studentt[4]);
			math = Float.parseFloat(studentt[5]);
			english = Float.parseFloat(studentt[6]);
			lit = Float.parseFloat(studentt[7]);
			gpa = (math + lit + english) / 3;
			Student stu = new Student(idstu, namestu, dateofbir, loc, gender, math, english, lit, gpa);
			listStuu.add(stu);
		}
		System.out.println(listStuu.size());
		Collections.sort(listStuu, new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return Integer.valueOf(s1.getStudentID()).compareTo(Integer.valueOf(s2.getStudentID()));
			}
		});
		printListbyid(listStuu);
	}

	private boolean enterSex() {
		System.out.print("Input Sex: 1==> Male || 0==> Female ");
		int sex = scanner.nextInt();
		boolean sexx;
		if (sex == 1) {
			sexx = true;
			;
		}
		sexx = false;
		return sexx;
	}

	private String enterDOB() {
		System.out.print("Input Date of Birth, type dd/mm/yyyy: ");
		String dateofBirth = scanner.nextLine();
		return dateofBirth;
	}

	private String enterAddress() {
		System.out.print("Input student address: ");
		return scanner.nextLine();
	}

	public void findStudentbyName(String name) throws Exception {
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(STUDENT_FILE_NAME));
		String line = null;
		String splitBy = ",";
		float math = 0;
		float english = 0;
		float lit = 0;
		float gpa = 0;
		List<Student> listStu = new ArrayList<Student>();
		while ((line = reader.readLine()) != null) {
			String[] studentt = line.split(splitBy);
			int idstu = Integer.parseInt(studentt[0]);
			String namestu = studentt[1].toString();
			String dateofbir = studentt[2].toString();
			String loc = studentt[3].toString();
			Boolean gender = Boolean.valueOf(studentt[4]);
			math = Float.parseFloat(studentt[5]);
			english = Float.parseFloat(studentt[6]);
			lit = Float.parseFloat(studentt[7]);
			Student stu = new Student(idstu, namestu, dateofbir, loc, gender, math, english, lit);
			listStu.add(stu);
		}
		for (int i = 0; i < listStu.size(); i++) {
			if (listStu.get(i).getName().contains(name)) {
				System.out.println(listStu.get(i).getStudentID() + "," + listStu.get(i).getName() + ","
						+ listStu.get(i).getDateofBirth() + ", " + listStu.get(i).getLocation() + ",  "
						+ listStu.get(i).isSex());
			}
		}
	}

	public String enterName() {
		System.out.print("Input your name: ");
		return scanner.nextLine();
	}

	public int enterID() {
		System.out.print("Input student id: ");
		while (true) {
			try {
				int id = Integer.parseInt((scanner.nextLine()));
				return id;
			} catch (NumberFormatException ex) {
				System.out.print("invalid! Input student id again: ");
			}
		}
	}

}
