package com.stormpath.idsite_demo;

import org.apache.catalina.connector.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
/**
 * application’s entry point
 * @author Ishim Manon
 *
 */

@SpringBootApplication
public class ATReSApplication {

    private static final Logger log = LoggerFactory.getLogger(ATReSApplication.class);

    @Value("#{ @environment['tomcat.ajp.port'] }")
    Integer ajpPort;

    @Value("#{ @environment['tomcat.ajp.enabled'] }")
    Boolean tomcatAjpEnabled;

    public static void main(String[] args) {
        SpringApplication.run(ATReSApplication.class, args);
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {

        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        if (tomcatAjpEnabled && ajpPort > 0) {
            log.info("Starting AJP on port: " + ajpPort);

            Connector ajpConnector = new Connector("AJP/1.3");
            ajpConnector.setProtocol("AJP/1.3");
            ajpConnector.setPort(ajpPort);
            ajpConnector.setSecure(false);
            ajpConnector.setAllowTrace(false);
            ajpConnector.setScheme("http");
            tomcat.addAdditionalTomcatConnectors(ajpConnector);
        }

        return tomcat;
    }
}
