package Model;

import java.io.Serializable;

public class Student implements Serializable {
	private int studentID;
	private String name;
	private String dateofBirth;
	private String location;
	private boolean sex;
	private float mathMark;
	private float engMark;
	private float literatureMark;
	private float gpa;
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}


	public Student(int studentID, String name, String dateofBirth, String location, boolean sex, float mathMark,
			float engMark, float literatureMark) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.dateofBirth = dateofBirth;
		this.location = location;
		this.sex = sex;
		this.mathMark = mathMark;
		this.engMark = engMark;
		this.literatureMark = literatureMark;
	}
	public Student(int studentID, String name, String dateofBirth, String location, boolean sex, float mathMark,
			float engMark, float literatureMark, float gpa) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.dateofBirth = dateofBirth;
		this.location = location;
		this.sex = sex;
		this.mathMark = mathMark;
		this.engMark = engMark;
		this.literatureMark = literatureMark;
		this.gpa = gpa;
	}
	public float getMathMark() {
		return mathMark;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public void setMathMark(float mathMark) {
		this.mathMark = mathMark;
	}

	public float getEngMark() {
		return engMark;
	}

	public void setEngMark(float engMark) {
		this.engMark = engMark;
	}

	public float getLiteratureMark() {
		return literatureMark;
	}

	public void setLiteratureMark(float literatureMark) {
		this.literatureMark = literatureMark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
