package ManageStudent;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageStudentUtils {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Mark> markList = new ArrayList<Mark>();
	static ArrayList<Student> studentList = new ArrayList<Student>();
	static ArrayList<Subject> subjectList = new ArrayList<Subject>();
	static ArrayList<Integer> check = new ArrayList<Integer>();

	public static void main(String[] args) {
		studentList.add(new Student(101, "Vu Van", "Doan", 2000, "Nam"));
		studentList.add(new Student(102, "Tran Thu", "Hoai", 2000, "Nu"));
		studentList.add(new Student(103, "Tran Van", "Cuong", 1999, "Nam"));
		subjectList.add(new Subject(01, "Java", 3));
		subjectList.add(new Subject(02, "C++", 2.0));
		subjectList.add(new Subject(03, "SQL", 2));
		subjectList.add(new Subject(04, "HTML", 2));
		markList.add(new Mark(101, 01, 8.5));
		markList.add(new Mark(101, 04));
		markList.add(new Mark(101, 03));
		markList.add(new Mark(101, 02, 9.5));
		markList.add(new Mark(102, 01, 9.0));
		markList.add(new Mark(102, 02, 10));
		markList.add(new Mark(102, 03, 8.6));
		markList.add(new Mark(103, 01));
		markList.add(new Mark(103, 02));
		menu();
	}

	// sort danh sach sinh vien theo AlphaB
	public static void sort() {
		for (int i = 0; i < studentList.size() - 1; i++) {
			for (int j = i + 1; j < studentList.size(); j++) {
				if (studentList.get(i).getName().compareToIgnoreCase(studentList.get(j).getName()) > 0) {
					Student st = studentList.get(i);
					studentList.set(i, studentList.get(j));
					studentList.set(j, st);
				}
			}
		}
	}
	// end sort
	// ***********************************************************************

	public static void menu() {
		System.out.println("==============================Menu(I)==============================\n");
		System.out.println("0.Thoat chuong trinh");
		System.out.println("1.Cap nhat danh sach");
		System.out.println("2.Hien thi bang diem sinh vien");
		System.out.println("3.Tim kiem");
		System.out.println("\t3.1.Tim kiem theo ma sinh vien");
		System.out.println("\t3.2.Tim kiem theo ma mon hoc\n");
		System.out.println("===================================================================\n");
		int select;
		do {
			System.out.print("Moi ban nhap lua chon(menu(I)): ");
			select = scan.nextInt();
			switch (select) {
			case 1:
				updateList();
				break;
			case 2:
				displayList();
				break;
			case 3:
				find();
				break;
			case 0:
				return;
			default:
				System.out.println("Khong hop le");
				return;
			}
		} while (true);
	}

	// funcion1: Them sua xoa danh sach:Student, Subject, Mark
	public static void updateList() {
		System.out.println("\t==========================Menu(I_1)==========================\n");
		System.out.print("\t1.Update Students");
		System.out.println("\t2.Update Subjects");
		System.out.print("\t3.Update Mark");
		System.out.println("\t\t4.Quay lai menu(I)");
		System.out.println("\t===========================================================\n");
		int select;
		do {
			System.out.print("\tMoi ban nhap lua chon(menu(I_1)): ");
			select = scan.nextInt();
			switch (select) {
			case 1:
				updateStudent();
				break;
			case 2:
				updateSubject();
				break;
			case 3:
				updateMark();
				break;
			case 4:
				return;
			default:
				System.out.println("Khong hop le");
				return;
			}
		} while (true);
	}

	// indexof Student: Kiem tra xem sinh vien da co trong danh sach chua
	public static int indexOfStudent(int code) {
		for (int i = 0; i < studentList.size(); i++) {
			if (code == studentList.get(i).getCode())
				return i;
		}
		return -1;
	}// end indexofStudent

	// indexofStudentMark: Kiem tra xem sinh vien da co diem chua
	public static int indexOfStudentMark(int studentCode) {
		for (int i = 0; i < markList.size(); i++) {
			if (studentCode == markList.get(i).getStudentCode() && markList.get(i).getMark() > -1)
				return i;
		}
		return -1;
	}// end indexofMark

	// updateStudent
	public static void updateStudent() {
		System.out.println("\t\t==========================Menu(I_1_1)==========================\n");
		System.out.println(
				"\t\t1.Them sinh vien\t 2.Sua thong tin sinh vien\n\t\t3.Xoa sinh vien\t\t 4.Hien thi danh sach sinh vien\n\t\t5.Quay lai menu(I_1)");
		System.out.println("\t\t===========================================================\n");
		int select;
		do {
			System.out.print("\t\tMoi ban nhap lua chon(menu(I_1_1)): ");
			select = scan.nextInt();
			int newCode = 0, index;
			String temp;
			switch (select) {
			case 1: // them sinh vien
				System.out.print("\t\tNhap ma sinh vien can them: ");
				scan.nextLine();
				do {
					temp = scan.nextLine();
					if (checkNumber(temp))
						newCode = Integer.parseInt(temp);
					else
						System.out.print("\t\tNhap lai,ma sv phai la so: ");
				} while (!checkNumber(temp));
				index = indexOfStudent(newCode);
				if (index != -1) {
					System.out.println("\t\tSinh vien nay da co trong danh sach => menu(I_1)");
					return;
				}
				// nhap thong tin cua sinh vien moi
				String firstName;
				String name;
				int birth;
				String gender;
				System.out.print("\t\tNhap ho dem: ");
				// scan.nextLine();
//				boolean checkFirst = false;
//				do {
//					checkFirst = true;
//					firstName = scan.nextLine();
//					String[] checkFirstName = firstName.split(" ");
//					for(int i=0;i<checkFirstName.length;i++) {
//						if (!checkString(checkFirstName[i])) {
//							System.out.print("\tHo dem chi dc chua cac ki tu a-z va A-Z,nhap lai: ");
//							checkFirst = false;
//							// xoa het phan tu trong checkFirstName
//							break;
//						}
//					}
//					
//				} while (!checkFirst);
				firstName = scan.nextLine();
				System.out.print("\t\tNhap ten: ");
				name = scan.nextLine();
				System.out.print("\t\tNhap nam sinh: ");
				birth = scan.nextInt();
				System.out.print("\t\tNhap gioi tinh: ");
				scan.nextLine();
				gender = scan.nextLine();
				// end nhap thong tin
				Student st = new Student(newCode, firstName, name, birth, gender);
				studentList.add(st);
				System.out.println("\t\t Ban da them thanh cong sinh vien co ma sv: " + newCode);
				break;
			case 2: // sua thong tin sinh vien
				System.out.print("\t\tNhap ma sinh vien can sua: ");
				scan.nextLine();
				do {
					temp = scan.nextLine();
					if (checkNumber(temp))
						newCode = Integer.parseInt(temp);
					else
						System.out.print("\t\tNhap lai,ma sv phai la so: ");
				} while (!checkNumber(temp));
				index = indexOfStudent(newCode);
				if (index == -1) {
					System.out.println("\t\tSinh vien nay khong co trong danh sach => menu(I_1)");
					return;
				}
				// display sinh vien can sua
				System.out.println("\t\tBan dang sua sinh vien sau: ");
				System.out.println("\t\t" + studentList.get(index));
				// sua thong tin sinh vien nay
				System.out.print("\t\tNhap ho dem moi: ");
				// scan.nextLine();
				firstName = scan.nextLine();
				System.out.print("\t\tNhap ten moi: ");
				name = scan.nextLine();
				System.out.print("\t\tNhap nam sinh moi: ");
				birth = scan.nextInt();
				System.out.print("\t\tNhap gioi tinh: ");
				scan.nextLine();
				gender = scan.nextLine();
				// end nhap thong tin
				studentList.get(index).setFirstName(firstName);
				studentList.get(index).setName(name);
				studentList.get(index).setBirth(birth);
				studentList.get(index).setGender(gender);
				System.out.println("\t\t Ban da sua thanh cong sinh vien co ma sv: " + newCode);
				System.out.println("\t\t" + studentList.get(index));
				break;
			case 3: // xoa sinh vien
				System.out.print("\t\tNhap ma sinh vien can xoa: ");
				scan.nextLine();
				do {
					temp = scan.nextLine();
					if (checkNumber(temp))
						newCode = Integer.parseInt(temp);
					else
						System.out.print("\t\tNhap lai,ma sv phai la so: ");
				} while (!checkNumber(temp));
				index = indexOfStudent(newCode);
				if (index == -1) {
					System.out.println("\t\tSinh vien nay khong co trong danh sach => menu(I_1)");
					return;
				}
				int index01 = indexOfStudentMark(newCode);
				if (index01 != -1.0) {
					System.out.println("\t\tSinh vien nay da hoc ,khong the xoa => menu(I_1)");
					return;
				}
				studentList.remove(index);
				System.out.println("\t\tBan da xoa thanh cong sinh vien co ma sv: " + newCode);
				break;
			case 4: // hien thi danh sach sinh vien
				sort();
				System.out.println("\t\tDanh sach sinh vien");
				int stt = 1;
				for (Student s : studentList) {
					System.out.println("\t\t" + stt + "." + s.toString());
					stt++;
				}
				break;
			case 5:
				return;
			default:
				System.out.println("\t\tKhong hop le");
				return;
			}
		} while (true);
	}
	// updateSubject

	// indexOfSubject: Kiem tra xem mon hoc da co chua
	public static int indexOfSubject(int code) {
		for (int i = 0; i < subjectList.size(); i++) {
			if (code == subjectList.get(i).getCode())
				return i;
		}
		return -1;
	}// end indexOfSubject

	public static void updateSubject() {
		System.out.println("\t\t==========================Menu(I_1_2)==========================\n");
		System.out
				.println("\t\t1.Them mon hoc\t 2.Sua thong tin mon hoc\n\t\t3.Xoa mon hoc\t4.Hien thi danh sach mon hoc"
						+ "\n\t\t5.Quay lai menu(I_1)");
		System.out.println("\t\t===========================================================\n");
		int select;
		int newCode = 0;
		String subjectName;
		double coefficient;
		int index;
		String temp;
		do {
			System.out.print("\t\tMoi ban nhap lua chon(menu(I_1_2)): ");
			select = scan.nextInt();
			switch (select) {
			case 1: // them mon hoc
				System.out.print("\t\tNhap ma mon hoc can them: ");
				scan.nextLine();
				do {
					temp = scan.nextLine();
					if (checkNumber(temp))
						newCode = Integer.parseInt(temp);
					else
						System.out.print("\t\tNhap lai,ma MH phai la so: ");
				} while (!checkNumber(temp));
				index = indexOfSubject(newCode);
				if (index != -1) {
					System.out.println("\t\tMon hoc nay da co trong danh sach => menu(I_1)");
					return;
				}
				// nhap thong tin cua mon hoc moi
				System.out.print("\t\tNhap ten mon hoc: ");
				subjectName = scan.nextLine();
				System.out.print("\t\tNhap he so: ");
				coefficient = scan.nextDouble();
				// end nhap thong tin
				Subject sb = new Subject(newCode, subjectName, coefficient);
				subjectList.add(sb);
				System.out.println("\t\t Ban da them thanh cong mon hoc co ma: " + newCode);
				break;
			case 2: // sua mon hoc
				System.out.print("\t\tNhap ma mon hoc can sua: ");
				scan.nextLine();
				do {
					temp = scan.nextLine();
					if (checkNumber(temp))
						newCode = Integer.parseInt(temp);
					else
						System.out.print("\t\tNhap lai,ma MH phai la so: ");
				} while (!checkNumber(temp));
				index = indexOfSubject(newCode);
				if (index == -1) {
					System.out.println("\t\tMon hoc nay khong co trong danh sach => menu(I_1)");
					return;
				}
				// display ra mon hoc dang sua
				System.out.println("\t\tMon hoc ban dang sua: ");
				System.out.println("\t\t" + subjectList.get(index).toString()); // end display

				// nhap thong tin moi cua mon hoc
				System.out.print("\t\tNhap ten  moi cua mon hoc: ");
				
				subjectName = scan.nextLine();
				System.out.print("\t\tNhap he so moi: ");
				coefficient = scan.nextDouble();// end nhap thong tin

				// set lai thong tin cho mon hoc
				subjectList.get(index).setCoefficient(coefficient);
				subjectList.get(index).setSubjectName(subjectName); // end set
				System.out.println("\t\t Ban da sua thanh cong mon hoc co ma: " + newCode);
				System.out.println("\t\t" + subjectList.get(index).toString());
				break;
			case 3: // xoa mon hoc
				System.out.print("\t\tNhap ma mon hoc can xoa: ");
				scan.nextLine();
				do {
					temp = scan.nextLine();
					if (checkNumber(temp))
						newCode = Integer.parseInt(temp);
					else
						System.out.print("\t\tNhap lai,ma MH phai la so: ");
				} while (!checkNumber(temp));
				index = indexOfSubject(newCode);
				if (index == -1) {
					System.out.println("\t\tMon hoc nay khong co trong danh sach => menu(I_1)");
					return;
				}
				int index01 = indexOfStudentMark(newCode);
				if (index01 != -1) {// kiem tra xem da co sinh vien nao hoc mon nay chua
					System.out.println("\t\tMon hoc nay da co sinh vien hoc, khong the xoa!=> menu(I_1)");
					return;
				}
				subjectList.remove(index);
				System.out.println("\t\t Ban da xoa thanh cong mon hoc co ma: " + newCode);
				break;
			case 4:// hien thi danh sach mon hoc
				System.out.println("\t\tDanh sach mon hoc");
				int stt = 1;
				for (Subject s : subjectList) {
					System.out.println("\t\t" + stt + "." + s.toString());
					stt++;
				}
				break;
			case 5:
				return;
			default:
				System.out.println("\t\tKhong hop le");
			}
		} while (true);
	}

	// updateMark
	// indexOfSSM: kiem tra xe sinh vien da co diem o mon hoc nay chua
	public static int indexOfSSM(int studentCode, int subjectCode) {
		for (int i = 0; i < markList.size(); i++) {
			if (markList.get(i).getStudentCode() == studentCode && markList.get(i).getSubjectCode() == subjectCode
					&& markList.get(i).getMark() > -1) {
				return i;
			}
		}
		return -1;
	}

	// end indexOfSSM
	// indexofCheck
	public static int indexOfCheck(int subjectCode) {
		for (int i = 0; i < check.size(); i++) {
			if (subjectCode == check.get(i))
				return i;
		}
		return -1;
	}// end indexOfCheck

	public static void updateMark() {
		System.out.println("\t\t==========================Menu(I_1_3)==========================\n");
		System.out.println("\t\t1.Them diem sinh vien\t 2.Sua diem sinh vien\n\t\t"
				+ "3.Xoa diem sinh vien\t 4.Quay lai menu(I_1)");
		System.out.println("\t\t===============================================================\n");
		int select;

		do {
			System.out.print("\t\tNhap lua chon(menu(I_1_3)): ");
			select = scan.nextInt();
			int newCode, index, subjectcode, kt;
			int indexSet;
			double mark;
			switch (select) {
			case 1:// them diem
				System.out.print("\t\tNhap ma sv can them diem: ");
				newCode = scan.nextInt();
				index = indexOfStudentMark(newCode);
				if (index != -1) {
					// xu ly truong hop sinh vien nay da co diem
					System.out.print("\t\tSinh vien nay da co diem cac mon: ");

					for (int i = 0; i < markList.size(); i++) {
						if (markList.get(i).getStudentCode() == newCode && markList.get(i).getMark() > -1) {
							System.out.print(getNameSubjectByCode(markList.get(i).getSubjectCode()) + ", ");
							check.add(markList.get(i).getSubjectCode()); // danh dau lai nhung mon hoc da co diem
						}
					}
					System.out.println();
					// tim cac mon hoc chua co diem cua sinh vien nay de them
					if (check.size() == subjectList.size()) {
						System.out.println("\t\tSinh vien nay da co diem tat ca cac mon =>menu(I_1)");
						return;
					}
					System.out.print("\t\tNhap ma mon hoc can them diem [");
					boolean kt01 = true;
					for (int i = 0; i < subjectList.size(); i++) {
						kt01 = true;
						for (int j = 0; j < check.size(); j++) {
							if (check.get(j) == subjectList.get(i).getCode()) {
								kt01 = false;
								break;
							}
						}
						if (kt01) {
							System.out.print(subjectList.get(i).getCode() + " ");
						}
					}
					System.out.print("]: ");
					int subjectCode = scan.nextInt();
					if (indexOfSubject(subjectCode) == -1) {
						System.out.println("\t\tKhong co mon hoc nay =>menu(I_1)");
						return;
					}
					System.out.print("\t\tNhap diem (0<mark<10): ");
					do {
						mark = scan.nextDouble();
						if (mark < 0 || mark > 10)
							System.out.print("\t\tNhap lai: ");
					} while (mark < 0 || mark > 10);
					markList.add(new Mark(newCode, subjectCode, mark));
					check.removeAll(check);
					System.out.println("\t\tBan da them diem cho sinh vien thanh cong => menu(I_1_3)");
					break;
				}
				// truong hop sinh vien nay chua co diem: add vao
				System.out.print("\t\tNhap ma mon hoc can them diem [");
				for (int i = 0; i < subjectList.size(); i++) {
					System.out.print(subjectList.get(i).getCode() + " ");
				}
				System.out.print("] :");
				subjectcode = scan.nextInt();
				if (indexOfSubject(subjectcode) == -1) {
					System.out.println("\t\tKhong co mon hoc nay =>menu(I_1)");
					return;
				}
				// kiem tra xem mon hoc cua sinh vien nay co diem chua
				int index01 = indexOfSSM(newCode, subjectcode);
				if (index01 != -1) {
					System.out.println("\t\t Mon hoc nay da co diem,khong the them =>menu(I_1)");
					return;
				}
				System.out.print("\t\tNhap diem (0<mark<10): ");
				do {
					mark = scan.nextDouble();
					if (mark < 0 || mark > 10)
						System.out.print("\t\tNhap lai: ");
				} while (mark < 0 || mark > 10);
				markList.add(new Mark(newCode, subjectcode, mark));
				check.removeAll(check);
				System.out.println("\t\tBan da them diem cho sinh vien thanh cong => menu(I_1_3)");
				break;
			case 2:// sua diem
				System.out.print("\t\tNhap ma sinh vien can sua diem: ");
				newCode = scan.nextInt();
				index = indexOfStudentMark(newCode);
				if (index == -1) {
					System.out.println("\t\tSinh vien nay chua co diem mon hoc nao => menu(I_1)");
					return;
				}
				System.out.print("\t\tSinh vien nay da co diem cac mon: ");

				for (int i = 0; i < markList.size(); i++) {
					if (markList.get(i).getStudentCode() == newCode && markList.get(i).getMark() > -1) {
						System.out.print(getNameSubjectByCode(markList.get(i).getSubjectCode()) + " ");
						check.add(markList.get(i).getSubjectCode()); // danh dau lai nhung mon hoc da co diem
					}
				}
				System.out.println();
				System.out.print("\t\tNhap ma mon hoc can sua diem[ ");
				for (int i = 0; i < check.size(); i++) {
					System.out.print(check.get(i) + " ");
				}
				System.out.print("]: ");
				subjectcode = scan.nextInt();
				index01 = indexOfSubject(subjectcode);
				kt = indexOfCheck(subjectcode);
				if (index01 == -1) {// kiem tra xem mon hoc co ton tai khong
					System.out.println("\t\tMon hoc nay khong co=>menu(I_1)");
					return;
				}
				// neu ton tai thi kiem tra xem co diem chua
				if (kt == -1) {// kiem tra xem mon hoc vua nhap co diem chua
					System.out.println("\t\tMon hoc nay sinh vien chua co diem de sua => menu(I_1)");
					return;
				}
				System.out.print("\t\tNhap diem (0<mark<10): ");
				do {
					mark = scan.nextDouble();
					if (mark < 0 || mark > 10)
						System.out.print("\t\tNhap lai: ");
				} while (mark < 0 || mark > 10);
				indexSet = indexOfSSM(newCode, subjectcode);
				markList.get(indexSet).setMark(mark);
				System.out.println("\t\tBan da sua diem thanh cong cho mon hoc " + subjectcode + " =>menu(I_1_3)");
				check.removeAll(check);
				break;
			case 3:// xoa diem
				System.out.print("\t\tNhap ma sv can xoa diem: ");
				newCode = scan.nextInt();
				index = indexOfStudentMark(newCode);
				if (index == -1) {// kiem tra sinh vien co diem de xoa chua
					System.out.println("\t\tSinh vien nay chua co diem mon hoc nao => menu(I_1)");
					return;
				}
				System.out.print("\t\tSinh vien nay da co diem cac mon: ");

				for (int i = 0; i < markList.size(); i++) {
					if (markList.get(i).getStudentCode() == newCode && markList.get(i).getMark() > -1) {
						System.out.print(getNameSubjectByCode(markList.get(i).getSubjectCode()) + ", ");
						check.add(markList.get(i).getSubjectCode()); // danh dau lai nhung mon hoc da co diem
					}
				}
				System.out.println();
				System.out.print("\t\tNhap ma mon hoc can xoa diem: ");
				subjectcode = scan.nextInt();
				index01 = indexOfSubject(subjectcode);
				kt = indexOfCheck(subjectcode);
				if (index01 == -1) {// kiem tra xem mon hoc co ton tai khong
					System.out.println("\t\tMon hoc nay khong co=>menu(I_1)");
					return;
				}
				// neu ton tai thi kiem tra xem co diem chua
				if (kt == -1) {// kiem tra xem mon hoc vua nhap co diem chua
					System.out.println("\t\tMon hoc nay sinh vien chua co diem de sua => menu(I_1)");
					return;
				}
				indexSet = indexOfSSM(newCode, subjectcode);
				markList.remove(indexSet);
				System.out.println("\t\tDa xoa thanh cong=>menu(I_1_3)");
				check.removeAll(check);
				break;
			case 4:
				return;
			default:
				System.out.println("\t\tLua chon khong hop le");
			}
		} while (true);

	}
	// end funcion1

	// ***********************************************************************
	// getCodefficientByCode
	public static double getCodefficientByCode(int subjectCode) {
		for (int i = 0; i < subjectList.size(); i++) {
			if (subjectCode == subjectList.get(i).getCode())
				return subjectList.get(i).getCoefficient();
		}
		return -1;
	}// end getCo...

	// getNameSubjectByCode
	public static String getNameSubjectByCode(int subjectCode) {
		for (int i = 0; i < subjectList.size(); i++) {
			if (subjectCode == subjectList.get(i).getCode())
				return subjectList.get(i).getNameSubject(subjectCode);
		}
		return null;
	}
	// end getNameSubjectByCode

	// funcion2: hien thi bang diem
	public static void displayList() {
		System.out.println("\t======================= Mark List ========================");
		int stt = 1;
		for (int st = 0; st < studentList.size(); st++) {
			System.out.println("\t" + stt + "." + studentList.get(st).toString());
			stt++;
			for (int i = 0; i < markList.size(); i++) {
				if (markList.get(i).getStudentCode() == studentList.get(st).getCode()) {
					check.add(markList.get(i).getSubjectCode()); // danh dau lai nhung mon hoc da co diem
				}
			}
			int demMark = 0;// dem xem co diem hay khong
			double sumMark = 0;
			double sumCoefficient = 0;
			for (int i = 0; i < markList.size(); i++) {
				if (markList.get(i).getStudentCode() == studentList.get(st).getCode()
						&& markList.get(i).getMark() > -1) {
					System.out.println("\t\tsubject: " + getNameSubjectByCode(markList.get(i).getSubjectCode())
							+ "\tmark: " + markList.get(i).getMark());
					demMark += 1;
					sumCoefficient += getCodefficientByCode(markList.get(i).getSubjectCode());
					sumMark += markList.get(i).getMark() * getCodefficientByCode(markList.get(i).getSubjectCode());
				}
			}
			if (demMark == 0) {// neu tat ca cac diem == -1 (chua hoc) => chua hoc mon nao
				System.out.println("\t\tSinh vien nay chua co diem mon nao");
			} else {
				System.out.println("\t\tDiem tong ket: " + (sumMark / sumCoefficient));
			}
			check.removeAll(check);
		}
	}
	// end funcion2

	// ***********************************************************************

	// funcion3: tim kiem theo maSV hoac maMH
	public static void find() {
		System.out.println("\t=========================== Tim kiem ===========================");
		System.out.println("\t1.Tim kiem theo ma sinh vien\t2.Tim kiem theo ma mon hoc\t3.Quay lai menu(I)");
		int select;
		do {
			System.out.print("\tNhap lua chon(Tim kiem): ");
			select = scan.nextInt();
			switch (select) {
			case 1:
				findByStudentCode();
				break;
			case 2:
				findBySubjectCode();
				break;
			case 3:
				return;
			default:
				System.out.println("\tLua chon khong hop le");
			}
		} while (true);
	}

	public static void findByStudentCode() {
		System.out.println("\t====== Tim kiem bang ma sinh vien ======");
		int studentCode;
		System.out.print("\tNhap ma sinh vien [ ");
		for (int i = 0; i < studentList.size(); i++) {
			System.out.print(studentList.get(i).getCode() + " ");
		}
		System.out.print("]: ");
		studentCode = scan.nextInt();
		int index = indexOfStudent(studentCode);
		if (index == -1) {
			System.out.println("\tSinh vien nay khong co trong danh sach=>menu(Tim kiem)");
			return;
		}
		System.out.println("\t" + studentList.get(index));
		for (int i = 0; i < markList.size(); i++) {
			if (markList.get(i).getStudentCode() == studentCode) {
				check.add(markList.get(i).getSubjectCode()); // danh dau lai nhung mon hoc da co diem
			}
		}
		int demMark = 0;// dem xem co diem hay khong
		double sumMark = 0;
		double sumCoefficient = 0;
		for (int i = 0; i < markList.size(); i++) {
			if (markList.get(i).getStudentCode() == studentCode && markList.get(i).getMark() > -1) {
				System.out.println("\t\tsubject: " + getNameSubjectByCode(markList.get(i).getSubjectCode()) + "\tmark: "
						+ markList.get(i).getMark());
				demMark += 1;
				sumCoefficient += getCodefficientByCode(markList.get(i).getSubjectCode());
				sumMark += markList.get(i).getMark() * getCodefficientByCode(markList.get(i).getSubjectCode());
			}
		}
		if (demMark == 0) {// neu tat ca cac diem == -1 (chua hoc) => chua hoc mon nao
			System.out.println("\t\tSinh vien nay chua co diem mon nao");
		} else {
			System.out.println("\t\tDiem tong ket: " + (sumMark / sumCoefficient));
		}
		check.removeAll(check);
	}

	// getStudentNamebyCode
	public static String getStudentNameByCode(int studentCode) {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getCode() == studentCode) {
				return studentList.get(i).getFirstName() + " " + studentList.get(i).getName();
			}
		}
		return null;
	}
	// end getStudentNamebyCode

	// indexOfSubjectMark
	public static int indexOfSubjectMark(int subjectCode) {
		for (int i = 0; i < markList.size(); i++) {
			if (subjectCode == markList.get(i).getSubjectCode() && markList.get(i).getMark() > -1)
				return i;
		}
		return -1;
	}// end indexofStudentSubject

	public static void findBySubjectCode() {
		System.out.println("\t=================== Tim kiem bang ma mon hoc ===================");
		int subjectCode;
		System.out.print("\tNhap ma mon hoc[ ");
		for (int i = 0; i < subjectList.size(); i++) {
			System.out.print(subjectList.get(i).getCode() + " ");
		}
		System.out.print("]: ");
		subjectCode = scan.nextInt();
		int index = indexOfSubject(subjectCode);
		if (index == -1) {
			System.out.println("\tMon hoc nay khong co trong danh sach =>menu(Tim kiem)");
			return;
		}
		System.out.println("\tMon hoc " + getNameSubjectByCode(subjectCode) + ":");
		int stt = 1;
		boolean ktra = false;
		for (int i = 0; i < markList.size(); i++) {
			if (markList.get(i).getSubjectCode() == subjectCode && markList.get(i).getMark() > -1) {
				System.out.print("\t" + stt + "." + getStudentNameByCode(markList.get(i).getStudentCode()));
				System.out.print("\tDiem: " + markList.get(i).getMark());
				stt++;
				System.out.println();
				ktra = true;
			}
		}
		if (!ktra) {
			System.out.println("\tMon hoc nay chua co sinh vien nao hoc");
		}
	}

	// end funcion3
	public static boolean checkNumber(String s) {
		if (s == null)
			return false;
		for (int index = 0; index < s.length(); index++) {
			if (s.charAt(index) < '0' || s.charAt(index) > '9')
				return false;
		}
		return true;
	}

	public static boolean isUper(String s) {
		for(int i=0;i<s.length();i++) {
			if (s.charAt(i) < 'A' || s.charAt(i) >'Z')
				return false;
		}
		return true;
	}
	public static boolean isLower(String s) {
		for(int i=0;i<s.length();i++) {
			if (s.charAt(i) < 'a' || s.charAt(i) >'z')
				return false;
		}
		return true;
	}
	
	public static boolean checkString(String s) {
		if (!isUper(s) && !isLower(s))
			return false;
		return true;
	}

}
