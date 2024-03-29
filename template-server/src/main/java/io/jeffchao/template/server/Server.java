package io.jeffchao.template.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;



import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {

  public static void main(String[] args) throws IOException, InterruptedException {
    String portString = System.getenv("PORT");
    int port = portString == null ? 4040 : Integer.valueOf(portString);
    HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
    server.createContext("/", new MyHandler());
    server.setExecutor(null); // creates a default executor
//    server.start();
    TimeUnit.SECONDS.sleep(10);
    System.out.println("Hello from Template Server");
//    this.server.stop();
  }

  static class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
      String response = "Hello from Gradle!";
      t.sendResponseHeaders(200, response.length());
      OutputStream os = t.getResponseBody();
      os.write(response.getBytes());
      os.close();
    }
  }
}