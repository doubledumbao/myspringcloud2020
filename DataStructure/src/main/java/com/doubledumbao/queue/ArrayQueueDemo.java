package com.doubledumbao.queue;

import java.util.Scanner;


/**
 * 测试队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char key = ' ';//接收用户输入
        ArrayQueue arrayQueue = new ArrayQueue(3);
        boolean loop = true;
        while(loop){
            System.out.println("a(add):添加数据到队列");
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 'a':
                    System.out.println("输入一个数：");
                    int val = scanner.nextInt();
                    try {
                        arrayQueue.addQueue(val);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    } finally {
                    }
                    break;
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'g':
                    try {
                        System.out.println(arrayQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    } finally {
                    }
                    break;
                case 'h':
                    try {
                        System.out.println(arrayQueue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    } finally {
                    }
                    break;
                case 'e':
                    loop = false;
                    scanner.close();
                    break;
                default:
                    break;

            }

        }

    }
}

/**
 * 数组模拟队列
 */
class ArrayQueue{
    //队列容量
    private int maxSize;
    //队列前端的下标
    private int front;
    //队列后端的下标
    private int rear;
    //存储数据
    private int[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        this.front = -1;
        this.rear= -1;
        this.arr = new int[maxSize];
    }

    /**
     * 判断队列是否满了
     * @return
     */
    public boolean ifFull(){
        return rear == maxSize -1;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 向队列中添加数据
     * @param a
     */
    public void addQueue(int a){
        if(ifFull()){
            throw new RuntimeException("队列已满，无法添加数据");
        }
        rear++;
        this.arr[rear] = a;
    }

    /**
     * 从队列中取出一个数据
     */
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法取出数据");
        }
        front ++;
        return this.arr[front];
    }

    /**
     * 展示队列数据
     */
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return ;
        }
        for (int i = 0; i < this.arr.length; i++) {
            System.out.printf("arr[%d] = %d \n",i,arr[i]);
        }
    }

    /**
     * 查看队列头
     * @return
     */
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return this.arr[front+1];
    }


}
