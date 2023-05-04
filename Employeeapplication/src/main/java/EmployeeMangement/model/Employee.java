package EmployeeMangement.model;

public class Employee {
public int id;
public String name;
public String email;
public String password;
public String country;

public Employee() {}

public Employee( int id,String name,String email,String password,String country) { 
     this.id=id;
     this.name=name;
     this.email=email;
     this.password=password;
     this.country=country;
}
   public void setId(int id) {
	  this.id=id;
   }   
   public void setCountry(String country) {
	  this.country=country;
   }
   public void setName(String name) {
	     this.name=name;
   }
   public void setEmail(String email) {
	     this.email=email;
   }
   public void setPassword(String password) {
	     this.password=password;
   }
   public int getId() {
	  return id;
   }
   public String getCountry() {
	  return country;
   }
   public String getName() {
	  return name;
   }
   public String getEmail() {
	  return email;
   }
   public String getPassword() {
	  return password;
   }
  }