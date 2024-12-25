//package com.client.service;
//
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @author hqz
// * @create 2022/8/23 10:08
// */
//public class PressureTest {
//
//    public static final ExecutorService executors = Executors.newFixedThreadPool(1000);
//
//    public static AtomicInteger failCount = new AtomicInteger(0);
//
//    public static AtomicInteger allReqCount = new AtomicInteger(0);
//
//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        System.out.println("start time:" + Calendar.getInstance().getTime().toString());
//        int batchNo = 1;
//        try {
//            for (int threadNum = 100; threadNum <= 1000; threadNum += 50) {
//                // 分批请求
//                System.out.println("batchNo:" + batchNo++);
//                ThreadTest(threadNum);
//                ThreadTest(threadNum);
//                Thread.sleep(1 * 1000L);
//            }
//            System.out.println("fail-percent:" + BigDecimal.valueOf(failCount.get()).divide(BigDecimal.valueOf(
//                    allReqCount.get()), RoundingMode.HALF_UP));
//        } catch (Exception e) {
//            System.out.println("batchNo-exc:" + batchNo);
//            System.out.println("fail-percent-exc:" + BigDecimal.valueOf(failCount.get()).divide(BigDecimal.valueOf(
//                    allReqCount.get()), RoundingMode.HALF_UP));
//        }
//    }
//
//    public static long ThreadTest(int threadNum) throws InterruptedException,
//            ExecutionException {
//        try {
//            // HttpClient, Http Request
//            HttpClient httpClient = HttpClient
//                    .newBuilder()
//                    .version(HttpClient.Version.HTTP_2)
//                    .executor(executors)
//                    .build();
//            List<CompletableFuture<HttpResponse<String>>> completableFutureList = new ArrayList<>(threadNum);
//            Long start = System.currentTimeMillis();
//            for (int i = 0; i < threadNum; i++) {
//                allReqCount.getAndIncrement();
//                HttpRequest httpRequest = HttpRequest
//                        .newBuilder()
//                        .GET()
//                        .uri(URI.create("http://localhost:8089/firstServlet.do?a=0"))
//                        .build();
//                // HttpRequestCompletableFuture
//                CompletableFuture<HttpResponse<String>> responseFuture =
//                        httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
//                responseFuture = responseFuture.thenApply(hr -> {
//                    if (hr.statusCode() != 200) {
//                        failCount.getAndIncrement();
////                    throw new RuntimeException("Req Failed");
//                    }
//                    return hr;
//                }).orTimeout(1000, TimeUnit.MILLISECONDS).exceptionally((e) -> {
//                    failCount.getAndIncrement();
//                    return null;
//                });
//                completableFutureList.add(responseFuture);
//            }
//            // long interval = System.currentTimeMillis() - start;
//            return CompletableFuture
//                    .allOf(completableFutureList.toArray(new CompletableFuture[0]))
//                    .thenApply(i -> System.currentTimeMillis() - start).exceptionally((e) -> {
//                        failCount.getAndIncrement();
//                        return null;
//                    })
//                    .get();
//        } catch (Exception e) {
//            failCount.getAndIncrement();
//            return failCount.get();
//        }
//    }
//}
//
