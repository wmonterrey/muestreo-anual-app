package ni.org.ics.estudios.cohorte.muestreoanual.activities.zikacluster;



import ni.org.ics.estudios.cohorte.muestreoanual.MainActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.activities.zikacluster.nuevos.NewCasoIndiceActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.adapters.zikacluster.MenuZikaClusterAdapter;
import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MenuZikaClusterActivity extends Activity {

	private GridView gridView;
	private TextView textView;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_zika);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		
		String[] menu_zika = getResources().getStringArray(R.array.menu_zika);
		textView = (TextView) findViewById(R.id.label);
		String labelHeader = "<b>"+getString(R.string.zika_cluster)+"</b><br />";
		textView.setText(Html.fromHtml(labelHeader));
		gridView = (GridView) findViewById(R.id.gridView1);
		gridView.setAdapter(new MenuZikaClusterAdapter(this, R.layout.menu_item_2, menu_zika));
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Intent i;
				switch(position){

				case 0:
					i = new Intent(getApplicationContext(),
							NewCasoIndiceActivity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(i);
					break;
				case 1:
					i = new Intent(getApplicationContext(),
							SelecPartZikaActivity.class);
					startActivity(i);
				break;
				default:
					
					break;
				}
			}
		});

	}	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.general, menu);
		return true;
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent i;
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.MENU_BACK:
			finish();
			return true;
		case R.id.MENU_HOME:
			i = new Intent(getApplicationContext(),
					MainActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			finish();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
	
