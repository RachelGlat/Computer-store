package controller;

import model.Cusomer;
import model.Product;
import model.PurchaseOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public interface Backend {
    void AddCustomer(Cusomer c) throws  Exception;
    void AddProduct(Product c) throws  Exception;
    HashMap<Long, Cusomer> getAllCustomers()throws Exception;
    HashSet<Product> getAllProducts()throws  Exception;
    // הוספה של הזמנה למערך ההזמנות (בדומה להוספת לקוח ומוצר.)
    void PlaceOrder(PurchaseOrder po)throws  Exception;
    // מחיקה של מוצר ממערך המוצרים, (אין צורך בלולאה.)
    void RemoveProduct(Product p) throws  Exception;
    ArrayList<Product> getCustomersOrders(Cusomer c)throws  Exception;
    Float CalcProductsTotalCost(Product [] products)throws  Exception;
}
