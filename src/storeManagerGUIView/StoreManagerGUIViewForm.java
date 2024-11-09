package storeManagerGUIView;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreManagerGUIViewForm extends JFrame {
    private JButton AddNewCoustumer;
    private JButton WatchOrders;
    private JButton products;
    private JButton order;
    private JPanel panel;

    public StoreManagerGUIViewForm() {
        AddNewCoustumer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewCustomerForm an=new AddNewCustomerForm();
                an.setVisible(true);
            }
        });

        products.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("ManageCatalogForm");
                frame.setContentPane(new ManageCatalogForm().panel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("StoreManagerGUIViewForm");
        frame.setContentPane(new StoreManagerGUIViewForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(400, 200));
    }
}
