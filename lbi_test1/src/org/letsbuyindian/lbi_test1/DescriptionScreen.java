package org.letsbuyindian.lbi_test1;

import java.io.ByteArrayInputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionScreen extends Activity {
	protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_layout);
        String name = "";
        String desc = "";
        byte[] image = new byte[10];
        // define a variable for modifying the text view
        TextView name_text = (TextView) findViewById(R.id.productName);
        TextView desc_text = (TextView) findViewById(R.id.productDesc);
        ImageView logo_img = (ImageView) findViewById(R.id.logoView);
        
        Bundle extras = getIntent().getExtras();
        if(extras != null){
        	name = extras.getString("name");
        	image = extras.getByteArray("image");
        	desc = extras.getString("desc");
        }
        logo_img.setImageBitmap(byteArraytoBitmap(image));
        name_text.setText(name);
        desc_text.setText(desc);
	}
	public Bitmap byteArraytoBitmap(byte[] byteStream){
		ByteArrayInputStream imageStream = new ByteArrayInputStream(byteStream);
		Bitmap image = BitmapFactory.decodeStream(imageStream);
		return image;
	}
}
