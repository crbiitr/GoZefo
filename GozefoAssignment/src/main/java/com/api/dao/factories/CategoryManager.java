package com.api.dao.factories;

import com.api.GozefoAssignmentConfiguration;
import com.api.dao.models.CategoryDAO;
import com.api.representation.response.BaseResponse;
import com.api.representation.response.CategoryResponse;
import com.api.representation.response.ErrorsResponse;
import org.hibernate.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by chetan on 29/1/18.
 */
public class CategoryManager {
    private SessionFactory sessionFactory;
    private GozefoAssignmentConfiguration gozefoAssignmentConfiguration;

    public CategoryManager(SessionFactory sessionFactory, GozefoAssignmentConfiguration gozefoAssignmentConfiguration) {
        this.sessionFactory = sessionFactory;
        this.gozefoAssignmentConfiguration = gozefoAssignmentConfiguration;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public CategoryManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Response getCategory(int categoryId) {
        Session session = sessionFactory.openSession();
        Response response;
        CategoryDAO categoryDAO = null;
        try {
            Query query = session.createQuery("From CategoryDAO where id = :categoryId");
            query.setParameter("categoryId", categoryId);
            List<CategoryDAO> result = query.list();
            BaseResponse baseResponse = new BaseResponse();
            if(result.size()>0) {
                categoryDAO = (CategoryDAO) result.get(0);
                baseResponse = new CategoryResponse("success",Response.Status.OK.getStatusCode(),categoryId,categoryDAO.getName());
            } else {
                baseResponse.setStatus("failed");
                baseResponse.setStatusCode(Response.Status.NO_CONTENT.getStatusCode());
            }
            session.close();
            response = Response.ok(baseResponse).build();
            return response;
        }  catch (Exception e) {
            e.printStackTrace();
            response = Response.status(Response.Status.OK).entity(new ErrorsResponse("failed", 0,
                    "Invalid Session", Response.Status.BAD_REQUEST.getStatusCode())).build();
        }finally {
            if(session != null) {
                session.close();
            }
        }
        return response;
    }
}
