package ni.org.ics.estudios.cohorte.muestreoanual.adapters.zikacluster;

import java.text.SimpleDateFormat;
import java.util.List;

import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.ParticipanteZikaCluster;



import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ParticipanteZikaClusterAdapter extends ArrayAdapter<ParticipanteZikaCluster> {
	
	private SimpleDateFormat mDateFormat = new SimpleDateFormat("MMM dd, yyyy");


	public ParticipanteZikaClusterAdapter(Context context, int textViewResourceId,
			List<ParticipanteZikaCluster> items) {
		super(context, textViewResourceId, items);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.complex_list_item, null);
		}
		ParticipanteZikaCluster participante = getItem(position);
		if (participante != null) {
			TextView textView = (TextView) v.findViewById(R.id.identifier_text);
			if (textView != null) {
				textView.setText(this.getContext().getString(R.string.code) + " " + participante.getCodigo());
			}

			textView = (TextView) v.findViewById(R.id.name_text);
			String nameCompleto = participante.getNombre1();
			if (participante.getNombre2()!=null) nameCompleto = nameCompleto + " "+  participante.getNombre2();
			nameCompleto = nameCompleto +" "+ participante.getApellido1();
			if (participante.getApellido2()!=null) nameCompleto = nameCompleto + " "+  participante.getApellido2();
			if (textView != null) {
				textView.setText(nameCompleto);
			}

			textView = (TextView) v.findViewById(R.id.der_text);
			if (textView != null) {
				textView.setText(mDateFormat.format(participante.getFechana()));
			}
			
			ImageView imageView = (ImageView) v.findViewById(R.id.image);
			if (imageView != null) {
				if (participante.getCohorte().equals("1")) {
					imageView.setImageResource(R.drawable.male);
				} else if (participante.getCohorte().equals("0")) {
					imageView.setImageResource(R.drawable.female);
				}
			}
			String labelHeader="";
			
			labelHeader = labelHeader + "Agregar datos<br />";
			
			textView = (TextView) v.findViewById(R.id.infoc_text);
			if (textView != null) {
				textView.setText(Html.fromHtml(labelHeader));
			}
		}
		return v;
	}
}
