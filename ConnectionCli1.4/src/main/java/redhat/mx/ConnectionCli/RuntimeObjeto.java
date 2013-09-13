package redhat.mx.ConnectionCli;
import java.util.List;

import org.jboss.dmr.Property;


public class RuntimeObjeto {

	private String vm_name;
	private String vm_vendorName;
	private String vm_versionValor;
	private String spec_versionValor;
	private String input_argumentsValor;
	
	public RuntimeObjeto( List<Property> objeto){
		for (Property data: objeto){
			String  output =data.getName().toString(); 
				if(output.compareTo("vm-name") == 0  )
				
					setVm_name (data.getValue().asString() );
					
				
				else if(output.compareTo("vm-version") == 0  )
				
					setVm_versionValor( data.getValue().asString() );
					
				 
				else if(output.compareTo("spec-version") == 0  )
				
					setSpec_versionValor( data.getValue().asString() ) ;
					
				
				else if(output.compareTo("input-arguments") == 0  )
				
					setInput_argumentsValor( data.getValue().asString() );
					
				
				else if(output.compareTo("vm-vendor") == 0  )
				
					setVm_vendorName ( data.getValue().asString() );
				
				
					
				 
		}
		
	}

	private String getVm_name() {
		return vm_name+"\n";
	}

	private void setVm_name(String vm_name) {
		this.vm_name = vm_name;
	}

	private String getVm_vendorName() {
		return vm_vendorName+"\n";
	}

	private void setVm_vendorName(String vm_vendorName) {
		this.vm_vendorName = vm_vendorName;
	}

	private String getVm_versionValor() {
		return vm_versionValor+"\n";
	}

	private void setVm_versionValor(String vm_versionValor) {
		this.vm_versionValor = vm_versionValor;
	}

	private String getSpec_versionValor() {
		return spec_versionValor+"\n";
	}

	private void setSpec_versionValor(String spec_versionValor) {
		this.spec_versionValor = spec_versionValor;
	}

	private String getInput_argumentsValor() {
		return input_argumentsValor+"\n";
	}

	private void setInput_argumentsValor(String input_argumentsValor) {
		this.input_argumentsValor = input_argumentsValor;
	}
	public String getInfo(){
		String info ;
		info = "VM Name = "+getVm_name();
		info += "Vendor Name = "+getVm_vendorName();
		info += "VM version = "+getVm_versionValor();
		info += "java version = "+getSpec_versionValor();
		info += "vm input argumens = "+getInput_argumentsValor();
		return info;
	}
	
}
