package de.bytefish.fileuploads.web.configuration;

import de.bytefish.fileuploads.web.exceptions.FileUploadExceptionMapper;
import de.bytefish.fileuploads.web.resource.FileUploadResource;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        // Register the Resource:
        register(FileUploadResource.class);

        // Register the Feature for Multipart Uploads (File Upload):
        register(MultiPartFeature.class);

        // Register Exception Mappers for returning API Errors:
        register(FileUploadExceptionMapper.class);

        // Disable WADL Generation:
        property("jersey.config.server.wadl.disableWadl", true);

        // Add some Tracing:
        property("jersey.config.server.tracing.type", "ALL");
        property("jersey.config.server.tracing.threshold", "TRACE");
    }
}
