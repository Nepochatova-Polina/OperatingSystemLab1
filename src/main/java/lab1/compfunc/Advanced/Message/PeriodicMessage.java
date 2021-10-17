package lab1.compfunc.Advanced.Message;

import lab1.compfunc.Advanced.DoubleOps.DoubleOpsUtility;
import lab1.compfunc.Advanced.IntOps.IntOpsUtility;
import lab1.compfunc.Advanced.Main;

import java.util.Random;
import java.util.Scanner;

public class PeriodicMessage extends Thread {

    @Override
    public void run() {
        while (!DoubleOpsUtility.isStop() || !IntOpsUtility.isStop()) {
            try {
                Thread.sleep(5000);
                System.out.println("""
                        Do you want to:
                        (a)continue
                        (b)continue with promt
                        (c)stop
                        """);
                MessagesUtility.setMessageFlag(true);
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
                        DoubleOpsUtility.setRestart(true);
                        IntOpsUtility.setRestart(true);
                        synchronized (Main.doubleBinThread) {
                            Main.doubleBinThread.notify();
                        }
                        synchronized (Main.intBinThread) {
                            Main.intBinThread.notify();
                        }
                        Thread.sleep(1000);
                        DoubleOpsUtility.setRestart(false);
                        IntOpsUtility.setRestart(false);
                    }
                    case "c", "C", "stop", "Stop" -> {
                        MessagesUtility.setStopComputation(true);
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
                MessagesUtility.setMessageFlag(false);
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        interrupt();
        System.out.println("message thread stopped");
    }

    public static void newArray() {
        Random rand = new Random();
        int[] intArr = new int[10];
        double[] doubleArr = new double[10];
        for (int i = 0; i < 10; i++) {
            intArr[i] = rand.nextInt(100);
            doubleArr[i] = rand.nextDouble(100);
        }
        IntOpsUtility.setIntArray(intArr);
        DoubleOpsUtility.setDoubleArray(doubleArr);

    }
}
