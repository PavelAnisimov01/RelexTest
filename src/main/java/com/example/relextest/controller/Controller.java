package com.example.relextest.controller;

import com.example.relextest.service.RelexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class Controller {

    @Autowired
    private final RelexService relexService;

    public Controller(RelexService relexService) {
        this.relexService = relexService;
    }

    @GetMapping("/get_max_value")
    public Map<String, Integer> getMax() {
        Map<String, Integer> map = new HashMap<>();
        map.put("max_value", relexService.getMax());
        return map;
    }

    @GetMapping("/get_min_value")
    public Map<String, Integer> getMin() {
        Map<String, Integer> map = new HashMap<>();
        map.put("min_value", relexService.getMin());
        return map;
    }

    @GetMapping("/get_mediane")
    public Map<String, Integer> getMediane() {
        Map<String, Integer> map = new HashMap<>();
        map.put("mediane", relexService.getMediane());
        return map;
    }

    @GetMapping("/get_arithmetic_mean_value")
    public Map<String, Integer> getArithmeticMeanValue() {
        Map<String, Integer> map = new HashMap<>();
        map.put("arithmetic_mean_value", relexService.getArithmeticMeanValue());
        return map;
    }

    @GetMapping("/get_longest_sequence_increasing_numbers")
    public Map<String, String> getLongestSequenceIncreasingNumbers() {
        Map<String, String> map = new HashMap<>();
        map.put("longest_sequence_increasing_numbers", relexService.getLongestSequenceIncreasingNumbers());
        return map;
    }

    @GetMapping("/get_longest_sequence_decreasing_numbers")
    public Map<String, String> getLongestSequenceDecreasingNumbers() {
        Map<String, String> map = new HashMap<>();
        map.put("longest_sequence_decreasing_numbers", relexService.getLongestSequenceDecreasingNumbers());
        return map;
    }
}