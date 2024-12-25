//package com.client.util;
//
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * @author hqz
// * @create 2023/8/14 14:45
// */
//public class AsyncUtil {
//    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);
//
//    public static void main(String[] args) {
//        List<CompletableFuture<Void>> taskList = List.of(
//                CompletableFuture.runAsync(() ->{
//                    System.out.println("this is task one");
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("task one end");
//                },threadPool),
//                CompletableFuture.runAsync(() -> {
//                    System.out.println("this is task two");
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("task two end");
//                }, threadPool));
//        CompletableFuture.allOf(taskList.toArray(new CompletableFuture[0])).join();
//    }
//}
