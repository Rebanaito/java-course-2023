package edu.hw3;

import java.util.PriorityQueue;

public class NYSE implements StockMarket {
    public NYSE() {
    }

    private final static PriorityQueue<Stock> QUEUE = new PriorityQueue<>();

    public void add(Stock stock) {
        QUEUE.add(stock);
    }

    public void remove(Stock stock) {
        QUEUE.remove(stock);
    }

    public Stock mostValuableStock() {
        return QUEUE.poll();
    }
}
