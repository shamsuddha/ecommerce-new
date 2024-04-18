package personal.rajit.service.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.util.CollectionUtils;
import personal.rajit.controller.request_dto.SellDetailSearchDto;
import personal.rajit.entity.QSellDetail;

public class SellDetailPredicate {

    private static final QSellDetail qSellDetail = QSellDetail.sellDetail;

    public static Predicate makePredicate(SellDetailSearchDto sellDetailSearchDto) {

        BooleanBuilder builder = new BooleanBuilder();
        if (!CollectionUtils.isEmpty(sellDetailSearchDto.getIdList())) {
            builder.and(qSellDetail.id.in(sellDetailSearchDto.getIdList()));
        }
        if (!CollectionUtils.isEmpty(sellDetailSearchDto.getIdNotEqualList())) {
            builder.and(qSellDetail.id.notIn(sellDetailSearchDto.getIdNotEqualList()));
        }

    /*if (StringUtils.isNotBlank(roomSearchDto.getRoomCategoryId())) {
      builder.and(qRoom.roomCategoryId.equalsIgnoreCase(roomSearchDto.getRoomCategoryId()));
    }*/
      /*  if (StringUtils.isNotBlank(sellDetailSearchDto.getMultiSearchProp())) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(qSellDetail.name.containsIgnoreCase(sellDetailSearchDto.getMultiSearchProp()))
                    .or(qSellDetail.name.containsIgnoreCase(roomSearchDto.getMultiSearchProp()))
                    .or(qSellDetail.roomCategoryId.containsIgnoreCase(roomSearchDto.getMultiSearchProp()));
            builder.and(booleanBuilder);
        } */

        return builder;
    }

}

