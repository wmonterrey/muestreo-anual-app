package ni.org.ics.estudios.cohorte.muestreoanual.adapters;

import java.text.DateFormat;
import java.util.List;

import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.CambioEstudio;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CambioEstudioAdapter extends ArrayAdapter<CambioEstudio> {

	DateFormat mediumDf = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.SHORT);
	
	
	public CambioEstudioAdapter(Context context, int textViewResourceId,
			List<CambioEstudio> items) {
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
		CambioEstudio cambio = getItem(position);
		if (cambio != null) {

			TextView textView = (TextView) v.findViewById(R.id.identifier_text);
			if (textView != null) {
				textView.setText(cambio.getCambioEstudioId().getCodigo().toString());
			}

			textView = (TextView) v.findViewById(R.id.name_text);
			if (textView != null) {
				textView.setText(mediumDf.format(cambio.getCambioEstudioId().getFechaCambio()));
			}
			
			textView = (TextView) v.findViewById(R.id.der_text);
			if (textView != null) {
				textView.setText(cambio.getMovilInfo().getUsername());
			}
		}
		return v;
	}
}
