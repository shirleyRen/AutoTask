package com.coofee.autotask;

import com.alibaba.fastjson.JSONObject;
import com.coofee.autotask.util.Request;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TaskStart {

    public static void main(String[] args) {
        try {
            String str = args[0];
            if(str != null){
                String[] strArr = str.split("\\|");
                new TaskStart().hlcheckin(strArr[0], strArr[1]);
            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {

        }
        try {
            String str = args[1];
            if(str != null){
                String[] strArr = str.split("\\|");
                new TaskStart().hlcheckin(strArr[0], strArr[1]);
            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {

        }


    }


    public void hlcheckin(String memberid, String token) {
        String url = "https://api.bhgmall.com.cn/checkIn/do?mallId=10000060080225";
        JSONObject jsonObject = Request.gethl(url, memberid, token);
        System.out.println(jsonObject.toJSONString());
    }

}
