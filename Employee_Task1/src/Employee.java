import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;


	Employee(int  id,String name,int age,String gender,String department,int yearofjoining,double salary){
		this.id=id;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.department=department;
		this.yearOfJoining=yearofjoining;
		this.salary=salary;
	}
	
}

class EmployeeManagement 
{

    List<Employee> employeeList = new ArrayList<Employee>();

    public EmployeeManagement() {
        // Initialize the employeeList with data here
         
employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
    }

    // Task 1: How many male and female employees are there in the organization?
    public void countMaleAndFemaleEmployees() {
        long maleCount = employeeList.stream().filter(e -> "Male".equals(e.gender)).count();
        long femaleCount = employeeList.stream().filter(e -> "Female".equals(e.gender)).count();
        System.out.println("Male Employees: " + maleCount);
        System.out.println("Female Employees: " + femaleCount);
    }

    // Task 2: Print the name of all departments in the organization
    public void printDepartments() 
	{
        Set<String> departments = employeeList.stream().map(e -> e.department).collect(Collectors.toSet());
        departments.forEach(System.out::println);
    }

    // Task 3: What is the average age of male and female employees?
    public void averageAgeByGender() {
        Map<String, Double> avgAgeByGender = employeeList.stream()
                .collect(Collectors.groupingBy(e -> e.gender, Collectors.averagingInt(e -> e.age)));
        System.out.println("Average Age of Male Employees: " + avgAgeByGender.get("Male"));
        System.out.println("Average Age of Female Employees: " + avgAgeByGender.get("Female"));
    }

    // Task 4: Get the details of the highest-paid employee in the organization
    public void highestPaidEmployee() {
        Optional<Employee> highestPaid = employeeList.stream().max(Comparator.comparingDouble(e -> e.salary));
        if (highestPaid.isPresent()) {
            Employee employee = highestPaid.get();
            System.out.println("Highest Paid Employee: " + employee.name);
            System.out.println("Salary: " + employee.salary);
            System.out.println("Department: " + employee.department);
        }
    }

    // Task 5: Get the names of all employees who have joined after 2015
    public void employeesJoinedAfter2015() {
        List<String> names = employeeList.stream()
                .filter(e -> e.yearOfJoining > 2015)
                .map(e -> e.name)
                .collect(Collectors.toList());
        names.forEach(System.out::println);
    }
	
	// Task 6: Count the number of employees in each department
    public void countEmployeesInEachDepartment() {
        Map<String, Long> departmentCounts = employeeList.stream()
                .collect(Collectors.groupingBy(e -> e.department, Collectors.counting()));
        departmentCounts.forEach((department, count) -> {
            System.out.println(department + ": " + count);
        });
    }

    // Task 7: What is the average salary of each department
    public void averageSalaryByDepartment() {
        Map<String, Double> avgSalaryByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(e -> e.department, Collectors.averagingDouble(e -> e.salary)));
        avgSalaryByDepartment.forEach((department, avgSalary) -> {
            System.out.println(department + ": " + avgSalary);
        });
    }

    // Task 8: Get the details of the youngest male employee in the product development department
    public void youngestMaleInProductDevelopment() {
        Optional<Employee> youngestMaleInProductDev = employeeList.stream()
                .filter(e -> "Male".equals(e.gender) && "Product Development".equals(e.department))
                .min(Comparator.comparingInt(e -> e.age));
        if (youngestMaleInProductDev.isPresent()) {
            Employee employee = youngestMaleInProductDev.get();
            System.out.println("Youngest Male in Product Development:");
            System.out.println("Name: " + employee.name);
            System.out.println("Age: " + employee.age);
            System.out.println("Salary: " + employee.salary);
        } else {
            System.out.println("No male employee in the Product Development department.");
        }
    }

    // Task 9: How many male and female employees are there in the sales and marketing team
    public void countMaleAndFemaleInSalesAndMarketing() {
        long maleCount = employeeList.stream()
                .filter(e -> "Sales And Marketing".equals(e.department) && "Male".equals(e.gender))
                .count();
        long femaleCount = employeeList.stream()
                .filter(e -> "Sales And Marketing".equals(e.department) && "Female".equals(e.gender))
                .count();
        System.out.println("Male Employees in Sales And Marketing: " + maleCount);
        System.out.println("Female Employees in Sales And Marketing: " + femaleCount);
    }
	
	// Task 10: What is the average salary of male and female employees?
    public void averageSalaryByGender() {
        Map<String, Double> avgSalaryByGender = employeeList.stream()
                .collect(Collectors.groupingBy(e -> e.gender, Collectors.averagingDouble(e -> e.salary)));
        System.out.println("Average Salary of Male Employees: " + avgSalaryByGender.get("Male"));
        System.out.println("Average Salary of Female Employees: " + avgSalaryByGender.get("Female"));
    }

    // Task 11: List down the names of all employees in each department
    public void listEmployeesByDepartment() {
        Map<String, List<String>> employeesByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(e -> e.department, Collectors.mapping(e -> e.name, Collectors.toList())));
        employeesByDepartment.forEach((department, names) -> {
            System.out.println(department + ": " + String.join(", ", names));
        });
    }

    // Task 12: What is the average salary and total salary of the whole organization
    public void organizationSalaryStatistics() {
        double totalSalary = employeeList.stream().mapToDouble(e -> e.salary).sum();
        double averageSalary = totalSalary / employeeList.size();
        System.out.println("Total Salary of the Organization: " + totalSalary);
        System.out.println("Average Salary of the Organization: " + averageSalary);
    }

    // Task 13: Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years
    public void separateEmployeesByAge() {
        Map<Boolean, List<Employee>> ageSeparatedEmployees = employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.age <= 25));
        List<Employee> youngerEmployees = ageSeparatedEmployees.get(true);
        List<Employee> olderEmployees = ageSeparatedEmployees.get(false);
        
        System.out.println("Younger Employees (<= 25 years):");
        youngerEmployees.forEach(e -> System.out.println(e.name + " (" + e.age + " years)"));

        System.out.println("Older Employees (> 25 years):");
        olderEmployees.forEach(e -> System.out.println(e.name + " (" + e.age + " years)"));
    }

     // Task 14: Who is the oldest employee in the organization?
    public void findOldestEmployee() {
        Employee oldestEmployee = null;
        for (Employee employee : employeeList) {
            if (oldestEmployee == null || employee.age > oldestEmployee.age) {
                oldestEmployee = employee;
            }
        }

        if (oldestEmployee != null) {
            System.out.println("Oldest Employee: " + oldestEmployee.name);
            System.out.println("Age: " + oldestEmployee.age);
            System.out.println("Department: " + oldestEmployee.department);
        } else {
            System.out.println("No employees in the list.");
        }
    }

    public static void main(String[] args) {
        EmployeeManagement manager = new EmployeeManagement();
        manager.countMaleAndFemaleEmployees();
        manager.printDepartments();
        manager.averageAgeByGender();
        manager.highestPaidEmployee();
        manager.employeesJoinedAfter2015();
		manager.countEmployeesInEachDepartment();
        manager.averageSalaryByDepartment();
        manager.youngestMaleInProductDevelopment();
        manager.countMaleAndFemaleInSalesAndMarketing();
		manager.averageSalaryByGender();
        manager.listEmployeesByDepartment();
        manager.organizationSalaryStatistics();
        manager.separateEmployeesByAge();
		manager.findOldestEmployee();
    }
}