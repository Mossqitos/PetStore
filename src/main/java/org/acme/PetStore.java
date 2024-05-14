package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.ResponseStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Path("/pet")
public class PetStore {
    //MapPet alt
    private Map<Integer, Pet> petsById = new HashMap<>();

    //Add pet data to map
    public PetStore() {
        Pet[] pets = {
                new Pet(1, new Category(1, "Dogs"), "Fido", Arrays.asList("url1", "url2"), Arrays.asList(new Tag(1, "tag1"), new Tag(2, "tag2")), "available"),
                new Pet(2, new Category(2, "Dogs"), "Rex", Arrays.asList("url3", "url4"), Arrays.asList(new Tag(3, "tag3"), new Tag(4, "tag4")), "available"),
                new Pet(3, new Category(3, "Dogs"), "Max", Arrays.asList("url5", "url6"), Arrays.asList(new Tag(5, "tag5"), new Tag(6, "tag6")), "available"),
                new Pet(4, new Category(4, "Cats"), "Milo", Arrays.asList("url7", "url8"), Arrays.asList(new Tag(7, "tag7"), new Tag(8, "tag8")), "available"),
                new Pet(5, new Category(5, "Cats"), "Tiger", Arrays.asList("url9", "url10"), Arrays.asList(new Tag(9, "tag9"), new Tag(10, "tag10")), "available"),
                new Pet(6, new Category(6, "Birds"), "Tweety", Arrays.asList("url11", "url12"), Arrays.asList(new Tag(11, "tag11"), new Tag(12, "tag12")), "available"),
                new Pet(7, new Category(7, "Birds"), "Polly", Arrays.asList("url13", "url14"), Arrays.asList(new Tag(13, "tag13"), new Tag(14, "tag14")), "available"),
                new Pet(8, new Category(8, "Rabbits"), "Bugs", Arrays.asList("url15", "url16"), Arrays.asList(new Tag(15, "tag15"), new Tag(16, "tag16")), "available"),
                new Pet(9, new Category(9, "Rabbits"), "Thumper", Arrays.asList("url17", "url18"), Arrays.asList(new Tag(17, "tag17"), new Tag(18, "tag18")), "available"),
                new Pet(10, new Category(10, "Fish"), "Nemo", Arrays.asList("url19", "url20"), Arrays.asList(new Tag(19, "tag19"), new Tag(20, "tag20")), "available")
        };
        for (Pet pet : pets) {
            petsById.put(pet.getId(), pet);
        }
    }

//    @Produces(MediaType.TEXT_PLAIN)
//    @Consumes(MediaType.TEXT_PLAIN)
    //Check all number of pets
    @GET
    @Path("count")
    public Response count() {
        return Response.ok(petsById.size(), MediaType.APPLICATION_JSON).build();
    }


    //Get all pets
    @GET
    @Path("GetAll")
    public Response getAll() {
        return Response.ok(petsById, MediaType.APPLICATION_JSON).build();
    }

    //Get by id
    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") int id) {
        //select pet by key (id)
        Pet pet = petsById.get(id);

        //null check
        if (pet == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        //return pet by id that selected
        return Response.ok(pet, MediaType.APPLICATION_JSON).build();
    }

    //Update pet
    @PUT
    @Path("{id}")
    public Response updatePet(@PathParam("id") int id, Pet pet) {
        // Check if pet exists
        if (!petsById.containsKey(id)) {
            return Response.status(Response.Status.NOT_FOUND).entity("Pet not found.").build();
        }

        // Update pet
        petsById.put(id, pet);
        return Response.ok(pet, MediaType.APPLICATION_JSON).build();
    }

    //Add new pet
    @POST
    @Path("Add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPet(Pet pet) {
        // Check duplicate
        if (petsById.containsKey(pet.getId())) {
            return Response.status(Response.Status.CONFLICT).entity("A pet with this ID already exists.").build();
        }

        // Add new pet to map
        petsById.put(pet.getId(), pet);
        return Response.ok(pet, MediaType.APPLICATION_JSON).build();
    }


}
