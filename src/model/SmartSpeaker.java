package src.model;

public class SmartSpeaker extends SmartDevice implements Connectable, Switchable {
    private int volume;
    private ConnectionType connection;

    public SmartSpeaker(String id, String nama, int daya, int volume) {
        super(id, nama, daya);
        this.volume = volume;
        this.connection = ConnectionType.NONE;
    }

    public int getVolume() { return volume; }
    public ConnectionType getConnection() { return connection; }

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