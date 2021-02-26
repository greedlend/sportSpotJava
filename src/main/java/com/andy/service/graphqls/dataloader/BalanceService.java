package com.andy.service.graphqls.dataloader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/23
 * @Proposal:
 */
@Slf4j
@Service
public class BalanceService {

    public Map<String, BigDecimal> getBalanceFor(Set<String> userBaseIds, String uuid) {
        log.info("Executor for List:{}, userBase:{}", userBaseIds, uuid);
        Map<String, BigDecimal> result = new HashMap<>();
        result.put("05681e52-1e54-4c47-8aba-918ecdc9220f", BigDecimal.ONE);
        result.put("8a495055-01f3-4d11-adb6-9978e571becf", new BigDecimal(200.52));
        return result;
    }
}
