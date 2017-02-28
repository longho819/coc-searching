package com.longho.cocsearch.services;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

/**
 * Created by leho on 2/26/17.
 */
public class IPAddress {

    public String getIpAddress() {
        try{
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));

            String ip = in.readLine(); //you get the IP as a String
            return ip;
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return null;
    }

    public static void main(String[] agrs){
        IPAddress ip =  new IPAddress();
        System.out.println(ip.getIpAddress());
    }
}
