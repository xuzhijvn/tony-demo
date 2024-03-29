package com.tony.other.demo2;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tony老师
 * @create 2021-05-07
 * Description:
 */
@Service
public class SensitiveStrategyService {
    Map<SensitiveType, SensitiveStrategy> map = new HashMap<>();

    public SensitiveStrategyService(List<SensitiveStrategy> sensitiveStrategyList) {
        sensitiveStrategyList.forEach(sensitiveStrategy -> map.put(sensitiveStrategy.getSensitiveType(), sensitiveStrategy));
    }

    public String generatorSensitive(SensitiveType typeEnum, String str) {
        SensitiveStrategy sensitiveStrategy = map.get(typeEnum);
        if (sensitiveStrategy != null) {
            return sensitiveStrategy.maskingData(str);
        }
        return "";
    }

}