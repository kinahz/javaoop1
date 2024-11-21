class ExamChecking extends Thread {
    private int sheetsToCheck;
    private int assistantId;

    public ExamChecking(int sheetsToCheck, int assistantId) {
        this.sheetsToCheck = sheetsToCheck;
        this.assistantId = assistantId;
    }

    @Override
    public void run() {
        for (int i = 1; i <= sheetsToCheck; i++) {
            System.out.println("Assistant " + assistantId + " checking sheet " + i);
            try {
                Thread.sleep(500); // Simulate time to check each sheet
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}