package com.playground.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Java 8 Multithreading Playground
 */
public class ThreadsPlayground {

    //Threadpools
    private static ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
    private static ExecutorService fixedThreadPool;
    private static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);

    //Tasks
    private static Runnable runnable = () -> System.out.println("Hello runner");
    private static Callable<String> callable = () -> "hello";
    private static List<Callable<String>> callables = Arrays.asList(() -> "task1", () -> "task2");

    public static void main(String[] args) throws Exception {

        /************** Single thread pool running one task *************/
        System.out.println("Single threadpool running a task 100 times");
        Future<?> future = singleThreadPool.submit(runnable);
        future.get();
        singleThreadPool.shutdown();

        /************** Fixed thread pool of 5 running a task 100 times *************/
        System.out.println("Fixed threadpool of size 5");
        fixedThreadPool = Executors.newFixedThreadPool(5);
        List<Future<?>> futures = new ArrayList<>();
        //Trigger 100 tasks
        for(int i = 0; i < 100; i++) {
            futures.add(fixedThreadPool.submit(callable));
        }
        //Wait for 100 tasks
        for(Future fixedFuture: futures) {
            fixedFuture.get();
        }
        fixedThreadPool.shutdown();

        /************** Fixed thread pool running invoking any of the two tasks and waiting for one to complete *************/
        System.out.println("Fixed threadpool of size 2 running any task");
        fixedThreadPool = Executors.newFixedThreadPool(2);
        String result = fixedThreadPool.invokeAny(callables);
        System.out.println(result);
        fixedThreadPool.shutdown();

        /************** Scheduled thread pool running with a delay 1 second *************/
        System.out.println("Scheduled threadpool running a task with 1 second delay");
        scheduledThreadPool.schedule(runnable, 1, TimeUnit.SECONDS);
        scheduledThreadPool.shutdown();
    }
}
