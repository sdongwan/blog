package com.sdongwan.blog.util;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/23.
 */
public class MethodUtil {


    public static String getIPAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarder-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String nowTime = simpleDateFormat.format(new Date(System.currentTimeMillis()));
        return nowTime;
    }

    public static void upload(String uploadPath, String saveName, File file) {
        if (!new File(uploadPath).exists()) {
            new File(uploadPath).mkdirs();
        }

        File saveFile = new File(uploadPath, saveName);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(saveFile);
            byte buffer[] = new byte[1024];
            int length = 0;
            while ((length = fis.read(buffer)) > 0) {

                fos.write(buffer, 0, length);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件上传失败");
        } finally {
            close(fos, fis);
        }

    }


    public static void close(FileOutputStream fos, FileInputStream fis) {
        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("fos关闭失败");
            }
        }

        if (fis != null) {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("fis关闭失败");
            }
        }


    }

}
