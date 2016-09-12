package ni.org.ics.estudios.cohorte.muestreoanual.activities.zikacluster;

import java.util.ArrayList;
import java.util.List;

import ni.org.ics.estudios.cohorte.muestreoanual.MainActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.adapters.zikacluster.ParticipanteZikaClusterAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.ParticipanteZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.ConstantsDB;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;

public class MiembrosClusterZikaActivity extends ListActivity {


	private Button mAddButton;
	
	public static final int BARCODE_CAPTURE = 2;

	private ArrayAdapter<ParticipanteZikaCluster> mParticipanteZikaClusterAdapter;
	private List<ParticipanteZikaCluster> mParticipantesZikaCluster = new ArrayList<ParticipanteZikaCluster>();
	private ParticipanteZikaCluster mParticipante = new ParticipanteZikaCluster();
	
	private Integer codigo;	
	

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.miembros_list);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		
		codigo = getIntent().getIntExtra(ConstantsDB.CODIGO,-1);
		llenarDatos(codigo);
		mAddButton = (Button) findViewById(R.id.add_button);
		mAddButton.setText(getString(R.string.add)+ " " +getString(R.string.zika_miembros));

		
		mAddButton.setOnClickListener(new View.OnClickListener()  {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),
						NewMiembroClusterActivity.class);
				i.putExtra(ConstantsDB.CODIGO, codigo);
				i.putExtra(ConstantsDB.codigo_casa, mParticipante.getCodigo_casa());
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
			}
		});

	}
	
	@Override
	protected void onResume() {
		super.onResume();
		llenarDatos(codigo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.general, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==android.R.id.home){
			finish();
			return true;
		}
		else if(item.getItemId()==R.id.MENU_BACK){
			finish();
			return true;
		}
		else if(item.getItemId()==R.id.MENU_HOME){
			Intent i = new Intent(getApplicationContext(),
					MainActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			finish();
			return true;
		}
		else{
			return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	public void onBackPressed (){
		finish();
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
	}

	public void llenarDatos(Integer codigo){
		String filtro = "";
		CohorteAdapter ca = new CohorteAdapter();
		ca.open();
		filtro = ConstantsDB.codigo_indice + "=" + codigo + " and " + ConstantsDB.codigo + "<>" + codigo;
		mParticipantesZikaCluster = ca.getParticipanteZikaClusters(filtro, null);
		filtro = ConstantsDB.codigo + "=" + codigo;
		mParticipante= ca.getParticipanteZikaCluster(filtro, null);
		ca.close();
		if (mParticipantesZikaCluster.isEmpty()) showToast(getString(R.string.no_items));
		refreshView();
	}
	
	private void refreshView() {
		mParticipanteZikaClusterAdapter = new ParticipanteZikaClusterAdapter(this, R.layout.complex_list_item,
				mParticipantesZikaCluster);
		setListAdapter(mParticipanteZikaClusterAdapter);
	}

	private void showToast(String mensaje){
		LayoutInflater inflater = getLayoutInflater();

		View layout = inflater.inflate(R.layout.toast,
				(ViewGroup) findViewById(R.id.toast_layout_root));

		TextView text = (TextView) layout.findViewById(R.id.text);
		text.setText(mensaje);

		Toast toast = new Toast(getApplicationContext());
		toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(layout);
		toast.show();
	}
	
	@Override
	protected void onListItemClick(ListView listView, View view, int position,
			long id) {

		ParticipanteZikaCluster mParticipanteZikaCluster = (ParticipanteZikaCluster) getListAdapter().getItem(position);
		codigo = mParticipanteZikaCluster.getCodigo();
		Intent i = new Intent(getApplicationContext(),
				MenuInfoZikaActivity.class);
		i.putExtra(ConstantsDB.CODIGO, codigo);
		startActivity(i);
	}
}
