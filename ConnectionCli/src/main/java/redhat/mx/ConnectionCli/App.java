package redhat.mx.ConnectionCli;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.client.OperationBuilder;
import org.jboss.as.controller.client.helpers.ClientConstants;
import org.jboss.dmr.ModelNode;
import org.jboss.dmr.Property;

public class App {
	private static String nodoSocket = "socket-binding-group";
	private static String nodoPath = "path";
	private static File archivoDestino = new File("Chapter.xml");

	public static void main(final String[] args) throws IOException {

		try {

			System.out.println("Lista de datos");
			List<Property> dataSources = getDataSources(nodoPath);
			List<Path> rutas = new ArrayList<Path>();
			PrintWriter outXml = new PrintWriter(archivoDestino);
			String lectura;

			objetosPath objpath = new objetosPath(getDataSources(nodoSocket));
			objpath.enlazaPath();
			/**/
			BufferedReader entrada = new BufferedReader(new FileReader(
					"Header.xml"));
			lectura = "";
			while ((lectura = entrada.readLine()) != null) {
				outXml.println(lectura);
			}
			outXml.printf(objpath.getObjetoPath());

			/*
			 * for (Property dataSource : dataSources) {
			 * System.out.println("Property: " + dataSource.getName());
			 * System.out.println("Value: " + dataSource.getValue());
			 * 
			 * }
			 */
			outXml.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<Property> getDataSources(String nodo) throws IOException {
		final ModelNode request = new ModelNode();
		request.get(ClientConstants.OP).set("read-resource");
		request.get("recursive").set(true);
		// request.get(ClientConstants.OP_ADDR).add("path"); //camino a leer
		request.get(ClientConstants.OP_ADDR).add(nodo);
		ModelControllerClient client = null;
		try {
			client = ModelControllerClient.Factory.create(
					InetAddress.getByName("127.0.0.1"), 9999);
			final ModelNode response = client.execute(new OperationBuilder(
					request).build());
			// return
			// response.get(ClientConstants.RESULT).get("path","java.home").asPropertyList();

			// return
			// response.get(ClientConstants.RESULT).get("path").asPropertyList()
			// ; //camino a leer
			return response.get(ClientConstants.RESULT).get(nodo)
					.asPropertyList();
		} finally {
			safeClose(client);
		}
	}

	public static void safeClose(final Closeable closeable) {
		if (closeable != null)
			try {
				closeable.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}

}
