package com.capar.niyazi.ecommerce.config;

import com.capar.niyazi.ecommerce.entity.Country;
import com.capar.niyazi.ecommerce.entity.Product;
import com.capar.niyazi.ecommerce.entity.ProductCategory;
import com.capar.niyazi.ecommerce.entity.State;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {
    // Data fields
    private final EntityManager em;

    @Autowired
    public DataRestConfig(EntityManager em) {
        this.em = em;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupportedMethods = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};

        // disable HTTP methods for PUT, POST and DELETE
        disableHttpMethods(Product.class, config, theUnsupportedMethods);
        disableHttpMethods(ProductCategory.class, config, theUnsupportedMethods);
        disableHttpMethods(Country.class, config, theUnsupportedMethods);
        disableHttpMethods(State.class, config, theUnsupportedMethods);

        exposeIds(config);
    }

    private void disableHttpMethods(Class<?> theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)) // for single item
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)); // for collection
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        // Get a list of all entity classes from the entity manager.
        Set<EntityType<?>> entityTypes = em.getMetamodel().getEntities();

        // Create an array of the entity types.
        List<Class<?>> entityClasses = new ArrayList<>();

        // Get the entity types for the entities.
        for (EntityType<?> entityType : entityTypes) {
            entityClasses.add(entityType.getJavaType());
        }

        // Expose the entity ids for the array of entity/domain types.
        Class<?>[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}
