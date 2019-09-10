package ManageStudent;

public class Student {
	private int code;
	private String firstName;
	private String name;
	private int birth;
	private String gender;
	
	
	
	public Student() {
		super();
	}
	
	
	public Student(int code, String firstName, String name, int birth, String gender) {
		super();
		this.code = code;
		this.firstName = firstName;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
	}


	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return " code:" + code + " name:" + firstName +" "+name + " birth:" + birth
				+ " gender:" + gender;
	}
	
}
