package org.acme.Pet;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.*;

@Path("/petapi")
public class PetStore {



    //Get All tag
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Tag")
    public Response getTagAll(){
        List<Tag> tag = Tag.listAll();
        return Response.ok(tag).build();
    }

    //Get tag by id
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Tag/{id}")
    public Response getTagById(@PathParam("id") Long id){
       return Tag.findByIdOptional(id)
               .map(tag -> Response.ok(tag).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    //Check all number of pets
    @GET
    @Path("Count")
    public Response countPets() {
        return Response.ok(Petmodel.count()).build();
    }

    //Get All category
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Category")
    public Response getCategoryAll(){
        List<Category> category = Category.listAll();
        return Response.ok(category).build();
    }



    //Get by category's id
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Category/{id}")
    public Response getCategoryById(@PathParam("id") Long id){
        return Category.findByIdOptional(id)
                .map(category -> Response.ok(category).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }


    //Get all pets
    @GET
    @Path("GetAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPets() {
        // Get all pets
        List<Petmodel> pets = Petmodel.listAll();
        return Response.ok(pets).build();
    }


    //Get by pet by id
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPetById(@PathParam("id") int id) {
        // Check if pet exists
        if (Petmodel.find("id", id).firstResultOptional().isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("Pet not found.").build();
        }

        // Get pet
        Petmodel pet = Petmodel.findById(id);
        return Response.ok(pet, MediaType.APPLICATION_JSON).build();
    }

    //Update pet
//    @PUT
//    @Path("{id}")
//    public Response updatePet(@PathParam("id") int id, Petmodel pet) {
//        // Check if pet exists
//        if (!petsById.containsKey(id)) {
//            return Response.status(Response.Status.NOT_FOUND).entity("Pet not found.").build();
//        }
//
//        // Update pet
//        petsById.put(id, pet);
//        return Response.ok(pet, MediaType.APPLICATION_JSON).build();
//    }

    //Add new pet
//    @POST
//    @Path("Add")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addPet(Petmodel pet) {
//        // Check duplicate
//        if (petsById.containsKey(pet.getId())) {
//            return Response.status(Response.Status.CONFLICT).entity("A pet with this ID already exists.").build();
//        }
//
//        // Add new pet to map
//        petsById.put(pet.getId(), pet);
//        return Response.ok(pet, MediaType.APPLICATION_JSON).build();
//    }

    //Delete pet
//    @DELETE
//    @Path("{id}")
//    public Response deletePet(@PathParam("id") int id) {
//        // Check if pet exists
//        if (!petsById.containsKey(id)) {
//            return Response.status(Response.Status.NOT_FOUND).entity("Pet not found.").build();
//        }
//
//        // Delete pet
//        Petmodel pet = petsById.remove(id);
//        return Response.ok(pet, MediaType.APPLICATION_JSON).build();
//    }


}


