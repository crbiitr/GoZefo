package com.api.resources;

import com.api.dao.ManagerFactory;
import com.api.dao.factories.CategoryManager;
import com.api.dao.factories.ProductManager;
import com.api.representation.request.ProductRequest;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by chetan on 29/1/18.
 */
@Slf4j
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("")
public class ProductResource extends BaseResource {
    public ProductResource() {
    }
    @Path("/product-list/{category}")
    public Response category(@NotNull @PathParam("category") int category) {
        ManagerFactory managerFactory = ManagerFactory.getInstance();
        CategoryManager categoryManager= managerFactory.getCategoryManager();
        return categoryManager.getCategory(category);
    }

    @POST
    @Path("/product-list/")
    public Response category(ProductRequest request) {
        ManagerFactory managerFactory = ManagerFactory.getInstance();
        ProductManager productManager= managerFactory.getProductManager();
        return productManager.getProduct(request);
    }

    @POST
    @Path("/product/")
    public Response addProduct(ProductRequest request) {
        ManagerFactory managerFactory = ManagerFactory.getInstance();
        ProductManager productManager= managerFactory.getProductManager();
        return productManager.addProduct(request);
    }
}
