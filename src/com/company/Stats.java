package com.company;

/**
 * Created by pratap on 5/3/17.
 */

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Stats {
    public static class StatisticsAggregatorImpl implements StatisticsAggregator {

        Map<String, List<Double>> symbolPriceMap = new ConcurrentHashMap<>();

        @Override
        public void putNewPrice(String symbol, double price) {
            // YOUR CODE HERE
            if (symbolPriceMap.containsKey(symbol)) {
                symbolPriceMap.get(symbol).add(price);
            } else {
                List<Double> priceList = new ArrayList<>();
                priceList.add(price);
                symbolPriceMap.put(symbol, priceList);
            }
        }

        @Override
        public double getAveragePrice(String symbol) {
            // YOUR CODE HERE
            double averagePrice = 0.0;
            if (symbolPriceMap.containsKey(symbol)) {
                List<Double> priceList = symbolPriceMap.get(symbol);
                double total = 0.0;
                for (double price : priceList) {
                    total += price;
                }
                if (total != 0.0) {
                    averagePrice = total / priceList.size();
                }
            }
            return averagePrice;
        }

        @Override
        public int getTickCount(String symbol) {
            // YOUR CODE HERE
            int count = 0;
            if(symbolPriceMap.containsKey(symbol)){
                count = symbolPriceMap.get(symbol).size();
            }
            return count;
        }
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface StatisticsAggregator {
        // This is an input. Make note of this price.
        public void putNewPrice(String symbol, double price);

        // Get the average price
        public double getAveragePrice(String symbol);

        // Get the total number of prices recorded
        public int getTickCount(String symbol);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final StatisticsAggregator stats = new StatisticsAggregatorImpl();
            final Set<String> symbols = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            int threads = Integer.parseInt(inputs[0]);
            ExecutorService pool = Executors.newFixedThreadPool(threads);
            for (int i = 1; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String symbol = tokens[0];
                symbols.add(symbol);
                final double price = Double.parseDouble(tokens[1]);
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        stats.putNewPrice(symbol, price);
                    }
                });

            }
            pool.shutdown();
            try {
                pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (String symbol : symbols) {
                System.out.println(String.format("%s %.4f %d", symbol,
                        stats.getAveragePrice(symbol),
                        stats.getTickCount(symbol)));
            }
        }
        scanner.close();

    }
}
