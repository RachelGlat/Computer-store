package model;

public abstract class Product {
    private long id;
    private String name;
    private String Description;
    private float pricePerUnit;

    static int cnt =0;
    public Product() {
    }

    public Product( String name, String description, float pricePerUnit) {
        this.id = cnt++;
        this.name = name;
        Description = description;
        this.pricePerUnit = pricePerUnit;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public float getPricePerUnit() {
        return pricePerUnit;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Description='" + Description + '\'' +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }

    public abstract float getPrice(Product product);

}

