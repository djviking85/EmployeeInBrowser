package pro.sky.employe25.employeers.Employer.Service;

import org.springframework.stereotype.Service;
import pro.sky.employe25.employeers.Employer.Model.Employee;
import pro.sky.employe25.employeers.Employer.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.employe25.employeers.Employer.Exceptions.EmployeeNotFoundException;
import pro.sky.employe25.employeers.Employer.Exceptions.EmployeeStorageIsFullException;

import java.util.*;

import static pro.sky.employe25.employeers.Employer.Model.Departament.DEPARTAMENT_MAP_ID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int maxEmployersNumbers = 10;
    private static List<Employee> employees = new ArrayList<>();
    static {
        Employee it1 = new Employee("Алекс", "Сигурдсон", 200000, DEPARTAMENT_MAP_ID.get(1));
        Employee it2 = new Employee("Sam", "Schott", 150000, DEPARTAMENT_MAP_ID.get(1));

        Employee buchgaltery1 = new Employee("Eva", "Brown", 25000, DEPARTAMENT_MAP_ID.get(2));
        Employee buchgaltery2 = new Employee("Silvia", "Nilson", 35000, DEPARTAMENT_MAP_ID.get(2));
        Employee buchgaltery3 = new Employee("Mira", "O'Hara", 45000, DEPARTAMENT_MAP_ID.get(2));

        Employee managers1 = new Employee("Frank", "Blue", 60000, DEPARTAMENT_MAP_ID.get(3));
        Employee managers2 = new Employee("Sam", "Smith", 65000, DEPARTAMENT_MAP_ID.get(3));
        Employee managers3 = new Employee("Fill", "Varrant", 75000, DEPARTAMENT_MAP_ID.get(3));
        Employee managers4 = new Employee("Ed", "Hollywood", 101000, DEPARTAMENT_MAP_ID.get(3));

        employees.add(it1);
        employees.add(it2);

        employees.add(buchgaltery1);
        employees.add(buchgaltery2);
        employees.add(buchgaltery3);

        employees.add(managers1);
        employees.add(managers2);
        employees.add(managers3);
        employees.add(managers4);

    }
    private final Map<Integer, Employee> employeeByHashCode = new HashMap<>();

    private int getEmployeeKey(String firstName, String lastName) {
        return Objects.hash(firstName, lastName);
    }
    @Override
    public Employee add(String firstName, String lastName, float salary, int departamentId) {
        Employee employee = new Employee(firstName, lastName, salary, DEPARTAMENT_MAP_ID.get(departamentId));

        if (employeeByHashCode.size() == maxEmployersNumbers) {
            throw new EmployeeStorageIsFullException(" Людей слишком много");
        }
        int employeeKey = getEmployeeKey(firstName, lastName);
        if (employeeByHashCode.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAddedException(" такой тип уже есть");
        }
        employeeByHashCode.put(employeeKey, employee);

        return employee;
    }
    @Override

    public Employee find(String firstName, String lastName) {
        int employeeHashCode = getEmployeeKey(firstName, lastName);

        Employee employee = employeeByHashCode.get(employeeHashCode);

        if (employee == null) {
            throw new EmployeeNotFoundException(" при поиске сотрудник не найден.");
        }
        return employee;
    }
@Override
    public Employee remove(String firstName, String lastName) {
        int employeeHashCode = getEmployeeKey(firstName, lastName);
        Employee employee = employeeByHashCode.remove(employeeHashCode);
        if (employee == null) {
            throw new EmployeeNotFoundException(" при поиске сотрудник не найден.");
        }
        return employee;
    }
@Override
    public List<Employee> getAll() {
    return employees;

    }

}