package streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreams {

public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee("Josiah", 90000, "Engineer"));
		employees.add(new Employee("Matt", 100000, "Engineer"));
		employees.add(new Employee("Abe", 250000, "Engineer"));
		employees.add(new Employee("Terry", 250001, "Database Arch"));
		employees.add(new Employee("Roy", 2500000, "CEO"));
		employees.add(new Employee("Brian", 70000, "Dev"));
		employees.add(new Employee("Danny", Integer.MAX_VALUE, "Juggling"));
		employees.add(new Employee("Dan", 3000000, "Management"));
		employees.add(new Employee("Lee", 0, "Intern"));
		employees.add(new Employee("Terri", 350000, "Dev"));
		employees.add(new Employee("Stanley", 75000, "Dev"));
		employees.add(new Employee("Donny", 85000, "Mobile Eng"));
		employees.add(new Employee("Rebecca", 650000, "Finances"));
		
		
		// regular stream
		long before = System.currentTimeMillis();
		long count = employees.stream()
						.filter(e -> e.getSalary() > 100000)
						.count();
		long after = System.currentTimeMillis();
		
		System.out.println("Stream count = " + count);
		System.out.println("Stream time = " + (after - before));
		
		// parallel stream
		before = System.currentTimeMillis();
		count = employees.parallelStream()
						.filter(e -> e.getSalary() > 100000)
						.count();
		after = System.currentTimeMillis();
		
		System.out.println("Parallel Stream count = " + count);
		System.out.println("Parallel Stream time = " + (after - before));
		
		
	}
}
