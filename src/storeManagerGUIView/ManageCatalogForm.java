package storeManagerGUIView;

import controller.Backend_DAO_List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageCatalogForm extends JFrame {
    private JButton AddProduct;
    private JButton DellProduct;
    private JList ListProduct;
    public JPanel panel;

    DefaultListModel   AllProductsListModel;
    Backend_DAO_List bdl = Backend_DAO_List.get();

    public ManageCatalogForm()  {


        this.setSize(400,400);
        getContentPane().setLayout(new GridLayout(0,2,10,10));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        AddProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p();
            }
        });

        AllProductsListModel =new DefaultListModel();
        ListProduct.setModel(AllProductsListModel);
        RefreshProductList();
    }

    public void RefreshProductList() {
        try {
            AllProductsListModel.clear();
            AllProductsListModel.addAll(bdl.getAllProducts());
        } catch (Exception ex) {
        }
    }
    private void p(){
        JFrame frame = new JFrame("AddNewProductForm");
        frame.setContentPane(new AddNewProductForm(this).panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
