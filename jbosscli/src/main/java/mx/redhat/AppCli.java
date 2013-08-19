package mx.redhat;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.client.OperationBuilder;
import org.jboss.as.controller.client.helpers.ClientConstants;
import org.jboss.dmr.ModelNode;
import org.jboss.dmr.Property;

public class AppCli extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            PrintWriter out = response.getWriter();
            List<Property> dataSources = getDataSources();
            for (Property dataSource : dataSources) {
                out.println("Property: " + dataSource.getName());
                out.println("Value: " + dataSource.getValue());

            }

            out.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static List<Property> getDataSources() throws IOException {
        final ModelNode request = new ModelNode();
        request.get(ClientConstants.OP).set("read-resource");
        request.get("recursive").set(true);
        request.get(ClientConstants.OP_ADDR).add("subsystem", "datasources");
        ModelControllerClient client = null;
        try {
            client = ModelControllerClient.Factory.create(InetAddress.getByName("127.0.0.1"), 9999);
            final ModelNode response = client.execute(new OperationBuilder(request).build());
            return response.get(ClientConstants.RESULT).get("data-source","ExampleDS").asPropertyList();
            //return response.get(ClientConstants.RESULT).get("data-source").asList();
        } finally {
            safeClose(client);
        }
    }

    public static void safeClose(final Closeable closeable) {
        if (closeable != null) try {
            closeable.close();
        } catch (Exception e) {
            // no-op
        }
    }
}