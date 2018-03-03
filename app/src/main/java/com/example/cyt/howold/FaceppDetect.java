package com.example.cyt.howold;

import android.content.Context;
import android.graphics.Bitmap;
import android.provider.SyncStateContract;

import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;

import org.apache.http.HttpRequest;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

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

                try {
                    HttpRequests request = (HttpRequests) new HttpRequests(Contant.KEY,Contant.SECRET,true,true);
                    Bitmap bmSmall = Bitmap.createBitmap(bm,0,0,bm.getWidth(),bm.getHeight());
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bmSmall.compress(Bitmap.CompressFormat.JPEG,100,stream);

                    byte[] arrays = stream.toByteArray();

                    PostParameters parameters = new PostParameters();
                    parameters.setImg(arrays);
                    JSONObject jsonObject = request.detectionDetect(parameters);

                    if (callBack != null){
                        callBack.success(jsonObject);
                    }

                } catch (FaceppParseException e) {
                    e.printStackTrace();
                    if (callBack != null){
                        callBack.error(e);
                    }
                }
            }
        }).start();

    }
}
