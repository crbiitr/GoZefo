package com.api;

import com.api.dao.ManagerFactory;
import com.api.dao.factories.CategoryManager;
import com.api.dao.factories.ProductManager;
import com.api.dao.models.CategoryDAO;
import com.api.dao.models.SofasDAO;
import com.api.dao.models.SubCategoryDAO;
import com.api.resources.ProductResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

/**
 * Created by chetan on 29/1/18.
 */
public class GozefoAssignmentApplication extends Application<GozefoAssignmentConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GozefoAssignmentApplication().run(args);
    }

    @Override
    public String getName() {
        return "GozefoAssignment";
    }

    private final HibernateBundle<GozefoAssignmentConfiguration> hibernate =
            new HibernateBundle<GozefoAssignmentConfiguration>(CategoryDAO.class, SofasDAO.class, SubCategoryDAO.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(GozefoAssignmentConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };
    @Override
    public void initialize(final Bootstrap<GozefoAssignmentConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(final GozefoAssignmentConfiguration configuration,
                    final Environment environment) {
        final CategoryManager categoryManager = new CategoryManager(hibernate.getSessionFactory(), configuration);
        final ProductManager productManager = new ProductManager(hibernate.getSessionFactory(), configuration);
        ManagerFactory.getInstance().setCategoryManager(categoryManager);
        ManagerFactory.getInstance().setProductManager(productManager);
        environment.jersey().register(new ProductResource());
    }

}
