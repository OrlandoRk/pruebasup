package redhat.mx.ConnectionCli;
/*
 * Proyecto de : Ramos Garcia Orlando
 * IDE : eclipse
 * Datos de entrada IP,puerto
 */
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
	private static conexionJbossCli conexion = new conexionJbossCli() ;
	private static String []deployment = {"deployment"};
	private static String []runtime = {"core-service","platform-mbean","type","runtime"};
	/*
	 * 
	 * 
	 * 
	 */
	public static void main(final String[] args) throws IOException , NullPointerException ,RuntimeException{

	try{	
		Scanner in = new Scanner(System.in);
		conexion.setDataIp(args[0],Integer.parseInt(args[1]));
		String [] resourceruntime = {"recursive","include-runtime",""};
		puertos ports = new puertos(conexion.getDataSources( nodoSocket,read_resource,resourceruntime));
		List<pathobjeto> rutas = new ArrayList<pathobjeto>();
		App objetoapp = new App();
		objetoInterfaz interfaces ;
		
		//error si no hay apps desplegadas
		System.out.println("\t\tJboss-standalone-informacion general");
		
	
		// información JVM
	    try{ 
			
			RuntimeObjeto javaversion = new RuntimeObjeto( conexion.getDataSources( runtime,read_resource,resourceruntime) );
			System.out.println("------------------------------------------------------");
			System.out.println("Informacion JVM");
			System.out.println("------------------------------------------------------");
			System.out.println( javaversion.getInfo() );
	        }catch( Exception e){
	        	//System.out.println( "error ( no se encontro la ruta ) :"+runtime) ;
	        }
	    //path
		
	 //	objetoapp.chapterpath();
	    try {

			System.out.println("------------------------------------------------------");
		    System.out.println("informacion de path");
		    System.out.println("------------------------------------------------------");
		    path objpath = new path( conexion.getDataSources( nodoPath,read_resource,recursiva ) ); 
	        objpath.enlazaPath();
	        System.out.println(objpath.getObjetoPath());    
  
	    	
	    }catch(Exception e){
	    	
	    }
		//aplicaciones 
		try{
			deployment aplicaciones;
			aplicaciones = new deployment( conexion.getDataSources( deployment,read_resource,resourceruntime) );
			System.out.println("------------------------------------------------------");
			System.out.println("Deployment");
			System.out.println("------------------------------------------------------");
			System.out.println( aplicaciones.getInfo() );
			
		}catch(Exception e){
			System.out.println("------------------------------------------------------");
			System.out.println("NO Deployment");
			System.out.println("------------------------------------------------------");
		}
		//
		try{
		loggerobjeto log1 = new loggerobjeto();
		System.out.println("------------------------------------------------------");
		System.out.println("informacion de loggers");
		System.out.println("------------------------------------------------------\n\n");
		System.out.println(log1.getInfo());
		}catch(Exception e){
			//
		}
		try{
		System.out.println("------------------------------------------------------");
	    System.out.println("informacion de ip's");
	    System.out.println("------------------------------------------------------");
	    objetoapp.imprime(conexion.getDataSources( interfaz,read_resource,resourceruntime));
		}catch( Exception e){
			//
		}
		
		try{
		System.out.println("informacion de puertos");
		System.out.println("------------------------------------------------------");
		System.out.println( ports.getInfo() );
		}catch( Exception e){
			//
		}
		try{
		String []datasourcepath = {"subsystem","datasources","data-source"};
		List <Property> ddd = conexion.getDataSources( datasourcepath,read_resource,resourceruntime);
		System.out.println("------------------------------------------------------");
	    System.out.println("informacion de data-source's");
	    System.out.println("------------------------------------------------------");
		 for (Property dataSource : ddd) {
		        System.out.println( new dataSourceobjeto(dataSource).getInfo());
		        }
		}catch( Exception e){
			
		}
    		
    	}catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println( " forma ejecucion : parametros-ejecucion ip puerto\n" + e.getMessage());e.printStackTrace() ;
        
         
    }
	}
	
	//imprime datos de la interface
	public  void imprime(List<Property> data){
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
		
	    path objpath = new path( conexion.getDataSources( nodoPath,read_resource,recursiva ) ); 
        objpath.enlazaPath();
		
        while( (lectura = entrada.readLine() )!=null )
	        {
	        	outXml.println(lectura);
	        }
	       
	    outXml.printf(objpath.getObjetoPath());    
	    outXml.close();  
	        
	        
	}
	
}
 
 
 

