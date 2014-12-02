package org.letsbuyindian.lbi_test1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Product {
	
	private int id;
	private String name;
	private Bitmap image;
	private String description;
	
	public Product (){ }
	
	public Product (String name, Bitmap image, String description){
		this.name = name;
		this.image = image;
		this.description = description;
	}
	
	 public long getId() {
		    return id;
	}

	 public void setId(int id) {
		    this.id = id;
	 }
	 
	public String getname(){
		return name;
	}
	
	public void setname(String name){
		this.name = name;
	}
	/**
	public byte[] getImage(){
		// convert the bitmap image to byte array
		return this.bitmaptoByteArray(image) ;
	}**/
	
	public Bitmap getImage(){
		// convert the bitmap image to byte array
		return this.image ;
	}
	
	public void setImage(byte[] image){
		// convert the bytearray to bitmap image
		this.image = this.byteArraytoBitmap(image) ;
	}
	
	public String getdescription(){
		return description;
	}
	
	public void setdescription(String description){
		this.description = description;
	}
	
	public String toString(){
		return "Product [id=" + id + ", name=" + name + ", image="+image.toString()+ ", description=" + description + "]";
	}
	
	public byte[] bitmaptoByteArray(){
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte imageInByte[] = stream.toByteArray();
        return imageInByte;
	}
	
	public byte[] bitmaptoByteArray(Bitmap image){
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte imageInByte[] = stream.toByteArray();
        return imageInByte;
	}
	
	public Bitmap byteArraytoBitmap(byte[] byteStream){
		ByteArrayInputStream imageStream = new ByteArrayInputStream(byteStream);
		Bitmap image = BitmapFactory.decodeStream(imageStream);
		return image;
	}

}
