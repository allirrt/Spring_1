package com.irrt.spring.springduble.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class HorseSound implements SoundAnimals{
    @Override
    public String sound() {
        return "neigh";
    }
}
