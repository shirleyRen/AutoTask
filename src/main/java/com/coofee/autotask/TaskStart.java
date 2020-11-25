package com.coofee.autotask;

import com.alibaba.fastjson.JSONObject;
import com.coofee.autotask.util.Request;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TaskStart {

    public static void main(String[] args) {
        String user1token = args[0];
        if (user1token != null) {
            new TaskStart().ldsignin(user1token);
        }
        String user2token = args[1];
        if (user2token != null) {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException ie) {
            }
            new TaskStart().ldsignin(user2token);
        }
        try {
            String str = args[2];
            if(str != null){
                String[] strArr = str.split("\\|");
                new TaskStart().hlcheckin(strArr[0], strArr[1]);
            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {

        }
        try {
            String str = args[3];
            if(str != null){
                String[] strArr = str.split("\\|");
                new TaskStart().hlcheckin(strArr[0], strArr[1]);
            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {

        }


    }

    public void ldsignin(String token) {
        String url = "https://longde.vdongchina.org.cn/addons/zjhj_mall/core/web/index.php?_acid=3&r=api/integralmall/integralmall/register&access_token=" + token + "&_version=2.8.9&_platform=wx";
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        url = url + "&today=" + dateFormat.format(date);
        JSONObject jsonObject = Request.getld(url);
        System.out.println(jsonObject.toJSONString());
    }

    public void hlcheckin(String memberid, String token) {
        String url = "https://api.bhgmall.com.cn/checkIn/do?mallId=10000060080225";
        JSONObject jsonObject = Request.gethl(url, memberid, token);
        System.out.println(jsonObject.toJSONString());
    }

}
