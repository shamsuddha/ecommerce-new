package personal.rajit.service.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;
import personal.rajit.controller.request_dto.CustomerSearchDto;
import personal.rajit.entity.QCustomer;

public class CustomerPredicate {

    private static final QCustomer qCustomer = QCustomer.customer;

    //private static final QRoomCategory qRoomCategory = QRoomCategory.roomCategory;

    public static Predicate makePredicate(CustomerSearchDto customerSearchDto) {

        BooleanBuilder builder = new BooleanBuilder();

        if (!CollectionUtils.isEmpty(customerSearchDto.getIdList())) {
            builder.and(qCustomer.id.in(customerSearchDto.getIdList()));
        }
        if (!CollectionUtils.isEmpty(customerSearchDto.getIdNotEqualList())) {
            builder.and(qCustomer.id.notIn(customerSearchDto.getIdNotEqualList()));
        }
        if (StringUtils.isNotBlank(customerSearchDto.getName())) {
            builder.and(qCustomer.name.eq(customerSearchDto.getName()));
        }
        if (StringUtils.isNotBlank(customerSearchDto.getNameIgnoreCase())) {
            builder.and(qCustomer.name.equalsIgnoreCase(customerSearchDto.getNameIgnoreCase()));
        }

    /*if (StringUtils.isNotBlank(roomSearchDto.getRoomCategoryId())) {
      builder.and(qRoom.roomCategoryId.equalsIgnoreCase(roomSearchDto.getRoomCategoryId()));
    }*/
      /*  if (StringUtils.isNotBlank(customerSearchDto.getMultiSearchProp())) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(qCustomer.name.containsIgnoreCase(customerSearchDto.getMultiSearchProp()))
                    .or(qCustomer.name.containsIgnoreCase(roomSearchDto.getMultiSearchProp()))
                    .or(qCustomer.roomCategoryId.containsIgnoreCase(roomSearchDto.getMultiSearchProp()));
            builder.and(booleanBuilder);
        } */

        return builder;
    }

}
