package storeManagerGUIView;

import controller.Backend_DAO_List;
import model.Cusomer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AddNewCustomerForm extends JFrame {

    Backend_DAO_List bdl = Backend_DAO_List.get();
    private JButton jButtonOK;
    private JLabel  jLabelID;
    private JLabel  jLabelName;
    private JLabel  jLabelAddress;
    private JTextField    jTextFieldID;
    private JTextField   jTextFieldName;
    private JTextField   jTextFieldAddress;

    public AddNewCustomerForm()  {

        jLabelID = new JLabel("ID:");
        jTextFieldID = new JTextField();
        jLabelName = new JLabel("Name:");
        jTextFieldName = new JTextField();
        jLabelAddress = new JLabel("Address:");
        jTextFieldAddress = new JTextField();
        jButtonOK = new JButton("OK");


        getContentPane().add(jLabelID);
        getContentPane().add(jTextFieldID);
        getContentPane().add(jLabelName);
        getContentPane().add(jTextFieldName);
        getContentPane().add(jLabelAddress);
        getContentPane().add(jTextFieldAddress);
        getContentPane().add(jButtonOK);



        this.setSize(400,400);
        getContentPane().setLayout(new GridLayout(0,2,10,10));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jTextFieldID.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) || jTextFieldID.getText().length()>=9)
                    e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        jButtonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    long id = Long.parseLong(jTextFieldID.getText().trim());
                    if (jTextFieldName.getText().isBlank())
                        throw new Exception("חובה להכניס שם");
                    if (jTextFieldAddress.getText().isBlank())
                        throw new Exception("חובה להכניס כתובת");
                    if (bdl.getAllCustomers().containsKey(id))
                        throw new Exception("מספר זהות קיים במערכת");
                    Cusomer c = new Cusomer();
                    c.setId(id);
                    c.setName(jTextFieldName.getText());
                    c.setAddress(jTextFieldAddress.getText());
                    bdl.AddCustomer(c);
                    JOptionPane.showMessageDialog(AddNewCustomerForm.this,"הלקוח נוסף בהצלחה");
                    System.out.println(bdl.getAllCustomers());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(AddNewCustomerForm.this,ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        AddNewCustomerForm form = new AddNewCustomerForm();
        form.setVisible(true);
    }
}

