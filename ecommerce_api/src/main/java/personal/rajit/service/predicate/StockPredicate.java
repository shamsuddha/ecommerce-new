package personal.rajit.service.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;
import personal.rajit.controller.request_dto.StockSearchDto;
import personal.rajit.entity.QStock;

public class StockPredicate {

    private static final QStock qStock = QStock.stock;
    //private static final QRoomCategory qRoomCategory = QRoomCategory.roomCategory;

    public static Predicate makePredicate(StockSearchDto stockSearchDto) {

        BooleanBuilder builder = new BooleanBuilder();
        if (!CollectionUtils.isEmpty(stockSearchDto.getIdList())) {
            builder.and(qStock.id.in(stockSearchDto.getIdList()));
        }
        if (!CollectionUtils.isEmpty(stockSearchDto.getIdNotEqualList())) {
            builder.and(qStock.id.notIn(stockSearchDto.getIdNotEqualList()));
        }
        if (StringUtils.isNotBlank(stockSearchDto.getName())) {
            builder.and(qStock.name.eq(stockSearchDto.getName()));
        }
        if (StringUtils.isNotBlank(stockSearchDto.getNameIgnoreCase())) {
            builder.and(qStock.name.equalsIgnoreCase(stockSearchDto.getNameIgnoreCase()));
        }

    /*if (StringUtils.isNotBlank(roomSearchDto.getRoomCategoryId())) {
      builder.and(qRoom.roomCategoryId.equalsIgnoreCase(roomSearchDto.getRoomCategoryId()));
    }*/
      /*  if (StringUtils.isNotBlank(stockSearchDto.getMultiSearchProp())) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(qStock.name.containsIgnoreCase(stockSearchDto.getMultiSearchProp()))
                    .or(qStock.name.containsIgnoreCase(roomSearchDto.getMultiSearchProp()))
                    .or(qStock.roomCategoryId.containsIgnoreCase(roomSearchDto.getMultiSearchProp()));
            builder.and(booleanBuilder);
        } */

        return builder;
    }

}
