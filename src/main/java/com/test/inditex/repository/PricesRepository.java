package com.test.inditex.repository;

import com.test.inditex.entity.PricesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricesRepository extends CrudRepository<PricesEntity, Integer> {

    @Query("SELECT o FROM PricesEntity o WHERE startDate<=:date AND endDate>=:date " +
            "AND productId=:productId AND brandId=:brandId ")
    List<PricesEntity> getPrice(@Param("date")LocalDateTime date,
                                @Param("productId") Integer productId,
                                @Param("brandId") Integer brandId);
}
