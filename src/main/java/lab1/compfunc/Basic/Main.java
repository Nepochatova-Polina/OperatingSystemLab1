package lab1.compfunc.Basic;

import java.util.Scanner;


public class Main {
    public static BinaryMin binaryMin = new BinaryMin();

    public static void main(String[] args) throws InterruptedException {
            System.out.println("Type the double-type number:");
            Scanner doub = new Scanner(System.in);
            while (!doub.hasNextDouble()) {
                System.out.println("Invalid input\n Type the double-type number:");
                doub.next();
            }
            double doubNum = doub.nextDouble();
            System.out.println("Type the int-type number:");
            Scanner integ = new Scanner(System.in);
            while (!integ.hasNextInt()) {
                System.out.println("Invalid input\n Type the int-type number:");
                integ.next();
            }
            int intNum = integ.nextInt();
            if (doubNum == 2 || intNum == 2) {
                System.out.println("Input value is incorrect!");
            } else {
                DoubleOps.createThreads(doubNum);
                IntOps.createTreads(intNum);
                Thread.sleep(5000);
                double DresOfBinOperation = binaryMin.DoubleBinaryMin(DoubleOps.getfResult(), DoubleOps.getgResult());
                int IresOfBinOperation = binaryMin.IntBinaryMin(IntOps.getfResult(), IntOps.getgResult());
                System.out.println("Minimum of two double results is: " + DresOfBinOperation);
                System.out.println("Minimum of two integer results is: " + IresOfBinOperation + "\n");
            }
        }
    }




