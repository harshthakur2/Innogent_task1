package com.opencsv;

public class program2 {

	public static void main(String[] args) {
		
	EmployeeDatabase employeeList=new EmployeeDatabase();
		public void countMaleAndFemaleEmployees() {
	        long maleCount = employeeList.stream().filter(e -> "Male".equals(e.gender)).count();
	        long femaleCount = employeeList.stream().filter(e -> "Female".equals(e.gender)).count();
	        System.out.println("Male Employees: " + maleCount);
	        System.out.println("Female Employees: " + femaleCount);
	    }
	}

}
