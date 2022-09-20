package hrms.model.entity;

import com.google.gson.Gson;

import java.time.LocalDate;

public class Furlough {
    int id,employeeId;
    LocalDate start,end;

    public Furlough(int id, int employeeId, LocalDate start, LocalDate end) {
        this.id = id;
        this.employeeId = employeeId;
        this.start = start;
        this.end = end;
    }

    public Furlough(int employeeId, LocalDate start, LocalDate end) {
        this.employeeId = employeeId;
        this.start = start;
        this.end = end;
    }

    public Furlough() {
    }

    public int getId() {
        return id;
    }

    public Furlough setId(int id) {
        this.id = id;
        return this;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Furlough setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public LocalDate getStart() {
        return start;
    }

    public Furlough setStart(LocalDate start) {
        this.start = start;
        return this;
    }

    public LocalDate getEnd() {
        return end;
    }

    public Furlough setEnd(LocalDate end) {
        this.end = end;
        return this;
    }
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
