package streams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindFirstExample {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<Employee>();
		
		
		
		employees.add(new Employee("Josiah", 90000, "Engineer"));
		employees.add(new Employee("Matt", 100000, "Engineer"));
		employees.add(new Employee("Abe", 250000, "Engineer"));
		employees.add(new Employee("Brian", 90000, "Intern"));
		employees.add(new Employee("Danny", 90000, "CEO"));
		employees.add(new Employee("Dan", 90000, "Dev"));
		employees.add(new Employee("Lee", 85000, "Dev"));
		employees.add(new Employee("Terry", 65000, "Finances"));
		
		
		
		// first person who is in the Dev department
		Employee e1 = employees.stream()
				.filter(empl -> empl.getDepartment().equals("Dev"))
				.findAny()
				.orElse(null);
		
		
		System.out.println(e1);
		
		
		Employee e2 = employees.stream()
				.filter(empl -> empl.getDepartment().equals("Intern"))
				.findAny()
				.orElse(null);
		
		System.out.println(e2);
		
		
		
		Set<Employee> employeeSet = new HashSet<Employee>();
		employeeSet.add(new Employee("Josiah", 90000, "Engineer"));
		employeeSet.add(new Employee("Matt", 100000, "Engineer"));
		employeeSet.add(new Employee("Abe", 250000, "Engineer"));
		employeeSet.add(new Employee("Brian", 90000, "Intern"));
		employeeSet.add(new Employee("Danny", 90000, "CEO"));
		employeeSet.add(new Employee("Dan", 90000, "Dev"));
		employeeSet.add(new Employee("Lee", 85000, "Dev"));
		employeeSet.add(new Employee("Terry", 65000, "Finances"));
		

		
		Employee e3 = employees.stream()
				.filter(empl -> empl.getDepartment().equals("Dev"))
				.findFirst()
				.orElse(null);
		
		System.out.println(e3);
		
		
		Set<Employee> e4 = employees.stream()
				.filter(empl -> empl.getDepartment().equals("Dev"))
				.collect(Collectors.toSet());
				
		
		System.out.println(e4);
		
	}

}
