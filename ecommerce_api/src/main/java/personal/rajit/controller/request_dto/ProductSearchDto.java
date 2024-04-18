package personal.rajit.controller.request_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import personal.rajit.common.SearchDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProductSearchDto extends SearchDto {
    private List<String> idList;
    private List<String> idNotEqualList;

    private String name;
    private String nameIgnoreCase;
}
