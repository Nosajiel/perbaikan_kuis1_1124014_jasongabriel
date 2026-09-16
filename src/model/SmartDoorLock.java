package src.model;

public class SmartDoorLock extends SmartDevice implements Lockable {
    private String pin;
    private boolean locked;

    public SmartDoorLock(String id, String nama, int daya, String pin) {
        super(id, nama, daya);
        this.pin = pin;
        this.locked = false;
    }

    public String getPin() { return pin; }
    public boolean isLocked() { return locked; }

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