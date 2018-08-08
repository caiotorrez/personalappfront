package com.personalapp.custom;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@SuppressWarnings("serial")
public class CustomURLEncoderDecoder implements Serializable {
	
    public static String encodeUTF8(String value){
        try {
            return value == null ? null : URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("UTF-8 not supported by this JVM");
        }
    }

    public static String decodeUTF8(String value){
        try {
            return value == null ? null : URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("UTF-8 not supported by this JVM");
        }
    }

}