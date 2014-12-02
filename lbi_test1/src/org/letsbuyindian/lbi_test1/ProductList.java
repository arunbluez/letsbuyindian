package org.letsbuyindian.lbi_test1;

import java.util.List;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class ProductList extends ListActivity {

	MySQLiteHelper db = new MySQLiteHelper(this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.personals_layout);
	
        
        List<Product> list_products = db.getAllProducts();
        
	CustomAdapter adapter = new CustomAdapter (this, list_products);
    setListAdapter(adapter);
    }
    
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	
    	// Get the item clicked on the list
    	Product item = (Product) getListAdapter().getItem(position);	
    	// Create an intent for opening a new activity(descriptionScreen)
    	Intent intent = new Intent(getApplicationContext(), DescriptionScreen.class);
    	//Product values = db.getProductValues(item);
    	intent.putExtra("name", item.getname());
    	intent.putExtra("image", item.bitmaptoByteArray());
    	intent.putExtra("desc", item.getdescription());
    	startActivity(intent);
      }

}
