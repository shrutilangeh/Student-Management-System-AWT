import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Student {
    int id;
    String name;
    int age;
    String course;

    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }
}

public class StudentManagementAWT extends Frame implements ActionListener {

    Label l1, l2, l3, l4;

    TextField tf1, tf2, tf3, tf4;

    Button addBtn, updateBtn, deleteBtn, clearBtn;

    TextArea displayArea;

    ArrayList<Student> students = new ArrayList<>();

    StudentManagementAWT() {

        setTitle("Student Management System");

        setSize(700, 500);

        setLayout(new GridLayout(6,1));

        
        l1 = new Label("ID:");
        l2 = new Label("Name:");
        l3 = new Label("Age:");
        l4 = new Label("Course:");

        
        tf1 = new TextField(15);
        tf2 = new TextField(15);
        tf3 = new TextField(15);
        tf4 = new TextField(15);

        
        addBtn = new Button("Add");
        updateBtn = new Button("Update");
        deleteBtn = new Button("Delete");
        clearBtn = new Button("Clear");

        
        displayArea = new TextArea( 15,60);

        
        

Panel p1 = new Panel();
p1.add(l1);
p1.add(tf1);

Panel p2 = new Panel();
p2.add(l2);
p2.add(tf2);

Panel p3 = new Panel();
p3.add(l3);
p3.add(tf3);

Panel p4 = new Panel();
p4.add(l4);
p4.add(tf4);

Panel p5 = new Panel();
p5.setLayout(new GridLayout(1,4,10,10));
p5.add(addBtn);
p5.add(updateBtn);
p5.add(deleteBtn);
p5.add(clearBtn);



add(p1);
add(p2);
add(p3);
add(p4);
add(p5);



add(displayArea);

        
        addBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        clearBtn.addActionListener(this);

    
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    
    void displayStudents() {

        displayArea.setText("");

        for (Student s : students) {

            displayArea.append(
                "ID: " + s.id +
                ", Name: " + s.name +
                ", Age: " + s.age +
                ", Course: " + s.course + "\n"
            );
        }
    }

    public void actionPerformed(ActionEvent e) {

        
        if (e.getSource() == addBtn) {

            if (tf1.getText().equals("") ||
                tf2.getText().equals("") ||
                tf3.getText().equals("") ||
                tf4.getText().equals("")) {

                displayArea.setText("Please fill all fields.");
                return;
            }

            int id = Integer.parseInt(tf1.getText());
            String name = tf2.getText();
            int age = Integer.parseInt(tf3.getText());
            String course = tf4.getText();

            Student s = new Student(id, name, age, course);

            students.add(s);

            displayStudents();
        }

        
        if (e.getSource() == updateBtn) {

            int id = Integer.parseInt(tf1.getText());

            for (Student s : students) {

                if (s.id == id) {

                    s.name = tf2.getText();
                    s.age = Integer.parseInt(tf3.getText());
                    s.course = tf4.getText();

                    displayStudents();

                    return;
                }
            }

            displayArea.setText("Student Not Found.");
        }

        
        if (e.getSource() == deleteBtn) {

            int id = Integer.parseInt(tf1.getText());

            for (Student s : students) {

                if (s.id == id) {

                    students.remove(s);

                    displayStudents();

                    return;
                }
            }

            displayArea.setText("Student Not Found.");
        }

        
        if (e.getSource() == clearBtn) {

            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");

            displayArea.setText("");
        }
    }

    public static void main(String[] args) {

        new StudentManagementAWT();
    }
}