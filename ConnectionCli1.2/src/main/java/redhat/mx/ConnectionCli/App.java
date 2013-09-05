package redhat.mx.ConnectionCli;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.client.OperationBuilder;
import org.jboss.as.controller.client.helpers.ClientConstants;
import org.jboss.dmr.ModelNode;
import org.jboss.dmr.Property;


public class App 
{
	private static String []nodoSocket ={"socket-binding-group","standard-sockets","socket-binding"};
	private static String []nodoPath = {"path"};
	private static String sistema =" system-property";
	private static String sub_sistema ="subsystem";
	private static String []interfaz = {"interface"};
	private static String []logging ={"subsystem","logging"};
	private static File archivoDestino = new File("Chapter.xml");
	private static String read_resource = "read-resource";
	private static String []recursiva = {"recursive",""};
	private static String include_runtime = "include-runtime";
	private static conexionJbossCli conexion = new conexionJbossCli();
	
	
	/*
	 * 
	 * 
	 * 
	 */
	public static void main(final String[] args) throws IOException , NullPointerException ,RuntimeException{

	try{	
		
		System.out.println("Lista de datos");
		String [] resourceruntime = {"recursive","include-runtime",""};
		puertos ports = new puertos(conexion.getDataSources( nodoSocket,read_resource,resourceruntime));
		//List<Property> dataInterfaz = conexion.getDataSources( logging,read_resource,resourceruntime);
		List<Path> rutas = new ArrayList<Path>();
		App objetoapp = new App();
		objetoapp.chapterpath();
		loggerobjeto log1 = new loggerobjeto();
		System.out.println("------------------------------------------------------");
		System.out.println("informacion de loggers");
		System.out.println("------------------------------------------------------\n\n");
		
		log1.getInfo();
		System.out.println("------------------------------------------------------");
		objetoapp.imprime(conexion.getDataSources( logging,read_resource,resourceruntime));
		System.out.println("informacion de puertos");
		System.out.println("------------------------------------------------------");
		ports.getInfo();
		System.out.println("------------------------------------------------------\n\n");
	    //llamada informacion interfaz
		//objetoapp.imprime(conexion.getDataSources( nodoSocket,read_resource,resourceruntime));
	    //llamada informacion interfaz
        
    	}catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println( "error : " + e.getMessage());e.printStackTrace() ;
         
    }
	}
	public  void imprime(List<Property> data){
		System.out.println("informacion de ip's");
		System.out.println("------------------------------------------------------");
		
		 for (Property dataSource : data) {
	         System.out.println( new objetoInterfaz(dataSource).getInfo() );
	        //System.out.println("propiedades :"+dataSource.getName()+"Valor: "+dataSource.getValue());
	        }
		 System.out.println("------------------------------------------------------");
	}
	public void chapterpath() throws IOException{
		PrintWriter outXml = new PrintWriter(archivoDestino );
		BufferedReader entrada = new BufferedReader( new FileReader("Header.xml"));
	    String lectura = "";
		
	    objetosPath objpath = new objetosPath( conexion.getDataSources( nodoPath,read_resource,recursiva ) ); 
        objpath.enlazaPath();
		
        while( (lectura = entrada.readLine() )!=null )
	        {
	        	outXml.println(lectura);
	        }
	       
	    outXml.printf(objpath.getObjetoPath());    
	    outXml.close();  
	        
	        
	}
	
}
 
 
 

