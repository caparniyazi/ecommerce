package com.capar.niyazi.ecommerce.config;

import com.capar.niyazi.ecommerce.entity.Product;
import com.capar.niyazi.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupportedMethods = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};

        config.getExposureConfiguration()
                .forDomainType(Product.class).withItemExposure(
                        ((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods))
                )
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods));

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class).withItemExposure(
                        ((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods))
                )
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods));
    }
}
