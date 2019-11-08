package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class ToArrayAndCollectors {

	public static void main(String[] args) {
		

		List<Employee> employees = new ArrayList<Employee>();
		
		
		
		employees.add(new Employee("Josiah", 90000, "Engineer"));
		employees.add(new Employee("Matt", 100000, "Engineer"));
		employees.add(new Employee("Abe", 250000, "Engineer"));
		employees.add(new Employee("Brian", 90000, "Intern"));
		employees.add(new Employee("Danny", 9000000, "CEO"));
		employees.add(new Employee("Dan", 90000, "Dev"));
		employees.add(new Employee("Lee", 85000, "Dev"));
		employees.add(new Employee("Terry", 65000, "Finances"));
		
		
		
		
		Employee[] devs = employees.stream()
				.filter(empl -> empl.getDepartment().equals("Dev"))
				.toArray(Employee[]:: new); // method reference, will refere to constructor
		
		for (int i = 0; i < devs.length; i++) {
			System.out.println(devs[i]);
			
		
		}
		
		List<Employee> devList = employees.stream()
				.filter(empl -> empl.getDepartment().equals("Dev"))
				.collect(Collectors.toList());
		
		employees.stream()
		.filter(empl -> empl.getDepartment().equals("Dev"))
		.collect(Collectors.toList())
		.forEach(System.out::println);

	
	
	// filter by salary
	
	Map<Boolean, List<Employee>> richEmployees = employees.stream()
			.collect(Collectors.partitioningBy(empl -> empl.getSalary() >= 100000));
	
	
	System.out.println("Rich Employees");
	richEmployees.get(true).forEach(System.out::println);
	
	
	richEmployees.forEach((k,v) -> System.out.println(k + ": " + v));
	 
	Employee riches = employees.stream()
			.reduce( (empl1, employ2) -> empl1.getSalary() > employ2.getSalary() ? empl1 : employ2)
			.get();
	
	System.out.println("Rich = " + riches);
	
	Employee poor = employees.stream()
			.reduce( (empl1, employ2) -> empl1.getSalary() < employ2.getSalary() ? empl1 : employ2)
			.get();
	
	System.out.println("Poor = " + poor);
	
	

	
	String dep = employees.stream()
			.map(emp ->  " "+emp.getDepartment())
			.distinct()
			.reduce("", String::concat);
	
	System.out.println("By departments --: " +dep);
	
	//diferents approaches 
	String allDep = employees.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment))
			.keySet()
			.stream()
			.reduce((e1,e2) -> e1 + ", " + e2)
			.get();
	
	System.out.println(allDep);
	
	String allDepartments = employees.stream()
			.map(Employee::getDepartment)
			.collect(Collectors.toList())
			.stream()
			.distinct()
			.reduce((dep1, dep2) -> dep1 + ", "+ dep2)
			.get();
	
	System.out.println(allDepartments);
	}
}
