package hrms.model.entity;

import com.google.gson.Gson;

import java.time.LocalDate;

public class Salary {
    int id,employeeId;
    LocalDate date;
    long amount;

    public Salary() {
    }

    public Salary(int employeeId, LocalDate date, long amount) {
        this.employeeId = employeeId;
        this.date = date;
        this.amount = amount;
    }

    public Salary(int id, int employeeId, LocalDate date, long amount) {
        this.id = id;
        this.employeeId = employeeId;
        this.date = date;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Salary setId(int id) {
        this.id = id;
        return this;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Salary setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Salary setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public long getAmount() {
        return amount;
    }

    public Salary setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
