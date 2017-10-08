// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package de.bytefish.fileuploads.exceptions;

import de.bytefish.fileuploads.model.errors.HttpServiceError;
import de.bytefish.fileuploads.model.errors.ServiceError;

public class FileUploadException extends RuntimeException {

    private final HttpServiceError httpServiceError;

    public FileUploadException(ServiceError serviceError) {
        this.httpServiceError = new HttpServiceError(400, serviceError);
    }

    public FileUploadException(ServiceError serviceError, String message) {
        super(message);

        httpServiceError = new HttpServiceError(400, serviceError);
    }

    public FileUploadException(ServiceError serviceError, String message, Throwable cause) {
        super(message, cause);
        this.httpServiceError = new HttpServiceError(400, serviceError);
    }

    public HttpServiceError getHttpServiceError() {
        return httpServiceError;
    }
}
