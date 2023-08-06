package com.bitlabs;
import java.util.ArrayList;
import java.util.Scanner;
class Patient{
private String name,city,address,gender,guardiansName,guardiansAddress,recovery;
private long aadharNumber,contactNumber,guardiansNumber;
private int age,id;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getGuardiansName() {
	return guardiansName;
}
public void setGuardiansName(String guardiansName) {
	this.guardiansName = guardiansName;
}
public String getGuardiansAddress() {
	return guardiansAddress;
}
public void setGuardiansAddress(String guardiansAddress) {
	this.guardiansAddress = guardiansAddress;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}

public String getRecovery() {
	return recovery;
}
public void setRecovery(String recovery) {
	this.recovery = recovery;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public long getAadharNumber() {
	return aadharNumber;
}
public void setAadharNumber(long aadharNumber) {
	this.aadharNumber = aadharNumber;
}
public long getContactNumber() {
	return contactNumber;
}
public void setContactNumber(long contactNumber) {
	this.contactNumber = contactNumber;
}
public long getGuardiansNumber() {
	return guardiansNumber;
}
public void setGuardiansNumber(long guardiansNumber) {
	this.guardiansNumber = guardiansNumber;
}

}
 class Arogya{
ArrayList<Patient> patients=new ArrayList<Patient>();

public void addPatient(Scanner s,int n) {
	int count1=0;
	for(int i=1;i<=n;i++) {
		count1++;
		Patient p=new Patient();	
		System.out.println("Patient Id is automatically generated ");
		p.setId(count1);
		
		
		System.out.println("Enter the patient name : ");
		p.setName(s.next());
		
		while(true){
			System.out.println("Enter the patient age : ");
			int a=s.nextInt();
			if(a>=1 && a<100) {
				p.setAge(a);
				break;
			}
			else {
				System.out.println("The age should not contain above 2 digits ");
			}
	
		}while(true) {
		try{
		
		System.out.println("Enter the contact number : ");
		Long number=s.nextLong();
		if(String.valueOf(number).length()==10 && String.valueOf(number).charAt(0)=='6'||String.valueOf(number).charAt(0)=='7'|| String.valueOf(number).charAt(0)=='8'||String.valueOf(number).charAt(0)=='9'){
			p.setContactNumber(number);
			break;
		}
		else {
			System.out.println("The number should be 10 digits only");
		}
		}
		catch(Exception e) {
			System.out.println("Invalid Contact number ");
		}
		}
		while(true) {
		try{
		System.out.println("Enter the Aadhar number : ");
		long aadhar=s.nextLong();
		if(String.valueOf(aadhar).length()==12) {
			p.setAadharNumber(aadhar);
			break;
		}
		else {
			System.out.println("The aadhar number should contain 12 digits only");
		}
		}
		catch(Exception e) {
			System.out.println("Invalid Aadhar number ");
			s.nextLine();
		}
		}
		
		System.out.println("Enter the address : ");
		p.setAddress(s.next());
		
		System.out.println("Enter the city : ");
		p.setCity(s.next());
		
		System.out.println("Enter the gender : ");
		p.setGender(s.next());
		s.nextLine();
		
		System.out.println("Enter the Guardian name : ");
		p.setGuardiansName(s.next());
		
		System.out.println("Enter the Guardians address : ");
		p.setGuardiansAddress(s.next());
		
		p.setRecovery("Not recovered");
		while(true) {
		try {
		System.out.println("Enter the Guardians Contact Number : ");
		long guardianContact=s.nextLong();
		if(String.valueOf(guardianContact).length()==10 && String.valueOf(guardianContact).charAt(0)=='6'||String.valueOf(guardianContact).charAt(0)=='7'||String.valueOf(guardianContact).charAt(0)=='8'||String.valueOf(guardianContact).charAt(0)=='9') {
			p.setGuardiansNumber(guardianContact);
			break;
		}
		else {
			System.out.println("The number should be 10 digits only");
		}
		}
		catch(Exception e) {
			System.out.println("Invalid guardian's contact number ");
		}
		
		
	}
		
		patients.add(p);
	}
	
}
public void getPatientDetails() {
	for(Patient pt:patients) {
	System.out.println();
	System.out.println("The patients Details are : ");
	System.out.println("ID : "+pt.getId());
	System.out.println("Name : "+pt.getName());
	System.out.println("AGE: "+pt.getAge());
	System.out.println("AADHARNUMBER : "+pt.getAadharNumber());
	System.out.println("NUMBER : "+pt.getContactNumber());
	System.out.println("CITY : "+pt.getCity());
	System.out.println("ADDRESS : "+pt.getAddress());
	System.out.println("GUARDIAN'S NAME : "+pt.getGuardiansName());
	System.out.println("GUARDIAN'S NUMBER : "+pt.getGuardiansNumber());
	System.out.println("GUARDIAN'S ADDRESS : "+pt.getGuardiansAddress());
	System.out.println("RECOVERY STATUS : "+pt.getRecovery());
	}
}
public void listById(Scanner s) {
	System.out.println();
	System.out.println("Enter the Id : ");
	int patientId=s.nextInt();
	for(Patient pt:patients) {
		if(patientId==pt.getId()) {
			allData(pt);
			break;
		}
		else {
			System.out.println("The entered Id should be unique ");
		}
	}
}
public void listByCity(Scanner s) {
	int count=0;
	System.out.println();
	System.out.println("Enter the name of the city : ");
	String cityName=s.next();
	for(Patient pt:patients) {
		if(cityName.equalsIgnoreCase(pt.getCity())) {
			allData(pt);
			count++;
		}
		
	}
	if(count==0) {
		System.out.println("No patient is found with the entered city ");
	}
}
public void getByAge(Scanner s) {
	System.out.println();
	System.out.println("Enter the minimum age : ");
	int min_age=s.nextInt();
	System.out.println("Enter the maximum age : ");
	int max_age=s.nextInt();
	for(Patient pt:patients) {
	if(pt.getAge()>= min_age&&pt.getAge()<=max_age) {
		allData(pt);
	}
	else{
		System.out.println("No patient is found between the age");
		
	}
	}
}
public void markRecovered(Scanner s) {
	s.nextLine();
	System.out.println("Enter the patient Id : ");
	int id1=s.nextInt();
	for(Patient pt:patients) {
		if(id1==pt.getId()) {
			System.out.println("Enter patient Status as recovered (YES/NO)");
			String opt=s.next();
			switch(opt) {
			case "YES":{
				pt.setRecovery("Recovered");
				System.out.println("The recovery status is updated ");
				break;
				}
			case "NO" :{
				pt.setRecovery("Not recovered");
				System.out.println("The recovery status is updated ");
				break;
			}
			default :{
				System.out.println("Enter a valid option ");
				break;
			}
			}
			
		}
	}
}
public void deleteById(Scanner s) {
	System.out.println();
	System.out.println("Enter the patient Id : ");
	int id2=s.nextInt();
	boolean found=false;
	for(Patient pt:patients) {
		if(id2==pt.getId()) {
			patients.remove(pt);
			found=true;
			break;
		}
	}
	if(found) {
		System.out.println("Patient details are succesfully deleted  ");
	}
	else {
		System.out.println("No patient is found with this Id");
	}
}
public void allData(Patient pt){
		System.out.println();
		System.out.println("The patients Details are : ");
		System.out.println("ID : "+pt.getId());
		System.out.println("Name : "+pt.getName());
		System.out.println("AGE: "+pt.getAge());
		System.out.println("AADHARNUMBER : "+pt.getAadharNumber());
		System.out.println("NUMBER : "+pt.getContactNumber());
		System.out.println("CITY : "+pt.getCity());
		System.out.println("ADDRESS : "+pt.getAddress());
		System.out.println("GUARDIAN'S NAME : "+pt.getGuardiansName());
		System.out.println("GUARDIAN'S NUMBER : "+pt.getGuardiansNumber());
		System.out.println("GUARDIAN'S ADDRESS : "+pt.getGuardiansAddress());
		System.out.println("RECOVERY STATUS : "+pt.getRecovery());
	
	
}

 }

public class Arka1{
public static void main(String[] args) {
	
	
	Scanner s=new Scanner(System.in);
	System.out.println();
	System.out.println("--------------------WELCOME TO ARKA HOSPITAL--------------------");
	
	Arogya inf=new Arogya();
	
	
	int option;
	do {
		System.out.println();
		System.out.println("1.Add Patient ");
		System.out.println("2.Display Patient Details ");
		System.out.println("3.Search the Patient by ID ");
		System.out.println("4.Search the Patient by City ");
		System.out.println("5.Search the Patient by Age ");
		System.out.println("6.Mark Recovery Status ");
		System.out.println("7.Delete the Patient details ");
		System.out.println("8.Exit ");
		System.out.println();
		System.out.println("Select an option : ");
		option=s.nextInt();
		switch(option) {
		case 1:{
			System.out.println("Enter number of patients to add : ");
			int n=s.nextInt();
			inf.addPatient(s,n);
			
			break;
		}
		case 2:{
			inf.getPatientDetails();
			break;
		}
		case 3:{
			inf.listById(s);
			break;
		}
		case 4:{
			inf.listByCity(s);
			break;
		}
		case 5:{
			inf.getByAge(s);
			break;
		}
		case 6:{
			inf.markRecovered(s);
			break;
		}
		case 7:{
			inf.deleteById(s);
			break;
		}
		case 8:{
			System.out.println("============================EXIT===========================");
			break;
		}
		default : {
			System.out.println("Enter a valid Option ");
			break;
		}
		}
	}while(option!=8);
	
}
}





