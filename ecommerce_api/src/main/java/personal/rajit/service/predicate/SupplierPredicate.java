package personal.rajit.service.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;
import personal.rajit.controller.request_dto.SupplierSearchDto;
import personal.rajit.entity.QSupplier;

public class SupplierPredicate {
    private static final QSupplier qSupplier = QSupplier.supplier;
    //private static final QRoomCategory qRoomCategory = QRoomCategory.roomCategory;

    public static Predicate makePredicate(SupplierSearchDto supplierSearchDto) {

        BooleanBuilder builder = new BooleanBuilder();
        if (!CollectionUtils.isEmpty(supplierSearchDto.getIdList())) {
            builder.and(qSupplier.id.in(supplierSearchDto.getIdList()));
        }
        if (!CollectionUtils.isEmpty(supplierSearchDto.getIdNotEqualList())) {
            builder.and(qSupplier.id.notIn(supplierSearchDto.getIdNotEqualList()));
        }
        if (StringUtils.isNotBlank(supplierSearchDto.getName())) {
            builder.and(qSupplier.name.eq(supplierSearchDto.getName()));
        }
        if (StringUtils.isNotBlank(supplierSearchDto.getNameIgnoreCase())) {
            builder.and(qSupplier.name.equalsIgnoreCase(supplierSearchDto.getNameIgnoreCase()));
        }

    /*if (StringUtils.isNotBlank(roomSearchDto.getRoomCategoryId())) {
      builder.and(qRoom.roomCategoryId.equalsIgnoreCase(roomSearchDto.getRoomCategoryId()));
    }*/
      /*  if (StringUtils.isNotBlank(supplierSearchDto.getMultiSearchProp())) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(qSupplier.name.containsIgnoreCase(supplierSearchDto.getMultiSearchProp()))
                    .or(qSupplier.name.containsIgnoreCase(roomSearchDto.getMultiSearchProp()))
                    .or(qSupplier.roomCategoryId.containsIgnoreCase(roomSearchDto.getMultiSearchProp()));
            builder.and(booleanBuilder);
        } */

        return builder;
    }
}
