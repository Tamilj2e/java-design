package design_patterns.builder;

import com.sun.net.httpserver.HttpContext;
import jdk.jfr.ContentType;

import java.util.HashMap;
import java.util.Map;

class HttpRequest{
    private String url;
    private String method;
    private Map<String,String> headers;
    private String body;

    private HttpRequest(){

    }
    public static class Builder{
        private HttpRequest request = new HttpRequest();
        public Builder url(String url){
            this.request.url = url;
            return this;
        }
        public Builder headers(String key,String value){
            if(this.request.headers==null){
                this.request.headers=new HashMap<>();
            }
            this.request.headers.put(key,value);
            return this;
        }

        public Builder method(String method){
            this.request.method=method;
            return this;
        }

        public Builder body(String body){
            this.request.body = body;
            return this;
        }

        public HttpRequest build(){
            if(this.request.url==null){
                throw new IllegalStateException("url required");
            }
            return request;
        }
    }
}
public class Test {

    HttpRequest request = new HttpRequest.Builder().url("gmail.com").method("POST")
            .body("message passed").headers("content-type", "text").build();

}
