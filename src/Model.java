import java.awt.*;
import javax.swing.*;
import com.google.gson.Gson;
import org.json.JSONObject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Model {
    private int width = 300;
    private int height = 400;
    public JFrame frame = new JFrame("My first app");

    public class Form {
        String name;
        String surname;
        int age;
        String university;
        public Form(String name, String surname, int age, String university) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.university = university;
        }
    }
    public Model() {
        //frame.setSize(width, height);
        //frame.setVisible(true);
    }
    public void addComponent(Component component) {
        frame.add(component);
        pack();
    }
    public void pack() {
        frame.pack();
        frame.setSize(width, height);
    }
    public void updateSize() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(width, height);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public String createJson(String name, String surname, int age, String university) {
        Form user = new Form(name, surname, age, university);
        Gson gson = new Gson();
        String jsonString = gson.toJson(user);
        System.out.println(jsonString);
        return jsonString;
    }

}
