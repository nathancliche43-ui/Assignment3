package com.example.zoomanagementapplication;

import com.example.zoomanagementapplication.Model.ZooComponent;
import com.example.zoomanagementapplication.Model.ZooSection;

public class ZooService {

    private ZooSection rootSection;
    public ZooService() {
    }
    public void setRootSection(ZooSection rootSection) {
        this.rootSection = rootSection;
    }

    public ZooSection getRootSection() { return rootSection; }
}
