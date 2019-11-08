package streams;

import java.util.Arrays;
import java.util.List;

public class ReduceStream {

	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(2,4,6,6,2,4,12,3,11);
		
		
		// sum the numbers
		
		int sum = numbers.stream()
				.reduce(1, (num1,num2) -> num1 + num2);
		
		
		System.out.println("sum = " + sum);
		
		
		// largest value
		
		
		int biggest = numbers.stream()
				.reduce( (num1, num2) -> num1 > num2 ? num1 : num2)
				.get();
		
		System.out.println("biggest= " + biggest);
	}
}
