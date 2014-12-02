package org.letsbuyindian.lbi_test1;

import java.io.ByteArrayInputStream;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter <Product> {
	
	private final Context context;
	//private final String[] values;
	private final List<Product> names;
	
	 static class ViewHolder {
		 public TextView text;
		 public ImageView image;
	 }
	
	public CustomAdapter(Context context, List<Product> names){
		super(context, R.layout.products_layout, names);
		this.context = context;
		this.names = names;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		/**
		LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowView = inflator.inflate(R.layout.activity_main, parent, false);
		TextView tv = (TextView) rowView.findViewById(R.id.label);
		ImageView iv = (ImageView) rowView.findViewById(R.id.icon);
		**/
		View rowView = convertView;
		if (rowView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(R.layout.products_layout, parent, false);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.text = (TextView) rowView.findViewById(R.id.label);
			viewHolder.image = (ImageView) rowView.findViewById(R.id.icon);
			rowView.setTag(viewHolder);
		}
		
		ViewHolder holder = (ViewHolder) rowView.getTag();
		Product item = names.get(position);
		holder.text.setText(item.getname());
		/**
		byte[] outImage = item.getImage();
		ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
		Bitmap theImage = BitmapFactory.decodeStream(imageStream);**/
		holder.image.setImageBitmap(item.getImage());
		/**
		if (item_value	.startsWith("Lux")){
			holder.image.setImageResource(R.drawable.smiley_victory);
		}
		else{
			holder.image.setImageResource(R.drawable.smiley_happy);
		}**/
		return rowView;		
	}
}
