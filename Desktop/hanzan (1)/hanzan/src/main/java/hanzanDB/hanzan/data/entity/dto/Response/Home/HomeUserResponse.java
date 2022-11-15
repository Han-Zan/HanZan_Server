package hanzanDB.hanzan.data.entity.dto.Response.Home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HomeUserResponse {
    private String name;
    private List<HomeResponseDto> lists;
}
