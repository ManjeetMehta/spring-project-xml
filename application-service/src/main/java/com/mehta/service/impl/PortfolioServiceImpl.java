package com.mehta.service.impl;

import java.util.List;

import com.mehta.model.Stock;
import com.mehta.service.PortfolioService;
import com.mehta.service.StockService;

public class PortfolioServiceImpl implements PortfolioService {
	private StockService stockService;
	private List<Stock> stocks;

	public StockService getStockService() {
		return stockService;
	}

	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public double getMarketValue() {
		double marketValue = 0.0;

		for (Stock stock : stocks) {
			marketValue += stockService.getPrice(stock) * stock.getQuantity();
		}

		System.out.println("\n\n" + marketValue + "\n\n");

		return marketValue;
	}
}