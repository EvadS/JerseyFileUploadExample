package de.bytefish.fileuploads.web.exceptions;

import de.bytefish.fileuploads.exceptions.FileUploadException;
import de.bytefish.fileuploads.model.errors.HttpServiceError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;

public class FileUploadExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<FileUploadException> {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadExceptionMapper.class);

    @Override
    public Response toResponse(FileUploadException fileUploadException) {

        if(logger.isErrorEnabled()) {
            logger.error("An error occured", fileUploadException);
        }

        HttpServiceError httpServiceError = fileUploadException.getHttpServiceError();

        return Response
                .status(httpServiceError.getHttpStatusCode())
                .entity(httpServiceError.getServiceError())
                .build();
    }
}
