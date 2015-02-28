package com.millross.vertx.demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerRequest;

/**
 * Hello world!
 *
 */
public class DemoVerticle extends AbstractVerticle
{
    public static void main( String[] args ) {
        Vertx.vertx().deployVerticle(new DemoVerticle());
    }

    @Override
    public void start() throws Exception {
        super.start();
        HttpServer server = getVertx().createHttpServer(new HttpServerOptions().setPort(8080));
        server.requestHandler(req -> req.response().end(responseBody(req)));
        server.listen();
    }

    private String responseBody(final HttpServerRequest req) {
        String param = req.params().get("abc");
        return("Hello" + (param == null ? "" : " " + param + "0"));
    }
}
