package com.example.zoomanagementapplication.Model;

public class ZooService {

    private ZooSection rootSection;
    public ZooService() {
    }
    public void setRootSection(ZooSection rootSection) {
        this.rootSection = rootSection;
    }

    public ZooSection getRootSection() { return rootSection; }
}
