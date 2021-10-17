package lab1.compfunc.Advanced.Message;

import lab1.compfunc.Advanced.Main;

import java.util.Objects;
import java.util.Scanner;

public class KeyStopClass extends Thread {

    @Override
    public void run() {
        Scanner string = new Scanner(System.in);
        String confirmCombo;
        while (!MessagesClass.isStopComputation()) {
            try {
                confirmCombo = string.nextLine();
                if (Objects.equals(confirmCombo, "  ") /*|| Objects.equals(confirmCombo, "c")*/) {
                    MessagesClass.setMessageFlag(true);
                    System.out.println("Please confirm that computation should be stopped y(yes)/n(no)");
                    Thread.sleep(5000);
                    confirmCombo = string.nextLine();
                    switch (confirmCombo) {
                        case "y", "Y", "yes", "Yes", "YES" -> {
                            MessagesClass.setStopComputation(true);
                            MessagesClass.setMessageFlag(false);
                            synchronized (Main.doubleBinThread) {
                                Main.doubleBinThread.notify();
                            }
                            synchronized (Main.intBinThread) {
                                Main.intBinThread.notify();
                            }
                        }
                        case "n", "N", "no", "No", "NO" -> {
                            MessagesClass.setMessageFlag(false);
                            synchronized (Main.doubleBinThread) {
                                Main.doubleBinThread.notify();
                            }
                            synchronized (Main.intBinThread) {
                                Main.intBinThread.notify();
                            }
                        }
                        default -> {
                            System.out.println("action is not confirmed within 5 sec proceeding");
                            MessagesClass.setMessageFlag(false);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        interrupt();
    }

}
