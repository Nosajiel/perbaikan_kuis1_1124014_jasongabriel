import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum ConnectionType {
    WIFI, BLUETOOTH, NONE
}

interface Connectable {
    void connect(ConnectionType type);

    void disconnect();
}

interface Switchable {
    void turnOn();

    void turnOff();
}

interface Lockable {
    void lock();

    void unlock();
}

abstract class SmartDevice {
    private String id;
    private String nama;
    private int daya;
    private String status;

    public SmartDevice(String id, String nama, int daya) {
        this.id = id;
        this.nama = nama;
        this.daya = daya;
        this.status = "OFF";
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getDaya() {
        return daya;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract String getDeviceDetails();
}

class SmartTV extends SmartDevice implements Switchable, Connectable {
    private int channel;
    private int volume;
    private ConnectionType connection;

    public SmartTV(String id, String nama, int daya, int channel, int volume) {
        super(id, nama, daya);
        this.channel = channel;
        this.volume = volume;
        this.connection = ConnectionType.NONE;
    }

    public int getChannel() {
        return channel;
    }

    public int getVolume() {
        return volume;
    }

    public ConnectionType getConnection() {
        return connection;
    }

    @Override
    public void turnOn() {
        setStatus("ON");
        System.out.println(getNama() + " dinyalakan.");
    }

    @Override
    public void turnOff() {
        setStatus("OFF");
        System.out.println(getNama() + " dimatikan.");
    }

    @Override
    public void connect(ConnectionType type) {
        this.connection = type;
        System.out.println(getNama() + " terhubung via " + type);
    }

    @Override
    public void disconnect() {
        this.connection = ConnectionType.NONE;
        System.out.println(getNama() + " terputus dari jaringan.");
    }

    @Override
    public String getDeviceDetails() {
        return "[SmartTV] ID=" + getId() + ", Nama=" + getNama() + ", Daya=" + getDaya() +
                "W, Status=" + getStatus() + ", Channel=" + channel +
                ", Volume=" + volume + ", Koneksi=" + connection;
    }
}

class SmartSpeaker extends SmartDevice implements Connectable, Switchable {
    private int volume;
    private ConnectionType connection;

    public SmartSpeaker(String id, String nama, int daya, int volume) {
        super(id, nama, daya);
        this.volume = volume;
        this.connection = ConnectionType.NONE;
    }

    public int getVolume() {
        return volume;
    }

    public ConnectionType getConnection() {
        return connection;
    }

    @Override
    public void turnOn() {
        setStatus("ON");
        System.out.println(getNama() + " dinyalakan.");
    }

    @Override
    public void turnOff() {
        setStatus("OFF");
        System.out.println(getNama() + " dimatikan.");
    }

    @Override
    public void connect(ConnectionType type) {
        this.connection = type;
        System.out.println(getNama() + " terhubung via " + type);
    }

    @Override
    public void disconnect() {
        this.connection = ConnectionType.NONE;
        System.out.println(getNama() + " terputus dari jaringan.");
    }

    @Override
    public String getDeviceDetails() {
        return "[SmartSpeaker] ID=" + getId() + ", Nama=" + getNama() + ", Daya=" + getDaya() +
                "W, Status=" + getStatus() + ", Volume=" + volume +
                ", Koneksi=" + connection;
    }
}

class SmartDoorLock extends SmartDevice implements Lockable {
    private String pin;
    private boolean locked;

    public SmartDoorLock(String id, String nama, int daya, String pin) {
        super(id, nama, daya);
        this.pin = pin;
        this.locked = false;
    }

    public String getPin() {
        return pin;
    }

    public boolean isLocked() {
        return locked;
    }

    @Override
    public void lock() {
        this.locked = true;
        setStatus("LOCKED");
        System.out.println(getNama() + " terkunci.");
    }

    @Override
    public void unlock() {
        this.locked = false;
        setStatus("UNLOCKED");
        System.out.println(getNama() + " terbuka.");
    }

    @Override
    public String getDeviceDetails() {
        return "[SmartDoorLock] ID=" + getId() + ", Nama=" + getNama() + ", Daya=" + getDaya() +
                "W, Status=" + getStatus() + ", PIN=****, Locked=" + locked;
    }
}

class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Input tidak valid, masukkan angka: ");
            scanner.next();
        }
        int nilai = scanner.nextInt();
        scanner.nextLine();
        return nilai;
    }

    public static String readLine() {
        return scanner.nextLine();
    }
}

public class perbaikan_kuis1_1124014_jasongabriel {

    private static final List<SmartDevice> devices = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("Pilih menu: ");
            int input = InputUtil.readInt();

            switch (input) {
                case 1:
                    tambahDevice();
                    break;
                case 2:
                    tampilkanSemuaDevice();
                    break;
                case 0:
                    System.out.println("Terima kasih");
                    return;
                default:
                    System.out.println("Menu tidak dikenal, coba lagi");
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("SMART HOME MENU");
        System.out.println("1. Tambah Perangkat");
        System.out.println("2. Lihat Semua Perangkat");
        System.out.println("0. Keluar");
    }

    private static void tambahDevice() {
        System.out.println();
        System.out.println("Pilih jenis perangkat:");
        System.out.println("1. SmartTV");
        System.out.println("2. SmartSpeaker");
        System.out.println("3. SmartDoorLock");
        System.out.print("Jenis: ");
        int jenis = InputUtil.readInt();

        System.out.print("ID perangkat: ");
        String id = InputUtil.readLine();

        System.out.print("Nama perangkat: ");
        String nama = InputUtil.readLine();

        System.out.print("Daya (W): ");
        int daya = InputUtil.readInt();

        switch (jenis) {
            case 1: {
                System.out.print("Channel: ");
                int channel = InputUtil.readInt();
                System.out.print("Volume: ");
                int volume = InputUtil.readInt();
                devices.add(new SmartTV(id, nama, daya, channel, volume));
                System.out.println("SmartTV berhasil ditambahkan.");
                break;
            }
            case 2: {
                System.out.print("Volume: ");
                int volume = InputUtil.readInt();
                devices.add(new SmartSpeaker(id, nama, daya, volume));
                System.out.println("SmartSpeaker berhasil ditambahkan.");
                break;
            }
            case 3: {
                System.out.print("PIN: ");
                String pin = InputUtil.readLine();
                devices.add(new SmartDoorLock(id, nama, daya, pin));
                System.out.println("SmartDoorLock berhasil ditambahkan.");
                break;
            }
            default:
                System.out.println("Jenis perangkat tidak dikenal.");
        }
    }

    private static void tampilkanSemuaDevice() {
        System.out.println();
        System.out.println("DAFTAR PERANGKAT");
        if (devices.isEmpty()) {
            System.out.println("Belum ada perangkat.");
            return;
        }

        for (int i = 0; i < devices.size(); i++) {
            SmartDevice d = devices.get(i);
            System.out.println((i + 1) + ". " + d.getDeviceDetails());
        }
    }
}