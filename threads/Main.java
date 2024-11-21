public class Main {
    public static void main(String[] args) {
        int totalSheets = 500;
        int sheetsPerAssistant = 50;
        int numAssistants = totalSheets / sheetsPerAssistant;

        for (int i = 1; i <= numAssistants; i++) {
            new ExamChecking(sheetsPerAssistant, i).start();
        }
    }
}