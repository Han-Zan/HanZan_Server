package hanzanDB.hanzan.service.impl;

import hanzanDB.hanzan.data.dao.PreferredDAO;
import hanzanDB.hanzan.data.entity.Preferred;
import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dto.PreferredDto;
import hanzanDB.hanzan.data.entity.dto.Response.PreferredResponseDto;
import hanzanDB.hanzan.service.PreferredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PreferredServiceImpl implements PreferredService {
    private final PreferredDAO preferredDAO;
    @Autowired
    public PreferredServiceImpl(PreferredDAO preferredDAO) {
        this.preferredDAO = preferredDAO;
    }

    @Override
    public PreferredResponseDto savePreferred(PreferredDto preferredDto) {
        Preferred preferred = new Preferred();
        preferred.setUseridx(preferredDto.getUseridx());
        preferred.setDrinks(preferredDto.getDrinkidx());
        preferred.setCreatedAt(LocalDateTime.now());

        Preferred newpref = preferredDAO.insertPreferred(preferred);

        PreferredResponseDto preferredResponseDto = new PreferredResponseDto();
        preferredResponseDto.setId(newpref.getId());
        preferredResponseDto.setUserId(newpref.getUseridx());
        preferredResponseDto.setDrinkId(newpref.getDrinks());
        preferredResponseDto.setCreatedAt(newpref.getCreatedAt());
        return preferredResponseDto;
    }

    @Override
    public List<Product> getPreferredProd(Long userid) throws Exception{
        return preferredDAO.getPreferred(userid);
    }
    @Override
    public void delete(Long user, Long product) throws Exception {
        preferredDAO.Delete(user, product);
    }
}
