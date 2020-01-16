package com.guo.raspberry.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 过俊文
 * @Description 工具类
 * @Date 2020/1/15
 **/

public class CommonUtil {

    public static String exeCmd(String commandStr) throws IOException {
        StringBuilder sb = new StringBuilder();
        Process p = Runtime.getRuntime().exec(commandStr);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"GBK"));) {
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
        }
        return sb.toString();
    }
}
