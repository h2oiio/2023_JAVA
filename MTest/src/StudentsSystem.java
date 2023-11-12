import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Student{
	String name;
	String snum;
	String grade;
	
	public Student(String name, String snum, String grade){
		this.name = name;
		this.snum = snum;
		this.grade = grade;
	}
}

public class StudentsSystem {
	public static void main(String[] args) throws IOException{
		int num2;
		String search;
		String name, snum, grade;
		Scanner scan = null;
		PrintWriter in = new PrintWriter(new FileWriter("stu_out.txt"));
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.println("이름 : ");
			name = s.next();
			System.out.println("학번 : ");
			snum = s.next();
			System.out.println("성적 : ");
			grade = s.next();
			System.out.println("입력이 끝났으면 1, 계속하려면 0 : ");
			num2 = s.nextInt();
			in.print(name + ", " + snum + ", " + grade + System.lineSeparator());
			in.flush();
			if(num2 == 1)
				break;
		}
	}


}

// 20221019 이수정