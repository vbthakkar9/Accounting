package com.vir.accounting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vir.accounting.entity.Trade;
/**
 * 
 * @author Admin
 *
 */
@Repository
public interface TradeRepository  extends JpaRepository<Trade, Integer>{

	List<Trade> findBySymbolContains(String name);
}
