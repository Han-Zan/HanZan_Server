package hanzanDB.hanzan.securityutil.service;

import hanzanDB.hanzan.data.entity.dto.Response.Home.HomeResponseDto;

import java.util.List;

public interface HomeService {
    List<HomeResponseDto> returnTop3(Long uid);
}
