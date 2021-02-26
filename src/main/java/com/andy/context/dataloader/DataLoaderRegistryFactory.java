package com.andy.context.dataloader;

import com.andy.service.graphqls.dataloader.BalanceService;
import lombok.RequiredArgsConstructor;
import org.dataloader.BatchLoaderEnvironment;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/23
 * @Proposal:
 */
@Component
@RequiredArgsConstructor
public class DataLoaderRegistryFactory {

    public static final String BALANCE_DATA_LOADER = "BALANCE_DATA_LOADER";
    private static final Executor threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private final BalanceService balanceService;

    public DataLoaderRegistry create(String uuid) {

        DataLoaderRegistry registry = new DataLoaderRegistry();

        registry.register(BALANCE_DATA_LOADER, createBalanceDataLoarder(uuid));

        return registry;
    }

    private DataLoader<String, BigDecimal> createBalanceDataLoarder(String uuid) {
        return DataLoader.newMappedDataLoader((Set<String> userBaseIds) ->
            CompletableFuture.supplyAsync(() -> balanceService.getBalanceFor(userBaseIds, uuid), threadPool));
    }
}
