package hanzanDB.hanzan.data.entity.dto.Request;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RecommandationRequest {
    private Long userIdx;
    private List<String> foodNames;
    private List<String> drinkNames;
}
