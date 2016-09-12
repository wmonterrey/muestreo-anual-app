package ni.org.ics.estudios.cohorte.muestreoanual.adapters;

import java.text.DateFormat;
import java.util.List;

import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.RecepcionBHC;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class BHCAdapter extends ArrayAdapter<RecepcionBHC> {
	
	DateFormat mediumDf = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.SHORT);

	public BHCAdapter(Context context, int textViewResourceId,
			List<RecepcionBHC> items) {
		super(context, textViewResourceId, items);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.complex_list_item, null);
		}
		RecepcionBHC tubo = getItem(position);
		if (tubo != null) {
			TextView textView = (TextView) v.findViewById(R.id.name_text);
			if (textView != null) {
				textView.setText(this.getContext().getString(R.string.code) + " " + tubo.getRecBhcId().getCodigo());
			}

			textView = (TextView) v.findViewById(R.id.identifier_text);
			if (textView != null) {
				textView.setText(mediumDf.format(tubo.getFecreg()));
			}

			textView = (TextView) v.findViewById(R.id.der_text);
			if (textView != null) {
					textView.setText(tubo.getLugar());
			}
		}
		return v;
	}
}
