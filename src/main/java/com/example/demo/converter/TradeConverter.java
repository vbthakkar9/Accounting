package com.example.demo.converter;

import com.example.demo.dto.TradeDto;
import com.example.demo.entity.Trade;

public class TradeConverter {

	public static Trade dtoToEntity(TradeDto tradeDto) {
		Trade trade= new Trade(tradeDto.getTradeId(), tradeDto.getSymbol(), tradeDto.getPrice(), tradeDto.getQuantity(), tradeDto.getDate(), tradeDto.getClientCode(), tradeDto.getBuySell(), tradeDto.getScriptCode(), tradeDto.getType());
		trade.setTradeId(tradeDto.getTradeId());
		return trade;
	}

	public static TradeDto entityToDto(Trade trade) {
		TradeDto tradeDto = new TradeDto(trade.getTradeId(), trade.getSymbol(), trade.getPrice(), trade.getQuantity(), trade.getDate(), trade.getClientCode(), trade.getBuySell(), trade.getScriptCode(), trade.getType());
		return tradeDto;
	}
}
