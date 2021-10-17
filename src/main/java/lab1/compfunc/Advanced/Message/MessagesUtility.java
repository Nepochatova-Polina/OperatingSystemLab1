package lab1.compfunc.Advanced.Message;

public class MessagesUtility {
    private static boolean messageFlag = false;
    private static boolean stopComputation = false;

    public static boolean isMessageFlag() {
        return !messageFlag;
    }

    public static void setMessageFlag(boolean messageFlag) {
        MessagesUtility.messageFlag = messageFlag;
    }

    public static boolean isStopComputation() {
        return !stopComputation;
    }

    public static void setStopComputation(boolean stopComputation) {
        MessagesUtility.stopComputation = stopComputation;
    }
}
