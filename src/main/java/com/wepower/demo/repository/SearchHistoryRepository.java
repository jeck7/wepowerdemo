package com.wepower.demo.repository;

import com.wepower.demo.model.domain.SerachHistroy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchHistoryRepository extends JpaRepository<SerachHistroy, Long> {
}
