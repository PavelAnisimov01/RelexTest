package com.example.relextest.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Service
public class RelexService {
    public List<Integer> getList() {
        File text = new File("F:\\company\\internship_relex\\10m.txt");
        Scanner sc;

        {
            try {
                sc = new Scanner(text);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            list.add(Integer.parseInt(input));
        }
        return list;
    }

    public Integer getMax() {
        List<Integer> arr = getList();
        int max = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > max) max = arr.get(i);

        }
        return max;
    }

    public Integer getMin() {
        List<Integer> arr = getList();

        int min = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < min) min = arr.get(i);

        }
        return min;
    }

    public Integer getMediane() {
        List<Integer> arr = getList();
        Collections.sort(arr);

        int median;
        if (arr.size() % 2 == 0) median = (arr.get(arr.size() / 2 - 1) + arr.get(arr.size() / 2)) / 2;
        else median = arr.get(arr.size() / 2);
        return median;
    }

    public Integer getArithmeticMeanValue() {
        List<Integer> arr = getList();

        int arithmeticMeanValue = 0;
        for (Integer integer : arr) {
            arithmeticMeanValue += integer;
        }
        arithmeticMeanValue = arithmeticMeanValue / arr.size();
        return arithmeticMeanValue;
    }

    public String getLongestSequenceIncreasingNumbers() {
        List<Integer> arr = getList();
        int count = 0;
        int max = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) > arr.get(i)) {
                count++;
                if (count > max) max = count;
            } else count = 0;
        }
        count = 0;
        StringBuilder arr_part = new StringBuilder();
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) > arr.get(i)) {
                count++;
                if (count == max) {

                    for (int j = i - max + 1; j <= i + 1; j++) {
                        if (j != i + 1)
                            arr_part.append(arr.get(j).toString()).append(",").append(" ");
                        else arr_part.append(arr.get(j).toString()).append(";").append(" ");
                    }

                }
            } else count = 0;

        }

        return arr_part.toString();
    }

    public String getLongestSequenceDecreasingNumbers() {
        List<Integer> arr = getList();
        int count = 0;
        int max = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) < arr.get(i)) {
                count++;
                if (count > max) max = count;
            } else count = 0;
        }
        count = 0;
        StringBuilder arr_part = new StringBuilder();
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) < arr.get(i)) {
                count++;
                if (count == max) {

                    for (int j = i - max + 1; j <= i + 1; j++) {
                        if (j != i + 1)
                            arr_part.append(arr.get(j).toString()).append(",").append(" ");
                        else arr_part.append(arr.get(j).toString()).append(";").append(" ");
                    }

                }
            } else count = 0;

        }

        return arr_part.toString();
    }
}