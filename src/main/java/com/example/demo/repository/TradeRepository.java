package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Trade;
/**
 * 
 * @author Admin
 *
 */
@Repository
public interface TradeRepository  extends JpaRepository<Trade, Integer>{

}
