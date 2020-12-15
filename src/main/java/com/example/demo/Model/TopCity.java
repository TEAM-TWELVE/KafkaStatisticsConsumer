package com.example.demo.Model;

public class TopCity implements Comparable<TopCity>{
    private String name;
    private int noOfSearches;

    public TopCity(String name, int noOfSearches) {
        this.name = name;
        this.noOfSearches = noOfSearches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfSearches() {
        return noOfSearches;
    }

    public void setNoOfSearches(int noOfSearches) {
        this.noOfSearches = noOfSearches;
    }

    @Override
    public int compareTo(TopCity o) {
        return this.noOfSearches - o.getNoOfSearches();
    }
}
