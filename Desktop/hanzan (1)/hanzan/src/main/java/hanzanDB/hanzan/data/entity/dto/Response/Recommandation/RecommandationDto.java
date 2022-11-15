package hanzanDB.hanzan.data.entity.dto.Response.Recommandation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecommandationDto {
    private Long combIdx;
    private Integer score;
    private boolean isPrefer;
    private float rating;
}
