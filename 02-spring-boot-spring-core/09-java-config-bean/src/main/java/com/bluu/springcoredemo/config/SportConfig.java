package com.bluu.springcoredemo.config;

import com.bluu.springcoredemo.common.Coach;
import com.bluu.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aqua")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
