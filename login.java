import java.util.Scanner;

public class login {
    private final String adminUsername = "admin";
    private final String adminPassword = "admin";
    private final String customerUsername = "customer";
    private final String customerPassword = "customer";

    public login() {

    }

    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("===============================================");
        System.out.println("               L O G I N");
        System.out.println("===============================================");
        System.out.println("Pilih jenis akun:");
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        System.out.println("===============================================");
        System.out.print("Masukkan pilihan: ");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                adminLogin(input);
                break;
            case 2:
                customerLogin(input);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private void adminLogin(Scanner input) {
        System.out.println("===============================================");
        System.out.print("Masukkan username : ");
        String inputUsername = input.nextLine();
        System.out.print("Masukkan password : ");
        String inputPassword = input.nextLine();

        if (inputUsername.equals(adminUsername) && inputPassword.equals(adminPassword)) {
            System.out.println("===============================================");
            System.out.println("Selamat datang, admin!");
            // Tampilan untuk admin
        } else {
            System.out.println("===============================================");
            System.out.println("Login admin gagal. Silakan coba lagi.");
        }
    }

    private void customerLogin(Scanner input) {
        System.out.println("===============================================");
        System.out.print("Masukkan username : ");
        String inputUsername = input.nextLine();
        System.out.print("Masukkan password : ");
        String inputPassword = input.nextLine();

        if (inputUsername.equals(customerUsername) && inputPassword.equals(customerPassword)) {
            System.out.println("===============================================");
            System.out.println("Selamat datang, customer!");
            // Tampilan untuk customer
        } else {
            System.out.println("===============================================");
            System.out.println("Login customer gagal. Silakan coba lagi.");
        }
    }

    public static void main(String[] args) {
        login loginSystem = new login();
        loginSystem.login();
    }
}
