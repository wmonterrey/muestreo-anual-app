package ni.org.ics.estudios.cohorte.muestreoanual.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.Casa;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Participante;
import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.database.Cursor;
import android.util.Log;



public class DownloadParticipanteTask extends DownloadTask {

	private Integer codCasa;
	private String codigo;
	private String error = null;
	private String url = null;
	private String username = null;
	private String password = null;
	private List<Casa> casas = null;
	private List<Participante> participantes = null;

	@Override
	protected String doInBackground(String... values) {

		url = values[0];
		username = values[1];
		password = values[2];
		codigo = values[3];

		try {
			codCasa = checkCasa();
			if (codCasa>0){
				try {
					error = descargarCasas();
				} catch (Exception e) {
					// Regresa error al descargar
					e.printStackTrace();
					return e.getLocalizedMessage();
				}

				if (casas != null){
					// open db and clean entries
					ca.open();
					Cursor c = ca.buscarCasa(codCasa);
					if (!(c != null && c.getCount()>0)){
						try {
							addCasas(casas);
						} catch (Exception e) {
							// Regresa error al insertar
							e.printStackTrace();
							return e.getLocalizedMessage();
						}
					}
					// close db and stream
					if (c != null) {
						c.close();
					}
					ca.close();
				}

				try {
					error = descargarParticipantes();
				} catch (Exception e) {
					// Regresa error al descargar
					e.printStackTrace();
					return e.getLocalizedMessage();
				}

				if (participantes != null){
					// open db and clean entries
					ca.open();
					Cursor c = ca.buscarParticipante(Integer.valueOf(codigo));
					if (!(c != null && c.getCount()>0)){
						try {
							addParticipantes(participantes);
						} catch (Exception e) {
							// Regresa error al insertar
							e.printStackTrace();
							return e.getLocalizedMessage();
						}
					}
					// close db and stream
					if (c != null) {
						c.close();
					}

					ca.close();
				}
			}
			else{
				error = "No encontrado..";
			}
		} catch (Exception e) {
			// Regresa error al descargar
			e.printStackTrace();
			return e.getLocalizedMessage();
		}
		return error;
	}

	// url, username, password
	protected Integer checkCasa() throws Exception {
		try {
			// The URL for making the GET request
			final String urlRequest = url + "/movil/checkcasa/{codigo}";

			// Set the Accept header for "application/json"
			HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
			HttpHeaders requestHeaders = new HttpHeaders();
			List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
			acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
			requestHeaders.setAccept(acceptableMediaTypes);
			requestHeaders.setAuthorization(authHeader);

			// Populate the headers in an HttpEntity object to use for the request
			HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

			// Create a new RestTemplate instance
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

			// Perform the HTTP GET request
			ResponseEntity<Integer> responseEntity = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
					Integer.class, codigo);

			return responseEntity.getBody();

		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
			return 0;	
		}
	}

	private void addCasas(List<Casa> casas) throws Exception {

		int v = casas.size();

		ListIterator<Casa> iter = casas.listIterator();

		while (iter.hasNext()){
			ca.crearCasa(iter.next());
			publishProgress("Casas", Integer.valueOf(iter.nextIndex()).toString(), Integer
					.valueOf(v).toString());
		}

	}

	// url, username, password
	protected String descargarCasas() throws Exception {
		try {
			// The URL for making the GET request
			final String urlRequest = url + "/movil/casa/{codCasa}";

			// Set the Accept header for "application/json"
			HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
			HttpHeaders requestHeaders = new HttpHeaders();
			List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
			acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
			requestHeaders.setAccept(acceptableMediaTypes);
			requestHeaders.setAuthorization(authHeader);

			// Populate the headers in an HttpEntity object to use for the request
			HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

			// Create a new RestTemplate instance
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

			// Perform the HTTP GET request
			ResponseEntity<Casa[]> responseEntity = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
					Casa[].class, codCasa);

			// convert the array to a list and return it
			casas = Arrays.asList(responseEntity.getBody());
			return null;

		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
			return e.getLocalizedMessage();	
		}
	}


	private void addParticipantes(List<Participante> participantes) throws Exception {

		int v = participantes.size();

		ListIterator<Participante> iter = participantes.listIterator();

		while (iter.hasNext()){
			ca.crearParticipante(iter.next());
			publishProgress("Participantes", Integer.valueOf(iter.nextIndex()).toString(), Integer
					.valueOf(v).toString());
		}

	}

	// url, username, password
	protected String descargarParticipantes() throws Exception {
		try {
			// The URL for making the GET request
			final String urlRequest = url + "/movil/participante/{codigo}";

			// Set the Accept header for "application/json"
			HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
			HttpHeaders requestHeaders = new HttpHeaders();
			List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
			acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
			requestHeaders.setAccept(acceptableMediaTypes);
			requestHeaders.setAuthorization(authHeader);

			// Populate the headers in an HttpEntity object to use for the request
			HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

			// Create a new RestTemplate instance
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

			// Perform the HTTP GET request
			ResponseEntity<Participante[]> responseEntity = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
					Participante[].class, codigo);

			// convert the array to a list and return it
			participantes = Arrays.asList(responseEntity.getBody());
			return null;

		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
			return e.getLocalizedMessage();	
		}
	}

}
