package edu.hw3;

import org.jetbrains.annotations.NotNull;

public class Stock implements Comparable<Stock> {
	public Stock(String name, double price) {
		this.nameOnTheExchange = name;
		this.stockPrice = price;
	}

	public Stock(String name) {
		this.nameOnTheExchange = name;
	}
	private final String nameOnTheExchange;
	private double stockPrice;

	public String tradedAs() {
		return this.nameOnTheExchange;
	}

	public double getStockPrice() {
		return this.stockPrice;
	}

	public void setStockPrice(int newPrice) {
		this.stockPrice = newPrice;
	}

	@Override
	public int compareTo(@NotNull Stock o) {
		if (stockPrice > o.stockPrice) {
			return -1;
		} else if (stockPrice < o.stockPrice) {
			return 1;
		}
		return 0;
	}
}
