package src.view;

import java.util.List;
import java.util.Scanner;
import src.controller.SmartHomeController;

public class SmartHomeView {

    private final Scanner scanner = new Scanner(System.in);
    private final SmartHomeController controller = new SmartHomeController();

    public static void main(String[] args) {
        SmartHomeView view = new SmartHomeView();
        view.run();
    }

    public void run() {
        while (true) {
            showMainMenu();
            int input = askInt("Pilih menu: ");

            switch (input) {
                case 1:
                    tambahDevice();
                    break;
                case 2:
                    tampilkanSemuaDevice();
                    break;
                case 0:
                    showMessage("Terima kasih");
                    return;
                default:
                    showMessage("Menu tidak dikenal, coba lagi");
            }
        }
    }

    private void showMainMenu() {
        System.out.println();
        System.out.println("SMART HOME MENU");
        System.out.println("1. Tambah Perangkat");
        System.out.println("2. Lihat Semua Perangkat");
        System.out.println("0. Keluar");
    }

    private void showDeviceTypeMenu() {
        System.out.println();
        System.out.println("Pilih jenis perangkat:");
        System.out.println("1. SmartTV");
        System.out.println("2. SmartSpeaker");
        System.out.println("3. SmartDoorLock");
    }

    private int askInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Input tidak valid, masukkan angka: ");
            scanner.next();
        }
        int nilai = scanner.nextInt();
        scanner.nextLine();
        return nilai;
    }

    private String askString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private void showMessage(String msg) {
        System.out.println(msg);
    }

 private void tambahDevice() {
        showDeviceTypeMenu();
        int jenis = askInt("Jenis: ");

        String id = askString("ID perangkat: ");
        String nama = askString("Nama perangkat: ");
        int daya = askInt("Daya (W): ");

        switch (jenis) {
            case 1: {
                int channel = askInt("Channel: ");
                int volume = askInt("Volume: ");
                controller.addTV(id, nama, daya, channel, volume);
                showMessage("SmartTV berhasil ditambahkan.");
                break;
            }
            case 2: {
                int volume = askInt("Volume: ");
                controller.addSpeaker(id, nama, daya, volume);
                showMessage("SmartSpeaker berhasil ditambahkan.");
                break;
            }
            case 3: {
                String pin = askString("PIN: ");
                controller.addDoorLock(id, nama, daya, pin);
                showMessage("SmartDoorLock berhasil ditambahkan.");
                break;
            }
            default:
                showMessage("Jenis perangkat tidak dikenal.");
        }
    }

    private void tampilkanSemuaDevice() {
        System.out.println();
        System.out.println("DAFTAR PERANGKAT");

        if (controller.isEmpty()) {
            System.out.println("Belum ada perangkat.");
            return;
        }

        List<String> details = controller.getAllDeviceDetails();
        for (int i = 0; i < details.size(); i++) {
            System.out.println((i + 1) + ". " + details.get(i));
        }
    }
}