import java.util.Random;



public class Program {
    public static volatile boolean done = false;
    private static class OlaThread extends Thread
    {
        private int num;
        public OlaThread(int num)
        {
            this.num = num;
        }

        @Override
        public void run() {
            super.run();
            Random rand = new Random();
            done = false;

            int[] arr = new int[num];
            while (!done) {

                for (int i = 0; i < arr.length; i++) {
                    arr[i] = rand.nextInt(90) + 10;
                }


                if (isSorted(arr)) {
                    done = true;
                    for (int i = 0; i < arr.length; i++) {
                        System.out.println(arr[i]);
                    }
                    System.out.println(this + "Successfully FOUND!");

                }
                //else System.out.println(this + "failed to find");
        }
    }




    public static boolean isSorted(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] >= arr[i + 1])
                return false;
        return true;
    }
    public static void olaMamash(int num) {
        Random rand = new Random();
        boolean flag = false;
        boolean bigflag = false;
        int[] arr = new int[num];
        while (!bigflag) {
            flag = false;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rand.nextInt(90) + 10;
            }


            if (isSorted(arr)) {

                for (int j : arr) {
                    System.out.println(j);
                }
                bigflag = !bigflag ;
            }

        }

    }

    public static void main(String[] args) {
        OlaThread[] olaThreads = new OlaThread[16];
        for (int i = 0; i < olaThreads.length; i++) {
            olaThreads[i] = new OlaThread(11);
        }
        for (int i = 0; i < olaThreads.length; i++) {
            System.out.println("In thread "+i);
            olaThreads[i].start();

        }

    }
}
}

