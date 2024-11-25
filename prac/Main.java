import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "Students.xlsx";
        List<Student> students = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through rows, skipping the header
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row != null) {
                    String name = row.getCell(0).getStringCellValue();
                    double currentScholarship = row.getCell(1).getNumericCellValue();
                    double newScholarship = row.getCell(2).getNumericCellValue();

                    students.add(new Student(name, currentScholarship, newScholarship));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display scholarship details for each student
        displayScholarshipDetails(students);
    }

    private static void displayScholarshipDetails(List<Student> students) {
        System.out.println("Scholarship Details:");
        for (Student student : students) {
            System.out.printf("Name: %s, Current: %.2f, New: %.2f, Increase: %.2f%n",
                    student.getName(),
                    student.getCurrentScholarship(),
                    student.getNewScholarship(),
                    student.getScholarshipIncrease());
        }
    }
}
