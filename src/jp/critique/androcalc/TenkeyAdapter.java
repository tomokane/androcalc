package jp.critique.androcalc;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.view.Gravity;

public class TenkeyAdapter extends BaseAdapter {
	
	private Button btn;
	private TextView txt;
	
	private String[] buttunLabel = new String[] {
						"C","+/-","÷","x"
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
		txt = new TextView(parent.getContext());
		if(buttunLabel[position] != null) {
			txt.setText(String.valueOf(buttunLabel[position]));
			txt.setTextSize(50f);
			txt.setGravity(Gravity.CENTER);
			txt.setBackgroundResource(R.drawable.shape_radio_blue);
			txt.setPadding(0, 0, 0, 0);
		}
		
		return txt;
	}

}
