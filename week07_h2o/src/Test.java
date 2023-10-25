import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Test {

	public static void main(String[] args) throws IOException {
		File file1 = new File("obama.txt");
		File file2 = new File("output.txt");
		char CharCounter = 0;
		BufferedReader in = (new BufferedReader(new FileReader(file1)));
		PrintWriter out = (new PrintWriter(new FileWriter(file2)));
		int ch;
        while ((ch = in.read()) != -1) {
            char character = (char) ch;
            
            if (Character.isLowerCase(character)) {
                out.print(Character.toUpperCase(character));	// 소문자를 대문자로 변환하여 출력 파일에 쓰기
            } else {
                out.print(character);							// 소문자가 아닌 경우 그대로 출력 파일에 쓰기
            }
        }
		in.close();
		out.close();
	}

}
