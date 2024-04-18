package personal.rajit.service.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;
import personal.rajit.controller.request_dto.ProductCategorySearchDto;
import personal.rajit.entity.QProductCategory;

public class ProductCategoryPredicate {

    private static final QProductCategory qProductCategory = QProductCategory.productCategory;
    //private static final QRoomCategory qRoomCategory = QRoomCategory.roomCategory;

    public static Predicate makePredicate(ProductCategorySearchDto productCategorySearchDto) {

        BooleanBuilder builder = new BooleanBuilder();
        if (!CollectionUtils.isEmpty(productCategorySearchDto.getIdList())) {
            builder.and(qProductCategory.id.in(productCategorySearchDto.getIdList()));
        }
        if (!CollectionUtils.isEmpty(productCategorySearchDto.getIdNotEqualList())) {
            builder.and(qProductCategory.id.notIn(productCategorySearchDto.getIdNotEqualList()));
        }
        if (StringUtils.isNotBlank(productCategorySearchDto.getName())) {
            builder.and(qProductCategory.name.eq(productCategorySearchDto.getName()));
        }
        if (StringUtils.isNotBlank(productCategorySearchDto.getNameIgnoreCase())) {
            builder.and(qProductCategory.name.equalsIgnoreCase(productCategorySearchDto.getNameIgnoreCase()));
        }

    /*if (StringUtils.isNotBlank(roomSearchDto.getRoomCategoryId())) {
      builder.and(qRoom.roomCategoryId.equalsIgnoreCase(roomSearchDto.getRoomCategoryId()));
    }*/
      /*  if (StringUtils.isNotBlank(productCategorySearchDto.getMultiSearchProp())) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(qProductCategory.name.containsIgnoreCase(productCategorySearchDto.getMultiSearchProp()))
                    .or(qProductCategory.name.containsIgnoreCase(roomSearchDto.getMultiSearchProp()))
                    .or(qProductCategory.roomCategoryId.containsIgnoreCase(roomSearchDto.getMultiSearchProp()));
            builder.and(booleanBuilder);
        } */

        return builder;
    }

}
