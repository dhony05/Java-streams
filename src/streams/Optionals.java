package streams;

import java.util.Optional;

public class Optionals {

	public static void main(String[] args) {
		
		Optional<String> opt1 = Optional.empty();
		
		System.out.println(opt1);
		
		
		Optional<String> opt2 = Optional.of("hello");
		String str = "world";
		
		Optional<String> opt3 = Optional.of(str);
		
		System.out.println(opt2 + " " + opt3);
		
		Optional<Person> opt4 = Optional.of(new Person());
		System.out.println(opt4);
		
		
		Optional <Person> optNull = Optional.ofNullable(null);
		
		System.out.println(optNull);
		
		
		if(opt3.isPresent()) {
			System.out.println("Is not empty");
		}else {
			System.out.println("Is empty");
		}

	}

}
