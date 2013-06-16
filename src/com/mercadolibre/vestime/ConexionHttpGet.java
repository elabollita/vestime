package com.mercadolibre.vestime;

import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

public class ConexionHttpGet {
	
	private DefaultHttpClient httpClient = new DefaultHttpClient();
    HttpGet request = new HttpGet();
    InputStream content = null;

    public int getNovedades() throws Exception {
    	int longJson;
    	MylocalData.getInstance().strUrl = "https://api.mercadolibre.com/sites/MLA/search?q=hombre&category=MLA1430";
    	//MylocalData.getInstance().strUrl = "https://api.mercadolib";
    	String url = MylocalData.getInstance().strUrl;
 
    	HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = httpclient.execute(new HttpGet(url));
        StatusLine statusLine = response.getStatusLine();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        response.getEntity().writeTo(out);
        out.close();
        String responseString = out.toString();
        
        if(responseString != "" || responseString != null){
        	
        	MylocalData.getInstance().itemsMensNews = new JSONObject(responseString);
            
            MylocalData.getInstance().jsonItemData = MylocalData.getInstance().itemsMensNews.getJSONArray("results");
            
            MylocalData.getInstance().itemsMensLong = MylocalData.getInstance().jsonItemData.length();
            
            longJson = MylocalData.getInstance().itemsMensNews.length();
            
            MylocalData.getInstance().products = new ArrayList<HashMap<String, String>>();
            
            for(int i = 0; i < MylocalData.getInstance().itemsMensLong; i++){
    			HashMap<String, String> item = new HashMap<String, String>();
    			JSONObject pData =new JSONObject();
    			pData = (JSONObject) MylocalData.getInstance().jsonItemData.get(i);
    			item.put("id", String.valueOf(i));
    			item.put("prodId", pData.getString("id"));
    			item.put("siteId", pData.getString("site_id"));
    			item.put("prodTitle", pData.getString("title"));
    			item.put("prodThumb", pData.getString("thumbnail"));
    			item.put("prodPrice", String.valueOf(pData.getDouble("price")));
    			MylocalData.getInstance().products.add(item);
    			String urlImageStr = pData.getString("thumbnail");
    			urlImageStr = urlImageStr.replace("MLA_v_I_f", "MLA_v_Y_f");
    			URL urlImage = new URL(urlImageStr);
				Bitmap bmp = BitmapFactory.decodeStream(urlImage.openConnection().getInputStream());
    			MylocalData.getInstance().bitmapArray.add(bmp);
    			
    			//System.out.println("lugares: "+MylocalData.getInstance().products.size());
     		}
            
            return 1;
            
        }else{
        	
        	return 0;
        	
        }
        
        

        

    }


}
