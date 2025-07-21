import java.util.Scanner; // import library scanner untuk menerima input

// Class utama untuk menjalankan program singly linked list data mahasiswa
public class MahasiswaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SingleLinkedList list = new SingleLinkedList();
        int choice = 0;

        do {
            System.out.println("\n=== Program Singly Linked List Data Mahasiswa ===");
            System.out.println("1. Push Data Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mahasiswa");
            System.out.println("3. Pop Semua Data Mahasiswa");
            System.out.println("4. Keluar Program");
            System.out.print("Pilih Menu (1-4): ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka 1-4.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Jurusan: ");
                    String jurusan = scanner.nextLine();
                    list.push(nim, nama, jurusan);
                    break;

                case 2:
                    list.displaySorted();
                    break;

                case 3:
                    list.popAll();
                    break;

                case 4:
                    System.out.println("Terima kasih, program selesai!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Pilih antara 1-4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}