package com.qiatu.operate.app.common;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

/**
 * Created by chechi on 15-1-20.
 */
public class AppUtils {

    /**
     * 二进制转十六进制字符串
     *
     * @param bytes
     * @return
     */
    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toLowerCase());
        }
        return sign.toString();
    }

    private static byte[] getMD5Digest(String data) throws IOException {
        byte[] bytes;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            bytes = md.digest(data.getBytes("utf-8"));
        } catch (GeneralSecurityException ex) {
            throw new IOException(ex.getMessage());
        }
        return bytes;
    }


    public static String sign(String params) {
        try {
            return byte2hex(getMD5Digest(params));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
