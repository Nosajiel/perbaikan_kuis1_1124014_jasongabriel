package src.controller;

import java.util.ArrayList;
import java.util.List;
import src.model.SmartDevice;
import src.model.SmartDoorLock;
import src.model.SmartSpeaker;
import src.model.SmartTV;

public class SmartHomeController {

    private final List<SmartDevice> devices = new ArrayList<>();

    public void addTV(String id, String nama, int daya, int channel, int volume) {
        devices.add(new SmartTV(id, nama, daya, channel, volume));
    }

    public void addSpeaker(String id, String nama, int daya, int volume) {
        devices.add(new SmartSpeaker(id, nama, daya, volume));
    }

    public void addDoorLock(String id, String nama, int daya, String pin) {
        devices.add(new SmartDoorLock(id, nama, daya, pin));
    }

    public List<String> getAllDeviceDetails() {
        List<String> details = new ArrayList<>();
        for (int i = 0; i < devices.size(); i++) {
            SmartDevice d = devices.get(i);
            details.add(d.getDeviceDetails());
        }
        return details;
    }

    public boolean isEmpty() {
        return devices.isEmpty();
    }
}