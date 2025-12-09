import java.util.Scanner;
public class Beasiswa02 {

    static Scanner sc = new Scanner(System.in);
    static final int MAX = 100;

    static String[] nama = new String[MAX];
    static String[] nim = new String[MAX];
    static double[] ipk = new double[MAX];
    static String[] jenis = new String[MAX];
    static int[] penghasilan = new int[MAX];

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
        String n = sc.nextLine();

        System.out.print("NIM: ");
        String nm = sc.nextLine();

        System.out.print("IPK terakhir: ");
        double ip = sc.nextDouble();
        sc.nextLine();

        System.out.print("Jenis Beasiswa (Reguler/Unggulan/Riset): ");
        String jb = sc.nextLine();

        System.out.print("Penghasilan orang tua (maksimal 2000000): ");
        int pg = sc.nextInt();
        sc.nextLine();

        if (pg > 2000000) {
            System.out.println("Pendaftaran dibatalkan karena penghasilan melebihi batas maksimal.");
            return;
        }

        nama[jumlah] = n;
        nim[jumlah] = nm;
        ipk[jumlah] = ip;
        jenis[jumlah] = jb;
        penghasilan[jumlah] = pg;

        jumlah++;

        System.out.println("Pendaftar berhasil disimpan. Total pendaftar: " + jumlah);
    }

    static void tampilData() {

        if (jumlah == 0) {
            System.out.println("Belum ada pendaftar.");
            return;
        }

        for (int i = 0; i < jumlah; i++) {
            System.out.println((i + 1) + ". " + nama[i] + " - " + jenis[i] + " - IPK: " + ipk[i]);
        }
    }

    static void cariJenis() {

        System.out.print("Jenis Beasiswa (Reguler/Unggulan/Riset): ");
        String j = sc.nextLine();

        boolean ada = false;

        for (int i = 0; i < jumlah; i++) {
            if (jenis[i].equalsIgnoreCase(j)) {
                System.out.println((i + 1) + ". " + nama[i] + " - " + jenis[i] + " - IPK: " + ipk[i]);
                ada = true;
            }
        }

        if (!ada) {
            System.out.println("Tidak ada pendaftar.");
        }
    }

    static void rataRata() {
        double totalR, totalU, totalRi;
        totalR = totalU = totalRi = 0;

        int countR = 0, countU = 0, countRi = 0;

        for (int i = 0; i < jumlah; i++) {
            if (jenis[i].equalsIgnoreCase("Reguler")) {
                totalR += ipk[i];
                countR++;
            }
            if (jenis[i].equalsIgnoreCase("Unggulan")) {
                totalU += ipk[i];
                countU++;
            }
            if (jenis[i].equalsIgnoreCase("Riset")) {
                totalRi += ipk[i];
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
