package com.powsybl.docker.afs;

import com.powsybl.afs.network.server.NetworkCacheServer;
import com.powsybl.afs.ws.server.AppStorageServer;
import com.powsybl.afs.ws.server.UserEndpoint;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
/*
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(AppDataBean.class).to(AppDataBean.class).in(Singleton.class);
                bind(WebSocketContext.class).to(WebSocketContext.class).in(Singleton.class);
                bind(SimpleKeyGenerator.class).to(KeyGenerator.class);
            }
        });
        */
        register(AppStorageServer.class);
        register(UserEndpoint.class);
        register(NetworkCacheServer.class);

        BeanConfig swaggerConfig = new BeanConfig();
        swaggerConfig.setBasePath("/rest");
        SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);

        packages(ApiListingResource.class.getPackage().getName());
    }
}
