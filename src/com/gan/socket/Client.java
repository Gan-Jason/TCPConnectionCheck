package com.gan.socket;

import java.io.*;
import java.net.Socket;
import java.util.Properties;


class CountTime implements Runnable {
    @Override
    public void run() {
        go();
    }

    private void go() {
        long startTime = System.currentTimeMillis();
        long timeOut = 0;
        while (timeOut < 1000) {
            timeOut = System.currentTimeMillis() - startTime;
        }
        System.out.println("Connect not successfully");
        System.exit(-1);
//        if(timeOut>=5)
//            throw Exception("Timeout");
    }
}

public class Client implements Runnable {
	private static final String PROPERTIES_NAME = "Configure.properties";
	public static String IP = null;
    public static int port=0;


    public static void main(String[] args) {
        FileInputStream in = null;
        try{
			Properties properties = new Properties();
			in = new FileInputStream(PROPERTIES_NAME);
			properties.load(in);
			IP = properties.getProperty("IP");
			port=Integer.parseInt(properties.getProperty("PORT"));
			//System.out.println("读取配置信息成功！");
			//System.out.println(IP);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("读取配置信息失败！");
		}finally{
			if(in != null){
				try{
					in.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}

        Client c = new Client();
        CountTime countTime = new CountTime();
        Thread thread1 = new Thread(c), thread2 = new Thread(countTime);
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        go();
    }

    private void go() {
        try {
            //www.jasongan.xyz
            Socket so = new Socket(Client.IP, Client.port);
            if (so.isConnected()) {
                System.out.println("Connected successfully");
                System.exit(1);
            }

//            InputStreamReader stream = new InputStreamReader(so.getInputStream());
//            BufferedReader reader = new BufferedReader(stream);
//
//            String advice = reader.readLine();
//            System.out.println("Today you should:" + advice);
//            reader.close();

        } catch (IOException ex) {
            System.out.println("Connect refused!");
            System.exit(-2);

        }
    }
}
