package lab1.compfunc.Advanced;

import lab1.compfunc.Advanced.DoubleOps.DoubleOps;
import lab1.compfunc.Advanced.IntOps.IntOps;

import java.util.Scanner;

public class PeriodicMessage extends Thread{
    public static boolean messageFlag = false;
    public static boolean stopComputation = false;

    @Override
    public void run() {
        while (!DoubleOps.stop || !IntOps.stop) {
            try {
                Thread.sleep(5000);
                System.out.println("Do you want to:\n"+ "(a)continue\n" +"(b)continue with promt\n"  +"(c)stop\n");
                messageFlag = true;
                Thread.sleep(5000);
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
                        System.out.println("Continue with prompt");
                    }
                    case "b", "B", "continue with promt", "Continue with prompt" ->
                            //                        synchronized (Main.doubleBinThread) {
//                            Main.doubleBinThread.notify();
//                        }
//                        synchronized (Main.intBinThread) {
//                            Main.intBinThread.notify();
//                        }
                            System.out.println("Continue with prompt");
                    case "c", "C", "stop", "Stop" -> {
                        stopComputation = true;
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
                messageFlag = false;
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        interrupt();
        System.out.println("message thread stopped " + interrupted());
    }
}
