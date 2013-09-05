package redhat.mx.ConnectionCli;
import java.util.ArrayList;
import java.util.List;
import org.jboss.dmr.Property;

public class puertos {
	private String [][]puertos = new String [2][100] ;
	private List <String> name = new ArrayList<String>();
	private List <String> port = new ArrayList<String>();
	private List<Property> propiedad;
	public puertos(List <Property> propiedad){
		this.propiedad = propiedad;
		enlaza();
	}
	
	public void getInfo()
	{
		//ya que los puertos son en pares
		 for (int i = 0; i < name.size() ; i++) {
	          System.out.println(name.get(i)+" -> "+port.get(i));
	         }
			
	}
	private void enlaza(){
		for (Property dataSource : propiedad) {
       	   setPuerto(dataSource);
        }
		
	}
	private void setPuerto(Property source){
		setName( source.getValue().get("name").asString() );
		setPort( source.getValue().get("port").asString() );
	}

	public String getName() {
		String nombre = "";
		for ( int i = 0; i< name.size(); i++)
			nombre+=name.get(i)+"\n";
		return nombre;
	}

	public void setName(String name) {
		this.name.add( name);
	}


	public void setPort(String port) {
		this.port.add( port);
	}
	public String getPort(){
		String nombre = "";
		for ( int i = 0; i< name.size(); i++)
			nombre+=port.get(i)+"\n";
		return nombre;
	}
	
}
