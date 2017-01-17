package com.adiye.happyhome.coreapi.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by nyeluri on 11/15/16.
 */

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_Id")
    private Long userId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="date_of_birth")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="MM/dd/yyyy")
    private Date dob;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
            Objects.equals(firstName, user.firstName) &&
            Objects.equals(lastName, user.lastName) &&
            Objects.equals(dob, user.dob);
    }

    @Override public int hashCode() {
        return Objects.hash(userId, firstName, lastName, dob);
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userId='").append(userId).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", dob='").append(dob).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
