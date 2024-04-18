package personal.rajit.service.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;
import personal.rajit.controller.request_dto.EmployeeSearchDto;
import personal.rajit.entity.QEmployee;

public class EmployeePredicate {

    private static final QEmployee qEmployee = QEmployee.employee;

    public static Predicate makePredicate(EmployeeSearchDto employeeSearchDto) {

        BooleanBuilder builder = new BooleanBuilder();

        if (!CollectionUtils.isEmpty(employeeSearchDto.getIdList())) {
            builder.and(qEmployee.id.in(employeeSearchDto.getIdList()));
        }
        if (!CollectionUtils.isEmpty(employeeSearchDto.getIdNotEqualList())) {
            builder.and(qEmployee.id.notIn(employeeSearchDto.getIdNotEqualList()));
        }
        if (StringUtils.isNotBlank(employeeSearchDto.getName())) {
            builder.and(qEmployee.name.eq(employeeSearchDto.getName()));
        }
        if (StringUtils.isNotBlank(employeeSearchDto.getNameIgnoreCase())) {
            builder.and(qEmployee.name.equalsIgnoreCase(employeeSearchDto.getNameIgnoreCase()));
        }

    /*if (StringUtils.isNotBlank(roomSearchDto.getRoomCategoryId())) {
      builder.and(qRoom.roomCategoryId.equalsIgnoreCase(roomSearchDto.getRoomCategoryId()));
    }*/
      /*  if (StringUtils.isNotBlank(employeeSearchDto.getMultiSearchProp())) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(qEmployee.name.containsIgnoreCase(employeeSearchDto.getMultiSearchProp()))
                    .or(qEmployee.name.containsIgnoreCase(roomSearchDto.getMultiSearchProp()))
                    .or(qEmployee.roomCategoryId.containsIgnoreCase(roomSearchDto.getMultiSearchProp()));
            builder.and(booleanBuilder);
        } */

        return builder;
    }

}
