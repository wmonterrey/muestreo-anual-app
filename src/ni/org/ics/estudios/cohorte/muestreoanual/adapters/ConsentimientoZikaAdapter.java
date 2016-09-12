package ni.org.ics.estudios.cohorte.muestreoanual.adapters;

import java.text.DateFormat;
import java.util.List;

import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ConsentimientoZika;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ConsentimientoZikaAdapter extends ArrayAdapter<ConsentimientoZika> {

	DateFormat mediumDf = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.SHORT);
	
	
	public ConsentimientoZikaAdapter(Context context, int textViewResourceId,
			List<ConsentimientoZika> items) {
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
		ConsentimientoZika visita = getItem(position);
		if (visita != null) {

			TextView textView = (TextView) v.findViewById(R.id.identifier_text);
			if (textView != null) {
				textView.setText(visita.getConsZikaId().getCodigo().toString());
			}

			textView = (TextView) v.findViewById(R.id.name_text);
			if (textView != null) {
				textView.setText(mediumDf.format(visita.getConsZikaId().getFechaCons()));
			}
			
			textView = (TextView) v.findViewById(R.id.der_text);
			if (textView != null) {
				textView.setText(visita.getMovilInfo().getUsername());
			}
		}
		return v;
	}
}
