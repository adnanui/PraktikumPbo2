import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah siswa: ");
        int jumlahSiswa = scanner.nextInt();
        scanner.nextLine();

        Student[] students = new Student[jumlahSiswa];

        for (int i = 0; i < jumlahSiswa; i++) {
            System.out.println("\nData siswa ke-" + (i + 1));

            System.out.print("Masukkan nama: ");
            String name = scanner.nextLine();

            System.out.print("Masukkan nilai: ");
            double score = scanner.nextDouble();
            scanner.nextLine();

            students[i] = new Student(name, score);
        }

        for (int i = 0; i < jumlahSiswa; i++) {
            students[i].checkPassed();
        }

        double totalScore = 0;
        int passedCount = 0;
        int failedCount = 0;

        System.out.println("\n=== HASIL DATA SISWA ===");

        for (int i = 0; i < jumlahSiswa; i++) {
            String status;

            if (students[i].passed) {
                status = "Lulus";
                passedCount++;
            } else {
                status = "Tidak Lulus";
                failedCount++;
            }

            totalScore += students[i].score;

            System.out.println(
                "Siswa: " + students[i].name
                + " - Nilai: " + students[i].score
                + " - " + status
            );
        }

        double average = totalScore / jumlahSiswa;

        System.out.printf("%nRata-rata nilai kelas: %.2f%n", average);
        System.out.println("Jumlah siswa lulus: " + passedCount);
        System.out.println("Jumlah siswa tidak lulus: " + failedCount);

        scanner.close();
    }
}