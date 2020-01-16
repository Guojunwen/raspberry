package com.guo.raspberry.bean;

/**
 * @Author 过俊文
 * @Description 设备信息
 * @Date 2020/1/15
 **/

public class DeviceInfo {
    private String temp;

    private String totalRam;

    private String usedRam;

    private String freeRam;

    private String cpu;

    private String totalDisk;

    private String usedDisk;

    private String freeDisk;

    private String preDisk;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTotalRam() {
        return totalRam;
    }

    public void setTotalRam(String totalRam) {
        this.totalRam = totalRam;
    }

    public String getUsedRam() {
        return usedRam;
    }

    public void setUsedRam(String usedRam) {
        this.usedRam = usedRam;
    }

    public String getFreeRam() {
        return freeRam;
    }

    public void setFreeRam(String freeRam) {
        this.freeRam = freeRam;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getTotalDisk() {
        return totalDisk;
    }

    public void setTotalDisk(String totalDisk) {
        this.totalDisk = totalDisk;
    }

    public String getUsedDisk() {
        return usedDisk;
    }

    public void setUsedDisk(String usedDisk) {
        this.usedDisk = usedDisk;
    }

    public String getFreeDisk() {
        return freeDisk;
    }

    public void setFreeDisk(String freeDisk) {
        this.freeDisk = freeDisk;
    }

    public String getPreDisk() {
        return preDisk;
    }

    public void setPreDisk(String preDisk) {
        this.preDisk = preDisk;
    }
}
