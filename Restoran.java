package pbotugas1;


import java.util.ArrayList;

public class Restoran {

    private int id;
    private String name;
    private String address;
    private ArrayList<Menu> nmenu;

    public Restoran(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.nmenu = new ArrayList<>();
    }

    public int getId() {
        setId(id);
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        setName(name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        setAddress(address);
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Menu> getNmenu() {
        return nmenu;
    }

    public void setNmenu(Menu nmenu) {
        this.nmenu.add(nmenu);
    }

    @Override
    public String toString() {
        return "ID Restoran : " + id +
                ", Name=" + name + ' ' +
                ", Address=" + address + ' ';
    }
}
