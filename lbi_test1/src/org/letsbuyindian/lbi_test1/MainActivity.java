package org.letsbuyindian.lbi_test1;
 
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
 
public class MainActivity extends Activity {
	public static String mainCat;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);
         
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
}