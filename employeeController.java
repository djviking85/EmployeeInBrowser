package pro.sky.employe25.employeers.exceprion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class employeeController {
    // делаем красиво ошибки в браузере
    @ResponseStatus(HttpStatus.NOT_FOUND) // указываем статус
    @ExceptionHandler(EmployeeNotFoundException.class) // какой класс юзаем
    // чекаем что нам пишет в браузере
    public String handleException(EmployeeNotFoundException e) {
        return String.format("ошибка: %s,  причина: %s", HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    public String handleException(EmployeeAlreadyAddedException e) {
        return String.format("ошибка: %s,  причина: %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeStorageIsFullException.class)
    public String handleException(EmployeeStorageIsFullException e) {
        return String.format("ошибка: %s,  причина: %s", HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    private final EmployeeService employeeService;


    @Autowired // инжектим автовайредом
    public employeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

    @GetMapping()
    public String hello() {
        return "Добро пожаловать в списки типов!";
    }

    //  пишем гетмапы на адд файнд ремув и гет оллh
    @GetMapping(path = "/add")
    public Employee addEmployer(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("salary") float salary,
                                @RequestParam("departamentId") int departamentId) {
        return employeeService.add(firstName, lastName, salary, departamentId);
    }

    @GetMapping(path = "/find")
    public Employee findEmployer(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployer(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping(path = "/findAll")
    public List<Employee> getEmployers() {
        return employeeService.getAll();
    }



}