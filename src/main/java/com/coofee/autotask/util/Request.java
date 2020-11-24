package com.coofee.autotask.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**
 * 封装的网络请求请求工具类
 */
public class Request {

    private Request(){};

    /**
     * 发送ldget请求
     */
    public static JSONObject getld(String url){
        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Host","longde.vdongchina.org.cn");
        httpGet.addHeader("Content-Type","application/x-www-form-urlencoded");
        httpGet.addHeader("Connection","keep-alive");
        httpGet.addHeader("User-Agent","Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 MicroMessenger/7.0.17(0x17001124) NetType/WIFI Language/zh_CN");
        httpGet.addHeader("Referer","https://servicewechat.com/wx81a41ea914f34b85/52/page-frame.html");
        HttpResponse resp = null;
        String respContent = null;
        try{
            resp = client.execute(httpGet);
            HttpEntity entity=null;
            if(resp.getStatusLine().getStatusCode()<400){
                entity = resp.getEntity();
            } else{
                entity = resp.getEntity();
            }
            respContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e){
        } finally {
            return JSONObject.parseObject(respContent);
        }
    }

    /**
     * 发送hlget请求
     */
    public static JSONObject gethl(String url,String memberId,String access_token){
        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Host","api.bhgmall.com.cn");
        httpGet.addHeader("User-Agent","Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 MicroMessenger/7.0.17(0x17001124) NetType/WIFI Language/zh_CN");
        httpGet.addHeader("Referer","https://servicewechat.com/wx1b1dda695dff82c8/121/page-frame.html");
        httpGet.addHeader("memberId",memberId);
        httpGet.addHeader("access_token",access_token);
        HttpResponse resp = null;
        String respContent = null;
        try{
            resp = client.execute(httpGet);
            HttpEntity entity=null;
            if(resp.getStatusLine().getStatusCode()<400){
                entity = resp.getEntity();
            } else{
                entity = resp.getEntity();
            }
            respContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e){
        } finally {
            return JSONObject.parseObject(respContent);
        }
    }

    /**
     * 发送post请求
     */
    public static JSONObject post(String url , String body){
        StringEntity entityBody = new StringEntity(body,"UTF-8");
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("connection","keep-alive");
        httpPost.addHeader("referer","https://www.bilibili.com/");
        httpPost.addHeader("accept","application/json, text/plain, */*");
        httpPost.addHeader("Content-Type","application/x-www-form-urlencoded");
        httpPost.addHeader("charset","UTF-8");
        httpPost.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36");
        httpPost.setEntity(entityBody);
        HttpResponse resp = null;
        String respContent = null;
        try{
            resp = client.execute(httpPost);
            HttpEntity entity=null;
            if(resp.getStatusLine().getStatusCode()<400){
                entity = resp.getEntity();
            } else{
                entity = resp.getEntity();
            }
            respContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e){
        }
        finally {
            return JSONObject.parseObject(respContent);
        }
    }
}
