package jp.critique.androcalc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class AndrocalcActivity extends Activity {

	private static final String TAG = "AndrocalcActivity";

	private float result = 0f;
	private String currentOp;
	private TextView display;
	private Boolean inputFirst = true;

	public float getResult() {
		return result;
	}

	public void setResult(float result) {
		this.result = result;
		display.setText(String.valueOf(this.result));
	}

	public String getCurrentOp() {
		return currentOp;
	}

	public void setCurrentOp(String currentOp) {
		this.currentOp = currentOp;
	}

	public void resetCurrentOp() {
		setCurrentOp("reset");
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		display = (TextView) findViewById(R.id.editText1);

		calcClear();
		resetCurrentOp();

		GridView grid = (GridView) findViewById(R.id.gridView1);
		grid.setAdapter(new TenkeyAdapter());
		
//		TenkeyAdapter adapter = (TenkeyAdapter) grid.getAdapter();
//		Button obj = (Button) adapter.getItem(0);
//		Log.v(TAG, (String) obj.getText());

		grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Log.v(TAG,"position=" + position);
				
				GridView grid = (GridView) parent;
				Button btn = (Button) grid.getItemAtPosition(position);

				if(position == 0){
					calcClear();
				}else if(position == 1){
					inverseValue();
				}else if((position > 1 && position < 4) || position == 7 || position == 11){
					changeCurrentOp((String) btn.getText());
				}else if((position > 3 && position < 7) || (position > 7 && position < 11) || (position > 11 && position < 15) || position == 16){
					inputValue(Integer.parseInt((String) btn.getText()));
				}


			}

		}
				);
	}

	public void calcClear(){
		setCurrentOp("reset");
		setResult(0f);
	}

	public void inverseValue(){
		float val = getResult();
		val = val * -1;
		setResult(val);
	}

	public void inputValue(int value) {
		if(inputFirst == true){
			display.setText(String.valueOf(value));
			inputFirst = false;
		}else{
			String tmp = (String) display.getText();
			display.setText(tmp + String.valueOf(value));
		}
	}

	public void changeCurrentOp(String op) {
		float tmp = Float.parseFloat((String) display.getText());
		float currentResult = getResult();
		if(op == "+"){
			tmp = tmp + currentResult;
		}else if(op == "-"){
			tmp = tmp - currentResult;
		}else if(op == "x"){
			tmp = tmp * currentResult;
		}else if(op == "€"){
			tmp = tmp / currentResult;
		}

		setCurrentOp(op);
		setResult(tmp);
	}

}

