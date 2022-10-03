package com.itmaspro;

import com.itmaspro.customers.rest.v1.CustomerRestService;
import com.itmaspro.customers.rest.v1.HealthRestService;
import com.itmaspro.customers.rest.v1.filter.CorsFilter;
import com.itmaspro.customers.rest.v1.filter.LoggerInterceptor;
import com.itmaspro.customers.rest.v1.mapper.EmptyPayloadMapper;
import com.itmaspro.customers.rest.v1.mapper.ResourceNotFoundMapper;
import org.glassfish.jersey.jsonp.JsonProcessingFeature;
import com.itmaspro.customers.rest.v1.filter.AuthFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/v1")
public class CustomerApplication extends Application {

    @Override public Set<Class<?>> getClasses()
    {
        Set<Class<?>> classes = new HashSet<>();
        classes.add( CustomerRestService.class);
        classes.add( HealthRestService.class);
        classes.add(JsonProcessingFeature.class);
      //  classes.add(JacksonProvider.class);
        classes.add( EmptyPayloadMapper.class);
        classes.add( ResourceNotFoundMapper.class);
        classes.add(AuthFilter.class);
        classes.add( CorsFilter.class);
        classes.add( LoggerInterceptor.class);
        return classes;    }
}
