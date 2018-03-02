package com.example.cyt.howold;

import android.content.Context;
import android.graphics.Bitmap;
import android.provider.SyncStateContract;

import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;

import org.apache.http.HttpRequest;
import org.json.JSONObject;

/**
 * Created by CYT on 2018/3/2.
 */

public class FaceppDetect {

    public interface CallBack{

        void success(JSONObject result);

        void error(FaceppParseException exception);
    }

    public static void detect(final Bitmap bm,final CallBack callBack){

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpRequest request = (HttpRequest) new HttpRequests(Contant.KEY,Contant.SECRET,true,true);
            }
        });

    }
}
