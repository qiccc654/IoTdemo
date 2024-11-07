package com.briup.smart.env.client;

import com.briup.smart.env.entity.Environment;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

public class GatherImpl implements Gather {
    @Override
    public Collection<Environment> gather() throws Exception {


        ArrayList<Environment> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("evn_gather_impl/src/main/resources/data-file-simple.txt"));){
            String str = null;
            while ((str= br.readLine())!=null){
                String[] arr = str.split("[|]");
                //将数据封装到Environment对象中
                Environment environment = new Environment();
                //设置发送端id
                environment.setSrcId(arr[0]);
                //设置树莓派系统id
                environment.setDesId(arr[1]);
                //设置实验箱区域模块id(1-8)
                environment.setDevId(arr[2]);
                //设置模块上传感器地址
                environment.setSersorAddress(arr[3]);
                //设置传感器个数 String转int
                environment.setCount(Integer.parseInt(arr[4]));
                //设置发送指令标号 3表示接收数据 16表示发送命令
                environment.setCmd(arr[5]);
                //设置状态(默认1,表示成功) String类型转换为int类型
                environment.setStatus(Integer.parseInt(arr[7]));
                //设置采集时间 时间戳 String转long
                environment.setGather_date(new Timestamp(Long.parseLong(arr[9])));

                list.add(environment);
            }
            list.forEach(System.out::println);

        }catch (Exception e ){
            e.printStackTrace();
        }

        return null;
    }
}
