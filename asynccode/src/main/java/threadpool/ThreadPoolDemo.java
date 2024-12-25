package threadpool;

import java.util.concurrent.*;

/**
 * @author hqz
 * @create 2023/8/26 18:38
 */
public class ThreadPoolDemo {

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    ExecutorService executorService = new ThreadPoolExecutor(
          5, 10, 10, TimeUnit.MILLISECONDS,
          new LinkedBlockingDeque<>());


    public void execute(Runnable runnable){
        executorService.execute(runnable);
//        executorService.execute(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return null;
//            }
//        });
    }


    public void submit(Runnable runnable){
        executorService.submit(runnable);
    }

//    public static void main(String[] args) {
//        Runnable a = () -> {
//
//            int n = 10/0;
//        };
//        new ThreadPoolDemo().execute(a);
//        new ThreadPoolDemo().getExecutorService().shutdown();
//        System.out.println("status:" + new ThreadPoolDemo().getExecutorService().isTerminated());
//        System.out.println("isShutDown:" + new ThreadPoolDemo().getExecutorService().isShutdown());
//        throw new RuntimeException();
////        new ThreadPoolDemo().submit(a);
//    }
}
