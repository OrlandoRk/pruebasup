package redhat.mx.ConnectionCli;

import java.util.ArrayList;
import java.util.List;

import org.jboss.dmr.Property;

public class deployment {

	private List<deploymentobjeto> lista = new ArrayList<deploymentobjeto>();
	public deployment(List<Property> dataSource ){
		for ( Property data :dataSource){
			
			lista.add( new deploymentobjeto(data) );
		}
		
		
	}
	public String getInfo(){
		String info = "";
		int i;
		for ( i = 0; i< lista.size();i++){
			info+="\n";
			info=info+lista.get(i).getInfo();
		}
		return info;
	}

}
