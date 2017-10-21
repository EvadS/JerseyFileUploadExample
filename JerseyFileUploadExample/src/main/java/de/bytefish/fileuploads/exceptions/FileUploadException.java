// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package de.bytefish.fileuploads.exceptions;

import de.bytefish.fileuploads.model.errors.HttpServiceError;
import de.bytefish.fileuploads.model.errors.ServiceError;

public class FileUploadException extends RuntimeException {

    private final HttpServiceError httpServiceError;

    public FileUploadException(ServiceError serviceError) {
        this.httpServiceError = createServiceError(serviceError);
    }

    public FileUploadException(ServiceError serviceError, String message) {
        super(message);

        this.httpServiceError = createServiceError(serviceError);
    }

    public FileUploadException(ServiceError serviceError, String message, Throwable cause) {
        super(message, cause);

        this.httpServiceError = createServiceError(serviceError);
    }

    public HttpServiceError getHttpServiceError() {
        return httpServiceError;
    }

    private static HttpServiceError createServiceError(ServiceError serviceError) {
        return new HttpServiceError(400, serviceError);
    }
}
