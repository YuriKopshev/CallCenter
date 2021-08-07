package ru.netology;

import java.util.Random;
import java.util.concurrent.*;

public class Main {
    private static final LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
    private static final int ATSTIME = 5;
    private static final int ATSPAUSE = 1000;
    private static final int OPERATORPAUSE = 4000;

    public void call() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < ATSTIME; i++) {
                    try {
                        Random random = new Random(200000);
                        Thread.sleep(ATSPAUSE);
                        queue.add(random.nextInt(300000));
                        queue.add(random.nextInt(300000));
                        queue.add(random.nextInt(300000));
                        queue.add(random.nextInt(300000));
                        queue.add(random.nextInt(300000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(OPERATORPAUSE);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (queue.peek() != null) {
                        int call = queue.poll();
                        System.out.println("ОПЕРАТОР 1: Звонок от абонента № " + call + " отработан!");
                    } else {
                        break;
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(OPERATORPAUSE);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (queue.peek() != null) {
                        int call = queue.poll();
                        System.out.println("ОПЕРАТОР 2: Звонок от абонента № " + call + " отработан!");
                    } else {
                        break;
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(OPERATORPAUSE);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (queue.peek() != null) {
                        int call = queue.poll();
                        System.out.println("ОПЕРАТОР 3: Звонок от абонента № " + call + " отработан!");
                    } else {
                        break;
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new Main().call();
    }
}
