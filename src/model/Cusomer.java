package model;

public class Cusomer {
    private long id;
    private String name;
    private String address;

    public Cusomer(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Cusomer() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Cusomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
