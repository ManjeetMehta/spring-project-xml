package com.mehta.service;

import java.util.List;

import com.mehta.model.Stock;

public interface PortfolioService {

	public StockService getStockService();

	public void setStockService(StockService stockService);

	public List<Stock> getStocks();

	public void setStocks(List<Stock> stocks);

	public double getMarketValue();
}
