package redhat.mx.ConnectionCli;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jboss.dmr.Property;
public class loggerobjeto {
	//*
	private List<String> data = new ArrayList<String>();
	
	private String []rutas = {"subsystem","logging"};
	
	private static String []handlers = {"file-handler","async-handler",
			"custom-handler","syslog-handler",
			"root-logger","root-periodic-rotating-file-handler",
			"size-rotating-file-handler"};//*
	private List<String> handler = new ArrayList<String>();
	private List<String> Level = new ArrayList<String>();
	
	private conexionJbossCli conexion = new conexionJbossCli();
	private List<Property> informacion;
	public loggerobjeto() throws NullPointerException, IOException{
		getLogging(rutas);		
	}
	public String getInfo()throws NullPointerException,IOException
	{
		String info ="";
		for ( int i = 0; i< data.size() ; i++ ){
			info+=data.get(i)+"\n";
		}
		return info;
	}
	public void getLogging(String []ruta)throws NullPointerException,IOException{
		String operacion="read-resource";
		String [] resourceruntime = {"recursive","include-runtime",""};
		String dinfo;
		informacion = conexion.getDataSources(ruta, operacion, resourceruntime);
		for (Property info :informacion)
		{
			dinfo = "archivo : \n\t\t";
			for( int i = 0; i <7;i++ )
			if (info.getName().compareTo(handlers[i]) == 0){
			dinfo+=info.getName()+"\n\t\t";
			dinfo+=info.getValue().get("level")+"\n\t\t";
			dinfo+=info.getValue().get("handlers").asString()+"\n";
			data.add(dinfo);
			//System.out.println("propiedades :"+info.getName()+"Valor: "+info.getValue());
			break;
			}
		}
	}
	
	

}
