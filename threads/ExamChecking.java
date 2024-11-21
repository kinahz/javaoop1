import java.text.SimpleDateFormat;
import java.util.Date;

class ExamChecking extends Thread {
    private static int examSheets = 500;
    private int iterations;
    private static final int SHEETS_PER_ITERATION = 50;
    private static final Object LOCK = new Object();

    public ExamChecking(int iterations) {
        this.iterations = iterations;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < iterations) {
            synchronized (LOCK) {
                if (examSheets <= 0) {
                    System.out.println("ошибка");
                    System.exit(0);
                }

                examSheets -= SHEETS_PER_ITERATION;
                count++;

                String currentTime = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").format(new Date());
                System.out.println(getName() + " finished checking, at: " + currentTime +
                        ", exam sheet count is now " + examSheets);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
