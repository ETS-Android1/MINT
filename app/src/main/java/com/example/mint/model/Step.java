package com.example.mint.model;

import java.io.Serializable;

public class Step implements Serializable {
    private String address;
    private int distance;
    private int nbEdges;

    public Step() {
    }

    public Step(String address, int distance) {
        this.address = address;
        this.distance = distance;
        this.nbEdges = 1;
    }

    public Step(String address, int distance, int nbEdges){
        this.address = address;
        this.distance = distance;
        this.nbEdges = nbEdges;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void increaseDistance(int length) {
        this.distance += length;
    }

    public int getNbEdges() {
        return this.nbEdges;
    }
}
