public class Main {
    public static void main(String[] args) {
        ExamChecking m = new ExamChecking(6);
        ExamChecking m2 = new ExamChecking(4);

        m.setName("Alibek");
        m2.setName("Dana");

        m2.setPriority(Thread.MAX_PRIORITY);
        m.start();
        m2.start();
    }
}