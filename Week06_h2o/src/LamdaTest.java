interface ArrayProcessing{
	double apply(double[] array);
}

public class LamdaTest {
//	(1)
	public static final ArrayProcessing maxer = array -> {
		double max = array[0];
        for (double num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
	};
// (2)
	public static final ArrayProcessing miner = array -> {
		double min = array[0];
        for (double num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
	};
	public static final ArrayProcessing sumer = array -> {
		double sum = 0;
        for (double num : array) {
            sum += num;
        }
        return sum / array.length;
	};
	
    public static void main(String[] args) {
        double[] numbers = {1.2, 3.5, 2.8, 5.1, 4.7};

        // 최대값 계산 및 출력
        double maxNumber = maxer.apply(numbers);
        System.out.println("최대값: " + maxNumber);

        // 최소값 계산 및 출력
        double minNumber = miner.apply(numbers);
        System.out.println("최소값: " + minNumber);

        // 평균값 계산 및 출력
        double average = sumer.apply(numbers);
        System.out.println("평균값: " + average);
    }
}
