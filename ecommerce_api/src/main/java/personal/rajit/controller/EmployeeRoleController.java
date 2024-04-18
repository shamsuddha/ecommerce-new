package personal.rajit.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.rajit.controller.request_dto.EmployeeRoleSearchDto;
import personal.rajit.entity.EmployeeRole;
import personal.rajit.service.EmployeeRoleService;

@RestController
@RequestMapping("/employee-role")
@AllArgsConstructor
public class EmployeeRoleController {

    private final EmployeeRoleService employeeRoleService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeRole> save(@RequestBody EmployeeRole employeeRole) {
        return new ResponseEntity(employeeRoleService.saveEmployeeRole(employeeRole), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/update")
    public ResponseEntity<EmployeeRole> update(@RequestBody EmployeeRole employeeRole) {
        return new ResponseEntity(employeeRoleService.updateEmployeeRole(employeeRole), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteEmployeeRole(@RequestBody EmployeeRole employeeRole) {
        return new ResponseEntity(employeeRoleService.deleteEmployeeRole(employeeRole), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<EmployeeRole>> search(@RequestBody EmployeeRoleSearchDto employeeRoleSearchDto) {
        return new ResponseEntity(employeeRoleService.searchEmployeeRole(employeeRoleSearchDto), HttpStatusCode.valueOf(200));
    }
}
