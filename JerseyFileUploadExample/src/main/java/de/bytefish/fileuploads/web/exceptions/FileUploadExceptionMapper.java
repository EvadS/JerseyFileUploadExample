package de.bytefish.fileuploads.web.exceptions;

import de.bytefish.fileuploads.exceptions.FileUploadException;
import de.bytefish.fileuploads.model.HttpServiceError;

import javax.ws.rs.core.Response;

public class FileUploadExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<FileUploadException> {

    @Override
    public Response toResponse(FileUploadException fileUploadException) {

        HttpServiceError httpServiceError = fileUploadException.getHttpServiceError();

        return Response
                .status(httpServiceError.getHttpStatusCode())
                .entity(httpServiceError.getServiceError())
                .build();
    }
}
