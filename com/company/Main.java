package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static int count = 3000;
    static int time1, time2, time3, time4 = 0;
    static int circ1, circ2, circ3, circ4 = 0;
    static int limitGoods1, limitGoods2, limitGoods3, limitGoods4 = 0;

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<Thread>();

        threads.add(new Thread(new Runnable() {
            @Override
            public void run() {
                while (count > 0) {
                    if (limitGoods1 < 15) {
                        time1 += 2;
                        limitGoods1++;
                        count--;
                    }
                    if (limitGoods1 == 15) {
                        circ1++;
                        limitGoods1 = 0;
                    }
                }
            }
        }));

        threads.add(new Thread(new Runnable() {
            @Override
            public void run() {
                while (count > 0) {
                    if (limitGoods2 < 14) {
                        time2 += 2;
                        limitGoods2++;
                        count--;
                    }
                    if (limitGoods2 == 14) {
                        circ2++;
                        limitGoods2 = 0;
                    }
                }
            }
        }));

        threads.add(new Thread(new Runnable() {
            @Override
            public void run() {
                while (count > 0) {
                    if (limitGoods3 < 13) {
                        time3 += 2;
                        limitGoods3++;
                        count--;
                    }
                    if (limitGoods2 == 13) {
                        circ3++;
                        limitGoods3 = 0;
                    }
                }
            }
        }));

        threads.add(new Thread(new Runnable() {
            @Override
            public void run() {
                while (count > 0) {
                    if (limitGoods2 < 10) {
                        time4 += 2;
                        limitGoods4++;
                        count--;
                    }
                    if (limitGoods4 == 10) {
                        circ4++;
                        limitGoods4 = 0;
                    }
                }
            }
        }));

        for (Thread thread: threads) {
            thread.start();
        }
        for (Thread thread: threads) {
            thread.join();
        }

        System.out.println("Корабль #1: Времени затрачено: " + time1 + " Количество кругов: " +circ1);
        System.out.println("Корабль #2: Времени затрачено: " + time2 + " Количество кругов: " +circ2);
        System.out.println("Корабль #3: Времени затрачено: " + time3 + " Количество кругов: " +circ3);
        System.out.println("Корабль #4: Времени затрачено: " + time4 + " Количество кругов: " +circ4);

        System.out.println("Общее затраченное время: " + (time1 + time2 + time3 + time4));
    }
}