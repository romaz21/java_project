import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class View {
    private final Model model;
    private final int f_width = 70;
    private final int f_height = 30;
    private final int x_init = 40;
    private final int y_init = 70;
    public View(Model window) {
        this.model = window;
    }

    public void addComponents() {
        TextField nameBtn1 = addTxtField1("", x_init + 65, y_init);
        Label l1 = addLabel("name", x_init, y_init);
        TextField nameBtn2 = addTxtField1("", x_init + 65, y_init + 50);
        Label l2 = addLabel("surname", x_init, y_init + 50);
        TextField nameBtn3 = addTxtField1("", x_init + 65, y_init + 100);
        Label l3 = addLabel("age", x_init, y_init + 100);
        TextField nameBtn4 = addTxtField1("", x_init + 65, y_init + 150);
        Label l4 = addLabel("university", x_init, y_init + 150);
        Button btn=new Button("Send");
        btn.setBounds(50,300,200,30);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameBtn1.getText();
                String surname = nameBtn2.getText();
                String age = nameBtn3.getText();
                String university = nameBtn4.getText();
                Controller.sendData(name, surname, age, university);

                //Requests a = new Requests();
                //a.sendMessage(name);
            }
        });

        model.updateSize();
        model.addComponent(l1);
        model.addComponent(l2);
        model.addComponent(l3);
        model.addComponent(l4);
        model.addComponent(nameBtn1);
        model.addComponent(nameBtn2);
        model.addComponent(nameBtn3);
        model.addComponent(nameBtn4);
        model.addComponent(btn);
        //model.updateSize();
    }
    public TextField addTxtField1(String text, int x, int y) {
        TextField nameBtn = new TextField(text);
        nameBtn.setBounds(x,y, f_width + 20,f_height);
        return nameBtn;
    }

    public Label addLabel(String text, int x, int y) {
        Label l = new Label(text);
        l.setBounds(x, y, f_width, f_height);
        return l;
    }


    public void pack(Frame frame) {
        frame.pack();
    }
}
