package com.rest.employee;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by Sindhu on 8/13/15.
 */
public class Employee {

    int employeeID;

    @NotNull(message = "First name cannot be null!")
    String firstName;

    @NotNull(message = "Last name cannot be null!")
    String lastName;

    @Email(message = "Enter a valid email address!")
    @NotNull
    @NotEmpty(message = "Email id is required. It cannot be null and empty!")
    String email;

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getFirstName() {
        return firstName;

    }

    public String getLastName() {

        return lastName;
    }

    public String getEmail() {

        return email;
    }


}
