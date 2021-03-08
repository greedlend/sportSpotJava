package com.andy.service.graphqls.dataloader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/23
 * @Proposal:
 */
@Slf4j
@Service
public class BalanceService {

    public Map<UUID, BigDecimal> getBalanceFor(Set<UUID> userBaseIds, UUID uuid) {
        log.info("Executor for List:{}, userBase:{}", userBaseIds, uuid);
        Map<UUID, BigDecimal> result = new HashMap<>();
        result.put(UUID.fromString("05681e52-1e54-4c47-8aba-918ecdc9220f"), BigDecimal.ONE);
        result.put(UUID.fromString("8a495055-01f3-4d11-adb6-9978e571becf"), new BigDecimal(200.52));
        return result;
    }
}
