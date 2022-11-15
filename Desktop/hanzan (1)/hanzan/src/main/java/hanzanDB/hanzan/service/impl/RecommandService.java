package hanzanDB.hanzan.service.impl;

import hanzanDB.hanzan.data.entity.Combination;
import hanzanDB.hanzan.data.entity.Food;
import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dao.CombinationDAO;
import hanzanDB.hanzan.data.entity.dao.FoodDAO;
import hanzanDB.hanzan.data.entity.dao.PreferredCombDAO;
import hanzanDB.hanzan.data.entity.dao.ProductDAO;
import hanzanDB.hanzan.data.entity.dto.Request.CombinationRequest;
import hanzanDB.hanzan.data.entity.dto.Response.Recommandation.RecommandationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommandService {
    private final CombinationDAO combinationDAO;
    private final ProductDAO productDAO;
    private final FoodDAO foodDAO;
    private final PreferredCombDAO preferredCombDAO;

    @Autowired
    public RecommandService(CombinationDAO combinationDAO, ProductDAO productDAO, FoodDAO foodDAO, PreferredCombDAO preferredCombDAO) {
        this.combinationDAO = combinationDAO;
        this.productDAO = productDAO;
        this.foodDAO = foodDAO;
        this.preferredCombDAO = preferredCombDAO;
    }

    public RecommandationDto recommand(Long userId, String foodName, String drinkName) throws Exception{
        Food foods = foodDAO.getFoodByName(foodName);
        Product prod = productDAO.selectProductByname(drinkName);
        Combination combination = new Combination();
        combination.setRating(0);
        combination.setDid(prod.getId());
        combination.setFid(foods.getId());
        combination.setPnum(0);
        combination.setScore(recommandationSet(foods, prod).intValue());
        Combination combi = combinationDAO.insertCombination(combination);

        RecommandationDto recommandationDto = new RecommandationDto();
        recommandationDto.setScore(combi.getScore());
        recommandationDto.setRating(combi.getRating());
        recommandationDto.setCombIdx(combi.getId());
        recommandationDto.setPrefer(preferredCombDAO.isIn(userId, combi.getId()));

        return recommandationDto;
    }

    public Double recommandationSet(Food food, Product product) {
        List<Product> prodlist = food.getProductsList();
        Double setNum = 0.0;
        for(Product prod : prodlist) {
            Double MaxNum = 0.0;
            MaxNum += Math.abs(prod.getSweet() - product.getSweet());
            MaxNum += Math.abs(prod.getBitter() - product.getBitter());
            MaxNum += Math.abs(prod.getSour() - product.getSour());
            MaxNum += Math.abs(prod.getBody() - product.getBody());
            MaxNum += 5 * (Math.abs(prod.getSparkle() - product.getSparkle()));
            MaxNum += (3 * (Math.abs(prod.getAlcohol() - product.getAlcohol()))) / 10;
            if(!(prod.getCategory() == product.getCategory()))
                MaxNum += 20;

            MaxNum = ((80 -  MaxNum) / 80) * 100;
            if(setNum <  MaxNum)
                setNum = MaxNum;
        }
        return setNum;

    }


}
