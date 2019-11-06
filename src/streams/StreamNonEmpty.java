package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamNonEmpty {

	public static void main(String[] args) {
	
	List<String> food = Arrays
			.asList("pizza", "",null, 
					"sandwich", "",null, 
					"mangu","sushi");

	System.out.println(food);
	
	//filtering the strings that aren't empty
	
	
	List<String> foodNotEmpty = food.stream() // set stream
								.filter(f ->  f != null  && !f.isEmpty() )
								.collect(Collectors.toList());
	
	
	
	System.out.println(foodNotEmpty);
	
	List <Person> people  = Arrays.asList(new Person("Omran",27),
			new Person(),
			new Person("Greg",28),
			new Person("Abe", 25),
			new Person("N/A", -6),
			new Person()
			);
	
	List<Person> realPeople = people.stream()
				.filter(p -> !p.getName().equals("N/A") || (p.getAge() > 0)  )
				.collect(Collectors.toList());
	
	//System.out.println(realPeople);
	
	realPeople.stream().forEach(System.out::println);
	}

}
