package redhat.mx.ConnectionCli;

import java.util.List;

import org.jboss.dmr.Property;

public class deploymentobjeto {
	private String name;
	private String enable;
	private String status;
	private String subsystem;
	private String subdeployment;
	private String runtime_name;
	private String getRuntime_name() {
		return runtime_name;
	}
	private void setRuntime_name(String runtime_name) {
		this.runtime_name = runtime_name;
	}
	public deploymentobjeto(Property dataSource ){
		setName( dataSource.getValue().get("name").asString() );
		setEnable(dataSource.getValue().get("enabled").asString());
		setStatus(dataSource.getValue().get("status").asString());
		setSubsystem(dataSource.getValue().get("subsystem").asString());
		setSubdeployment(dataSource.getValue().get("subdeployment").asString());
		setRuntime_name(dataSource.getValue().get("runtime-name").asString());
	}
	
	public String getInfo(){
		String info ="";
		info+=" name = "+getName();
		info+=" runtime-name = "+getRuntime_name();
		info+=" status = "+getStatus();
		info+=" enabled = "+getEnable();
		info+=" subdeployment = "+ getSubdeployment();
		info+=" subsystem = "+getSubsystem();
		return info;
	}
	private String getName() {
		return name+"\n";
	}
	private void setName(String name) {
		this.name = name;
	}
	private String getEnable() {
		return enable+"\n";
	}
	private void setEnable(String enable) {
		this.enable = enable;
	}
	private String getStatus() {
		return status+"\n";
	}
	private void setStatus(String status) {
		this.status = status;
	}
	private String getSubsystem() {
		return subsystem+"\n";
	}
	private void setSubsystem(String subsystem) {
		this.subsystem = subsystem;
	}
	private String getSubdeployment() {
		return subdeployment+"\n";
	}
	private void setSubdeployment(String subdeployment) {
		this.subdeployment = subdeployment;
	}
	
}
