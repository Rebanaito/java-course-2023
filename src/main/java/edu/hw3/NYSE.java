package edu.hw3;

import java.util.PriorityQueue;

public class NYSE implements StockMarket {
	public NYSE() {
	}
	private final static PriorityQueue<Stock> queue = new PriorityQueue<>();
	public void add(Stock stock) {
		queue.add(stock);
	}

	public void remove(Stock stock) {
		queue.remove(stock);
	}

	public Stock mostValuableStock() {
		return queue.poll();
	}
}