import java.util.*;

public class pemdas27 {
    static Scanner input = new Scanner(System.in);
    // Nama : Azraf Azizullah
    // NIM : 25150707111028
    public static boolean sudahinputKRS = false;
    public static boolean sudahinputnilai = false;
    public static String[] namamatkul;
    public static int[] sks;
    public static int jumlahmatkul;
    public static double[] nilaimatkul;
    public static String nama;
    public static String NIM;
    public static int totalsks;
    public static String programstudi;
    public static String semester;

    public static void main(String[] args) {
        int pilih = 0;
        while (pilih != 9) {
            info();
            System.out.print("Pilih Menu = ");
            pilih = input.nextInt();
            switch (pilih) {
                case 0:
                    info();
                    break;
                case 1:
                    InputData();
                    break;
                case 2:
                    InputKRS();
                    break;
                case 3:
                    InputNilai();
                    break;
                case 4:
                    EditNilai();
                    break;
                case 5:
                    CetakKRS();
                    break;
                case 6:
                    CetakKHS();
                    break;
                case 9:
                    InfoExit();
                    break;
                default:
                    System.out.println("Pilihan Menu Tidak Ada");
            }
        }
    }

    public static void info() {
        System.out.println("-------------------------------------");
        System.out.println("Aplikasi KRS dan KHS Mahasiswa FILKOM");
        System.out.println("-------------------------------------");
        System.out.println("Pilihan Menu : ");
        System.out.println("1. Input Data Mahasiswa");
        System.out.println("2. Input KRS");
        System.out.println("3. Input Nilai");
        System.out.println("4. Edit Nilai");
        System.out.println("5. Cetak KRS");
        System.out.println("6. Cetak KHS");
        System.out.println("9. Keluar");
    };

    public static void InputData() {
        System.out.println("==============================");
        System.out.println("     INPUT DATA MAHASISWA");
        System.out.println("==============================");
        System.out.print("Masukkan Nama : ");
        input.nextLine();
        nama = input.nextLine();
        System.out.print("Masukkan NIM : ");
        NIM = input.nextLine();
        System.out.print("Masukkan Program Studi : ");
        programstudi = input.nextLine();
        System.out.print("Masukkan Semester : ");
        semester = input.nextLine();
    };

    public static void InputKRS() {
        System.out.println("===INPUT KRS===");
        System.out.print("Masukkan Jumlah Mata Kuliah : ");
        jumlahmatkul = input.nextInt();
        namamatkul = new String[jumlahmatkul];
        sks = new int[jumlahmatkul];
        for (int i = 0; i < jumlahmatkul; i++) {
            input.nextLine();
            System.out.printf("Masukkan Nama Mata Kuliah ke-%d :", (i + 1));
            namamatkul[i] = input.nextLine();
            System.out.printf("Masukkan SKS Mata Kuliah ke-%d :", (i + 1));
            sks[i] = input.nextInt();
            input.nextLine();
        }
        totalsks = 0;
        for (int i = 0; i < sks.length; i++) {
            totalsks += sks[i];
        }
        System.out.println("===INPUT SELESAI===");
        for (int i = 0; i < namamatkul.length; i++) {
            System.out.println(namamatkul[i]);
            System.out.println(sks[i]);
        }
        sudahinputKRS = true;
    };

    public static void InputNilai() {
        System.out.println("===INPUT NILAI===");
        if (sudahinputKRS) {
            nilaimatkul = new double[jumlahmatkul];
            for (int i = 0; i < nilaimatkul.length; i++) {
                System.out.printf("Masukkan Nilai Mata Kuliah %s : ", namamatkul[i]);
                nilaimatkul[i] = input.nextInt();
            }
            sudahinputnilai = true;
        } else {
            System.out.println("Data KRS belum diinput,\nSilahkan input KRS terlebih dahulu");
            System.out.println("============================================");
            System.out.println("\n\n");
        }
    }

