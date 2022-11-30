package hanzanDB.hanzan.data.entity.dao.impl;

import hanzanDB.hanzan.data.entity.Rating;
import hanzanDB.hanzan.data.entity.dao.CombinationDAO;
import hanzanDB.hanzan.data.entity.Combination;
import hanzanDB.hanzan.data.entity.dto.Request.CombinationRequest;
import hanzanDB.hanzan.data.entity.dto.Response.Recommandation.RecommandListDto;
import hanzanDB.hanzan.data.entity.dto.Response.Recommandation.RecommandationDto;
import hanzanDB.hanzan.data.repository.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class CombinationDAOImpl implements CombinationDAO {
    protected final Log logger = LogFactory.getLog(getClass());
    private final PreferredCombRepository preferredCombRepository;
    private final CombinationRepository combinationRepository;
    private final ProductRepository productRepository;
    private final FoodRepository foodRepository;

    private final RatingRepository ratingRepository;

    @Autowired
    public CombinationDAOImpl(PreferredCombRepository preferredCombRepository, CombinationRepository combinationRepository, ProductRepository productRepository, FoodRepository foodRepository, RatingRepository ratingRepository) {
        this.preferredCombRepository = preferredCombRepository;
        this.combinationRepository = combinationRepository;
        this.productRepository = productRepository;
        this.foodRepository = foodRepository;
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Combination insertCombination(Combination comb) throws Exception{
        Optional<Combination> combi = combinationRepository.findByDidAndFid(comb.getDid(), comb.getFid());
        if(combi.isPresent()) {
            Combination combs = combi.get();
            combs.setScore(comb.getScore());
            Combination newcomb = combinationRepository.save(combs);
            return newcomb;
        }
        Combination newcombi = combinationRepository.save(comb);
        return newcombi;
    }
    @Override
    public CombinationRequest getCombination (Long userId, Long combId) {
        Combination combi = combinationRepository.getReferenceById(combId);
        CombinationRequest combreq = new CombinationRequest();
        combreq.setId(combi.getId());
        combreq.setFoodname(foodRepository.getReferenceById(combi.getFid()).getName());
        combreq.setDrinkname(productRepository.getReferenceById(combi.getDid()).getName());
        combreq.setDrinkCategory(productRepository.getReferenceById(combi.getDid()).getCategory());
        combreq.setFoodCategory(foodRepository.getReferenceById(combi.getFid()).getFoodType());
        combreq.setFoodimg(foodRepository.getReferenceById(combi.getFid()).getImg());
        combreq.setDrinkimg(productRepository.getReferenceById(combi.getDid()).getImg());
        combreq.setRating(combi.getRating());
        combreq.setPnum(combi.getPnum());
        combreq.setCombScore(combi.getScore());
        if(preferredCombRepository.findByUidAndCombid(userId, combId).isPresent())
            combreq.setIsPrefer(true);
        else
            combreq.setIsPrefer(false);
        return combreq;
    }
    @Override
    public List<CombinationRequest> listAllComb(Long userId) {
        List<CombinationRequest> newlist = new ArrayList<>();
        for(Combination comb : combinationRepository.findAll()) {
            CombinationRequest combreq = new CombinationRequest();
            combreq.setId(comb.getId());
            combreq.setDrinkname(productRepository.getReferenceById(comb.getDid()).getName());
            combreq.setFoodname(foodRepository.getReferenceById(comb.getFid()).getName());
            combreq.setDrinkimg(productRepository.getReferenceById(comb.getDid()).getImg());
            combreq.setFoodimg(foodRepository.getReferenceById(comb.getFid()).getImg());
            combreq.setDrinkCategory(productRepository.getReferenceById(comb.getDid()).getCategory());
            combreq.setFoodCategory(foodRepository.getReferenceById(comb.getFid()).getFoodType());
            combreq.setPnum(comb.getPnum());
            combreq.setCombScore(comb.getScore());
            if(preferredCombRepository.findByUidAndCombid(userId, comb.getId()).isPresent())
                combreq.setIsPrefer(true);
            else
                combreq.setIsPrefer(false);
            newlist.add(combreq);
        }
        return newlist;
    }
    @Override
    public Combination updateCount(Long cid) throws Exception {
        Optional<Combination> getCombination = combinationRepository.findById(cid);
        Combination comb;
        if(getCombination.isPresent()) {
            Combination combination = getCombination.get();
            int num = combination.getPnum();
            num = num + 1;
            combination.setPnum(num);
            comb = combinationRepository.save(combination);
        } else {
            throw new Exception();
        }
        return comb;
    }
    @Override
    public Combination deleteCount(Long cid) throws Exception {
        Optional<Combination> getCombination = combinationRepository.findById(cid);
        Combination comb;
        if(getCombination.isPresent()) {
            Combination combination = getCombination.get();
            int num = combination.getPnum();
            num = num - 1;
            combination.setPnum(num);
            comb = combinationRepository.save(combination);
        } else {
            throw new Exception();
        }
        return comb;
    }

    @Override
    public Integer GetAllPnum() throws Exception {
        List<Combination> listComb = combinationRepository.findAll();
        Integer totalCount = 0;
        for(Combination comb : listComb) {
            totalCount += comb.getPnum();
        }
        return totalCount;
    }

    @Override
    public List<RecommandListDto> returnMaxCombination(Long userIdx, List<RecommandListDto> recommandListDtos) {

        List<Rating> ratings = ratingRepository.findByUserIdxOrderByRatingDesc(userIdx);
        List<RecommandListDto> recommandationdtos = new ArrayList<>();
        List<RecommandListDto> originalRec = new ArrayList<>(recommandListDtos);
        for(Rating rating : ratings) {
            for(RecommandListDto recommandListDto : recommandListDtos) {
                if(rating.getRating() >= 4.0f) {
                    if(recommandListDto.getCombId() == rating.getCombIdx()) {
                        recommandationdtos.add(recommandListDto);
                    }
                }
            }
        }

        if(!ratings.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(ratings.size());
            Rating selected = ratings.get(randomIndex);
            Long selectedcombid = selected.getCombIdx();
            for(RecommandListDto recommandListDto : originalRec) {
                if(selectedcombid == recommandListDto.getCombId() ) {
                    logger.info(selectedcombid);
                    logger.info(recommandListDto.getCombId());
                    int num = originalRec.indexOf(recommandListDto);
                    recommandListDto.setHighlyRec(true);
                    originalRec.set(num, recommandListDto);
                }
            }
        }

        return originalRec;

    }
}
