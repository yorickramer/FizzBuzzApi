package FizzBuzz;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("fizzbuzz")
public interface IFizzBuzz {
	
	@GET
	@Path("createSeq")
    @Produces({"application/json", "application/xml"})
	Sequence createSeq(@QueryParam("lastElement") String lastElement);
	
}


