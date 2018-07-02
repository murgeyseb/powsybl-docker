package com.powsybl.docker.afs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.powsybl.docker.afs", "com.powsybl.afs.ws.server"})
public class AfsApplication {

    protected AfsApplication() {
        // No constructor
    }

    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .enable(true)
                .apiInfo(apiInfo());
    }

    public ApiInfo apiInfo() {
        StringVendorExtension vendorExtension = new StringVendorExtension("", "");
        Collection<VendorExtension> vendorExtensions = new ArrayList<>();
        vendorExtensions.add(vendorExtension);

        Contact contactInfo = new Contact("RTE", "www.rte-france.com",
                "sebastien.murgey@rte-france.com");

        return new ApiInfo(
                "GSE demo",
                "Example project showing how to integrate spring boot " +
                        "web app using jaxrs instead of springmvc with swagger and springfox.",
                "1.0",
                "For Demo only",
                contactInfo,
                "Mozilla Public License 2.0",
                "www.mozilla.org",
                vendorExtensions);
    }
    @Bean
    public ServerEndpointExporter endpointExporter() {
        return new ServerEndpointExporter();
    }

    public static void main(String[] args) {
        SpringApplication.run(AfsApplication.class, args);
    }
}
