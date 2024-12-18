package com.bluu.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {
    @Override
    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
        return "Expect heavy traffic this morning.";
    }

    @Override
    public String getFortune(boolean tripWire) {
        if(tripWire){
            throw new RuntimeException("Accident, Highway is closed!");
        }
        return getFortune();
    }
}
