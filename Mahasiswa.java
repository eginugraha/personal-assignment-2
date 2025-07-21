// Class untuk attribut mahasiswa
public class Mahasiswa {
    String nim;
    String nama;
    String jurusan;
    Mahasiswa next;

    // Constructor untuk inisialisasi atribut
    public Mahasiswa(String nim, String nama, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.next = null;
    }
}