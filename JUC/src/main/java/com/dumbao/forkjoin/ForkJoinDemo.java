package com.dumbao.forkjoin;


import java.util.concurrent.RecursiveTask;

/**
 * 求和计算的任务！
 */
public class ForkJoinDemo extends RecursiveTask<Long> {


    private Long start;
    private Long end;

    //临界值
    private Long temp = 100000L;

    public ForkJoinDemo(Long start,Long end){
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        if((end - start) < temp){
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else{
            //ForkJoin
            long middle = (start+end)/2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();//拆分任务，把任务压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1, end);
            task2.fork();//拆分任务，把任务压入线程队列
            return task1.join() + task2.join();
        }
    }
}
