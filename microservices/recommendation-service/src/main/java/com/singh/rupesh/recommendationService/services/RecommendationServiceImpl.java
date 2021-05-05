package com.singh.rupesh.recommendationService.services;

import com.mongodb.DuplicateKeyException;
import com.singh.rupesh.api.core.Recommendation;
import com.singh.rupesh.api.core.RecommendationService;
import com.singh.rupesh.recommendationService.persistence.RecommendationEntity;
import com.singh.rupesh.recommendationService.persistence.RecommendationRepository;
import com.singh.rupesh.util.customExceptions.InvalidInputException;
import com.singh.rupesh.util.exceptions.ServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecommendationServiceImpl implements RecommendationService {
    private static final Logger LOG = LoggerFactory.getLogger(RecommendationServiceImpl.class);
    private final RecommendationRepository repository;
    private final RecommendationMapper mapper;
    private final ServiceUtil serviceUtil;

    @Autowired
    public RecommendationServiceImpl(RecommendationRepository repository, RecommendationMapper mapper, ServiceUtil serviceUtil) {
        this.repository = repository;
        this.mapper = mapper;
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<Recommendation> getRecommendations(int productId) {
        if(productId < 1) throw new InvalidInputException("Invalid productId: " + productId);

        List<RecommendationEntity> entityList = repository.findByProductId(productId);
        List<Recommendation> list = mapper.entityListToApiList(entityList);
        list.forEach(e -> e.setServiceAddress(serviceUtil.getServiceAddress()));
        LOG.info("get Recommendations: response size: {}", list.size());
        return list;
    }

    @Override
    public Recommendation createRecommendation(Recommendation body) {
        try {
            RecommendationEntity entity = mapper.apiToEntity(body);
            RecommendationEntity newEntity = repository.save(entity);
            LOG.info("createRecommendation: created a recommendation entity: {}/ {}", body.getProductId(), body.getRecommendationId());
            return mapper.entityToApi(newEntity);
        }catch(DuplicateKeyException dke) {
            throw new InvalidInputException("Duplicate key, Product Id: " + body.getProductId() + ", Recommendation Id: " + body.getRecommendationId());
        }
    }

    @Override
    public void deleteRecommendations(int productId) {
        LOG.info("deleteRecommendations: tries to delete recommendations for the product with productId: {}", productId);
        repository.deleteAll(repository.findByProductId(productId));
    }
}