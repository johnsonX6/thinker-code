package com.client.algorithem.multithread;


import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author hqz
 * @create 2024/11/2 15:57
 */
public class Test9 {
    Logger logger = Logger.getLogger("Test9");
    static int RES = 0;
    /**
     * CompletableFuture默认使用的线程池是 ForkJoinPool.commonPool()，
     * commonPool是当前 JVM（进程） 上的所有 CompletableFuture、
     * 并行 Stream 共享的，commonPool 的目标场景是非阻塞的 CPU 密集型任务
     * @param args
     */
    public static void main(String[] args) {
        int a = 124;
        String b = "124";
        String s = "124";
        // 错误的
        System.out.println(b.equals(s));

        System.out.println(Integer.parseInt(b) == a);
        System.out.println(new Test9().orderTask());
            int x = 5;
            // supplyAsync 接受supplier 需要返回值 不需要入参
        CompletableFuture<Integer> c = CompletableFuture.supplyAsync(()-> calc(x));
//        System.out.println(c.join());
        System.out.println(RES);
        // runAysnc  接受runnable 不需要返回值 不需要入参
        CompletableFuture<Void> d = CompletableFuture.runAsync(
                () -> calc(x));

        // 接受function 需要有返回值，入参
        Context context = new Context();
        CompletableFuture<Context> d1 = CompletableFuture.completedFuture(context);

        d1.thenApply((dd ) -> context)
                .thenApply((d2) -> context);
        d1.thenAccept((dd) -> calc(a));
        /**
         * thenCompose：适用于复杂的计算过程，需要依赖于前一个操作的结果，
         * 并且这个计算过程本身也是一个异步操作的场景。例如，可以使用 thenCompose 来连接多个网络请求操作，
         * 每个请求都依赖于前一个请求的结果，并且每个请求都是一个异步操作
         */
        // handler可以返回新的结果 whenComplete也是等异步任务完成时被调用，第一个参数返回值，第二个参数异常
        // handler能返回新的结果
    }

    /**
     * get join都是获取异步守护线程执行之后的返回结果
     *
     * get需要捕获异常 抛出受检异常
     * join抛出运行时异常 可捕获或者抛出
     * @param a
     * @return
     */
    private static int calc(Integer a){
        RES = 30;
        return a*a;
    }

    private static void calc1(Integer a){
        RES = 30;
        System.out.println("calc1");
    }

    /**
     * ，CompletableFuture的默认线程池，只有在双核以上的机器内才会使用。在双核及以下的机器中，会为每个任务创建一个新线程，等于没有使用线程池，且有资源耗尽的风险。
     *
     * 因此建议，在使用CompletableFuture时，务必要自定义线程池。
     */
    private  List<Integer> orderTask(){
        Context context = new Context();
        List<Integer> res1 = new ArrayList<>();
        CompletableFuture<List<Integer>> task1 = CompletableFuture.supplyAsync(()->{
            List<Integer> res = new ArrayList<>();
            res.add(1);
            res.add(2);
            return res;
        });
        CompletableFuture<List<Integer>> task2 = CompletableFuture.supplyAsync(()->{
            List<Integer> res = new ArrayList<>();
            res.add(3);
            res.add(4);
            return res;
        }).handle((result ,exc) ->{
            if(exc != null) {
                logger.info("tastk2 exception");
            }
            return result;
        });
        CompletableFuture<List<Integer>> task3 = CompletableFuture.supplyAsync(()->{
            List<Integer> res = new ArrayList<>();
            res.add(5);
            res.add(6);
            return res;
        });
        // 必须限定异步返回类型
        List<CompletableFuture<List<Integer>>> cfs = new ArrayList<>();
        cfs.add(task1);
        cfs.add(task2);
        cfs.add(task3);
         res1 = cfs.stream().map(CompletableFuture::join).flatMap(List::stream)
                .collect(Collectors.toList());

        return res1;
    }

    static class Context{

    }
}
