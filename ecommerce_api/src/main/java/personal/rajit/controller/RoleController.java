package personal.rajit.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.rajit.controller.request_dto.RoleSearchDto;
import personal.rajit.entity.Role;
import personal.rajit.service.RoleService;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/save")
    public ResponseEntity<Role> save(@RequestBody Role role) {
        return new ResponseEntity(roleService.saveRole(role), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/update")
    public ResponseEntity<Role> update(@RequestBody Role role) {
        return new ResponseEntity(roleService.updateRole(role), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody Role role) {
        return new ResponseEntity(roleService.deleteRole(role), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Role>> search(@RequestBody RoleSearchDto roleSearchDto) {
        return new ResponseEntity(roleService.searchRole(roleSearchDto), HttpStatusCode.valueOf(200));
    }

}
