import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8089), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();
    }

    private static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            String str = "Hello. I am HTTPServer.";

            byte[] bytes = str.getBytes();
            exchange.sendResponseHeaders(200,bytes.length);

            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
            System.out.println(exchange.getRequestMethod());

//            if(exchange.getRequestMethod().equals("POST")){
//
//
//                //String result = new BufferedReader(new InputStreamReader(is))
//                //       .lines().collect(Collectors.joining("\n"));
//                //System.out.print("request headers values: ");
//                //System.out.println(exchange.getRequestHeaders().values());
//
//                InputStream is = exchange.getRequestBody();
//                // буффер данных в 64 килобайта
////                byte buf[] = new byte[64*1024];
////                // читаем 64кб от клиента, результат - кол-во реально принятых данных
////                int r = 0;
////                try {
////                    r = is.read(buf);
////                } catch (IOException exception) {
////                    System.err.println("Ошибка чтения из InputStream");
////                    exception.printStackTrace();
////
////                }
//                //Scanner scan = new Scanner(new InputStreamReader(is));
//                //System.out.println(scan.hasNext());
//                System.out.println(exchange.getProtocol());
//                System.out.println(exchange.getResponseCode());
//                Headers requestHeaders = exchange.getRequestHeaders();
//                Set<Map.Entry<String, List<String>>> entries = requestHeaders.entrySet();
//
//                int contentLength = Integer.parseInt(requestHeaders.getFirst("Content-length"));
//                System.out.println("Content-length = "+requestHeaders.getFirst("Content-length"));
//                System.out.println(requestHeaders.keySet());
//                System.out.println(requestHeaders.values());
//                byte[] data = new byte[contentLength];
//                int length = 0;
//                try {
//                    length = is.read(data);
//                } catch (IOException exception) {
//                    exception.printStackTrace();
//                }
//                //System.out.println(length);
//
//
//
//
//
//
//                // создаём строку, содержащую полученую от клиента информацию
//                //String request = new String(buf, 0, r);
//                //System.out.println(r);
//                is.close();
//
//            }

        }
    }
}
