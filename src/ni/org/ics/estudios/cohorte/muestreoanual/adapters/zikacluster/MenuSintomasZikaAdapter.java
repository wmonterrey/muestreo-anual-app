package ni.org.ics.estudios.cohorte.muestreoanual.adapters.zikacluster;




import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.ParticipanteZikaCluster;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MenuSintomasZikaAdapter extends ArrayAdapter<String> {

	private final String[] values;
	private final ParticipanteZikaCluster participante;

	public MenuSintomasZikaAdapter(Context context, int textViewResourceId,
			String[] values, ParticipanteZikaCluster participante) {
		super(context, textViewResourceId, values);
		CohorteAdapter ca = new CohorteAdapter();
		ca.open();
		this.values = values;
		this.participante = participante;
		ca.close();
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
			if(String.valueOf(participante.getSint1()).matches("0")){
				img=getContext().getResources().getDrawable( R.drawable.ic_edit);
			}
			else{
				img=getContext().getResources().getDrawable( R.drawable.ic_ok);
			}
			break;
		default:
			img=changeIcon(position);
			break;
		}
		textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
		return v;
	}
	
	public Drawable changeIcon(int pos){
		Drawable img = getContext().getResources().getDrawable( R.drawable.ic_error);;
		String valor1 = "";String valor2 = "";
		switch (pos){
		case 1: valor1 = String.valueOf(participante.getSint1()); valor2 =String.valueOf(participante.getSint2()); break;
		case 2: valor1 = String.valueOf(participante.getSint2()); valor2 =String.valueOf(participante.getSint3()); break;
		case 3: valor1 = String.valueOf(participante.getSint3()); valor2 =String.valueOf(participante.getSint4()); break;
		case 4: valor1 = String.valueOf(participante.getSint4()); valor2 =String.valueOf(participante.getSint5()); break;
		case 5: valor1 = String.valueOf(participante.getSint5()); valor2 =String.valueOf(participante.getSint6()); break;
		case 6: valor1 = String.valueOf(participante.getSint6()); valor2 =String.valueOf(participante.getSint7()); break;
		case 7: valor1 = String.valueOf(participante.getSint7()); valor2 =String.valueOf(participante.getSint8()); break;
		case 8: valor1 = String.valueOf(participante.getSint8()); valor2 =String.valueOf(participante.getSint9()); break;
		case 9: valor1 = String.valueOf(participante.getSint9()); valor2 =String.valueOf(participante.getSint10()); break;
		case 10: valor1 = String.valueOf(participante.getSint10()); valor2 =String.valueOf(participante.getSint11()); break;
		case 11: valor1 = String.valueOf(participante.getSint11()); valor2 =String.valueOf(participante.getSint12()); break;
		case 12: valor1 = String.valueOf(participante.getSint12()); valor2 =String.valueOf(participante.getSint13()); break;
		case 13: valor1 = String.valueOf(participante.getSint13()); valor2 =String.valueOf(participante.getSint14()); break;
		case 14: valor1 = String.valueOf(participante.getSint14()); valor2 =String.valueOf(participante.getSint15()); break;
		case 15: valor1 = String.valueOf(participante.getSint15()); valor2 =String.valueOf(participante.getSint16()); break;
		case 16: valor1 = String.valueOf(participante.getSint16()); valor2 =String.valueOf(participante.getSint17()); break;
		case 17: valor1 = String.valueOf(participante.getSint17()); valor2 =String.valueOf(participante.getSint18()); break;
		case 18: valor1 = String.valueOf(participante.getSint18()); valor2 =String.valueOf(participante.getSint19()); break;
		case 19: valor1 = String.valueOf(participante.getSint19()); valor2 =String.valueOf(participante.getSint20()); break;
		case 20: valor1 = String.valueOf(participante.getSint20()); valor2 =String.valueOf(participante.getSint21()); break;
		case 21: valor1 = String.valueOf(participante.getSint21()); valor2 =String.valueOf(participante.getSint22()); break;
		case 22: valor1 = String.valueOf(participante.getSint22()); valor2 =String.valueOf(participante.getSint23()); break;
		case 23: valor1 = String.valueOf(participante.getSint23()); valor2 =String.valueOf(participante.getSint24()); break;
		case 24: valor1 = String.valueOf(participante.getSint24()); valor2 =String.valueOf(participante.getSint25()); break;
		case 25: valor1 = String.valueOf(participante.getSint25()); valor2 =String.valueOf(participante.getSint26()); break;
		case 26: valor1 = String.valueOf(participante.getSint26()); valor2 =String.valueOf(participante.getSint27()); break;
		case 27: valor1 = String.valueOf(participante.getSint27()); valor2 =String.valueOf(participante.getSint28()); break;
		default:
			break;
		}
		if(valor1.matches("1") && valor2.matches("0")){
			img=getContext().getResources().getDrawable( R.drawable.ic_edit);
		}
		else if(valor1.matches("1") && valor2.matches("1")){
			img=getContext().getResources().getDrawable( R.drawable.ic_ok);
		}
		else{
			img=getContext().getResources().getDrawable( R.drawable.ic_error);
		}
		return img;
	}
	
	@Override
    public boolean isEnabled(int position) {
        // Disable the GridView
		boolean habilitar = false;
		String valor1 = "";String valor2 = "";
		switch (position){
		case 0: valor1 = "1"; valor2 =String.valueOf(participante.getSint1()); break;
		case 1: valor1 = String.valueOf(participante.getSint1()); valor2 =String.valueOf(participante.getSint2()); break;
		case 2: valor1 = String.valueOf(participante.getSint2()); valor2 =String.valueOf(participante.getSint3()); break;
		case 3: valor1 = String.valueOf(participante.getSint3()); valor2 =String.valueOf(participante.getSint4()); break;
		case 4: valor1 = String.valueOf(participante.getSint4()); valor2 =String.valueOf(participante.getSint5()); break;
		case 5: valor1 = String.valueOf(participante.getSint5()); valor2 =String.valueOf(participante.getSint6()); break;
		case 6: valor1 = String.valueOf(participante.getSint6()); valor2 =String.valueOf(participante.getSint7()); break;
		case 7: valor1 = String.valueOf(participante.getSint7()); valor2 =String.valueOf(participante.getSint8()); break;
		case 8: valor1 = String.valueOf(participante.getSint8()); valor2 =String.valueOf(participante.getSint9()); break;
		case 9: valor1 = String.valueOf(participante.getSint9()); valor2 =String.valueOf(participante.getSint10()); break;
		case 10: valor1 = String.valueOf(participante.getSint10()); valor2 =String.valueOf(participante.getSint11()); break;
		case 11: valor1 = String.valueOf(participante.getSint11()); valor2 =String.valueOf(participante.getSint12()); break;
		case 12: valor1 = String.valueOf(participante.getSint12()); valor2 =String.valueOf(participante.getSint13()); break;
		case 13: valor1 = String.valueOf(participante.getSint13()); valor2 =String.valueOf(participante.getSint14()); break;
		case 14: valor1 = String.valueOf(participante.getSint14()); valor2 =String.valueOf(participante.getSint15()); break;
		case 15: valor1 = String.valueOf(participante.getSint15()); valor2 =String.valueOf(participante.getSint16()); break;
		case 16: valor1 = String.valueOf(participante.getSint16()); valor2 =String.valueOf(participante.getSint17()); break;
		case 17: valor1 = String.valueOf(participante.getSint17()); valor2 =String.valueOf(participante.getSint18()); break;
		case 18: valor1 = String.valueOf(participante.getSint18()); valor2 =String.valueOf(participante.getSint19()); break;
		case 19: valor1 = String.valueOf(participante.getSint19()); valor2 =String.valueOf(participante.getSint20()); break;
		case 20: valor1 = String.valueOf(participante.getSint20()); valor2 =String.valueOf(participante.getSint21()); break;
		case 21: valor1 = String.valueOf(participante.getSint21()); valor2 =String.valueOf(participante.getSint22()); break;
		case 22: valor1 = String.valueOf(participante.getSint22()); valor2 =String.valueOf(participante.getSint23()); break;
		case 23: valor1 = String.valueOf(participante.getSint23()); valor2 =String.valueOf(participante.getSint24()); break;
		case 24: valor1 = String.valueOf(participante.getSint24()); valor2 =String.valueOf(participante.getSint25()); break;
		case 25: valor1 = String.valueOf(participante.getSint25()); valor2 =String.valueOf(participante.getSint26()); break;
		case 26: valor1 = String.valueOf(participante.getSint26()); valor2 =String.valueOf(participante.getSint27()); break;
		case 27: valor1 = String.valueOf(participante.getSint27()); valor2 =String.valueOf(participante.getSint28()); break;
		default:
			break;
		}
		if(valor1.matches("1") && valor2.matches("0")){
			habilitar = true;
		}
		else{
			habilitar = false;
		}
		return habilitar;
    }
}
