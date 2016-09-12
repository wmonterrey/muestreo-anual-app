package ni.org.ics.estudios.cohorte.muestreoanual.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.Authority;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.User;

import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.util.Log;



public class DownloadUsersRolesTask extends DownloadTask {

	private Boolean permiso;
	private String error = null;
	private String url = null;
	private String username = null;
	private String password = null;
	private List<User> usuarios = null;
	private List<Authority> roles = null;

	@Override
	protected String doInBackground(String... values) {

		url = values[0];
		username = values[1];
		password = values[2];

		try {
			permiso = checkRole();
			if(permiso){
				try {
					error = descargarUsuarios();
				} catch (Exception e) {
					// Regresa error al descargar
					e.printStackTrace();
					return e.getLocalizedMessage();
				}

				if (usuarios != null){
					// open db and clean entries
					ca.open();
					//ca.borrarTodosUsuarios();
					// download and insert barrios
					try {
						addUsuarios(usuarios);
					} catch (Exception e) {
						// Regresa error al insertar
						e.printStackTrace();
						return e.getLocalizedMessage();
					}
					// close db and stream
					ca.close();
				}

				try {
					error = descargarRoles();
				} catch (Exception e) {
					// Regresa error al descargar
					e.printStackTrace();
					return e.getLocalizedMessage();
				}

				if (roles != null){
					// open db and clean entries
					ca.open();
					ca.borrarTodosRoles();
					// download and insert barrios
					try {
						addRoles(roles);
					} catch (Exception e) {
						// Regresa error al insertar
						e.printStackTrace();
						return e.getLocalizedMessage();
					}
					// close db and stream
					ca.close();
				}				
			}
			else{
				return "No tiene permiso";
			}
		} catch (Exception e) {
			// Regresa error al descargar
			e.printStackTrace();
			return e.getLocalizedMessage();
		}
		return error;
	}

	// url, username, password
	protected Boolean checkRole() throws Exception {
		try {
			// The URL for making the GET request
			final String urlRequest = url + "/movil/role/{username}";

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
			ResponseEntity<Boolean> responseEntity = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
					Boolean.class, username);

			return responseEntity.getBody();

		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
			return false;	
		}
	}

	private void addUsuarios(List<User> usuarios) throws Exception {


		int v = usuarios.size();

		ListIterator<User> iter = usuarios.listIterator();

		while (iter.hasNext()){
			User usuario = iter.next();
			if (!ca.existeUsuario(usuario.getUsername())){
				ca.crearUsuario(usuario);
			}
			else{
				ca.actualizarUsuario(usuario);
			}
			publishProgress("Usuarios", Integer.valueOf(iter.nextIndex()).toString(), Integer
					.valueOf(v).toString());
		}

	}

	// url, username, password
	protected String descargarUsuarios() throws Exception {
		try {
			// The URL for making the GET request
			final String urlRequest = url + "/movil/usuarios";

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
			ResponseEntity<User[]> responseEntity = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
					User[].class);

			// convert the array to a list and return it
			usuarios = Arrays.asList(responseEntity.getBody());
			return null;

		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
			return e.getLocalizedMessage();	
		}
	}

	private void addRoles(List<Authority> roles) throws Exception {

		int v = roles.size();

		ListIterator<Authority> iter = roles.listIterator();

		while (iter.hasNext()){
			ca.crearRol(iter.next());
			publishProgress("Roles", Integer.valueOf(iter.nextIndex()).toString(), Integer
					.valueOf(v).toString());
		}

	}

	// url, username, password
	protected String descargarRoles() throws Exception {
		try {
			// The URL for making the GET request
			final String urlRequest = url + "/movil/roles";

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
			ResponseEntity<Authority[]> responseEntity = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
					Authority[].class);

			// convert the array to a list and return it
			roles = Arrays.asList(responseEntity.getBody());
			return null;

		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
			return e.getLocalizedMessage();	
		}
	}
}
