package lab1.compfunc.Advanced.Message;

import lab1.compfunc.Advanced.Main;
import java.util.Objects;
import java.util.Scanner;


public class StopByKey extends Thread {

    @Override
    public void run() {
        Scanner string = new Scanner(System.in);
        String confirmCombo;
        while (MessagesUtility.isStopComputation()) {
            confirmCombo = string.nextLine();
            if (Objects.equals(confirmCombo, "")) {
                MessagesUtility.setMessageFlag(true);
                System.out.println("Please confirm that computation should be stopped y(yes)/n(no)");
                confirmCombo = string.nextLine();
                switch (confirmCombo) {
                    case "y", "Y", "yes", "Yes", "YES" -> {
                        MessagesUtility.setStopComputation(true);
                        MessagesUtility.setMessageFlag(false);
                        synchronized (Main.doubleBinThread) {
                            Main.doubleBinThread.notify();
                        }
                        synchronized (Main.intBinThread) {
                            Main.intBinThread.notify();
                        }
                    }
                    case "n", "N", "no", "No", "NO" -> {
                        MessagesUtility.setMessageFlag(false);
                        synchronized (Main.doubleBinThread) {
                            Main.doubleBinThread.notify();
                        }
                        synchronized (Main.intBinThread) {
                            Main.intBinThread.notify();
                        }
                    }
                    default -> {
                        System.out.println("action is not confirmed within 5 sec proceeding");
                        MessagesUtility.setMessageFlag(false);
                    }
                }
            }
        }
        interrupt();
    }

}
