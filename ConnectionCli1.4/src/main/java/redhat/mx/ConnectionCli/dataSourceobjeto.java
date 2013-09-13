package redhat.mx.ConnectionCli;

import org.jboss.dmr.Property;

public class dataSourceobjeto {
	private String nombre;
	private String allow_multiple_users;
	private String connection_properties;
	private String connection_url;
	private String datasource_class;
	private String driver_class;
    private String driver_name;
    private String enabled;
    private String jndi_name;
    private String jta;
    private String new_connection_sql;
    private String password;
    private String security_domain;
    private String spy;
    private String track_statements;
    private String use_ccm;
    private String use_fast_fail;
    private String use_java_context;
    private String user_name;
    public dataSourceobjeto( Property source){
    	setNombre ( source.getName() );
    	setAllow_multiple_users(source.getValue().get("allow-multiple-users").asString() );
    	setConnection_properties(source.getValue().get("connection-properties").asString() );
    	setConnection_url(source.getValue().get("connection-url").asString() );
    	setDatasource_class(source.getValue().get("datasource-class").asString() );
    	setDriver_class(source.getValue().get("driver-class").asString() );
    	setDriver_name(source.getValue().get("driver-name").asString() );
    	setEnabled(source.getValue().get("enabled").asString() );
    	setJndi_name(source.getValue().get("jndi-name").asString() );
    	setJta(source.getValue().get("jta").asString() );
    	setNew_connection_sql(source.getValue().get("new-connection-sql").asString() );
    	setPassword(source.getValue().get("password").asString() );
    	setSecurity_domain(source.getValue().get("security-domain").asString() );
    	setSpy(source.getValue().get("spy").asString() );
    	setTrack_statements(source.getValue().get("track-statements").asString() );
    	setUse_ccm(source.getValue().get("use-ccm").asString() );
    	setUse_fast_fail(source.getValue().get("use-fast-fail").asString() );
    	setUse_java_context(source.getValue().get("use-java-context").asString() );
    	setUser_name(source.getValue().get("user-name").asString() );
    	
    	
    }
	private String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private String getAllow_multiple_users() {
		return allow_multiple_users;
	}
	private void setAllow_multiple_users(String allow_multiple_users) {
		this.allow_multiple_users = allow_multiple_users;
	}
	private String getConnection_properties() {
		return connection_properties;
	}
	private void setConnection_properties(String connection_properties) {
		this.connection_properties = connection_properties;
	}
	private String getConnection_url() {
		return connection_url;
	}
	private void setConnection_url(String connection_url) {
		this.connection_url = connection_url;
	}
	private String getDatasource_class() {
		return datasource_class;
	}
	private void setDatasource_class(String datasource_class) {
		this.datasource_class = datasource_class;
	}
	private String getDriver_class() {
		return driver_class;
	}
	private void setDriver_class(String driver_class) {
		this.driver_class = driver_class;
	}
	private String getDriver_name() {
		return driver_name;
	}
	private void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	private String getEnabled() {
		return enabled;
	}
	private void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	private String getJndi_name() {
		return jndi_name;
	}
	private void setJndi_name(String jndi_name) {
		this.jndi_name = jndi_name;
	}
	private String getJta() {
		return jta;
	}
	private void setJta(String jta) {
		this.jta = jta;
	}
	private String getNew_connection_sql() {
		return new_connection_sql;
	}
	private void setNew_connection_sql(String new_connection_sql) {
		this.new_connection_sql = new_connection_sql;
	}
	private String getPassword() {
		return password;
	}
	private void setPassword(String password) {
		this.password = password;
	}
	private String getSecurity_domain() {
		return security_domain;
	}
	private void setSecurity_domain(String security_domain) {
		this.security_domain = security_domain;
	}
	private String getSpy() {
		return spy;
	}
	private void setSpy(String spy) {
		this.spy = spy;
	}
	private String getTrack_statements() {
		return track_statements;
	}
	private void setTrack_statements(String track_statements) {
		this.track_statements = track_statements;
	}
	private String getUse_ccm() {
		return use_ccm;
	}
	private void setUse_ccm(String use_ccm) {
		this.use_ccm = use_ccm;
	}
	private String getUse_fast_fail() {
		return use_fast_fail;
	}
	private void setUse_fast_fail(String use_fast_fail) {
		this.use_fast_fail = use_fast_fail;
	}
	private String getUse_java_context() {
		return use_java_context;
	}
	private void setUse_java_context(String use_java_context) {
		this.use_java_context = use_java_context;
	}
	private String getUser_name() {
		return user_name;
	}
	private void setUser_name(String user_name) {
		this.user_name = user_name;
	}
    public String getInfo(){
    	String info = "Datasource : "+getNombre ( )+"\n" ;
    	info+="\t\tAllow_multiple_user = "+getAllow_multiple_users()+"\n" ;
    	info+="\t\tConnection_properties = "+getConnection_properties()+"\n" ;
    	info+="\t\tConnection_url = "+getConnection_url()+"\n" ;
    	info+="\t\tDatasource_class = "+getDatasource_class()+"\n" ;
    	info+="\t\tDriver_class = "+getDriver_class()+"\n" ;
    	info+="\t\tDriver_name = "+getDriver_name()+"\n" ;
    	info+="\t\tEnabled = "+getEnabled()+"\n" ;
    	info+="\t\tJndi_name = "+getJndi_name()+"\n" ;
    	info+="\t\tJta = "+getJta()+"\n" ;
    	info+="\t\tNew_connection_sql = "+getNew_connection_sql()+"\n" ;
    	info+="\t\tPassword = "+getPassword()+"\n" ;
    	info+="\t\tSecurity_domain = "+getSecurity_domain()+"\n" ;
    	info+="\t\tSpy = "+getSpy()+"\n" ;
    	info+="\t\tTrack_statements"+getTrack_statements()+"\n" ;
    	info+="\t\tUse_ccm = "+getUse_ccm()+"\n";
    	info+="\t\tUse_fast_fail = "+getUse_fast_fail()+"\n";
    	info+="\t\tUse_java_context = "+getUse_java_context()+"\n";
    	info+="\t\tUser_name = "+getUser_name()+"\n";
    	return info;
    }
    
}
