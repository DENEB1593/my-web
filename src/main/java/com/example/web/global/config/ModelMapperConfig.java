package com.example.web.global.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        org.modelmapper.config.Configuration config = modelMapper.getConfiguration();
        config.setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
