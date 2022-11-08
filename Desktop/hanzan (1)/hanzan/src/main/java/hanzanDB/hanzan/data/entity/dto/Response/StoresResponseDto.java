package hanzanDB.hanzan.data.entity.dto.Response;

import hanzanDB.hanzan.data.entity.Combination;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoresResponseDto {
    private Long idx;

    private String storeName;

    private String imgLink;

    private String kakaoId;

    private List<CombinationResponseDto> combinationList = new ArrayList<>();
}
