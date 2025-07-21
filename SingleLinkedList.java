// Class untuk menyimpan data mahasiswa dalam linked list
public class SingleLinkedList {
    Mahasiswa head;
    int size;

    // Constructor untuk inisialisasi linked list
    public SingleLinkedList() {
        head = null;
        size = 0;
    }

    // Validasi input NIM maximum 10 digit
    public boolean isValidNim(String nim) {
        return nim.matches("\\d{1,10}");
    }

    // Validasi input nama maximum 30 karakter
    public boolean isValidNama(String nama) {
        return nama.length() <= 30;
    }

    // Validasi input jurusan maximum 50 karakter
    public boolean isValidJurusan(String jurusan) {
        return jurusan.length() <= 50;
    }

    // Menambahkan data mahasiswa ke linked list
    public boolean push(String nim, String nama, String jurusan) {
        if (size >= 5) {
            System.out.println("Kapasitas penuh maximum 5 data!");
            return false;
        }
        if (!isValidNim(nim)) {
            System.out.println("NIM maximum 10 digit!");
            return false;
        }
        if (!isValidNama(nama)) {
            System.out.println("Nama maximum 30 karakter!");
            return false;
        }
        if (!isValidJurusan(jurusan)) {
            System.out.println("Jurusan maximum 50 karakter!");
            return false;
        }

        Mahasiswa newNode = new Mahasiswa(nim, nama, jurusan);
        if (head == null) {
            head = newNode;
        } else {
            Mahasiswa current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Data mahasiswa berhasil ditambahkan!");
        return true;
    }

    // Menampilkan daftar mahasiswa yang sudah diurutkan berdasarkan NIM
    public void displaySorted() {
        if (head == null) {
            System.out.println("Daftar mahasiswa kosong!");
            return;
        }

        Mahasiswa[] tempArray = new Mahasiswa[size];
        Mahasiswa current = head;
        int i = 0;
        while (current != null) {
            tempArray[i] = current;
            current = current.next;
            i++;
        }

        // Bubble sort berdasarkan NIM
        for (int j = 0; j < size - 1; j++) {
            for (int k = 0; k < size - j - 1; k++) {
                if (tempArray[k].nim.compareTo(tempArray[k + 1].nim) > 0) {
                    Mahasiswa temp = tempArray[k];
                    tempArray[k] = tempArray[k + 1];
                    tempArray[k + 1] = temp;
                }
            }
        }

        System.out.println("\nDaftar Mahasiswa (Urutan Berdasarkan NIM):");
        System.out.println("-----------------------------------------------");
        for (Mahasiswa m : tempArray) {
            System.out.println("NIM: " + m.nim);
            System.out.println("Nama: " + m.nama);
            System.out.println("Jurusan: " + m.jurusan);
            System.out.println("-----------------------------------");
        }
    }

    // Menghapus semua data mahasiswa dari linked list
    public void popAll() {
        if (head == null) {
            System.out.println("Daftar mahasiswa sudah kosong!");
            return;
        }
        head = null;
        size = 0;
        System.out.println("Semua data mahasiswa berhasil dihapus!");
    }
}