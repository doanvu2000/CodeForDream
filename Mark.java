package ManageStudent;

import java.util.ArrayList;

public class Mark extends Student{
	private int studentCode;
	private int subjectCode;
	private double mark;	
	public Mark() {
		super();
	}
	public Mark(int studentCode, int subjectCode, double mark) {
		super();
		this.studentCode = studentCode;
		this.subjectCode = subjectCode;
		this.mark = mark;
	}
	
	public Mark(int studentCode, int subjectCode){
		super();
		this.studentCode = studentCode;
		this.subjectCode = subjectCode;
		this.mark = -1;
	}
	
	public int getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(int studentCode) {
		this.studentCode = studentCode;
	}
	public int getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}

}
