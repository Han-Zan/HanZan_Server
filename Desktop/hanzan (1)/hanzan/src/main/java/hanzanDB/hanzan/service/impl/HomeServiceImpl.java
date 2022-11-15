package hanzanDB.hanzan.service.impl;

import hanzanDB.hanzan.data.entity.dao.HomeDAO;
import hanzanDB.hanzan.data.entity.dto.Response.Home.HomeResponseDto;
import hanzanDB.hanzan.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    private final HomeDAO homeDAO;
    @Autowired
    public HomeServiceImpl(HomeDAO homeDAO) {
        this.homeDAO = homeDAO;
    }
    @Override
    public List<HomeResponseDto> returnTop3(Long uid) {
        return homeDAO.returnCombination(uid);
    }
}
