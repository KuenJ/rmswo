package org.zerock.jdbcex3

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Path("/hello-world")
class HelloResource {
    @GET
    @Produces("text/plain")
    String hello() {
        return "Hello, World!"
    }
}