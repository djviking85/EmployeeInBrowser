package pro.sky.employe25.employeers.exceprion;

import java.util.Objects;

public class Employee {
    // создадим переменные, которые участвуют в конструкторе
    private String firstName;
    private String lastName;

    public String getFirstNameEmployer() {
        return firstName;
    }
    public String getLastNameEmployer() {
        return lastName;
    }

    public Employee (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    @Override
    public String toString() {
        return "  Имя:  " + this.firstName +
                ", Фамилия: " + this.lastName;
    }

       @Override
       public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != getClass()) return false;
          Employee employee = (Employee) o;
         return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
      }
    @Override
    public int hashCode () {
        return Objects.hash(firstName, lastName);
    }
}