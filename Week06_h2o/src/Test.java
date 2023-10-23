import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		List<String>list = Arrays.asList("Kim", "Park", "Lee", "Choi", "Chee");
		
		List<String>sublist = list.stream()			//(2)스트림 생성
				.filter(s->s.startsWith("C"))		//(3)스트림 처리
				.sorted()							//(4)스트림 처리
				.collect(Collectors.toList());		//(5)결과 생성
		
		System.out.println(sublist);				//(6)결과 출력
	}
}
