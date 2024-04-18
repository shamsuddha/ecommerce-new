package personal.rajit.service.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;
import personal.rajit.controller.request_dto.SellSearchDto;
import personal.rajit.entity.QSell;

public class SellPredicate {

    private static final QSell qSell = QSell.sell;
    //private static final QRoomCategory qRoomCategory = QRoomCategory.roomCategory;

    public static Predicate makePredicate(SellSearchDto sellSearchDto) {

        BooleanBuilder builder = new BooleanBuilder();
        if (!CollectionUtils.isEmpty(sellSearchDto.getIdList())) {
            builder.and(qSell.id.in(sellSearchDto.getIdList()));
        }
        if (!CollectionUtils.isEmpty(sellSearchDto.getIdNotEqualList())) {
            builder.and(qSell.id.notIn(sellSearchDto.getIdNotEqualList()));
        }
        if (StringUtils.isNotBlank(sellSearchDto.getName())) {
            builder.and(qSell.name.eq(sellSearchDto.getName()));
        }
        if (StringUtils.isNotBlank(sellSearchDto.getNameIgnoreCase())) {
            builder.and(qSell.name.equalsIgnoreCase(sellSearchDto.getNameIgnoreCase()));
        }

    /*if (StringUtils.isNotBlank(roomSearchDto.getRoomCategoryId())) {
      builder.and(qRoom.roomCategoryId.equalsIgnoreCase(roomSearchDto.getRoomCategoryId()));
    }*/
      /*  if (StringUtils.isNotBlank(sellSearchDto.getMultiSearchProp())) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(qSell.name.containsIgnoreCase(sellSearchDto.getMultiSearchProp()))
                    .or(qSell.name.containsIgnoreCase(roomSearchDto.getMultiSearchProp()))
                    .or(qSell.roomCategoryId.containsIgnoreCase(roomSearchDto.getMultiSearchProp()));
            builder.and(booleanBuilder);
        } */

        return builder;
    }
}
