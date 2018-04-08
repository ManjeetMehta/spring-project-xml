package com.mehta.service.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.mehta.model.Stock;
import com.mehta.service.PortfolioService;
import com.mehta.service.StockService;

public class PortfolioServiceImplTest {
	PortfolioService portfolio;
	StockService stockService;

	public static void main(String[] args) {
		PortfolioServiceImplTest tester = new PortfolioServiceImplTest();
		tester.setUp();
		System.out.println(tester.testMarketValue() ? "pass" : "fail");
	}

	public void setUp() {
		// Create a PortfolioService object which is to be tested
		portfolio = new PortfolioServiceImpl();

		// Create the mock object of stockService
		stockService = mock(StockService.class);

		// set the stockService to the PortfolioService
		portfolio.setStockService(stockService);
	}

	public boolean testMarketValue() {

		// Creates a list of stocks to be added to the PortfolioService
		List<Stock> stocks = new ArrayList<Stock>();
		Stock googleStock = new Stock("1", "Google", 10);
		Stock microsoftStock = new Stock("2", "Microsoft", 100);

		stocks.add(googleStock);
		stocks.add(microsoftStock);

		// add stocks to the PortfolioService
		portfolio.setStocks(stocks);

		// mock the behavior of stock service to return the value of various
		// stocks
		when(stockService.getPrice(googleStock)).thenReturn(1.00);
		when(stockService.getPrice(microsoftStock)).thenReturn(10.00);

		double marketValue = portfolio.getMarketValue();
		return marketValue == 1010.0;
	}
}
