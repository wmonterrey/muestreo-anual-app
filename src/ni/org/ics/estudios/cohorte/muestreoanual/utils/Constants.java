package ni.org.ics.estudios.cohorte.muestreoanual.utils;

import android.net.Uri;


/**
 * Constantes usadas en multiples clases de la aplicacion
 * 
 * @author William Aviles
 * 
 */
public class Constants {
	
	
	// status for records
    public static final String STATUS_SUBMITTED = "enviado";
    public static final String STATUS_NOT_SUBMITTED = "no enviado";
    public static final String STATUS_NOT_COMPLETED = "incompleto";
    
    public static final String TODOS = "todos";
    // status for casos
    public static final String STATUS_ACTIVE = "activo";
    public static final String STATUS_INACTIVE = "inactivo";
    
    //Providers
	public static final String AUTHORITY = "org.odk.collect.android.provider.odk.forms";
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/forms");
	public static final String AUTHORITY_I = "org.odk.collect.android.provider.odk.instances";
	public static final Uri CONTENT_URI_I = Uri.parse("content://" + AUTHORITY_I + "/instances");
	
	//nombres de extras
	public static final String TITLE = "titulo";
	public static final String OBJECTO = "objeto";
	
	//Opciones de la actividad de seleccionar participante
	public static final String MENU_INFO = "menu_info";
	public static final String MENU_ZIKA = "menu_zika";
	
	
	

}
