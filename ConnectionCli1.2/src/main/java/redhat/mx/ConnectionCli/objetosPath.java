package redhat.mx.ConnectionCli;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jboss.dmr.Property;

public class objetosPath {
	private List<Property> propiedad;
	private List<Path> rutas = new ArrayList<Path>();
	
	//se almacena la lista con la información correspondiente 
	public objetosPath( List <Property> propiedad)
	{
		setPropiedad(propiedad);
	}

	public void setPropiedad( List <Property> propiedad) {
		this.propiedad = propiedad;
	}
	// se guardan los datos en nodos con path
	public void enlazaPath( )
	{
		 for (Property dataSource : propiedad) {
	        	rutas.add( new Path(dataSource));
	         }
			
	}
	//se imprime la informacion del path
	
	public String getObjetoPath()
	{
		
		
		String texto="";
		texto=
		"<chapter id=\"chap-Book-Test_Chapter\">\n<title>Paths</title>\n"+
		"<section id=\"sect-Book-Test_Chapter-Test_Section_1\">\n"+
			"<title>Test Section 1</title>\n";
			
		texto+="\n\t<orderedlist>\n";
		for ( int i = 0; i < rutas.size();i++)
        {
		  texto+="\t\t<listitem>\n\t\t\t\t<para>\n";	
		  texto+="\t\t\t\""+rutas.get(i).getInfo()+"\"\n" ;
		  texto+="\t\t</para>\n\t\t\t\t</listitem>\n";	
        }
		texto+="\n\t</orderedlist>\n"+
		"</section>\n"+
		"</chapter>\n";
		return texto;
	}
	

}
