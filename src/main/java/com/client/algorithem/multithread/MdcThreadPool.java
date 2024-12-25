package com.client.algorithem.multithread;

import org.slf4j.MDC;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author hqz
 * @create 2024/12/1 15:32
 */
public class MdcThreadPool {

    private final ExecutorService executorService;

    public MdcThreadPool(ExecutorService executorService) {
        this.executorService = executorService;
    }

    /**
     * 在提交任务之前保留线程池之前MDC，执行任务中获取之前的MDC的context，最后再恢复到任务之前的oldContext，
     * @param task
     * @param <T>
     * @return
     */
    public <T> Future<T> execute(final Callable<T> task) {
        Map<String, String> context = MDC.getCopyOfContextMap();
        return executorService.submit(() -> {
            Map<String, String> oldContext = MDC.getCopyOfContextMap();
            try {
                if (context != null) {
                    MDC.setContextMap(context);
                }
                return task.call();
            } finally {
                if (oldContext != null) {
                    MDC.setContextMap(oldContext);
                }
            }
        });
    }

    /**
     * 设置transmittableThreadLocal
     */
}
