package lab1.compfunc.Basic;


import java.util.Scanner;
import lab1.compfunc.Basic.DoubleOps;
import lab1.compfunc.Basic.IntOps;
import lab1.compfunc.Basic.BinaryMin;


public class Main {
    public static BinaryMin binaryMin = new BinaryMin();

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Enter double number:");
        Scanner doub = new Scanner(System.in);
        double doubNum = doub.nextDouble();
        System.out.println("Enter integer number:");
        Scanner integ = new Scanner(System.in);
        int intNum = integ.nextInt();
        if(doubNum == 2 || intNum == 2) {
            System.out.println("Input value is incorrect!");
        }else{
            DoubleOps.createThreads(doubNum);
            IntOps.createTreads(intNum);
            Thread.sleep(2000);
            double DresOfBinOperation = binaryMin.DoubleBinaryMin(DoubleOps.fResult,DoubleOps.gResult);
            int IresOfBinOperation = binaryMin.IntBinaryMin(IntOps.fResult, IntOps.gResult);
            System.out.println("Minimum of two double results is: " + DresOfBinOperation);
            System.out.println("Minimum of two integer results is: " + IresOfBinOperation);
            }
        }

    }

