package com.mercadolibre.vestime;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;

public class MylocalData {
	
	public static Context context;
	
	public JSONObject itemsMensNews;
	
	public int itemsMensLong;
	
	public JSONArray jsonItemData;
	
	public String strUrl;
	
	ArrayList<Bitmap> bitmapArray = new ArrayList<Bitmap>();
	
	public JSONArray arrItems;

    private static MylocalData mInstance= null;
    
    public ArrayList<HashMap<String, String>> products;
	
	//ArrayList<HashMap<Integer,String>>  mStringList= new ArrayList<HashMap<Integer,String>>();
	
	//ArrayList<HashMap<String,String>>  mStringListCiudad= new ArrayList<HashMap<String,String>>();
	
	public String[] array_spinner_provincias;
	public String[] array_spinner_ciudad;
	public String[] array_spinner_provincias_id;
    
    
    public static synchronized MylocalData getInstance(){

        if(null == mInstance){

                mInstance = new MylocalData();

        }

        return mInstance;
    }
    
    
}