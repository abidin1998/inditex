package com.test.inditex.service;

import com.test.inditex.domain.PricesResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface InditexService {

    List<PricesResponse> getData(LocalDateTime tranformedDate, Integer productId, Integer brandId);
}
