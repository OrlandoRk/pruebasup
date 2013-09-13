package redhat.mx.ConnectionCli;
import org.jboss.dmr.Property;



public class pathobjeto {
	private String propiedad;
	private String name;
	private String path;
	private String read_only;
	private String relative_to;
 
	
	public pathobjeto( Property source)
	{
		setPropiedad(source.getName());
		setName( source.getValue().get("name").asString() );
		setPath( source.getValue().get("path").asString() );
		setRead_only( source.getValue().get("read-only").asString() );
		setRelative_to( source.getValue().get("relative-to").asString() );
	   
		
	}

	public String getInfo()
	{
		return getPropiedad()+": "+getPath()+"";
	}
	public String getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getRead_only() {
		return read_only;
	}

	public void setRead_only(String read_only) {
		this.read_only = read_only;
	}

	public String getRelative_to() {
		return relative_to;
	}

	public void setRelative_to(String relative_to) {
		this.relative_to = relative_to;
	}
	

}
