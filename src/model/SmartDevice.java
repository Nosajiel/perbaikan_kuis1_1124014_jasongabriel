package src.model;

public abstract class SmartDevice {
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