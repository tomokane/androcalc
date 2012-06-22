package jp.critique.androcalc;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class TenkeyAdapter extends BaseAdapter {
	
	private static final String TAG = "TenkeyAdapter";
	private Button btn;
	
	private String[] buttunLabel = new String[] {
						"C","+/-","ÅÄ","x"
	                    ,"7","8","9","-"
	                    ,"4","5","6","+"
	                    ,"3","2","1","="
	                    ,"0"};	
	private int BUTTON_COUNT = buttunLabel.length;
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return BUTTON_COUNT;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return (Object) btn;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		btn = new Button(parent.getContext());
		if(buttunLabel[position] != null) {
			btn.setText(String.valueOf(buttunLabel[position]));
			btn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					Log.v(TAG,"click btn=");
					
				}
				
			});
			btn.setClickable(false);
		}
		
		return btn;
	}

}
