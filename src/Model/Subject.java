package Model;

public class Subject {
	private int idSubject;
	private String subjectName;

	public int getIdSubject() {
		return idSubject;
	}
	public void setIdSubject(int idSubject) {
		this.idSubject = idSubject;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Subject(int idSubject, String subjectName) {
		super();
		this.idSubject = idSubject;
		this.subjectName = subjectName;
		
	}
	
}
