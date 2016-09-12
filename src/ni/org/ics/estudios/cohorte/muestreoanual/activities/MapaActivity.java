package ni.org.ics.estudios.cohorte.muestreoanual.activities;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.ConstantsDB;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.PointItemizedOverlay;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MapaActivity extends MapActivity{
	private MapController mapController;
	private MapView mapView; 
	List<Overlay> mapOverlay;
	PointItemizedOverlay posItemizedoverlay;
	Drawable drawMyLocation;
	Drawable drawPoints;
	Location location;
	LocationListener locationListener;
	private LocationManager locationManager;
	private CountDownTimer locationtimer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);

		mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);
		mapView.setSatellite(false);

		mapController = mapView.getController();
		mapController.setZoom(18);


		mapOverlay = mapView.getOverlays();
		
		drawMyLocation = this.getResources().getDrawable(R.drawable.ic_maps_indicator_current_position);
		drawPoints = this.getResources().getDrawable(R.drawable.ic_notification_overlay);

		locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

		if (locationManager == null) {
			showToast("Ubicación no disponible",1);
			return;
		}

		location = locationManager
				.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		if (location == null)
			location = locationManager
			.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		if (location != null) {
			showPosition();
		}


		locationListener = new LocationListener() {
			@Override
			public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			}

			@Override
			public void onProviderEnabled(String arg0) {
			}

			@Override
			public void onProviderDisabled(String arg0) {
			}

			@Override
			public void onLocationChanged(Location l) {
				location = l;
				locationManager.removeUpdates(this);
				if (l.getLatitude() == 0 || l.getLongitude() == 0) {
				} else {
					showPosition();
				}
			}
		};

		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
			locationManager.requestLocationUpdates(
					LocationManager.GPS_PROVIDER, 1000, 10f, locationListener);
		locationManager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER, 1000, 10f, locationListener);
		locationtimer = new CountDownTimer(60000, 5000) {
			@Override
			public void onTick(long millisUntilFinished) {
				if (location != null)
					locationtimer.cancel();
			}

			@Override
			public void onFinish() {
				if (location == null) {
					showToast("Esperando ubicación",2);
				}
			}
		};
		locationtimer.start();


		showParticipantes();
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	private void showPosition(){
		double lat = location.getLatitude();
		double lng = location.getLongitude();
		mapOverlay.remove(posItemizedoverlay);
		GeoPoint point = new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6));
		posItemizedoverlay = new PointItemizedOverlay(drawMyLocation, this);
		OverlayItem overlayitem = new OverlayItem(point, "Mi posición", "Lat: " +lat+" Long: "+lng);
		posItemizedoverlay.addOverlay(overlayitem);
		mapOverlay.add(posItemizedoverlay);
		mapController.setCenter(point);
	}

	private void showParticipantes() {

		CohorteAdapter ca = new CohorteAdapter();
		ca.open();
		Cursor puntos = null;
		puntos = ca.obtenerTodosPuntos();

		if (puntos != null && puntos.getCount() > 0) {

			do{
					double lat = puntos.getDouble(puntos.getColumnIndex(ConstantsDB.LATITUD));
					double lng = puntos.getDouble(puntos.getColumnIndex(ConstantsDB.LONGITUD));
					String codParticipante = String.valueOf(puntos.getInt(puntos.getColumnIndex(ConstantsDB.CODIGO))) +" - " +puntos.getString(puntos.getColumnIndex(ConstantsDB.NOMBRE1)) + " " +  puntos.getString(puntos.getColumnIndex(ConstantsDB.NOMBRE2)) 
							+ " " + puntos.getString(puntos.getColumnIndex(ConstantsDB.APELLIDO1)) + " " +  puntos.getString(puntos.getColumnIndex(ConstantsDB.APELLIDO2));
					String dataParticipante = "Código de Casa: " +  puntos.getString(puntos.getColumnIndex(ConstantsDB.COD_CASA))+ "\nDirección: " + puntos.getString(puntos.getColumnIndex(ConstantsDB.DIRECCION)) + "\nManzana: " +  String.valueOf(puntos.getInt(puntos.getColumnIndex(ConstantsDB.MANZANA))) 
							+ "\nCasa de : " +  puntos.getString(puntos.getColumnIndex(ConstantsDB.NOM_JEFE)) + " " +  puntos.getString(puntos.getColumnIndex(ConstantsDB.NOM_JEFE_2)) 
							+ " " + puntos.getString(puntos.getColumnIndex(ConstantsDB.APE_JEFE)) + " " +  puntos.getString(puntos.getColumnIndex(ConstantsDB.APE_JEFE_2));
					GeoPoint point = new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6));
					PointItemizedOverlay itemizedoverlay = new PointItemizedOverlay(drawPoints, this);
					OverlayItem overlayitem = new OverlayItem(point, codParticipante, dataParticipante);
					itemizedoverlay.addOverlay(overlayitem);
					mapOverlay.add(itemizedoverlay);

			} while (puntos.moveToNext());
		}
		if (puntos != null) {
			puntos.close();
		}
		ca.close();
	}	


	private void showToast(String mensaje, int numImage){
		LayoutInflater inflater = getLayoutInflater();

		View layout = inflater.inflate(R.layout.toast,
				(ViewGroup) findViewById(R.id.toast_layout_root));

		ImageView image = (ImageView) layout.findViewById(R.id.image);

		switch(numImage){
		case 0:
			image.setImageResource(R.drawable.ic_ok);
			break;
		case 1:
			image.setImageResource(R.drawable.ic_error);
			break;
		default:
			image.setImageResource(R.drawable.ic_launcher);
			break;
		}


		TextView text = (TextView) layout.findViewById(R.id.text);
		text.setText(mensaje);

		Toast toast = new Toast(getApplicationContext());
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(layout);
		toast.show();

	}
}