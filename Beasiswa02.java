import java.util.Scanner;
public class Beasiswa02 {

    static Scanner sc = new Scanner(System.in);

    static final int MAX = 100;
    static String[][] data = new String[MAX][5];
    static int jumlah = 0;

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        int pilih;

        do {
            System.out.println("\n=== Sistem Pendaftaran Beasiswa ===");
            System.out.println("1. Tambah Data Pendaftar Beasiswa");
            System.out.println("2. Tampilkan Semua Pendaftar");
            System.out.println("3. Cari Pendaftar berdasarkan Jenis Beasiswa");
            System.out.println("4. Hitung Rata-rata IPK per Jenis Beasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilData();
                    break;
                case 3:
                    cariJenis();
                    break;
                case 4:
                    rataRata();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilih != 5);
    }

    static void tambahData() {

        System.out.print("Nama Mahasiswa: ");
        String nama = sc.nextLine();

        System.out.print("NIM: ");
        String nim = sc.nextLine();

        System.out.print("IPK terakhir: ");
        String ipk = sc.nextLine();

        System.out.print("Jenis Beasiswa (Reguler/Unggulan/Riset): ");
        String jenis = sc.nextLine();

        System.out.print("Penghasilan orang tua (maksimal 2000000): ");
        int penghasilan = sc.nextInt();
        sc.nextLine();

        if (penghasilan > 2000000) {
            System.out.println("Pendaftaran dibatalkan karena penghasilan melebihi batas maksimal.");
            return;
        }

        data[jumlah][0] = nama;
        data[jumlah][1] = nim;
        data[jumlah][2] = ipk;
        data[jumlah][3] = jenis;
        data[jumlah][4] = String.valueOf(penghasilan);

        jumlah++;

        System.out.println("Pendaftar berhasil disimpan. Total pendaftar: " + jumlah);
    }

    static void tampilData() {

        if (jumlah == 0) {
            System.out.println("Belum ada pendaftar.");
            return;
        }

        for (int i = 0; i < jumlah; i++) {
            System.out.println((i + 1) + ". "
                    + data[i][0] + " - "
                    + data[i][3] + " - IPK: "
                    + data[i][2]);
        }
    }

    static void cariJenis() {

        System.out.print("Jenis Beasiswa (Reguler/Unggulan/Riset): ");
        String jenisCari = sc.nextLine();

        boolean ada = false;

        for (int i = 0; i < jumlah; i++) {

            if (data[i][3].equalsIgnoreCase(jenisCari)) {
                System.out.println((i + 1) + ". "
                        + data[i][0] + " - "
                        + data[i][3] + " - IPK: "
                        + data[i][2]);
                ada = true;
            }
        }

        if (!ada) {
            System.out.println("Tidak ada pendaftar.");
        }
    }

    static void rataRata() {

        double totalR = 0, totalU = 0, totalRi = 0;
        int countR = 0, countU = 0, countRi = 0;

        for (int i = 0; i < jumlah; i++) {

            if (data[i][3].equalsIgnoreCase("Reguler")) {
                totalR += Double.parseDouble(data[i][2]);
                countR++;
            }

            if (data[i][3].equalsIgnoreCase("Unggulan")) {
                totalU += Double.parseDouble(data[i][2]);
                countU++;
            }

            if (data[i][3].equalsIgnoreCase("Riset")) {
                totalRi += Double.parseDouble(data[i][2]);
                countRi++;
            }
        }

        if (countR > 0)
            System.out.println("Reguler : rata-rata IPK = " + (totalR / countR));
        else
            System.out.println("Reguler : tidak ada pendaftar.");

        if (countU > 0)
            System.out.println("Unggulan : rata-rata IPK = " + (totalU / countU));
        else
            System.out.println("Unggulan : tidak ada pendaftar.");

        if (countRi > 0)
            System.out.println("Riset : rata-rata IPK = " + (totalRi / countRi));
        else
            System.out.println("Riset : tidak ada pendaftar.");
    }
}
