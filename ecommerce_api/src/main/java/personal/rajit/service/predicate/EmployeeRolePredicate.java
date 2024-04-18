package personal.rajit.service.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.util.CollectionUtils;
import personal.rajit.controller.request_dto.EmployeeRoleSearchDto;
import personal.rajit.entity.QEmployeeRole;

public class EmployeeRolePredicate {

    private static final QEmployeeRole qEmployeeRole = QEmployeeRole.employeeRole;
    //private static final QRoomCategory qRoomCategory = QRoomCategory.roomCategory;

    public static Predicate makePredicate(EmployeeRoleSearchDto employeeRoleSearchDto) {

        BooleanBuilder builder = new BooleanBuilder();
        if (!CollectionUtils.isEmpty(employeeRoleSearchDto.getIdList())) {
            builder.and(qEmployeeRole.id.in(employeeRoleSearchDto.getIdList()));
        }
        if (!CollectionUtils.isEmpty(employeeRoleSearchDto.getIdNotEqualList())) {
            builder.and(qEmployeeRole.id.notIn(employeeRoleSearchDto.getIdNotEqualList()));
        }

    /*if (StringUtils.isNotBlank(roomSearchDto.getRoomCategoryId())) {
      builder.and(qRoom.roomCategoryId.equalsIgnoreCase(roomSearchDto.getRoomCategoryId()));
    }*/
      /*  if (StringUtils.isNotBlank(employeeRoleSearchDto.getMultiSearchProp())) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(qEmployeeRole.name.containsIgnoreCase(employeeRoleSearchDto.getMultiSearchProp()))
                    .or(qEmployeeRole.name.containsIgnoreCase(roomSearchDto.getMultiSearchProp()))
                    .or(qEmployeeRole.roomCategoryId.containsIgnoreCase(roomSearchDto.getMultiSearchProp()));
            builder.and(booleanBuilder);
        } */

        return builder;
    }

}
