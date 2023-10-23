import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class MethodReferenceLowetCase {

	public static void main(String[] args) {
		List<String> listOfNames = Arrays.asList(new String[]
				{"Apple", "Banana", "Cherry"});
		
		List<String> lowerCaseNames = convertToLowerCase(listOfNames);
        System.out.println(listOfNames);			// 원본 리스트 출력
        System.out.println(lowerCaseNames);			// 소문자로 변환된 리스트 출력
    }
	
	public static List<String> convertToLowerCase(List<String> inputList) {
        return inputList.stream()
                .map(String::toLowerCase) 			// 각 문자열을 소문자로 변환
                .collect(Collectors.toList());		// 변환된 문자열을 리스트로 수집
	}
}
