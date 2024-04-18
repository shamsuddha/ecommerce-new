package personal.rajit.service.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;
import personal.rajit.controller.request_dto.PurchaseSearchDto;
import personal.rajit.entity.QPurchase;

public class PurchasePredicate {
    private static final QPurchase qPurchase = QPurchase.purchase;
    //private static final QRoomCategory qRoomCategory = QRoomCategory.roomCategory;

    public static Predicate makePredicate(PurchaseSearchDto purchaseSearchDto) {

        BooleanBuilder builder = new BooleanBuilder();
        if (!CollectionUtils.isEmpty(purchaseSearchDto.getIdList())) {
            builder.and(qPurchase.id.in(purchaseSearchDto.getIdList()));
        }
        if (!CollectionUtils.isEmpty(purchaseSearchDto.getIdNotEqualList())) {
            builder.and(qPurchase.id.notIn(purchaseSearchDto.getIdNotEqualList()));
        }

    /*if (StringUtils.isNotBlank(roomSearchDto.getRoomCategoryId())) {
      builder.and(qRoom.roomCategoryId.equalsIgnoreCase(roomSearchDto.getRoomCategoryId()));
    }*/
      /*  if (StringUtils.isNotBlank(purchaseSearchDto.getMultiSearchProp())) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(qPurchase.name.containsIgnoreCase(purchaseSearchDto.getMultiSearchProp()))
                    .or(qPurchase.name.containsIgnoreCase(roomSearchDto.getMultiSearchProp()))
                    .or(qPurchase.roomCategoryId.containsIgnoreCase(roomSearchDto.getMultiSearchProp()));
            builder.and(booleanBuilder);
        } */

        return builder;
    }
}
