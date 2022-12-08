package hanzanDB.hanzan.data.entity.dto.Response.Store;

import hanzanDB.hanzan.data.entity.dto.Response.Combination.CombinationResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private List<StoreCombResponseDto> combinationList = new ArrayList<>();
}
