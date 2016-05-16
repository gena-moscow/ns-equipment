package ru.nefrosovet.nsequipment;

public class Machine {
    private String physMachineName;
    private String serialNumber;
    private String physMachineStatusName;
    private String roomName;
    private String bedName;

    public Machine(String physMachineName, String serialNumber, String physMachineStatusName, String roomName, String bedName) {
        this.physMachineName = physMachineName;
        this.serialNumber = serialNumber;
        this.physMachineStatusName = physMachineStatusName;
        this.roomName = roomName;
        this.bedName = bedName;
    }

    public String getPhysMachineName() {
        return physMachineName;
    }

    public Machine setPhysMachineName(String physMachineName) {
        this.physMachineName = physMachineName;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Machine setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public String getPhysMachineStatusName() {
        return physMachineStatusName;
    }

    public Machine setPhysMachineStatusName(String physMachineStatusName) {
        this.physMachineStatusName = physMachineStatusName;
        return this;
    }

    public String getRoomName() {
        return roomName;
    }

    public Machine setRoomName(String roomName) {
        this.roomName = roomName;
        return this;
    }

    public String getBedName() {
        return bedName;
    }

    public Machine setBedName(String bedName) {
        this.bedName = bedName;
        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "Machine['%s', SN='%s', state='%s', loc='%s;%s']",
                physMachineName, serialNumber, physMachineStatusName, roomName, bedName);
    }

}

