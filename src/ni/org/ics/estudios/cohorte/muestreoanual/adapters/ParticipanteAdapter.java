package ni.org.ics.estudios.cohorte.muestreoanual.adapters;

import java.text.SimpleDateFormat;
import java.util.List;

import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Participante;



import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ParticipanteAdapter extends ArrayAdapter<Participante> {
	
	private SimpleDateFormat mDateFormat = new SimpleDateFormat("MMM dd, yyyy");


	public ParticipanteAdapter(Context context, int textViewResourceId,
			List<Participante> items) {
		super(context, textViewResourceId, items);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.complex_list_item, null);
		}
		Participante participante = getItem(position);
		if (participante != null) {
			TextView textView = (TextView) v.findViewById(R.id.identifier_text);
			if (textView != null) {
				textView.setText(this.getContext().getString(R.string.code) + " " + participante.getCodigo());
				if(participante.getCasaCHF()!=null){
					textView.setText(textView.getText().toString()+ "-CHF:" + participante.getCasaCHF());
				}
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
				textView.setText(mDateFormat.format(participante.getFechaNac()));
			}
			
			ImageView imageView = (ImageView) v.findViewById(R.id.image);
			if (imageView != null) {
				if (participante.getSexo().equals("M")) {
					imageView.setImageResource(R.drawable.male);
				} else if (participante.getSexo().equals("F")) {
					imageView.setImageResource(R.drawable.female);
				}
			}
			String labelHeader="";
			
			labelHeader = labelHeader + "Estudio: " + participante.getEstudio()+"<br />";
			labelHeader = labelHeader + "Barrio: " + participante.getBarrioDesc()+"<br />";
			labelHeader = labelHeader + "Dirección: " + participante.getDirecFicha1()+"<br />";
			labelHeader = labelHeader + "Manzana: " + participante.getManzFicha1()+"<br />";
			labelHeader = labelHeader + "Personas en la casa: " + participante.getCuantasPers()+"<br />";
			labelHeader = labelHeader + "------------<br />";
			if (participante.getEstPart().equals(0)){
				labelHeader = labelHeader + "<br /><font color='red'>Participante retirado</font>";
			}
			else{
				if (participante.getPosZika().matches("Si")) labelHeader = labelHeader + "<font color='red'><b>Participante positivo a ZIKA</b></font><br />";
				if (participante.getMi().matches("Si")) labelHeader = labelHeader + "<font color='red'><b>Participante en monitoreo intensivo CHF</b></font><br />";
				if (participante.getCand().matches("Si")) labelHeader = labelHeader + "<font color='red'><b>Participante candidato a CHF</b></font><br />";
				if (participante.getConsFlu().matches("Si")|| participante.getPesoTalla().matches("Si")
						|| participante.getEnCasa().matches("Si")||participante.getEncPart().matches("Si")
						|| participante.getEncLacMat().matches("Si")||participante.getInfoVacuna().matches("Si")
						|| participante.getConsDeng().matches("Si") || participante.getObsequio().matches("Si")
						|| participante.getConmx().matches("No") || participante.getConmxbhc().matches("No")|| participante.getZika().matches("Si")
						|| participante.getAdn().matches("Si")|| participante.getDatosParto().matches("Si")|| participante.getDatosVisita().matches("Si")){
					labelHeader = labelHeader + "<font color='red'>Pendiente: <br /></font>";
					
					//Primero muestras
					//'#B941E0'purple
					//'#11BDF7' blue
					//'#32B507' green
					if (participante.getConvalesciente().matches("Na")){	
						labelHeader = labelHeader + "<font color='red'>" + this.getContext().getString(R.string.convless14) + "</font><br />";
					}
					else{
						if(participante.getEstudio().equals("Cohorte BB")){
							if (participante.getEdad()>=6){
								if (participante.getConmx().matches("No")){
									if (participante.getPbmc().matches("Si")){
										labelHeader = labelHeader + "<font color='#11BDF7'>Tomar 2cc en tubo PBMC<br /></font>";
									}
									else{
										labelHeader = labelHeader + "<font color='red'>Tomar 2cc en tubo Rojo<br /></font>";
									}
								}
								if (participante.getConmxbhc().matches("No")){
									if (participante.getPaxgene().matches("Si")){
										labelHeader = labelHeader + "<font color='#32B507'>Tomar 1cc para BHC (Paxgene)<br /></font>";
									}
									else{
										labelHeader = labelHeader + "<font color='#B941E0'>Tomar 1cc para BHC<br /></font>";
									}
								}
							}
						}
						else if(participante.getEstudio().equals("Influenza")){
							if(participante.getEdad()>=6 && participante.getEdad()<24){
								if (participante.getConmx().matches("No")){
									if (participante.getPbmc().matches("Si")){
										labelHeader = labelHeader + "<font color='#11BDF7'>Tomar 2cc en tubo PBMC<br /></font>";
										labelHeader = labelHeader + "<font color='red'>Tomar 1cc en tubo Rojo<br /></font>";
										labelHeader = labelHeader + "<font color='#B941E0'>No tomar BHC<br /></font>";
									}
									else{
										labelHeader = labelHeader + "<font color='red'>Tomar 2cc en tubo Rojo<br /></font>";
									}
								}
								if (participante.getConmxbhc().matches("No") && participante.getPbmc().matches("No")){
									if (participante.getPaxgene().matches("Si")){
										labelHeader = labelHeader + "<font color='#32B507'>Tomar 1cc para BHC (Paxgene)<br /></font>";
									}
									else{
										labelHeader = labelHeader + "<font color='#B941E0'>Tomar 1cc para BHC<br /></font>";
									}
								}
							}
							else {
								if (participante.getConmx().matches("No")){
									if (participante.getPbmc().matches("Si")){
										labelHeader = labelHeader + "<font color='#11BDF7'>Tomar 6cc en tubo PBMC<br /></font>";
										labelHeader = labelHeader + "<font color='red'>Tomar 1cc en tubo Rojo<br /></font>";
									}
									else{
										labelHeader = labelHeader + "<font color='red'>Tomar 6cc en tubo Rojo<br /></font>";
									}
								}
								if (participante.getConmxbhc().matches("No")){
									if (participante.getPaxgene().matches("Si")){
										labelHeader = labelHeader + "<font color='#32B507'>Tomar 1cc para BHC (Paxgene)<br /></font>";
									}
									else{
										labelHeader = labelHeader + "<font color='#B941E0'>Tomar 1cc para BHC<br /></font>";
									}
								}
							}
						}
						else if(participante.getEstudio().equals("Influenza  Cohorte BB")){
							if(participante.getEdad()>=6 && participante.getEdad()<24){
								if (participante.getConmx().matches("No")){
									if (participante.getPbmc().matches("Si")){
										labelHeader = labelHeader + "<font color='#11BDF7'>Tomar 2cc en tubo PBMC<br /></font>";
										labelHeader = labelHeader + "<font color='red'>Tomar 1cc en tubo Rojo<br /></font>";
										labelHeader = labelHeader + "<font color='#B941E0'>No tomar BHC<br /></font>";
									}
									else{
										labelHeader = labelHeader + "<font color='red'>Tomar 2cc en tubo Rojo<br /></font>";
									}
								}
								if (participante.getConmxbhc().matches("No") && participante.getPbmc().matches("No")){
									if (participante.getPaxgene().matches("Si")){
										labelHeader = labelHeader + "<font color='#32B507'>Tomar 1cc para BHC (Paxgene)<br /></font>";
									}
									else{
										labelHeader = labelHeader + "<font color='#B941E0'>Tomar 1cc para BHC<br /></font>";
									}
								}
							}
							else {
								if (participante.getConmx().matches("No")){
									if (participante.getPbmc().matches("Si")){
										labelHeader = labelHeader + "<font color='#11BDF7'>Tomar 6cc en tubo PBMC<br /></font>";
										labelHeader = labelHeader + "<font color='red'>Tomar 1cc en tubo Rojo<br /></font>";
									}
									else{
										labelHeader = labelHeader + "<font color='red'>Tomar 6cc en tubo Rojo<br /></font>";
									}
								}
								if (participante.getConmxbhc().matches("No")){
									if (participante.getPaxgene().matches("Si")){
										labelHeader = labelHeader + "<font color='#32B507'>Tomar 1cc para BHC (Paxgene)<br /></font>";
									}
									else{
										labelHeader = labelHeader + "<font color='#B941E0'>Tomar 1cc para BHC<br /></font>";
									}
								}
							}
						}
						else if(participante.getEstudio().equals("Dengue")){
							if (participante.getConmx().matches("No")){
								if (participante.getPbmc().matches("Si")){
									labelHeader = labelHeader + "<font color='#11BDF7'>Tomar 6cc en tubo PBMC<br /></font>";
								}
								else{
									labelHeader = labelHeader + "<font color='red'>Tomar 6cc en tubo Rojo<br /></font>";
								}
							}
							if (participante.getConmxbhc().matches("No")){
								if (participante.getPaxgene().matches("Si")){
									labelHeader = labelHeader + "<font color='#32B507'>Tomar 1cc para BHC (Paxgene)<br /></font>";
								}
								else{
									labelHeader = labelHeader + "<font color='#B941E0'>Tomar 1cc para BHC<br /></font>";
								}
							}
						}
						else if(participante.getEstudio().equals("Dengue  Influenza")){
							if (participante.getConmx().matches("No")){
								if (participante.getPbmc().matches("Si")){
									labelHeader = labelHeader + "<font color='#11BDF7'>Tomar 6cc en tubo PBMC<br /></font>";
									labelHeader = labelHeader + "<font color='red'>Tomar 1cc en tubo Rojo<br /></font>";
								}
								else{
									labelHeader = labelHeader + "<font color='red'>Tomar 6cc en tubo Rojo<br /></font>";
								}
							}
							if (participante.getConmxbhc().matches("No")){
								if (participante.getPaxgene().matches("Si")){
									labelHeader = labelHeader + "<font color='#32B507'>Tomar 1cc para BHC (Paxgene)<br /></font>";
								}
								else{
									labelHeader = labelHeader + "<font color='#B941E0'>Tomar 1cc para BHC<br /></font>";
								}
							}
						}
						if (participante.getConvalesciente().matches("Si")&& participante.getEdad()>=24){
							if (participante.getConmx().matches("No")){
								if (participante.getPbmc().matches("Si")){
									labelHeader = labelHeader + "<font color='#de3163'>Tomar 5cc de convaleciente<br /></font>";
								}
								else{
									labelHeader = labelHeader + "<font color='#de3163'>Tomar 5cc de convaleciente<br /></font>";
								}
							}
						}
					}
					
					//Nuevo orden
					
					if (participante.getEnCasa().matches("Si")) labelHeader = labelHeader + "Encuesta de Casa<br />";
					if (participante.getEncPart().matches("Si")) labelHeader = labelHeader + "Encuesta de Participante<br />";
					if (participante.getConsFlu().matches("Si")) labelHeader = labelHeader + "Consentimiento Influenza <br />";
					if (participante.getConsDeng().matches("Si")) labelHeader = labelHeader + "Consentimiento Dengue<br />";
					if (participante.getZika().matches("Si")) labelHeader = labelHeader + "Consentimiento Zika<br />";
					if (participante.getEncLacMat().matches("Si")) labelHeader = labelHeader + "Encuesta de Lactancia Materna<br />";
					if (participante.getPesoTalla().matches("Si")) labelHeader = labelHeader + "Peso y Talla <br />";
					if (participante.getDatosParto().matches("Si")) labelHeader = labelHeader + "Datos Parto BB<br />";
					if (participante.getInfoVacuna().matches("Si")) labelHeader = labelHeader + "Vacunas<br />";
					if (participante.getDatosVisita().matches("Si")) labelHeader = labelHeader + "Pendiente datos de casa<br />";
					if ((participante.getObsequio().matches("Si"))){
						labelHeader = labelHeader + "<font color='blue'>" + this.getContext().getString(R.string.gift_missing) + "</font><br />";
					}
					if (participante.getAdn().matches("Si")) labelHeader = labelHeader + "<font color='red'><b>Participante pendiente de ADN, Informar a LAB para toma.</b></font><br />";
					if ((participante.getRetoma()!=null && participante.getVolRetoma()!=null)){
						if ((participante.getRetoma().matches("Si"))){
							labelHeader = labelHeader + "<font color='red'>" + this.getContext().getString(R.string.retoma) +": " + participante.getVolRetoma() + "cc </font><br/>";
						}
					}
				}
				else{
					labelHeader = labelHeader + "<font color='blue'>No tiene procedimientos pendientes<br /></font>";
				}
			}
			textView = (TextView) v.findViewById(R.id.infoc_text);
			if (textView != null) {
				textView.setText(Html.fromHtml(labelHeader));
			}
		}
		return v;
	}
}
