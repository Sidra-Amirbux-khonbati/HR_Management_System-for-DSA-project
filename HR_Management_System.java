import javax.swing.*;
import java.awt.*;
import java.time.*;    

// ================= Employee Class =================
class Employee {
    String name;
    String id;
    LocalDateTime entryTime;
    LocalDateTime exitTime;

    Employee(String name, String id) {
        this.name = name;
        this.id = id;
        this.entryTime = null;
        this.exitTime = null;
    }
}

// ================= Interview Class =================
class Interview {
    private String[] questions = {
            "Tell me about yourself.",
            "Why do you want to work here?",
            "What are your strengths?",
            "What are your weaknesses?",
            "Where do you see yourself in 5 years?",
            "How do you handle pressure?",
            "Why should we hire you?",
            "What is your expected salary?",
            "Do you have any experience?",
            "Are you willing to relocate?"
    };

    public void conductInterview() {
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < questions.length; i++) {
            sb.append((i + 1) + ". " + questions[i] + "\n\n");
        }
        area.setText(sb.toString());

        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(null, scrollPane,
                "Interview Questions", JOptionPane.INFORMATION_MESSAGE);
    }
}

// ================= Salary Calculator =================
class SalaryCalculator {
    private static final double HOURLY_RATE = 500;

    public static double calculateSalary(LocalDateTime entry, LocalDateTime exit) {
        long hours = Duration.between(entry, exit).toHours();
        if (hours < 0) return 0;
        return hours * HOURLY_RATE;
    }
}

// ================= Employee Sorter with GUI Step =================
class EmployeeSorter {
    public static void insertionSortWithGUI(Employee[] arr, int n, JFrame frame) {
        for (int i = 1; i < n; i++) {
            Employee key = arr[i];
            int j = i - 1;
              //compare or shift
            while (j >= 0 && arr[j].id.compareTo(key.id) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;

            // ===== Show current step in GUI =====
            StringBuilder sb = new StringBuilder();
            sb.append("Step " + i + " after inserting ID: " + key.id + "\n\n");
            for (int k = 0; k < n; k++) {
                if (arr[k] != null)
                    sb.append(arr[k].id + " (" + arr[k].name + ")\n");
            }

            JTextArea area = new JTextArea(sb.toString());
            area.setEditable(false);
            JScrollPane scroll = new JScrollPane(area);
            scroll.setPreferredSize(new Dimension(400, 200));

            JOptionPane.showMessageDialog(frame, scroll, "Insertion Sort Step " + i, JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
// ================= Binary Search =================
class EmployeeSearch {
    public static Employee binarySearch(Employee[] arr, int n, String id) {
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].id.compareTo(id);

            if (cmp == 0)
                return arr[mid];
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }
}

// ================= Main HR Management System =================
public class ${NAME} {

    private static Employee[] employees = new Employee[100];
    private static int count = 0;

    public static void main(String[] args) {

        JFrame frame = new JFrame("HR Management System");
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(2, 3, 10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JButton registerBtn = new JButton("Register Employee");
        JButton interviewBtn = new JButton("Conduct Interview");
        JButton showBtn = new JButton("Show Employee IDs");
        JButton entryBtn = new JButton("Mark Entry Time");
        JButton exitBtn = new JButton("Mark Exit Time");
        JButton salaryBtn = new JButton("Calculate Salary");

        // ===== Register Employee =====
        registerBtn.addActionListener(e -> {

            if (count >= employees.length) {
                JOptionPane.showMessageDialog(frame,
                        "Employee limit reached", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String name = JOptionPane.showInputDialog("Enter Employee Name:");
            String id = JOptionPane.showInputDialog("Enter Employee ID:");

            if (name == null || id == null || name.trim().isEmpty() || id.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "Invalid input", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            employees[count++] = new Employee(name.trim(), id.trim());

            // ===== Call insertion sort with GUI pop-up =====
            EmployeeSorter.insertionSortWithGUI(employees, count, frame);

            JOptionPane.showMessageDialog(frame,
                    "Employee Registered & Sorted Successfully");
        });

        // ===== Interview =====
        interviewBtn.addActionListener(e ->
                new Interview().conductInterview()
        );

        // ===== Show Employee IDs =====
        showBtn.addActionListener(e -> {
            if (count == 0) {
                JOptionPane.showMessageDialog(frame,
                        "No Employees Added Yet", "Info",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Sorted Employee IDs:\n\n");
            for (int i = 0; i < count; i++) {
                sb.append((i + 1) + ". " + employees[i].id + " (" + employees[i].name + ")\n");
            }

            JTextArea area = new JTextArea(sb.toString());
            area.setEditable(false);
            JScrollPane scroll = new JScrollPane(area);
            scroll.setPreferredSize(new Dimension(400, 200));

            JOptionPane.showMessageDialog(frame, scroll, "Employees", JOptionPane.INFORMATION_MESSAGE);
        });

        // ===== Entry Time =====
        entryBtn.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Enter Employee ID:");
            if (id == null || id.trim().isEmpty()) return;

            Employee emp = EmployeeSearch.binarySearch(employees, count, id.trim());

            if (emp != null) {
                emp.entryTime = LocalDateTime.now();
                JOptionPane.showMessageDialog(frame,
                        "Entry Time Marked: " + emp.entryTime);
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Employee not found",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // ===== Exit Time =====
        exitBtn.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Enter Employee ID:");
            if (id == null || id.trim().isEmpty()) return;

            Employee emp = EmployeeSearch.binarySearch(employees, count, id.trim());

            if (emp != null && emp.entryTime != null) {
                emp.exitTime = LocalDateTime.now();
                JOptionPane.showMessageDialog(frame,
                        "Exit Time Marked: " + emp.exitTime);
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Entry not marked or employee not found",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // ===== Salary =====
        salaryBtn.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Enter Employee ID:");
            if (id == null || id.trim().isEmpty()) return;

            Employee emp = EmployeeSearch.binarySearch(employees, count, id.trim());

            if (emp != null && emp.entryTime != null && emp.exitTime != null) {
                double salary = SalaryCalculator.calculateSalary(emp.entryTime, emp.exitTime);
                JOptionPane.showMessageDialog(frame,
                        "Total Salary: Rs. " + salary);
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Incomplete data",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.add(registerBtn);
        frame.add(interviewBtn);
        frame.add(showBtn);
        frame.add(entryBtn);
        frame.add(exitBtn);
        frame.add(salaryBtn);

        frame.setVisible(true);
    }
}


