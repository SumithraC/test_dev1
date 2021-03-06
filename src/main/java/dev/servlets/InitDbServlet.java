package dev.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;
import org.hsqldb.server.ServerAcl.AclFormatException;

public class InitDbServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
	    super.init();
	    try {
	        System.out.println("Starting Database");
	        HsqlProperties p = new HsqlProperties();
	        p.setProperty("server.database.0", "mem:/opt/db/crm");
	        p.setProperty("server.dbname.0", "mydb");
	        p.setProperty("server.port", "9001");
	        Server server = new Server();
	        server.setProperties(p);
	        server.setLogWriter(null); // can use custom writer
	        server.setErrWriter(null); // can use custom writer
	        server.start();
	    } catch (AclFormatException afex) {
	        throw new ServletException(afex);
	    } catch (IOException ioex) {
	        throw new ServletException(ioex);
	    }
	}
}
