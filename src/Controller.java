import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import org.json.JSONObject;
import java.io.FileWriter;
import com.google.gson.Gson;
import java.io.PrintWriter;
public class Controller {
    private static Model model;
    private final View view;
    public class Form {
        String name;
        String surname;
        int age;
        public Form(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }
    }

    public Controller(Model window, View view) {
        this.model = window;
        this.view = view;
    }

    public void start() {
        //view = new View(window);
        view.addComponents();

    }

    public static void sendData(String name, String surname, String age, String university) {
        int age2 = isAge(age);
        if(age2 <= 0) {
            wrongAge();
            return;
        }
        String jsonString = model.createJson(name, surname, age2, university);
        Requests a = new Requests();
        a.sendMessage(jsonString);
        writeFile(jsonString);
        isSuccess();
    }
    public static int isAge(String num) {
        try {
            int n1 = Integer.parseInt(num);
            if(n1 > 0)
                return n1;
            else
                return 0;
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }
    public static void writeFile(String data) {
        String path = "/Users/rz/documents/myproject/json/data.json";
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void isSuccess() {
        JLabel label = new JLabel();
        label.setText("Form sent");

        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setBounds(300, 200, 200, 70);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public static void wrongAge() {
        JLabel label = new JLabel();
        label.setText("Age must be > 0");

        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setBounds(300, 200, 200, 70);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(label, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
