package org.acme.Pet;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.*;

@Path("/pet")
public class PetStore {
    //MapPet alt
    private Map<Integer, Petmodel> petsById = new HashMap<>();

    //Add pet data to map
    public PetStore() {
        Petmodel[] pets = {
                new Petmodel(1, new Category(1, "Dogs"), "Fido", Arrays.asList("url1", "url2"), Arrays.asList(new Tag(1, "tag1"), new Tag(2, "tag2")), "available"),
                new Petmodel(2, new Category(1, "Dogs"), "Rex", Arrays.asList("url3", "url4"), Arrays.asList(new Tag(3, "tag3"), new Tag(4, "tag4")), "available"),
                new Petmodel(3, new Category(1, "Dogs"), "Max", Arrays.asList("url5", "url6"), Arrays.asList(new Tag(5, "tag5"), new Tag(6, "tag6")), "available"),
                new Petmodel(4, new Category(2, "Cats"), "Milo", Arrays.asList("url7", "url8"), Arrays.asList(new Tag(7, "tag7"), new Tag(8, "tag8")), "available"),
                new Petmodel(5, new Category(2, "Cats"), "Tiger", Arrays.asList("url9", "url10"), Arrays.asList(new Tag(9, "tag9"), new Tag(10, "tag10")), "available"),
                new Petmodel(6, new Category(3, "Birds"), "Tweety", Arrays.asList("url11", "url12"), Arrays.asList(new Tag(11, "tag11"), new Tag(12, "tag12")), "available"),
                new Petmodel(7, new Category(3, "Birds"), "Polly", Arrays.asList("url13", "url14"), Arrays.asList(new Tag(13, "tag13"), new Tag(14, "tag14")), "available"),
                new Petmodel(8, new Category(4, "Rabbits"), "Bugs", Arrays.asList("url15", "url16"), Arrays.asList(new Tag(15, "tag15"), new Tag(16, "tag16")), "available"),
                new Petmodel(9, new Category(4, "Rabbits"), "Thumper", Arrays.asList("url17", "url18"), Arrays.asList(new Tag(17, "tag17"), new Tag(18, "tag18")), "available"),
                new Petmodel(10, new Category(5, "Fish"), "Nemo", Arrays.asList("url19", "url20"), Arrays.asList(new Tag(19, "tag19"), new Tag(20, "tag20")), "available")
        };
        for (Petmodel pet : pets) {
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

    //Get by category's id
    @GET
    @Path("GetByCategory/{id}")
    public Response Category(@PathParam("id") int id) {
        //select pet by key (id)
        Category pet = petsById.get(id).getCategory();

        //null check
        if (pet == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

       List<Petmodel> cPet = new ArrayList<>();
        //dump all data that contain this category
        for (Map.Entry<Integer, Petmodel> entry : petsById.entrySet()) {
            if (entry.getValue().getCategory().getCId() == id) {
                cPet.add(entry.getValue());
//                return Response.ok(entry.getValue(), MediaType.APPLICATION_JSON).build();
            }
        }

        //return pet by id that selected
        return Response.ok(cPet, MediaType.APPLICATION_JSON).build();
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
        Petmodel pet = petsById.get(id);

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
    public Response updatePet(@PathParam("id") int id, Petmodel pet) {
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
    public Response addPet(Petmodel pet) {
        // Check duplicate
        if (petsById.containsKey(pet.getId())) {
            return Response.status(Response.Status.CONFLICT).entity("A pet with this ID already exists.").build();
        }

        // Add new pet to map
        petsById.put(pet.getId(), pet);
        return Response.ok(pet, MediaType.APPLICATION_JSON).build();
    }

    //Delete pet
    @DELETE
    @Path("{id}")
    public Response deletePet(@PathParam("id") int id) {
        // Check if pet exists
        if (!petsById.containsKey(id)) {
            return Response.status(Response.Status.NOT_FOUND).entity("Pet not found.").build();
        }

        // Delete pet
        Petmodel pet = petsById.remove(id);
        return Response.ok(pet, MediaType.APPLICATION_JSON).build();
    }


}


