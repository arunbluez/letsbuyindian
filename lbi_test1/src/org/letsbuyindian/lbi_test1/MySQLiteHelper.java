package org.letsbuyindian.lbi_test1;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
	// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "ProductDB";
    
    public MySQLiteHelper (Context context){
    	super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db){
    	// sql statement to create table
    	String CREATE_BOOK_TABLE = "CREATE TABLE products ( "+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
    								"name TEXT, "+ "image BLOB, " + "description TEXT)";
    	// sql command to execute the above statement
    	db.execSQL(CREATE_BOOK_TABLE);
    	
    }
    
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    	// delete old table if exists
    	db.execSQL("DROP TABLE IF EXISTS products");
    	// create an empty table
    	this.onCreate(db);
    }
    
    // Table name
    private static final String TABLE_PRODUCTS = "products";
    
    // Products table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_DESCRIPTION = "description";
    
    // COLUMN NAMES IN DB 
    private static final String[] COLUMNS = {KEY_ID,KEY_NAME,KEY_IMAGE,KEY_DESCRIPTION};
    
    public void addProduct(Product pdt){
    	Log.d("addProduct", pdt.toString());
    	// getreference to readable DB
    	SQLiteDatabase db = this.getReadableDatabase();
    	
    	// create Contentvalues to add contents to the database
    	ContentValues values = new ContentValues();
    	values.put(KEY_NAME, pdt.getname());
    	values.put(KEY_IMAGE, pdt.bitmaptoByteArray(pdt.getImage())); // images can be stored in database as byte array
    	values.put(KEY_DESCRIPTION, pdt.getdescription());
    	
    	// insert the values to database
    	db.insert(TABLE_PRODUCTS, null, values);
    	
    	// close database
    	db.close();
    }
    
    // Get all books
    public List<Product> getAllProducts(){
    	List<Product> pdts = new ArrayList<Product>();
    	
    	// get ref to writable db
    	SQLiteDatabase  db = this.getWritableDatabase();
    	Cursor cursor = db.query(TABLE_PRODUCTS, COLUMNS, null, null, null, null, null);
    	
    	// go over each row and build a product and add it to the list
    	Product pdt = null;
    	if (cursor.moveToFirst()){
    		do{
    			pdt = new Product();
    			pdt.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_ID))));
    			pdt.setname(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
    			pdt.setImage(cursor.getBlob(cursor.getColumnIndex(KEY_IMAGE)));
    			pdt.setdescription(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)));
    			
    			// add pdt to the list of products
    			pdts.add(pdt);
    		}while(cursor.moveToNext());
    	}
    	Log.d("getAllProducts",pdts.toString());
    	return pdts;
    }
    
    /**
    // get product image_id
    public String getImageId(String name){
    	
    	Log.d("getImageId of name=",name);
    	String image = new String();
    	
    	SQLiteDatabase db = this.getReadableDatabase();
    	Cursor cursor = db.query(TABLE_PRODUCTS, COLUMNS, KEY_NAME + " = ?",new String[]{name},null, null, null,null);
    	
    	if (cursor != null && cursor.moveToFirst())
    		image = cursor.getString(cursor.getColumnIndex(KEY_IMAGE));
    	else
    		image = "THere is some problem with the query";
    	Log.d("getProductDescription=",image);
    	
    	return image;
    }
    **/
    
    // get product description
    public String getProductDescription(Product item){
    	
    	Log.d("getProductDescription of name=",item.toString());
    	String description = new String();
    	
    	SQLiteDatabase db = this.getWritableDatabase();
    	//SQLiteDatabase db = this.getReadableDatabase();
    	Cursor cursor = db.query(TABLE_PRODUCTS, COLUMNS, KEY_NAME + " = ?",new String[]{item.getname()},null, null, null,null);
    	//Cursor cursor = db.query(TABLE_PRODUCTS, COLUMNS, "id = ?", new String[]{String.valueOf(3)},null, null, null,null);
    	//Cursor cursor = db.query(TABLE_PRODUCTS, COLUMNS, "name=Hamam",null,null, null, null);
    	if (cursor != null && cursor.moveToFirst())
    		description = cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION));
    	else
    		description = "THere is some problem with the query";
    	Log.d("getProductDescription=",description);
    	return description;
    }
    
public Product getProductValues(Product item){
    	
    	Log.d("getProductValues of name=",item.toString());
    	Product pdt = new Product();
    	
    	SQLiteDatabase  db = this.getWritableDatabase();
    	Cursor cursor = db.query(TABLE_PRODUCTS, COLUMNS, KEY_NAME + " = ?",new String[]{item.getname()}, null, null, null, null);
    	
    	// go over each row and build a product and add it to the list
    	pdt = null;
    	if (cursor != null && cursor.moveToFirst()){
    	//pdt.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_ID))));
    	pdt.setname(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
    	pdt.setImage(cursor.getBlob(cursor.getColumnIndex(KEY_IMAGE)));
    	pdt.setdescription(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)));
    	}else
    	{
    		pdt.setdescription("THere is some problem with the query");
    	}
    	Log.d(" Values=",pdt.toString());
    	return pdt;
    }
    
    // get product names
    public List<String> getAllProductNames(){
    	List<String> names = new ArrayList<String>();
    	
    	// get ref to writable db
    	SQLiteDatabase  db = this.getWritableDatabase();
    	Cursor cursor = db.query(TABLE_PRODUCTS, COLUMNS, null, null, null, null, null);
    	
    	if (cursor.moveToFirst()){
    		do{
    			names.add(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
    		}while(cursor.moveToNext());
    	}
    		
    	Log.d("getAllProductNames",names.toString());
    	return names;
    }
    
 // Deleting all book
    public void deleteProducts() {
 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. delete
        db.delete(TABLE_PRODUCTS, null, null);
 
        // 3. close
        db.close();
        
        //Log.d("deleted all products"); 
    }
}
