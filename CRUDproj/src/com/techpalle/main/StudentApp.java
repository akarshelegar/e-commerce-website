package com.techpalle.main;
import com.techpalle.jdbc.*;

public class StudentApp {

	public static void main(String[] args) {
		
		//create Student Table 
		//StudentServices.creating();
		
		//insert two students details
		//StudentServices.inserting("Akarsh", "Physics", "akarsh@gmail.com");
		//StudentServices.inserting("Sudeep", "Maths", "sudeep@gmail.com");
		
		//delete Student Details
		//StudentServices.delete(2);

		//update Student Details
		//StudentServices.Update(3, "Sandeep", "Biology");
		
		StudentServices.read();
	}

}
