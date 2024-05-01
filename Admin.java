package pbotugas1;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Admin {

    static HashMap<String, Restoran> restorans = new HashMap<>();
    public static ArrayList<Order> orders = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    static void MenuAdmin() {
        System.out.println("===========================");
        System.out.println("|       MENU ADMIN        |");
        System.out.println("===========================");
        System.out.println("|1. Lihat Restoran        |");
        System.out.println("|2. Tambah Restoran       |");
        System.out.println("|3. Hapus Restoran        |");
        System.out.println("|4. Login Ulang           |");
        System.out.println("===========================");
    }


    public static void addRestoran() {
        System.out.print("Masukkan ID Restoran : ");
        int id = scanner.nextInt();

        System.out.print("Masukkan Nama Restoran : ");
        String name = scanner.next();

        System.out.print("Masukkan Alamat Restoran : ");
        String address = scanner.next();
        Restoran restoran = new Restoran(id, name, address);

        String inputMenu = "";
        while (!inputMenu.equals("Selesai")) {
            System.out.print("Masukkan Menu (format: nama menu|harga menu) enter, lalu ketik (Selesai) : ");
            inputMenu = scanner.next();
            if (!inputMenu.equals("Selesai")) {
                String[] menuData = inputMenu.split("\\|");
                restoran.setNmenu(new Menu(menuData[0], Integer.parseInt(menuData[1])));
            }
        }
        restorans.put(name, restoran);
        System.out.println("Menambah Restoran BERHASIL!!!");
    }

    public static void viewRestoran(){
        System.out.println("============= RESTORAN =============");
        for(String namaRestoran : restorans.keySet()){
            System.out.println("ID Restoran : " + restorans.get(namaRestoran).getId()
                    + " || Nama : " + namaRestoran + " || Alamat : " +restorans.get(namaRestoran).getAddress());
            System.out.println("Menu : ");
            for (Menu menu : restorans.get(namaRestoran).getNmenu()){
                System.out.println(menu.getName() + " || " +menu.getPrice());
            }
        }
    }

    public static void viewMenu(){
        System.out.println("==== RESTORAN ====");
        for(String namarestoran : restorans.keySet()) {
            System.out.println(namarestoran + " || " + restorans.get(namarestoran).getAddress());
        }
        System.out.print("Masukkan Nama Restoran : ");
        String pilih_restoran = scanner.next();
        if(!restorans.containsKey(pilih_restoran)){
            System.out.println("Menu Tidak Ada!!!");
        }
        Restoran res = restorans.get(pilih_restoran);
        Order newOrder = new Order(res);
        String menu = "";
        while(!menu.equals("2")){
            System.out.println("==== "+ res.getName() + " ====");
            System.out.println("Menu : ");
            int nomorMenu = 1;
            for (Menu menu1 : res.getNmenu()){
                System.out.println(nomorMenu + ". " + menu1.getName() + " - " + menu1.getPrice());
                nomorMenu++;
            }
            System.out.print("Masukkan Nomor Menu : ");
            int indexMenu = scanner.nextInt();
            System.out.print("Jumlah yang Ingin Dibeli : ");
            int jumlah_beli = scanner.nextInt();
            scanner.nextLine();

            newOrder.addMenu(res.getNmenu().get(indexMenu - 1), jumlah_beli);

            System.out.print("Apakah Ingin Menambah Menu Lagi?  (1 = Iya / 2 = Tidak) : ");
            menu = scanner.next();
        }
        System.out.print("Masukkan Jarak Pengantaran Makanan (dalam KM) : ");
        int jarak = scanner.nextInt();

        newOrder.setDistance(jarak);
        orders.add(newOrder);
        System.out.println("Berhasil Memesan Menu!!!");
    }

    public static void viewOrder(){
        System.out.println("===== ORDERS =====");
        for(int i = 0; i<orders.size(); i++){
            Order order = orders.get(i);
            System.out.println((i+1) + ". " +order.getRestoran().getName());
            System.out.println("Menu : ");
            for(Menu menu : order.getNmenu().keySet()){
                System.out.println(menu.getName() + " X " + order.getNmenu().get(menu));
            }
            System.out.println("Ongkir 1.000.km || Jarak : "+order.getDistance()+" km");
            System.out.println("Total Bayar : "+order.getTotalPrice());
        }
    }

    public static void removeRestoran(){
        for(String namaRestaurant : restorans.keySet()){
            System.out.println("ID Restoran : " + restorans.get(namaRestaurant).getId()
                    + " || Nama : " + namaRestaurant + " || Alamat : " +restorans.get(namaRestaurant).getAddress());
        }
        System.out.println("==============================");
        System.out.println("Masukkan Nama Restoran : ");
        String namaRestaurant = scanner.next();
        if(restorans.containsKey(namaRestaurant)){
            restorans.remove(namaRestaurant);
            System.out.println("Restoran Berhasil Di Hapus!!!");
        }else{
            System.out.println("RESTORAN TIDAK DITEMUKAN!!");
        }
    }
}


