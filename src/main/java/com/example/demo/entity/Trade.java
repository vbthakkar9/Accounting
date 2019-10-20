package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

/**
 * 
 * @author Admin
 *
 */
@Entity
public class Trade implements Serializable {
	private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;

	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer tradeId;

	@Column
	private String symbol;

	@Column
	private Integer price;

	@Column
	private Integer quantity;

	@Column
	private String date;

	@Column
	private String clientCode;

	@Column
	private String buySell;

	@Column
	private String scriptCode;

	@Column
	private String type;

	public Trade(Integer tradeId, String symbol, Integer price,
			Integer quantity, String date, String clientCode, String buySell,
			String scriptCode, String type) {
		this.tradeId = tradeId;
		this.symbol = symbol;
		this.price = price;
		this.quantity = quantity;
		this.date = date;
		this.clientCode = clientCode;
		this.buySell = buySell;
		this.scriptCode = scriptCode;
		this.type = type;
	}

	public Trade() {

	}

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getBuySell() {
		return buySell;
	}

	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}

	public String getScriptCode() {
		return scriptCode;
	}

	public void setScriptCode(String scriptCode) {
		this.scriptCode = scriptCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
