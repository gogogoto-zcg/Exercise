package com.exercise.baseskill.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author : cg.zhou
 * @date : 2020/4/9 0009-12:08
 * @Description : JAVA 自带定时任务类
 */
public class TestTimer {

    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("timerTask execute.");
        }
    }

    public static void main(String[] args) {

        MyTimerTask  timerTask= new TestTimer().new MyTimerTask();

        Timer timer =  new Timer();

        timer.schedule(timerTask,1000,500);

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timer.cancel();

    }
}
