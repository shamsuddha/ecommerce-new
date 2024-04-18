package personal.rajit.service.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;
import personal.rajit.controller.request_dto.PurchaseDetailSearchDto;
import personal.rajit.entity.QPurchaseDetail;

public class PurchaseDetailPredicate {

    private static final QPurchaseDetail qPurchaseDetail = QPurchaseDetail.purchaseDetail;


    public static Predicate makePredicate(PurchaseDetailSearchDto purchaseDetailSearchDto) {

        BooleanBuilder builder = new BooleanBuilder();
        if (!CollectionUtils.isEmpty(purchaseDetailSearchDto.getIdList())) {
            builder.and(qPurchaseDetail.id.in(purchaseDetailSearchDto.getIdList()));
        }
        if (!CollectionUtils.isEmpty(purchaseDetailSearchDto.getIdNotEqualList())) {
            builder.and(qPurchaseDetail.id.notIn(purchaseDetailSearchDto.getIdNotEqualList()));
        }

    /*if (StringUtils.isNotBlank(roomSearchDto.getRoomCategoryId())) {
      builder.and(qRoom.roomCategoryId.equalsIgnoreCase(roomSearchDto.getRoomCategoryId()));
    }*/
      /*  if (StringUtils.isNotBlank(purchaseDetailSearchDto.getMultiSearchProp())) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(qPurchaseDetail.name.containsIgnoreCase(purchaseDetailSearchDto.getMultiSearchProp()))
                    .or(qPurchaseDetail.name.containsIgnoreCase(roomSearchDto.getMultiSearchProp()))
                    .or(qPurchaseDetail.roomCategoryId.containsIgnoreCase(roomSearchDto.getMultiSearchProp()));
            builder.and(booleanBuilder);
        } */

        return builder;
    }
}
