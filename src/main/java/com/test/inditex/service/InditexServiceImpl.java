package com.test.inditex.service;

import com.test.inditex.domain.PricesResponse;
import com.test.inditex.entity.PricesEntity;
import com.test.inditex.repository.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InditexServiceImpl implements InditexService {

    private final PricesRepository pricesRepository;

    @Override
    public List<PricesResponse> getData(LocalDateTime tranformedDate, Integer productId, Integer brandId) {
        List<PricesEntity> priceList = pricesRepository.getPrice(tranformedDate,productId,brandId);
        List<PricesResponse> responseList = new ArrayList<>();
        priceList.forEach(f-> responseList.add(PricesResponse.builder()
                .priceList(f.getPriceList())
                .brandId(f.getBrandId())
                .endDate(f.getEndDate())
                .price(f.getPrice())
                .productId(f.getProductId())
                .startDate(f.getStartDate()).build()));
        return responseList;
    }
}
