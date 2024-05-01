package pbotugas1;

import java.util.Scanner;

public class Main {
    public static void main (String [] args) {
        String user, password;
        int menuRestoran, menuOrder;
        Scanner scanner = new Scanner(System.in);
        Login1 user2 = new Login1();
        user2.login1();
        Admin admin = new Admin();
        boolean isLoggedIn = false;


        while(!isLoggedIn) {
            System.out.println("===========================");
            System.out.println("|   WELCOME TO ETHEREAL    |");
            System.out.println("========== LOGIN ==========");
            System.out.print("| Masukkan username: ");
            user = scanner.next();
            System.out.print("| Masukkan password: ");
            password = scanner.next();
            System.out.println("===========================");

            if (user.equals(user2.getUsername_user()) && password.equals(user2.getPassword_user()) || user.equals(user2.getUsername_admin()) && password.equals(user2.getPassword_admin())) {
                int ulang;
                isLoggedIn = true;
                if (user.equals(user2.getUsername_user())) {
                    do {
                        System.out.println("===========================");
                        System.out.println("|       MENU CUSTOMER     |");
                        System.out.println("===========================");
                        System.out.println("| 1. Order Menu           |");
                        System.out.println("| 2. Lihat Orderan        |");
                        System.out.println("| 3. Login Ulang          |");
                        System.out.println("===========================");
                        System.out.print("Masukkan Pilihan yang Anda Inginkan ");
                        menuOrder = scanner.nextInt();
                        switch (menuOrder){
                            case 1:
                                Admin.viewMenu();
                                break;
                            case 2:
                                Admin.viewOrder();
                                break;
                            case 3:
                                isLoggedIn = false;
                                break;
                        }
                        String pesan = (!isLoggedIn) ? "Login ulang ? (1 = Tidak/ 2 = Iya) : " : "Apakah Anda Ingin Memilih Menu Lain? (1 = Iya /2 = Tidak) : ";
                        System.out.print(pesan);ulang= scanner.nextInt();
                    }while(ulang == 1);
                } else if (user.equals(user2.getUsername_admin())) {
                    do {
                        Admin.MenuAdmin();
                        System.out.print("Masukan opsi yang anda inginkan : ");
                        menuRestoran = scanner.nextInt();

                        switch (menuRestoran) {
                            case 1:
                                Admin.viewRestoran();
                                break;
                            case 2:
                                Admin.addRestoran();
                                break;
                            case 3:
                                Admin.removeRestoran();
                                break;
                            case 4:
                                isLoggedIn = false;
                                break;
                        }
                        String pesan = (!isLoggedIn) ? "Login ulang ? (1 = Tidak/ 2 = Iya) : " : "Apakah anda ingin memilih menu lain? (1 = iya /2 = tidak) : ";
                        System.out.print(pesan);ulang= scanner.nextInt();
                    }while(ulang == 1);
                }

            }else{
                System.out.println("* Username/Password salah!*");
            }

        }
    }
}