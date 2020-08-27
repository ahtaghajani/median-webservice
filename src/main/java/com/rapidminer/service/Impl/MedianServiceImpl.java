package com.rapidminer.service.Impl;

import com.rapidminer.service.MedianService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MedianServiceImpl implements MedianService {
    @Override
    public List<Map<String, Object>> calculateMedian(List<Map<String, Object>> content) {
        final List<Map<String, Object>> medianList = new ArrayList<>();

        final Set<String> columnNames = content.get(0).keySet();

        final String labelColumnName = "label";
        final Map<String, List<Map<String, Object>>> labelToRecords = content.stream()
                .collect(Collectors.groupingBy(row -> row.get(labelColumnName).toString()));

        labelToRecords.forEach((label, recordsOfLabel) -> {
            Map<String, Object> medianMap = new LinkedHashMap<>();
            for (String columnName : columnNames) {
                if (columnName.equals(labelColumnName)) {
                    medianMap.put(columnName, label);
                } else {
                    Object[] sortedValuesOfKey = recordsOfLabel.stream().map(record -> record.get(columnName)).sorted().toArray();
                    Object median = getMedian(sortedValuesOfKey);
                    medianMap.put(columnName, median);
                }
            }
            medianList.add(medianMap);
        });

        return medianList;
    }

    private Object getMedian(Object[] sortedValuesOfKey) {
        if (sortedValuesOfKey[0] instanceof Number) {
            if (sortedValuesOfKey.length % 2 == 0) {
                return ((double) sortedValuesOfKey[sortedValuesOfKey.length / 2] + (double) sortedValuesOfKey[sortedValuesOfKey.length / 2 - 1]) / 2;
            } else {
                return sortedValuesOfKey[sortedValuesOfKey.length / 2];
            }
        }else {
            return sortedValuesOfKey[sortedValuesOfKey.length / 2];
        }
    }
}
