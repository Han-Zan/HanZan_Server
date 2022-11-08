package hanzanDB.hanzan.data.entity.dao;

import hanzanDB.hanzan.data.entity.dto.Response.HomeResponseDto;

import java.util.List;

public interface HomeDAO {
    List<HomeResponseDto> returnCombination(Long uid);
}
