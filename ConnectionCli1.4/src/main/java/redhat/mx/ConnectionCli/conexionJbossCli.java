package redhat.mx.ConnectionCli;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.client.OperationBuilder;
import org.jboss.as.controller.client.helpers.ClientConstants;
import org.jboss.dmr.ModelNode;
import org.jboss.dmr.Property;

public class conexionJbossCli {
	private String ip;//"127.0.0.1"
	private int puerto;//9999
	 
	public void setDataIp(String ip,int puerto){
		this.ip = ip;
		this.puerto =puerto;
	}
	 public  List<Property> getDataSources(String [] nodo,String operacion , String []tipo_operacion ) throws IOException {
		 
		 	int iop = 0;
	        final ModelNode request = new ModelNode();
	        request.get(ClientConstants.OP).set(operacion);
	        //recursive,runtime
	        while( true  ){
	        	request.get(tipo_operacion[iop]).set(true);
	        	if (tipo_operacion[++iop] == "")
	        			break;
	        }
	   
	        
	      //  request.get(ClientConstants.OP_ADDR).add("path"); //camino a leer
	        request.get(ClientConstants.OP_ADDR).add(nodo[0]); 
	        ModelControllerClient client = null;
	        try {
	            client = ModelControllerClient.Factory.create(InetAddress.getByName(ip), puerto);
	            final ModelNode response = client.execute(new OperationBuilder(request).build());
	             //return response.get(ClientConstants.RESULT).get("path","java.home").asPropertyList();
	            
	           //return response.get(ClientConstants.RESULT).get("path").asPropertyList() ; //camino a leer
	           return response.get(ClientConstants.RESULT).get(nodo).asPropertyList() ;	
	        } finally {
	            safeClose(client);
	        }
	    }

	    public  void safeClose(final Closeable closeable) {
	        if (closeable != null) try {
	            closeable.close();
	        } catch (Exception e) {
	           System.out.println ( e.getMessage() );
	        }
	    }
}
