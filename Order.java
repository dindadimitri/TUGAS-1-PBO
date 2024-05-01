package pbotugas1;


import java.util.Scanner;
import java.util.HashMap;

public class Order {
    private Restoran restoran;
    private HashMap<Menu, Integer> nmenu;
    private int distance;

    public Order(Restoran restoran) {
        this.restoran = restoran;
        this.nmenu = new HashMap<>();
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public HashMap<Menu, Integer> getNmenu() {
        return nmenu;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTotalPrice() {
        int totalHarga = 0;
        for (Menu menu : this.nmenu.keySet()) {
            totalHarga += menu.getPrice() * this.nmenu.get(menu);
        }
        totalHarga += this.distance * 1000;
        return totalHarga;
    }

    public void addMenu(Menu menu, int quantity) {
        if (this.nmenu.containsKey(menu)) {
            int currentQuantity = this.nmenu.get(menu);
            this.nmenu.put(menu, currentQuantity + quantity);
        } else {
            this.nmenu.put(menu, quantity);
        }
    }
}