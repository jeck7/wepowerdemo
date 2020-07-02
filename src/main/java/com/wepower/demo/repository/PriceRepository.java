package com.wepower.demo.repository;

import com.wepower.demo.model.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
