package com.example.m2;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Environment;
import android.graphics.Bitmap;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void captureImage(){
    	//captures screen image
    	String Path = Environment.getExternalStorageDirectory().toString() + "/"; //+ ACCUWX.IMAGE_APPEND;
    	Bitmap bitmap;
    	View v1= getWindow().getDecorView().getRootView();
    	v1.setDrawingCacheEnabled(true);
    	bitmap = Bitmap.createBitmap(v1.getDrawingCache());
    	v1.setDrawingCacheEnabled(false);
    	
    	OutputStream out = null;
    	File imageFile = new File(Path);
    	
    	try {
    		out = new FileOutputStream(imageFile);
    		bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
    		out.flush();
    		out.close();
    	}catch (FileNotFoundException e){
    		e.printStackTrace();
    	}catch (IOException e){
    		e.printStackTrace();
    	}
    	
    
    
   
    }
    
}
