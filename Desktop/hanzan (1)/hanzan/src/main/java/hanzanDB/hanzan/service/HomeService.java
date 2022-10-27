package hanzanDB.hanzan.service;

import hanzanDB.hanzan.data.entity.dto.Response.HomeResponseDto;

import java.util.List;

public interface HomeService {
    List<HomeResponseDto> returnTop3(Long uid);
}
