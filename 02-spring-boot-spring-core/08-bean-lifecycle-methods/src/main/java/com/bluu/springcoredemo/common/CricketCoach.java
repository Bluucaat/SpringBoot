package com.bluu.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @PostConstruct
    public void doStartupTasks(){
        System.out.println("In doStartupTasks(): " + getClass().getSimpleName());
    }
    @PreDestroy
    public void doDestroyTasks(){
        System.out.println("In doDestroyTasks(): " + getClass().getSimpleName());
    }
    
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!";
    }
}
