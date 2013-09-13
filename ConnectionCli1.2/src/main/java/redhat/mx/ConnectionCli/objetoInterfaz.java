package redhat.mx.ConnectionCli;

import org.jboss.dmr.Property;

public class objetoInterfaz {
	private Property propiedad;
	//nombre de la llave principal
	private String nombre_propiedad;
	//variables definidas para cada interface
	private String any_address;
	private String any_ipv4_address;
	private String any_ipv6_address;
	private String inet_address; 
	private String link_local_address;
	private String loopback;
	private String loopback_address;
	private String multicast;
	private String name;
	private String nic;
	private String nic_match;
	private String not;
	private String point_to_point;
	private String public_address;
	private String site_local_address;
	private String subnet_match;
	private String up;
	private String virtual;
	private String resolved_address;
	
	public objetoInterfaz(Property source) {
		this.propiedad = source;
		setInfo();
		// TODO Auto-generated constructor stub
	}
	public void  setInfo()
	{
		setNombre_propiedad( propiedad.getName() );
		setAny_address( propiedad.getValue().get("any-address").asString() );
		setAny_ipv4_address(propiedad.getValue().get("any-ipv4-address").asString());
		setAny_ipv6_address (propiedad.getValue().get("any-ipv6-address").asString());
		setInet_address(propiedad.getValue().get("inet-address").asString());
		setLink_local_address (propiedad.getValue().get("link-local-address").asString());
		setLoopback_address (propiedad.getValue().get("loopback-address").asString());
		setPublic_address(propiedad.getValue().get("public-address").asString());
		setResolved_address(propiedad.getValue().get("resolved-address").asString()); 
	}
	public String getInfo()
	{
	 String info="";	
		info = "any-address :"+getAny_address()+"\n"+
		"any-ipv4-address :"+getAny_ipv4_address()+"\n"+
		"any-ipv6-address :"+getAny_ipv6_address()+"\n"+
		"inet-address :"+getInet_address()+"\n"+
		"link-local-address :"+getLink_local_address()+"\n"+
		"loopback-address :"+getLoopback_address()+"\n"+
		"public-address :"+getPublic_address()+"\n"+
		"resolved-address :"+getResolved_address()+"\n";	 
	 return info;
	}
	public String getResolved_address() {
		return resolved_address;
	}
	public void setResolved_address(String resolved_address) {
		this.resolved_address = resolved_address;
	}
	public String getAny_address() {
		return any_address;
	}

	public void setAny_address(String any_address) {
		this.any_address = any_address;
	}

	public String getAny_ipv4_address() {
		return any_ipv4_address;
	}

	public void setAny_ipv4_address(String any_ipv4_address) {
		this.any_ipv4_address = any_ipv4_address;
	}

	public String getAny_ipv6_address() {
		return any_ipv6_address;
	}

	public void setAny_ipv6_address(String any_ipv6_address) {
		this.any_ipv6_address = any_ipv6_address;
	}

	public String getInet_address() {
		return inet_address;
	}

	public void setInet_address(String inet_address) {
		this.inet_address = inet_address;
	}

	public String getLink_local_address() {
		return link_local_address;
	}

	public void setLink_local_address(String link_local_address) {
		this.link_local_address = link_local_address;
	}

	public String getLoopback_address() {
		return loopback_address;
	}

	public void setLoopback_address(String loopback_address) {
		this.loopback_address = loopback_address;
	}
	public Property getPropiedad() {
		return propiedad;
	}
	public void setPropiedad(Property propiedad) {
		this.propiedad = propiedad;
	}
	public String getNombre_propiedad() {
		return nombre_propiedad;
	}
	public void setNombre_propiedad(String nombre_propiedad) {
		this.nombre_propiedad = nombre_propiedad;
	}
	public String getPublic_address() {
		return public_address;
	}
	public void setPublic_address(String public_address) {
		this.public_address = public_address;
	}
	
		
}
