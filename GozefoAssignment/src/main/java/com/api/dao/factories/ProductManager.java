package com.api.dao.factories;

import com.api.GozefoAssignmentConfiguration;
import com.api.constants.Constants;
import com.api.dao.models.SofasDAO;
import com.api.exceptions.ParameterMissingException;
import com.api.representation.request.ProductRequest;
import com.api.representation.response.BaseResponse;
import com.api.representation.response.ErrorsResponse;
import com.api.representation.response.ProductResponse;
import org.hibernate.*;

import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chetan on 29/1/18.
 */
public class ProductManager {
    private SessionFactory sessionFactory;
    private GozefoAssignmentConfiguration gozefoAssignmentConfiguration;

    public ProductManager(SessionFactory sessionFactory, GozefoAssignmentConfiguration gozefoAssignmentConfiguration) {
        this.sessionFactory = sessionFactory;
        this.gozefoAssignmentConfiguration = gozefoAssignmentConfiguration;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ProductManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Response getProduct(ProductRequest request) {
        Response response;
        try {
            if(request!=null) {
                if(request.getSubcategory()!=null && request.getSubcategory().equals(Constants.SOFAS)) {
                    List<SofasDAO> result = getSofas(request);
                    BaseResponse baseResponse = new BaseResponse();
                    if(result.size()>0) {
                        baseResponse = new ProductResponse("success",Constants.SUCCESS,"Sofas",
                                Response.Status.OK.getStatusCode(),result);
                    } else {
                        baseResponse.setStatus("failed");
                        baseResponse.setStatusCode(Response.Status.NO_CONTENT.getStatusCode());
                    }
                    response = Response.ok(baseResponse).build();
                    return response;

                } else if(request.getSubcategory()!=null && request.getSubcategory().equals(Constants.BEDS)) {
                    //TODO Need to put code for beds
                } else {
                    return Response.status(Response.Status.OK).entity(new ErrorsResponse("failed", 0,
                            "Sub category not defined!", Response.Status.BAD_REQUEST.getStatusCode())).build();
                }
            } else {
                return Response.status(Response.Status.OK).entity(new ErrorsResponse("failed", 0,
                        "Request object is null!", Response.Status.BAD_REQUEST.getStatusCode())).build();
            }
        }  catch (Exception e) {
            e.printStackTrace();
            response = Response.status(Response.Status.OK).entity(new ErrorsResponse("failed", 0,
                    "Invalid Session", Response.Status.BAD_REQUEST.getStatusCode())).build();
            return response;
        }finally {

        }
        response = Response.status(Response.Status.OK).entity(new ErrorsResponse("failed", 0,
                "Something went wrong!", Response.Status.BAD_REQUEST.getStatusCode())).build();
        return response;
    }

    public List<SofasDAO> getSofas(ProductRequest request) {
        Session session = sessionFactory.openSession();
        List<SofasDAO> list = new LinkedList<>();
        Response response;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("From SofasDAO ");
            StringBuilder whereClause = new StringBuilder();
            if(request.getBrand()!=null) {
                whereClause.append("brand =:brand ");
            }
            if(request.getMaterial()!=null) {
                whereClause.append(" and material =:material ");
            }
            if(request.getSoftness()!=null) {
                whereClause.append(" and softness =:softness ");
            }
            if(request.getType()!=null) {
                whereClause.append(" and type=:type");
            }
            if(request.getMinPrice()!=null && request.getMaxPrice()!=null) {
                whereClause.append(" and price between :minPrice and :maxPrice ");
            } else if (request.getMinPrice()!=null) {
                whereClause.append(" and price =:minPrice ");
            }

            if(whereClause.toString().trim().length()<1) {
                stringBuilder.append(" ");
            } else {
                stringBuilder.append(" where ");
                stringBuilder.append(whereClause);
            }

            if(request.getSortBy()!=null) {
                stringBuilder.append(" order by :sortBy");
            }

            Query query = session.createQuery(stringBuilder.toString());
            if(request.getBrand()!=null) {
                query.setParameter("brand",request.getBrand());
            }
            if(request.getMaterial()!=null) {
                query.setParameter("material",request.getMaterial());
            }
            if(request.getSoftness()!=null) {
                query.setParameter("softness",request.getSoftness());
            }
            if(request.getType()!=null) {
                query.setParameter("type",request.getType());
            }

            if(request.getMinPrice()!=null && request.getMaxPrice()!=null) {
                query.setParameter("minPrice",request.getMinPrice());
                query.setParameter("maxPrice",request.getMaxPrice());
            } else if (request.getMinPrice()!=null) {
                query.setParameter("minPrice",request.getMinPrice());
            }
            if(request.getSortBy()!=null) {
                query.setParameter("sortBy",request.getSortBy());
            }

            List<SofasDAO> result = query.list();
            session.close();
            return result;
        }  catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session != null) {
                session.close();
            }
        }
        return list;
    }

    public Response addProduct(ProductRequest request) {
        Response response;
        try {
            if(request!=null) {
                if(request.getSubcategory()!=null) {
                    if(request.getSubcategory().equals(Constants.SOFAS)) {
                        return addSofa(request);
                    } else if(request.getSubcategory().equals(Constants.BEDS)) {
                        //TODO Need to add code for the Beds
                    } else {
                        throw new ParameterMissingException();
                    }
                } else {
                    throw new ParameterMissingException();
                }
            } else {
                throw new ParameterMissingException();
            }

        } catch (ParameterMissingException pme) {
            pme.printStackTrace();
            response = Response.status(Response.Status.OK).entity(new ErrorsResponse("failed", 0,
                    "Parameter missing error!", Response.Status.BAD_REQUEST.getStatusCode())).build();
        } catch (Exception e) {
            response = Response.status(Response.Status.OK).entity(new ErrorsResponse("failed", 0,
                    "Something went wrong!", Response.Status.BAD_REQUEST.getStatusCode())).build();
            return response;
        } finally {

        }
        response = Response.status(Response.Status.OK).entity(new ErrorsResponse("failed", 0,
                "Something went wrong!", Response.Status.BAD_REQUEST.getStatusCode())).build();
        return response;
    }

    public Response addSofa(ProductRequest request) {
         SofasDAO dao = new SofasDAO();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Response response;
        int categoryId;
         int subcategoryId;
         String name;
         String type;
         String material;
         String brand;
         String condition;
         String softness;
         BigDecimal price;
        try {
            if(request.getCategory()!=null && Constants.CATEGORY_MAP.get(request.getCategory())!=null) {
                categoryId = Constants.CATEGORY_MAP.get(request.getCategory());
                dao.setCategoryId(categoryId);
            } else {
                throw new ParameterMissingException();
            }
            if(request.getSubcategory()!=null && Constants.SUB_CATEGORY_MAP.get(request.getSubcategory())!=null) {
                subcategoryId = Constants.SUB_CATEGORY_MAP.get(request.getSubcategory());
                dao.setSubCategoryId(subcategoryId);
            } else {
                throw new ParameterMissingException();
            }
            if(request.getType()!=null) {
                type = request.getType();
                dao.setType(type);
            } else {
                throw new ParameterMissingException();
            }
            if(request.getMaterial()!=null) {
                material = request.getMaterial();
                dao.setMaterial(material);
            } else {
                throw new ParameterMissingException();
            }
            if(request.getBrand()!=null) {
                brand = request.getBrand();
                dao.setBrand(brand);
            } else {
                throw new ParameterMissingException();
            }
            if(request.getCondition()!=null) {
                condition = request.getCondition();
                dao.setCondition(condition);
            } else {
                throw new ParameterMissingException();
            }
            if(request.getSoftness()!=null) {
                softness = request.getSoftness();
                dao.setSoftness(softness);
            } else {
                throw new ParameterMissingException();
            }
            if(request.getPrice()!=null) {
                price = request.getPrice();
                dao.setPrice(price);
            } else {
                throw new ParameterMissingException();
            }
            if(request.getName()!=null) {
                name = request.getName();
                dao.setName(name);
            } else {
                throw new ParameterMissingException();
            }
            session.save(dao);
            transaction.commit();
            BaseResponse baseResponse = new BaseResponse("success",Response.Status.OK.getStatusCode());
            response = Response.ok(baseResponse).build();
        } catch (ParameterMissingException pme) {
            pme.printStackTrace();
            response = Response.status(Response.Status.OK).entity(new ErrorsResponse("failed", 0,
                    "Parameter missing error!", Response.Status.BAD_REQUEST.getStatusCode())).build();
        } catch (Exception e) {
            e.printStackTrace();
            response = Response.status(Response.Status.OK).entity(new ErrorsResponse("failed", 0,
                    "Something went wrong!", Response.Status.BAD_REQUEST.getStatusCode())).build();
        } finally {
            if(session != null) {
                session.close();
            }
        }

        return response;
    }
}
