package pro.sky.employe25.employeers.exceprion;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    // устанавливаем лимит на сотрудников, пусть их будет 3
    private final int maxEmployersNumbers = 3;
    // переводим в лист формат
    private final List<Employee> employees = new ArrayList<>();

    // метод на добавление сотрудника
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.size() == maxEmployersNumbers) {
            // прокидываем ошибку если слишком много людкй
            throw new EmployeeStorageIsFullException(" Людей слишком много");
        }
        // прокидываем на ошибку если не нуль и если есть такой тип и переводим в лист формат
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException(" такой тип уже есть");
        }
        employees.add(employee);

//        for (int i = 0; i < employees.size(); i++) {
//            if (employees[i] != null && employees[i].equals(employee)) {
//                throw new EmployeeAlreadyAddedException(" такой тип уже есть");
//            }
//            if (employees[i] == null) {
//                employees[i] = employee;
//                break;
//            }


 //       }
        return employee;
    }
    // метод на поиск сотрудника
    public Employee find(String firstName, String lastName) {

        Employee employee = null;
        for (Employee e : employees) {
            if (e != null && firstName.equals(e.getFirstNameEmployer()) && lastName.equals(e.getLastNameEmployer())) {
                employee = e;
            }
        }
        if (employee == null) {
            throw new EmployeeNotFoundException(" при поиске сотрудник не найден.");
        }
        return employee;

    }

    // метод на ремув сотрудников из базы
    public Employee remove(String firstName, String lastName) {
        // сначала ищем есть ли у нас он
        Employee employee = find(firstName, lastName);
        // переводим в лист формат
        for (Employee e: employees) {
            if (e.equals(employee)) {
                return e;
            }
            
        }
        if (employee == null) {
        }
        // проверяем на нули и есть ли у нас такой же
//        for (int i = 0; i < employees.length; i++) {
//            if (employees[i] != null && employees[i].equals(employee)) {
//                employees[i] = null;
//            }
//        }
        return employee;
    }

    // метод на получение всех чудиков в виде массива
    public List<Employee> getAll() {
        return employees;
    }
}
