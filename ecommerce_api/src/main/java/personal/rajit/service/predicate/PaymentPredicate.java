package personal.rajit.service.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.util.CollectionUtils;
import personal.rajit.controller.request_dto.PaymentSearchDto;
import personal.rajit.entity.QPayment;

public class PaymentPredicate {

    private static final QPayment qPayment = QPayment.payment;
    //private static final QRoomCategory qRoomCategory = QRoomCategory.roomCategory;

    public static Predicate makePredicate(PaymentSearchDto paymentSearchDto) {

        BooleanBuilder builder = new BooleanBuilder();
        if (!CollectionUtils.isEmpty(paymentSearchDto.getIdList())) {
            builder.and(qPayment.id.in(paymentSearchDto.getIdList()));
        }
        if (!CollectionUtils.isEmpty(paymentSearchDto.getIdNotEqualList())) {
            builder.and(qPayment.id.notIn(paymentSearchDto.getIdNotEqualList()));
        }


    /*if (StringUtils.isNotBlank(roomSearchDto.getRoomCategoryId())) {
      builder.and(qRoom.roomCategoryId.equalsIgnoreCase(roomSearchDto.getRoomCategoryId()));
    }*/
      /*  if (StringUtils.isNotBlank(paymentSearchDto.getMultiSearchProp())) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(qPayment.name.containsIgnoreCase(paymentSearchDto.getMultiSearchProp()))
                    .or(qPayment.name.containsIgnoreCase(roomSearchDto.getMultiSearchProp()))
                    .or(qPayment.roomCategoryId.containsIgnoreCase(roomSearchDto.getMultiSearchProp()));
            builder.and(booleanBuilder);
        } */

        return builder;
    }
}
