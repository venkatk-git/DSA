package Graphs.ShortestPath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class Edge {
    public int dest;
    public int price;

    public Edge(int dest, int price) {
        this.dest = dest;
        this.price = price;
    }
}

class City {
    public int city;
    public int stops;
    public int price;

    public City(int city, int stops, int price) {
        this.city = city;
        this.stops = stops;
        this.price = price;
    }
}

public class CheapestFlights {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Edge>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int numberOfEdges = flights.length;
        for(int i = 0; i < numberOfEdges; i++) {
            graph.get(flights[i][0]).add(new Edge(flights[i][1], flights[i][2]));
        }

        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);

        Deque<City> q = new ArrayDeque<>();
        q.offer(new City(src, 0,  0));
    
        while(!q.isEmpty()) {
            City currCity = q.poll();
            int srcCity = currCity.city;
            int srcPrice = currCity.price;
            int stops = currCity.stops;

            if(stops > k) continue;
            for(Edge city: graph.get(srcCity)) {
                int destCity = city.dest;
                int price = city.price;

                int calculatedPrice = price + srcPrice;
                if(calculatedPrice < prices[destCity] && stops <= k) {
                    prices[destCity] = calculatedPrice;
                    q.offer(new City(destCity, stops + 1, calculatedPrice));
                }
            }
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }    
}