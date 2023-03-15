package pro.sky.employe25.employeers.exceprion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


// создаем контроллер на департамент
    @RestController
    @RequestMapping("/departments")
    public class DepartamentController {
        private final DepartamentService departamentService;

        @Autowired
        public DepartamentController(DepartamentServiceImp departamentService) {
            this.departamentService = departamentService;
        }

         @GetMapping(path = "/max-salary")
        public Employee maxSalary(@RequestParam  Integer departmentId) {
        return departamentService.getEmployeeWithMaxSalary(departmentId);
        }
         @GetMapping(path = "/min-salary")
        public Employee minSalary (@RequestParam Integer departmentId) {
            return departamentService.getEmployeeWithMinSalary(departmentId);
        }
        @GetMapping(path = "/all")
        public Map<String, List<Employee>> allByDepId (@RequestParam (required = false) Integer departmentId) {
            return departamentService.getAll(departmentId);
        }


    }



