package personal.rajit.service.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;
import personal.rajit.controller.request_dto.ExpenseSearchDto;
import personal.rajit.entity.QExpense;

public class ExpensePredicate {


    private static final QExpense qExpense = QExpense.expense;
    //private static final QRoomCategory qRoomCategory = QRoomCategory.roomCategory;

    public static Predicate makePredicate(ExpenseSearchDto expenseSearchDto) {

        BooleanBuilder builder = new BooleanBuilder();
        if (!CollectionUtils.isEmpty(expenseSearchDto.getIdList())) {
            builder.and(qExpense.id.in(expenseSearchDto.getIdList()));
        }
        if (!CollectionUtils.isEmpty(expenseSearchDto.getIdNotEqualList())) {
            builder.and(qExpense.id.notIn(expenseSearchDto.getIdNotEqualList()));
        }


    /*if (StringUtils.isNotBlank(roomSearchDto.getRoomCategoryId())) {
      builder.and(qRoom.roomCategoryId.equalsIgnoreCase(roomSearchDto.getRoomCategoryId()));
    }*/
      /*  if (StringUtils.isNotBlank(expenseSearchDto.getMultiSearchProp())) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(qExpense.name.containsIgnoreCase(expenseSearchDto.getMultiSearchProp()))
                    .or(qExpense.name.containsIgnoreCase(roomSearchDto.getMultiSearchProp()))
                    .or(qExpense.roomCategoryId.containsIgnoreCase(roomSearchDto.getMultiSearchProp()));
            builder.and(booleanBuilder);
        } */

        return builder;
    }

}
