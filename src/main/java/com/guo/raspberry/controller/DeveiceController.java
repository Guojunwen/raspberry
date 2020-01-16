package com.guo.raspberry.controller;

import com.guo.raspberry.bean.DeviceInfo;
import com.guo.raspberry.util.CommonUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Dictionary;

/**
 * @Author 过俊文
 * @Description 设备信息管理
 * @Date 2020/1/15
 **/
@RestController
@RequestMapping("device")
public class DeveiceController {

    //获取CPU温度
    private final static String TEMP = "vcgencmd measure_temp";
    //内存情况
    private final static String RAM = "free";
    //CPU使用率
    private final static String CPU = "top -n1 | awk '/Cpu\\(s\\):/ {print $2}'";
    //硬盘
    private final static String DISK = "df -h /";

    @RequestMapping("/getInfo")
    public DeviceInfo getInfo() throws IOException {
        String tempResult = CommonUtil.exeCmd(TEMP);
        tempResult = tempResult.replaceAll("temp=", "").replaceAll("", "'C\\n");

        String ramResult = CommonUtil.exeCmd(RAM);
        String[] ramResultArray = ramResult.trim().split("\\s+");
        Integer totalRam = Integer.parseInt(ramResultArray[8].trim());
        Integer usedRam = Integer.parseInt(ramResultArray[9].trim());
        Integer freeRam = Integer.parseInt(ramResultArray[10].trim());

        String cpuResult = CommonUtil.exeCmd(CPU);
        String diskResult = CommonUtil.exeCmd(DISK);

        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setTemp(tempResult);
        deviceInfo.setTotalRam(totalRam / 1000 + " MB");
        deviceInfo.setUsedRam(usedRam / 1000 + " MB");
        deviceInfo.setFreeRam(freeRam / 1000 + " MB");

        deviceInfo.setCpu(cpuResult);

        String[] diskResultArray = diskResult.trim().split("\\s+");
        deviceInfo.setTotalDisk(diskResultArray[7]);
        deviceInfo.setUsedDisk(diskResultArray[8]);
        deviceInfo.setFreeDisk(diskResultArray[9]);
        deviceInfo.setPreDisk(diskResultArray[10]);

        return deviceInfo;
    }

    @RequestMapping("/test")
    public String test(String cmd) throws IOException {
        String result = CommonUtil.exeCmd(CPU);
        return result;
    }

    @RequestMapping("/cmd")
    public String cmd(String cmd) throws IOException {
        return CommonUtil.exeCmd(cmd);
    }

    public static void main(String[] args) {
        String str = "total used free shared buffers cached Mem: 947848 537264 410584 26228 84336 230332 -/+ buffers/cache: 222596 725252 Swap: 102396 0 102396";
        String[] strArray = str.split(" ");

        System.out.println(strArray[7]);
    }
}
