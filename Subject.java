package ManageStudent;

public class Subject {
	private int code;
	private String subjectName;
	private double coefficient;
	
	
	public Subject() {
		super();
	}
	
	
	public Subject(int code, String subjectName, double coefficient) {
		super();
		this.code = code;
		this.subjectName = subjectName;
		this.coefficient = coefficient;
	}


	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public double getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	public String getNameSubject(int code) {
		return subjectName;
	}

	@Override
	public String toString() {
		return "Subject [code=" + code + ", subjectName=" + subjectName + ", coefficient=" + coefficient + "]";
	}
	
}
