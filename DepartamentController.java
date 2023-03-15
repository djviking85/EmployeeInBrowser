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
    @RequestMapping("/departament")
    public class DepartamentController {
        private final DepartamentService departamentService;

        @Autowired
        public DepartamentController(DepartamentServiceImp departamentService) {
            this.departamentService = departamentService;
        }
        @GetMapping(path = "/max-salary")
        public Employee maxSalary (@RequestParam Integer departamentId) {
            return departamentService.getEmployeeWithMaxSalary(departamentId);
        }
        @GetMapping(path = "/min-salary")
        public Employee maxSalary (@RequestParam Integer departamentId) {
            return departamentService.getEmployeeWithMinSalary(departamentId);
        }
        @GetMapping(path = "/all")
        public Map<String, List<Employee>> allByDepId (@RequestParam (required = false) Integer departamentId) {
            return departamentService.getAll(departamentId);
        }


        }



