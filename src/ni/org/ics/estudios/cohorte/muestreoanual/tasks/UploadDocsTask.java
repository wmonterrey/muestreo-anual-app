package ni.org.ics.estudios.cohorte.muestreoanual.tasks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapterEnvio;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapterGetObjects;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Documentos;
import ni.org.ics.estudios.cohorte.muestreoanual.listeners.UploadListener;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.Constants;
import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.util.Log;

public class UploadDocsTask extends UploadTask {

	protected static final String TAG = UploadDocsTask.class.getSimpleName();
	private List<Documentos> mDocumentos = new ArrayList<Documentos>();
	

	private String url = null;
	private String username = null;
	private String password = null;
	private String error = null;
	private int c = 0;
	protected UploadListener mStateListener;

	@Override
	protected String doInBackground(String... values) {
		url = values[0];
		username = values[1];
		password = values[2];

		try {
			getDocumentos();
			if(mDocumentos.size()>0){
				CohorteAdapterGetObjects cAdap = new CohorteAdapterGetObjects();
				cAdap.open();
				c = mDocumentos.size();
				for(Documentos documento : mDocumentos){
					String filtro = "codigo = " + documento.getDocsId().getCodigo() + " and fechaDocumento = " + documento.getDocsId().getFechaDocumento().getTime();
					Documentos aEnviar = cAdap.getDocumentos(filtro);
					saveDocumento(Constants.STATUS_SUBMITTED,documento);
					error = cargarDocumento(url, username, password, aEnviar);
					if (!error.matches("Datos recibidos!")){
						saveDocumento(Constants.STATUS_NOT_SUBMITTED,documento);
						cAdap.close();
						return error;
					}
				}
				cAdap.close();
				return "Datos recibidos!";
			}
			else{
				return "Datos recibidos!";
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			return e1.getLocalizedMessage();
		}
	}
	
	
	/**cargar Documentos**/
	// url, username, password
	protected String cargarDocumento(String url, String username, 
			String password,Documentos doc) throws Exception {
		try {
			// La URL de la solicitud POST
			final String urlRequest = url + "/movil/documentos";
			HttpHeaders requestHeaders = new HttpHeaders();
			HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
			requestHeaders.setContentType(MediaType.APPLICATION_JSON);
			requestHeaders.setAuthorization(authHeader);
			HttpEntity<Documentos> requestEntity = 
					new HttpEntity<Documentos>(doc, requestHeaders);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
			restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
			// Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
			ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
					String.class);
			return response.getBody();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
			return e.getMessage();
		}

	}	
	
	private void saveDocumento(String estado, Documentos doc) {
		CohorteAdapterEnvio actualizar = new CohorteAdapterEnvio();
		actualizar.open();
		doc.setEstado(estado);
		doc.setFechaRecepcion(new Date());
		actualizar.updateDocumentosSent(doc);
		publishProgress("Actualizando documentos", Integer.valueOf(mDocumentos.indexOf(doc)).toString(), Integer
					.valueOf(c).toString());
		actualizar.close();
	}

	private void getDocumentos(){
		CohorteAdapterGetObjects ca = new CohorteAdapterGetObjects();
		ca.open();
		mDocumentos = ca.getDocumentosSinEnviar();
		ca.close();
	}

}