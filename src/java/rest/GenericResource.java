
import com.google.gson.Gson;
import dataGenerator.DataGenerator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/addresses")
public class GenericResource {

    Gson gson;
    DataGenerator data = new DataGenerator();

    /**
     * Creates a new instance of RestService
     */
    

    @GET
    @Produces("application/json")
    public Response getPerson() {
        return Response.status(Response.Status.OK).entity(data.getOnePersonJsonAsString()).build();
    }
    
    @GET
    @Path("{count}")
    @Produces("application/json")
    public String getBook(
    @PathParam("count") int count)
    {
        return data.getData(count, true, true, true, true);
    }
}

