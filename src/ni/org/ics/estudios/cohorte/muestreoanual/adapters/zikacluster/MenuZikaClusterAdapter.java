package ni.org.ics.estudios.cohorte.muestreoanual.adapters.zikacluster;




import ni.org.ics.estudios.cohorte.muestreoanual.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MenuZikaClusterAdapter extends ArrayAdapter<String> {

	private final String[] values;
	public MenuZikaClusterAdapter(Context context, int textViewResourceId,
			String[] values) {
		super(context, textViewResourceId, values);
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.menu_item_2, null);
		}
		TextView textView = (TextView) v.findViewById(R.id.label);
		textView.setTypeface(null, Typeface.NORMAL);
		textView.setTextColor(Color.BLACK);
		textView.setText(values[position]);

		// Change icon based on position
		Drawable img = null;
		switch (position){
		case 0: 
			img=getContext().getResources().getDrawable( R.drawable.ic_new);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			textView.setText(values[position]);
			break;
		case 1: 
			img=getContext().getResources().getDrawable( R.drawable.ic_view);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			textView.setText(values[position]);
			break;
		case 2: 
			img=getContext().getResources().getDrawable( R.drawable.ic_casa);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			textView.setText(values[position]);
			break;
		case 3: 
			img=getContext().getResources().getDrawable( R.drawable.ic_download);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			textView.setText(values[position]);
			break;
		case 4: 
			img=getContext().getResources().getDrawable( R.drawable.ic_upload);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			textView.setText(values[position]);
			break;
		default:
			img=getContext().getResources().getDrawable( R.drawable.ic_cohorte);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		}

		return v;
	}
}
