package com.app.Marrage.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long userId;
	String firstName;   
	String middleName;
	String lastName;
	String fullName;
	String gender;
	@Column(unique = true)
	Long mobileNumber;
	LocalDate dateOfBirth;
	String religion;
	String motherToung;
	@Column(unique = true)
	String emailId;
	String caste;
	String subcaste;
	String gothram;
	String maritalStatus;
	double height;
	String familyStatus;
	String familyType;
	String famiyValues;
	String disability;
	String highestEducation;
	String EmployementType;
	String occupation;
	Long income;
	String WorkLocation;
	int age;
	
	@Column(unique = true)
	String username;
	String password;
	
	
	public User() {
		super();
	}


   

	public User(Long userId, String firstName, String middleName, String lastName, String fullName, String gender,
			Long mobileNumber, LocalDate dateOfBirth, String religion, String motherToung, String emailId, String caste,
			String subcaste, String gothram, String maritalStatus, double height, String familyStatus,
			String familyType, String famiyValues, String disability, String highestEducation, String employementType,
			String occupation, Long income, String workLocation, int age, String username,
			String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.religion = religion;
		this.motherToung = motherToung;
		this.emailId = emailId;
		this.caste = caste;
		this.subcaste = subcaste;
		this.gothram = gothram;
		this.maritalStatus = maritalStatus;
		this.height = height;
		this.familyStatus = familyStatus;
		this.familyType = familyType;
		this.famiyValues = famiyValues;
		this.disability = disability;
		this.highestEducation = highestEducation;
		EmployementType = employementType;
		this.occupation = occupation;
		this.income = income;
		WorkLocation = workLocation;
		this.age = age;
		
		this.username = username;
		this.password = password;
	}




	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Long getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	


	public String getReligion() {
		return religion;
	}




	public void setReligion(String religion) {
		this.religion = religion;
	}




	public String getMotherToung() {
		return motherToung;
	}


	public void setMotherToung(String motherToung) {
		this.motherToung = motherToung;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getCaste() {
		return caste;
	}


	public void setCaste(String caste) {
		this.caste = caste;
	}


	public String getSubcaste() {
		return subcaste;
	}


	public void setSubcaste(String subcaste) {
		this.subcaste = subcaste;
	}


	public String getGothram() {
		return gothram;
	}


	public void setGothram(String gothram) {
		this.gothram = gothram;
	}


	public String getMaritalStatus() {
		return maritalStatus;
	}


	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public String getFamilyStatus() {
		return familyStatus;
	}


	public void setFamilyStatus(String familyStatus) {
		this.familyStatus = familyStatus;
	}


	public String getFamilyType() {
		return familyType;
	}


	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}


	public String getFamiyValues() {
		return famiyValues;
	}


	public void setFamiyValues(String famiyValues) {
		this.famiyValues = famiyValues;
	}


	public String getDisability() {
		return disability;
	}


	public void setDisability(String disability) {
		this.disability = disability;
	}


	public String getHighestEducation() {
		return highestEducation;
	}


	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}


	public String getEmployementType() {
		return EmployementType;
	}


	public void setEmployementType(String employementType) {
		EmployementType = employementType;
	}


	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

   


	public Long getIncome() {
		return income;
	}




	public void setIncome(Long income) {
		this.income = income;
	}




	public String getWorkLocation() {
		return WorkLocation;
	}


	public void setWorkLocation(String workLocation) {
		WorkLocation = workLocation;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
 
	
	

	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fName, String mName, String lName) {
	
		String name = fName + mName + lName;
		this.fullName = name ;
		System.out.println(name);
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}



	



	
	
	
	
		

}
