package src.model;

public class SmartTV extends SmartDevice implements Switchable, Connectable {
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