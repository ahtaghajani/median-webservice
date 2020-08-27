package com.rapidminer.service;

import java.util.List;
import java.util.Map;

public interface MedianService {
    List<Map<String, Object>> calculateMedian(List<Map<String, Object>> content);
}
