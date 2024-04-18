package personal.rajit.service.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.util.CollectionUtils;
import personal.rajit.controller.request_dto.RoleSearchDto;
import personal.rajit.entity.QRole;

public class RolePredicate {

    private static final QRole qRole = QRole.role;

    public static Predicate makePredicate(RoleSearchDto roleSearchDto) {

        BooleanBuilder builder = new BooleanBuilder();
        if (!CollectionUtils.isEmpty(roleSearchDto.getIdList())) {
            builder.and(qRole.id.in(roleSearchDto.getIdList()));
        }
        if (!CollectionUtils.isEmpty(roleSearchDto.getIdNotEqualList())) {
            builder.and(qRole.id.notIn(roleSearchDto.getIdNotEqualList()));
        }

    /*if (StringUtils.isNotBlank(roomSearchDto.getRoomCategoryId())) {
      builder.and(qRoom.roomCategoryId.equalsIgnoreCase(roomSearchDto.getRoomCategoryId()));
    }*/
      /*  if (StringUtils.isNotBlank(roleSearchDto.getMultiSearchProp())) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(qRole.name.containsIgnoreCase(roleSearchDto.getMultiSearchProp()))
                    .or(qRole.name.containsIgnoreCase(roomSearchDto.getMultiSearchProp()))
                    .or(qRole.roomCategoryId.containsIgnoreCase(roomSearchDto.getMultiSearchProp()));
            builder.and(booleanBuilder);
        } */

        return builder;
    }

}
