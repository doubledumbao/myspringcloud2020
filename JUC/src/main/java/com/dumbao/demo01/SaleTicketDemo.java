package com.dumbao.demo01;

public class SaleTicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"C").start();
    }

}

class Ticket{
    private int count = 50;

    public synchronized void sale(){
        if(count > 0){
            System.out.println(Thread.currentThread().getName()+"售出了编号为"+ count-- + "张票，还剩"+count+"张票！");
        }
    }
}
