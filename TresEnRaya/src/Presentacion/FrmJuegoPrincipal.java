package Presentacion;

import com.example.tresenraya.R;

import Negocio.JuegoTresEnRaya;
import android.os.Bundle;
import android.app.Activity;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class FrmJuegoPrincipal extends Activity implements OnClickListener{

	private Button btnX;
	private Button btnO;
	
	private JuegoTresEnRaya jug;
	
	public FrmJuegoPrincipal()
	{
		jug = new JuegoTresEnRaya();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frm_juego_principal);
		
		jug = new JuegoTresEnRaya();
		
		btnX = (Button)findViewById(R.id.button1);
		btnO = (Button)findViewById(R.id.button2);
		
		btnO.setOnClickListener(this);
		btnX.setOnClickListener(this);
		
		 /*TableLayout table = new TableLayout(this);
	        table.setStretchAllColumns(true);
	        table.setShrinkAllColumns(true);
	        TableRow rowTitle = new TableRow(this);
	        rowTitle.setGravity(Gravity.CENTER_HORIZONTAL);
	        TableRow rowDayLabels = new TableRow(this);
	        TableRow rowHighs = new TableRow(this);
	        TableRow rowLows = new TableRow(this);
	        TableRow rowConditions = new TableRow(this);
	        rowConditions.setGravity(Gravity.CENTER);
	        TextView empty = new TextView(this);
	        // title column/row
	        TextView title = new TextView(this);
	        title.setText("Java Weather Table");
	        title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
	        title.setGravity(Gravity.CENTER);
	        title.setTypeface(Typeface.SERIF, Typeface.BOLD);
	        TableRow.LayoutParams params = new TableRow.LayoutParams();
	        params.span = 6;
	        rowTitle.addView(title, params);
	        // labels column
	        TextView highsLabel = new TextView(this);
	        highsLabel.setText("Day High");
	        highsLabel.setTypeface(Typeface.DEFAULT_BOLD);
	        TextView lowsLabel = new TextView(this);
	        lowsLabel.setText("Day Low");
	        lowsLabel.setTypeface(Typeface.DEFAULT_BOLD);
	        TextView conditionsLabel = new TextView(this);
	        conditionsLabel.setText("Conditions");
	        conditionsLabel.setTypeface(Typeface.DEFAULT_BOLD);
	        rowDayLabels.addView(empty);
	        rowHighs.addView(highsLabel);
	        rowLows.addView(lowsLabel);
	        rowConditions.addView(conditionsLabel);
	        // day 1 column
	        TextView day1Label = new TextView(this);
	        day1Label.setText("Feb 7");
	        day1Label.setTypeface(Typeface.SERIF, Typeface.BOLD);
	        TextView day1High = new TextView(this);
	        day1High.setText("28°F");
	        day1High.setGravity(Gravity.CENTER_HORIZONTAL);
	        TextView day1Low = new TextView(this);
	        day1Low.setText("15°F");
	        day1Low.setGravity(Gravity.CENTER_HORIZONTAL);
	        
	        // day2 column
	        TextView day2Label = new TextView(this);
	        day2Label.setText("Feb 8");
	        day2Label.setTypeface(Typeface.SERIF, Typeface.BOLD);
	        TextView day2High = new TextView(this);
	        day2High.setText("26°F");
	        day2High.setGravity(Gravity.CENTER_HORIZONTAL);
	        TextView day2Low = new TextView(this);
	        day2Low.setText("14°F");
	        day2Low.setGravity(Gravity.CENTER_HORIZONTAL);
	      
	        // day3 column
	        TextView day3Label = new TextView(this);
	        day3Label.setText("Feb 9");
	        day3Label.setTypeface(Typeface.SERIF, Typeface.BOLD);
	        TextView day3High = new TextView(this);
	        day3High.setText("23°F");
	        day3High.setGravity(Gravity.CENTER_HORIZONTAL);
	        TextView day3Low = new TextView(this);
	        day3Low.setText("3°F");
	        day3Low.setGravity(Gravity.CENTER_HORIZONTAL);
	        
	        // day4 column
	        TextView day4Label = new TextView(this);
	        day4Label.setText("Feb 10");
	        day4Label.setTypeface(Typeface.SERIF, Typeface.BOLD);
	        TextView day4High = new TextView(this);
	        day4High.setText("17°F");
	        day4High.setGravity(Gravity.CENTER_HORIZONTAL);
	        TextView day4Low = new TextView(this);
	        day4Low.setText("5°F");
	        day4Low.setGravity(Gravity.CENTER_HORIZONTAL);
	        
	        // day5 column
	        TextView day5Label = new TextView(this);
	        day5Label.setText("Feb 11");
	        day5Label.setTypeface(Typeface.SERIF, Typeface.BOLD);
	        TextView day5High = new TextView(this);
	        day5High.setText("19°F");
	        day5High.setGravity(Gravity.CENTER_HORIZONTAL);
	        TextView day5Low = new TextView(this);
	        day5Low.setText("6°F");
	        day5Low.setGravity(Gravity.CENTER_HORIZONTAL);
	        
	        table.addView(rowTitle);
	        table.addView(rowDayLabels);
	        table.addView(rowHighs);
	        table.addView(rowLows);
	        table.addView(rowConditions);
	        setContentView(table);*/
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_frm_juego_principal, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
			case R.id.button1:{
				EditText edt1 = (EditText)findViewById(R.id.editText1);
				jug.crearJugadorX(edt1.getText().toString().trim(), 1);
			}break;
	
			case R.id.button2:{
				EditText edt2 = (EditText)findViewById(R.id.editText2);
				jug.crearJugadorO(edt2.getText().toString().trim(), 2);
			}break;
		}
	}

}
