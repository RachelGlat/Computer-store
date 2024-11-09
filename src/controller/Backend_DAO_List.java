package controller;
import model.*;

import java.util.*;

public class Backend_DAO_List implements Backend {
    private Map<Long, Cusomer> _Customers;
    private Set<Product> _Products;
    private List<PurchaseOrder> _PurchaseOrders;

    private Backend_DAO_List() {
        _Customers = new HashMap<>();
        _Products = new HashSet<>();
        _PurchaseOrders = new ArrayList<>();

        _Products.add(new HardwareProduct("מקלדת","צבעונית",75,12));
        _Products.add(new HardwareProduct("עכבר","גימינג",30,3));
        _Products.add(new HardwareProduct("מטען","נייד",23,11));
        _Products.add(new SoftwareProduct("word","תוכנת כתיבה",400,5));
        _Products.add(new SoftwareProduct("visual","תוכנת למידה",234,7));
    }

    static Backend_DAO_List b;

    public static Backend_DAO_List get(){
        if(b==null)
            b=new Backend_DAO_List();
        return b;
    }

    public Backend_DAO_List(Map<Long, Cusomer> _Customers, Set<Product> _Products, List<PurchaseOrder> _PurchaseOrders) {
        this._Customers = _Customers;
        this._Products = _Products;
        this._PurchaseOrders = _PurchaseOrders;
    }


    public void AddCustomer(Cusomer c) throws Exception {
        _Customers.put(c.getId(), c);
    }


    public void AddProduct(Product p) throws Exception {
        _Products.add(p);
    }

    public void PlaceOrder(PurchaseOrder po) throws Exception {
       _PurchaseOrders.add(po);
    }

    public void RemoveProduct(Product p) throws Exception {
        _Products.remove(p);
    }

    public Float CalcProductsTotalCost(Product[] products) throws Exception {
        Float SumToPay = null;
        for (int i=0;i< products.length;i++){
            SumToPay+=products[i].getPrice(products[i]);
        }
        return SumToPay;
    }

    public HashMap<Long, Cusomer> getAllCustomers() throws Exception {
        return (HashMap<Long, Cusomer>) _Customers;
    }

    public HashSet<Product> getAllProducts()throws  Exception {
        return (HashSet<Product>) _Products;
    }

    public ArrayList<Product> getCustomersOrders(Cusomer c)throws  Exception{
        ArrayList <Product> ret = new ArrayList<Product>();
        for (PurchaseOrder p:_PurchaseOrders)
        {
            if(p.getOrderingCustomer().getId() == c.getId())
                ret.addAll( p.getProducts());
        }
        return ret;
    }
}

