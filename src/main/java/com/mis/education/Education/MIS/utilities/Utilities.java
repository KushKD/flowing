package com.mis.education.Education.MIS.utilities;

import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.binary.Hex;


public class Utilities {

    public static Date convertStringToDate(String date) throws ParseException {
        String sDate1 = date;
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(sDate1);
        System.out.println(sDate1 + "\t" + date1);

        return date1;
    }

    public static final String createOtpMessage(String OTP) {

        return Constants.otp_Message + OTP;
    }


    public static final String getPhotoUrl(String imageName) {
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(imageName)
                .toUriString();
        return fileDownloadUri;
    }

    public static String base64Encode(String token) {
        byte[] encodedBytes = Base64Utils.encode(token.getBytes());
        return new String(encodedBytes, Charset.forName("UTF-8"));
    }


    public static String base64Decode(String token) {
        byte[] decodedBytes = Base64Utils.decode(token.getBytes());
        return new String(decodedBytes, Charset.forName("UTF-8"));
    }

    public static boolean ifEmptyField(String str) {
        if (str != null && !"".equals(str.trim()) && !"''".equals(str.trim()) && !"null".equals(str.trim())
                && !str.isEmpty() && !"0".equalsIgnoreCase(str.trim()))
            return true;

        return false;
    }

    public static String getClientIp(HttpServletRequest request) {
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }


    public static boolean positiveNegitive(Integer number) {
        if (number >= 0) {
            return true;
        } else if (number < 0) {
            return false;
        } else {
            return false;
        }
    }


    public static boolean verifyPaymentSignature(JSONObject attributes, String apiSecret)
            throws RazorpayException {
        String expectedSignature = attributes.getString("razorpay_signature");
        String orderId = attributes.getString("razorpay_order_id");
        String paymentId = attributes.getString("razorpay_payment_id");
        String payload = orderId + '|' + paymentId;
        return verifySignature(payload, expectedSignature, apiSecret);
    }

    public static boolean verifySignature(String payload, String expectedSignature, String secret)
            throws RazorpayException {
        String actualSignature = getHash(payload, secret);
        return isEqual(actualSignature.getBytes(), expectedSignature.getBytes());
    }

    public static String getHash(String payload, String secret) throws RazorpayException {
        Mac sha256_HMAC;
        try {
            sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] hash = sha256_HMAC.doFinal(payload.getBytes());
            return new String(Hex.encodeHex(hash));
        } catch (Exception e) {
            throw new RazorpayException(e.getMessage());
        }
    }

    private static boolean isEqual(byte[] a, byte[] b) {
        if (a.length != b.length) {
            return false;
        }
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result |= a[i] ^ b[i];
        }
        return result == 0;
    }
}


