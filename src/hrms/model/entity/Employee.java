package hrms.model.entity;

import com.google.gson.Gson;

import java.time.LocalDate;

public class Employee {
    int id;
    String name,lastName,fathersName,phoneNumber,nationalCode,password;
    LocalDate dob,employmentDate;

    public Employee() {
    }

    public Employee(String name, String lastName, String fathersName, String phoneNumber, String nationalCode,
                    String password, LocalDate dob, LocalDate employmentDate) {
        this.name = name;
        this.lastName = lastName;
        this.fathersName = fathersName;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
        this.password = password;
        this.dob = dob;
        this.employmentDate = employmentDate;
    }

    public Employee(int id, String name, String lastName, String fathersName, String phoneNumber, String nationalCode,
                    String password, LocalDate dob, LocalDate employmentDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.fathersName = fathersName;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
        this.password = password;
        this.dob = dob;
        this.employmentDate = employmentDate;
    }

    public int getId() {
        return id;
    }

    public Employee setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFathersName() {
        return fathersName;
    }

    public Employee setFathersName(String fathersName) {
        this.fathersName = fathersName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Employee setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public Employee setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Employee setPassword(String password) {
        this.password = password;
        return this;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Employee setDob(LocalDate dob) {
        this.dob = dob;
        return this;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public Employee setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
