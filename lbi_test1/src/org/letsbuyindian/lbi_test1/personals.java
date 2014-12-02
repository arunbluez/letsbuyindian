package org.letsbuyindian.lbi_test1;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class personals extends Activity {
	 /** Called when the activity is first created. */

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personals_layout);
        
        
    
        
        
    Button btn_p_baby = (Button) findViewById(R.id.btn_p_baby);
    
    btn_p_baby.setOnClickListener(new View.OnClickListener() {
        
        @Override
        public void onClick(View view) {
        	
            Intent i = new Intent(getApplicationContext(), ProductList.class);
            
        	i.putExtra("cat", "cat" );
            startActivity(i);
        }
    });
    }
}
