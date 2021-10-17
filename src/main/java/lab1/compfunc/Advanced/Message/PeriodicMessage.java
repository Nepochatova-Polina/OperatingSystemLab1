package lab1.compfunc.Advanced.Message;

import lab1.compfunc.Advanced.DoubleOps.DoubleOps;
import lab1.compfunc.Advanced.IntOps.IntOps;
import lab1.compfunc.Advanced.Main;

import java.util.Random;
import java.util.Scanner;

public class PeriodicMessage extends Thread {

    @Override
    public void run() {
        while (!DoubleOps.isStop() || !IntOps.isStop()) {
            try {
                Thread.sleep(5000);
                System.out.println("""
                        Do you want to:
                        (a)continue
                        (b)continue with promt
                        (c)stop
                        """);
                MessagesClass.setMessageFlag(true);
                Scanner string = new Scanner(System.in);
                String confirmString = string.nextLine();

                switch (confirmString) {
                    case "a", "A", "continue", "Continue" -> {
                        synchronized (Main.doubleBinThread) {
                            Main.doubleBinThread.notify();
                        }
                        synchronized (Main.intBinThread) {
                            Main.intBinThread.notify();
                        }
                    }
                    case "b", "B", "continue with promt", "Continue with prompt" -> {
                        newArray();
                        DoubleOps.setRestart(true);
                        IntOps.setRestart(true);
                        synchronized (Main.doubleBinThread) {
                            Main.doubleBinThread.notify();
                        }
                        synchronized (Main.intBinThread) {
                            Main.intBinThread.notify();
                        }
                        Thread.sleep(1000);
                        DoubleOps.setRestart(false);
                        IntOps.setRestart(false);
                    }
                    case "c", "C", "stop", "Stop" -> {
                        MessagesClass.setStopComputation(true);
                        synchronized (Main.doubleBinThread) {
                            Main.doubleBinThread.notify();
                        }
                        synchronized (Main.intBinThread) {
                            Main.intBinThread.notify();
                        }
                        System.out.println("stop");
                    }
                    default -> {
                        synchronized (Main.doubleBinThread) {
                            Main.doubleBinThread.notify();
                        }
                        synchronized (Main.intBinThread) {
                            Main.intBinThread.notify();
                        }
                    }
                }
                MessagesClass.setMessageFlag(false);
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        interrupt();
        System.out.println("message thread stopped " + interrupted());
    }

    public static void newArray() {
        Random rand = new Random();
        int[] intArr = new int[10];
        double[] doubleArr = new double[10];
        for (int i = 0; i < 10; i++) {
            intArr[i] = rand.nextInt(100);
            doubleArr[i] = rand.nextDouble(100);
        }
        IntOps.setIntArray(intArr);
        DoubleOps.setDoubleArray(doubleArr);

    }
}
