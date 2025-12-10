import java.util.Scanner;
public class Magang02 {

    static Scanner sc = new Scanner(System.in);
    static final int MAX = 100;

    static String[][] data = new String[MAX][6];
    static int jumlah = 0;

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        int pilih;

        do {
            System.out.println("\n=== Sistem Pendaftaran Magang Mahasiswa ===");
            System.out.println("1. Tambah Data Magang");
            System.out.println("2. Tampilkan Semua Pendaftar Magang");
            System.out.println("3. Cari Pendaftar berdasarkan Program Studi");
            System.out.println("4. Hitung Jumlah Pendaftar untuk Setiap Status");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1: tambahData(); break;
                case 2: tampilData(); break;
                case 3: cariProdi(); break;
                case 4: hitungStatus(); break;
                case 5: break;
                default: System.out.println("Pilihan tidak valid.");
            }

        } while (pilih != 5);
    }

    static void tambahData() {

        System.out.print("Nama Mahasiswa: ");
        String nama = sc.nextLine();

        System.out.print("NIM: ");
        String nim = sc.nextLine();

        System.out.print("Program Studi: ");
        String prodi = sc.nextLine();

        System.out.print("Perusahaan Tujuan Magang: ");
        String perusahaan = sc.nextLine();

        int semester;
        while (true) {
            System.out.print("Semester pengambilan magang (6 atau 7): ");
            semester = sc.nextInt();
            sc.nextLine();
            if (semester == 6 || semester == 7) break;
        }

        String status;
        while (true) {
            System.out.print("Status magang (Diterima/Menunggu/Ditolak): ");
            status = sc.nextLine();
            if (status.equalsIgnoreCase("Diterima") ||
                status.equalsIgnoreCase("Menunggu") ||
                status.equalsIgnoreCase("Ditolak")) break;
        }

        data[jumlah][0] = nama;
        data[jumlah][1] = nim;
        data[jumlah][2] = prodi;
        data[jumlah][3] = perusahaan;
        data[jumlah][4] = String.valueOf(semester);
        data[jumlah][5] = status;

        jumlah++;

        System.out.println("Data pendaftaran magang berhasil ditambahkan. Total pendaftar: " + jumlah);
    }

    static void tampilData() {

        if (jumlah == 0) {
            System.out.println("Belum ada pendaftar.");
            return;
        }

        for (int i = 0; i < jumlah; i++) {

            System.out.print((i + 1) + ". ");

            for (int j = 0; j < 6; j++) {
                System.out.print(data[i][j]);
                if (j < 5) System.out.print(" - ");
            }

            System.out.println();
        }
    }

    static void cariProdi() {

        System.out.print("Masukkan Program Studi: ");
        String prodiCari = sc.nextLine();

        boolean ada = false;

        System.out.println("No   Nama            NIM        Prodi                 Perusahaan          Semester   Status");

        for (int i = 0; i < jumlah; i++) {

            if (data[i][2].equalsIgnoreCase(prodiCari)) {

                String noSpasi = padRight(String.valueOf(i + 1), 4);
                String namaSpasi = padRight(data[i][0], 15);
                String nimSpasi = padRight(data[i][1], 10);
                String prodiSpasi = padRight(data[i][2], 20);
                String perusahaanSpasi = padRight(data[i][3], 20);
                String semesterSpasi = padRight(data[i][4], 10);
                String statusSpasi = padRight(data[i][5], 10);

                System.out.println(
                        noSpasi + " " +
                        namaSpasi +
                        " " + nimSpasi +
                        " " + prodiSpasi +
                        " " + perusahaanSpasi +
                        " " + semesterSpasi +
                        " " + statusSpasi
                );

                ada = true;
            }
        }

        if (!ada) {
            System.out.println("Tidak ada pendaftar.");
        }
    }

    static String padRight(String teks, int panjang) {
        while (teks.length() < panjang) {
            teks += " ";
        }
        return teks;
    }

    static void hitungStatus() {

        if (jumlah == 0) {
            System.out.println("Belum ada pendaftar.");
            return;
        }

        int diterima = 0, menunggu = 0, ditolak = 0;

        for (int i = 0; i < jumlah; i++) {
            if (data[i][5].equalsIgnoreCase("Diterima")) diterima++;
            else if (data[i][5].equalsIgnoreCase("Menunggu")) menunggu++;
            else if (data[i][5].equalsIgnoreCase("Ditolak")) ditolak++;
        }

        System.out.println("Diterima : " + diterima);
        System.out.println("Menunggu : " + menunggu);
        System.out.println("Ditolak : " + ditolak);
        System.out.println("Total pendaftar: " + jumlah);
    }
}
