package org.letsbuyindian.lbi_test1;
 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
 
public class MainActivity extends Activity {
	public static String mainCat;
	
	MySQLiteHelper db = new MySQLiteHelper(this);
	
	private String URL_ITEMS = "http://axismarketingteam.com/lbi/getProduct.php";
    private static final String TAG_PRODUCTS = "products";
    private static final String TAG_NAME = "name";
    private static final String TAG_IMAGE = "image";
    private static final String TAG_DESCRIPTION = "description";
    JSONArray matchProduct = null;
    ArrayList<HashMap<String, String>> matchProductList = new ArrayList<HashMap<String, String>>();
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);
        
        //db.deleteProducts();
        //json server code//
        new GetProducts().execute();

       
        //get image from drawable
        
        
        // convert bitmap to byte
        /**
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte imageInByte[] = stream.toByteArray();**/
        
        
        // show all products in LogCat
        
        
        
        /**
         * Creating all buttons instances
         * */
        // Dashboard Personal button
        Button btn_personals = (Button) findViewById(R.id.btn_personals);
         
        // Dashboard Lifesylte button
        Button btn_lifestyles = (Button) findViewById(R.id.btn_lifestyles);
         
        // Dashboard Grocery button
        Button btn_grocerys = (Button) findViewById(R.id.btn_grocerys);
         
        // Dashboard Beverages button
        Button btn_beverages = (Button) findViewById(R.id.btn_beverages);
         
        // Dashboard Household button
        Button btn_households = (Button) findViewById(R.id.btn_households);
         
        // Dashboard Weservice button
        Button btn_webservices = (Button) findViewById(R.id.btn_webservices);
         
        // Dashboard HomeElectronics button
        Button btn_electronics = (Button) findViewById(R.id.btn_electronics);
         
        // Dashboard Automobiles button
        Button btn_automobiles = (Button) findViewById(R.id.btn_automobiles);
         
        // Dashboard Services button
        Button btn_services = (Button) findViewById(R.id.btn_services);
         
        // Dashboard others button
        Button btn_others = (Button) findViewById(R.id.btn_others);
        /**
         * Handling all button click events
         * */
        mainCat = "testing";

        
        btn_personals.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {
            	mainCat = "personals";
                Intent i = new Intent(getApplicationContext(), personals.class);
                startActivity(i);
            }
        });

        btn_lifestyles.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), lifestyles.class);
                startActivity(i);
            }
        });
         
        btn_grocerys.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), grocerys.class);
                startActivity(i);
            }
        });
         
        btn_beverages.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {
   
                Intent i = new Intent(getApplicationContext(), beverages.class);
                startActivity(i);
            }
        });
         
        btn_households.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {
   
                Intent i = new Intent(getApplicationContext(), households.class);
                startActivity(i);
            }
        });
         
        btn_webservices.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), webservices.class);
                startActivity(i);
            }
        });
        btn_electronics.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View view) {
       
                Intent i = new Intent(getApplicationContext(), electronics.class);
                startActivity(i);
            }
        });
        
        btn_automobiles.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View view) {
          
                Intent i = new Intent(getApplicationContext(), automobiles.class);
                startActivity(i);
            }
        });
        btn_services.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View view) {
       
                Intent i = new Intent(getApplicationContext(), services.class);
                startActivity(i);
            }
        });
        btn_others.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View view) {
           
                Intent i = new Intent(getApplicationContext(), others.class);
                startActivity(i);
            }
        });
    }
    private class GetProducts extends AsyncTask<Void, Void, Void> {
        @Override
            protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
            protected Void doInBackground(Void... arg) {
            ServiceHandler serviceClient = new ServiceHandler();
            Log.d("url: ", "> " + URL_ITEMS);
            String json = serviceClient.makeServiceCall(URL_ITEMS,ServiceHandler.GET);
            // print the json response in the log
            Log.d("Get match fixture response: ", "> " + json);
            if (json != null) {
                try {
                    Log.d("try", "in the try");
                    JSONObject jsonObj = new JSONObject(json);
                    Log.d("jsonObject", "new json Object");
                    // Getting JSON Array node
                    matchProduct = jsonObj.getJSONArray(TAG_PRODUCTS);
                    Log.d("json aray", "user point array");
              
                    Log.d("len", "get array length");
                    
                    // Directory in SD card for storage of pictures
                    File image_dir = new File(Environment.getExternalStorageDirectory().getPath() + "/LetsBuyIndian");
                    String dest_file_path = "";
                    
                    for (int i = 0; i < matchProduct.length(); i++) {
                        JSONObject c = matchProduct.getJSONObject(i);
                        String name = c.getString(TAG_NAME);
                        Log.d("name", name);
                        String image_url = c.getString(TAG_IMAGE);
                        Log.d("image", image_url);
                        String desc = c.getString(TAG_DESCRIPTION);
                        Log.d("desc", desc);
                        Log.d("Image storage directory",image_dir.getPath());
                        if (image_dir.mkdir()||image_dir.isDirectory()){
                        	Log.d("Image storage directory",image_dir.getPath());
                        	dest_file_path = image_dir.getPath() + "/" + name + ".png";
                        }
                        Log.d("Image storage location",dest_file_path);
                        /**
                        //  hashmap for single match
                        HashMap<String, String> matchProduct = new HashMap<String, String>();
                        // adding each child node to HashMap key => value
                        matchProduct.put(TAG_NAME, name);
                        matchProduct.put(TAG_IMAGE, image);
                        matchProduct.put(TAG_DESCRIPTION, desc);
                        **/
                        downloadImageFromUrl(image_url,dest_file_path);
                        Bitmap image = BitmapFactory.decodeFile(dest_file_path);
                        //Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.p_baby);
                        Product jsonProduct = new Product(name, image, desc);
                        if(!db.isProduct(jsonProduct))
                        {
                        	db.addProduct(jsonProduct);
                        } 
                        //matchProductList.add(matchProduct);
                    }
                }
                catch (JSONException e) {
                    Log.d("catch", "in the catch");
                    e.printStackTrace();
                }
            } else {
                Log.e("JSON Data", "Didn't receive any data from server!");
            }
            return null;
        }
        
        public void downloadImageFromUrl(String url, String dest_file_path) {
            try {
                File dest_file = new File(dest_file_path);
                Log.d("destinationfile path", dest_file_path);
                URL u = new URL(url);
                URLConnection conn = u.openConnection();
                int contentLength = conn.getContentLength();
                DataInputStream stream = new DataInputStream(u.openStream());
                byte[] buffer = new byte[contentLength];
                stream.readFully(buffer);
                stream.close();
                DataOutputStream fos = new DataOutputStream(new FileOutputStream(dest_file));
                fos.write(buffer);
                fos.flush();
                fos.close();
                //Intent intent = new Intent(getApplicationContext(), ImageScreen.class);
                //intent.putExtra("path", dest_file_path);
                //startActivity(intent);             
            } catch(FileNotFoundException e) {
                Log.d("FILENOTFOUDEXCEPTION",e.toString() );
                return; 
            } catch (IOException e) {

                Log.d("IOEXCEPTION",e.toString() );
                return; 
            }
      }
        @Override
            protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            //--- sqllite initiate ---//
            
            
            // delete old database
            
           
        }
    }
}