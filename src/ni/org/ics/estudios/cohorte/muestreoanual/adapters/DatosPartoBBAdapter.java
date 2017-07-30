package ni.org.ics.estudios.cohorte.muestreoanual.adapters;

import java.text.DateFormat;
import java.util.List;

import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.DatosPartoBB;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DatosPartoBBAdapter extends ArrayAdapter<DatosPartoBB> {

	DateFormat mediumDf = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.SHORT);
	
	
	public DatosPartoBBAdapter(Context context, int textViewResourceId,
			List<DatosPartoBB> items) {
		super(context, textViewResourceId, items);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.complex_list_item , null);
		}
		DatosPartoBB datos = getItem(position);
		if (datos != null) {

			TextView textView = (TextView) v.findViewById(R.id.identifier_text);
			if (textView != null) {
				textView.setText(datos.getDatosPartoId().getCodigo().toString());
			}

			textView = (TextView) v.findViewById(R.id.name_text);
			if (textView != null) {
				textView.setText(mediumDf.format(datos.getDatosPartoId().getFechaDatosParto()));
			}
			
			textView = (TextView) v.findViewById(R.id.der_text);
			if (textView != null) {
				textView.setText(datos.getMovilInfo().getUsername());
			}
		}
		return v;
	}
}