    public static void EditNilai() {
        System.out.println("===EDIT NILAI===");
        if (sudahinputnilai) {
            for (int i = 0; i < namamatkul.length; i++) {
                System.out.printf("Ketik %d untuk mengedit Nilai Mata Kuliah %s\n", i + 1, namamatkul[i]);
            }
            System.out.print("Masukkan Angka : ");
            int angka = input.nextInt();
            if (angka <= namamatkul.length) {
                System.out.print("Edit Nilai Menjadi : ");
                nilaimatkul[angka - 1] = input.nextInt();
            } else {
                EditNilai();
            }
        } else {
            System.out.println("Data KRS belum diinput,\nSilahkan input KRS terlebih dahulu");
            System.out.println("============================================");
            System.out.println("\n\n");
        }
    };

    public static void CetakKRS() {
        System.out.println("=======================================");
        System.out.println("               CETAK KRS");
        System.out.println("=======================================");
        if (sudahinputKRS) {
            System.out.printf("Nama%12s: %s\n", " ", nama);
            System.out.printf("NIM%13s: %s\n", " ", NIM);
            System.out.printf("Program Studi%3s: %s\n", " ", programstudi);
            System.out.printf("Semester%8s: %s\n", " ", semester);
            System.out.println();
            System.out.println("No   Nama Mata Kuliah                SKS");
            System.out.println("-----------------------------------------");
            for (int i = 0; i < namamatkul.length; i++) {
                System.out.printf("%-5d%-33s%-4d\n", (i + 1), namamatkul[i], sks[i]);
            }
            System.out.println("-----------------------------------------");
            System.out.printf("%5sSKS Total%24s%d\n", " ", " ", totalsks);
            System.out.println("\n\n");

        } else {
            System.out.println("Data KRS belum diinput,\nSilahkan input KRS terlebih dahulu");
            System.out.println("============================================");
            System.out.println("\n\n");
        }
    };

    public static void CetakKHS() {
        System.out.println("============================================");
        System.out.println("                 CETAK KHS");
        System.out.println("============================================");
        if (sudahinputnilai) {
            double[] NxS = new double[jumlahmatkul];
            for (int i = 0; i < NxS.length; i++) {
                NxS[i] = sks[i] * nilaimatkul[i];
            }
            double NxStotal = 0.0;
            for (int i = 0; i < NxS.length; i++) {
                NxStotal += NxS[i];
            }
            double ipsemester = NxStotal / totalsks;
            int maxbebanstudi;
            if (ipsemester >= 3.00) {
                maxbebanstudi = 24;
            } else if (ipsemester >= 2.50) {
                maxbebanstudi = 21;
            } else if (ipsemester >= 2.00) {
                maxbebanstudi = 18;
            } else if (ipsemester >= 1.5) {
                maxbebanstudi = 15;
            } else {
                maxbebanstudi = 12;
            }
            System.out.printf("Nama%12s: %s\n", " ", nama);
            System.out.printf("NIM%13s: %s\n", " ", NIM);
            System.out.printf("Program Studi%3s: %s\n", " ", programstudi);
            System.out.printf("Semester%8s: %s\n", " ", semester);
            System.out.println();
            System.out.println("No   Nama Mata Kuliah              SKS  Nilai   NxS");
            System.out.println("-----------------------------------------------------");
            for (int i = 0; i < namamatkul.length; i++) {
                System.out.printf("%-5d%-31s%-4d%-7.2f%-5.2f\n", (i + 1), namamatkul[i], sks[i], nilaimatkul[i],
                        NxS[i]);
            }
            System.out.println("-----------------------------------------------------");
            System.out.printf("%5sTotal%26s%d%10s%-5.2f\n", " ", " ", totalsks, " ", NxStotal);
            System.out.println();
            System.out.printf("IP Semester\t: %-3.2f\n", ipsemester);
            System.out.printf("Beban Studi\t: maksimum %-2d SKS\n", maxbebanstudi);
            System.out.println("\n\n");
        } else {
            System.out.println("Data KRS belum diinput,\n Silahkan input KRS terlebih dahulu");
            System.out.println("============================================");
            System.out.println("\n\n");
        }
    };

    public static void InfoExit() {
        System.out.println("Terima Kasih Telah Menggunakan Aplikasi ini!");
    };

}