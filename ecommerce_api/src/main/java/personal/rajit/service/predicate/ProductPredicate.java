package personal.rajit.service.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;
import personal.rajit.controller.request_dto.ProductSearchDto;
import personal.rajit.entity.QProduct;

public class ProductPredicate {

    private static final QProduct qProduct = QProduct.product;
    //private static final QRoomCategory qRoomCategory = QRoomCategory.roomCategory;

    public static Predicate makePredicate(ProductSearchDto productSearchDto) {

        BooleanBuilder builder = new BooleanBuilder();
        if (!CollectionUtils.isEmpty(productSearchDto.getIdList())) {
            builder.and(qProduct.id.in(productSearchDto.getIdList()));
        }
        if (!CollectionUtils.isEmpty(productSearchDto.getIdNotEqualList())) {
            builder.and(qProduct.id.notIn(productSearchDto.getIdNotEqualList()));
        }
        if (StringUtils.isNotBlank(productSearchDto.getName())) {
            builder.and(qProduct.name.eq(productSearchDto.getName()));
        }
        if (StringUtils.isNotBlank(productSearchDto.getNameIgnoreCase())) {
            builder.and(qProduct.name.equalsIgnoreCase(productSearchDto.getNameIgnoreCase()));
        }

    /*if (StringUtils.isNotBlank(roomSearchDto.getRoomCategoryId())) {
      builder.and(qRoom.roomCategoryId.equalsIgnoreCase(roomSearchDto.getRoomCategoryId()));
    }*/
      /*  if (StringUtils.isNotBlank(productSearchDto.getMultiSearchProp())) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(qProduct.name.containsIgnoreCase(productSearchDto.getMultiSearchProp()))
                    .or(qProduct.name.containsIgnoreCase(roomSearchDto.getMultiSearchProp()))
                    .or(qProduct.roomCategoryId.containsIgnoreCase(roomSearchDto.getMultiSearchProp()));
            builder.and(booleanBuilder);
        } */

        return builder;
    }

}
