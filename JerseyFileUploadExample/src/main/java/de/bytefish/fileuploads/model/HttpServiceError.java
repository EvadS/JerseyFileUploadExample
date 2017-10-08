// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package de.bytefish.fileuploads.model;

public class HttpServiceError {

    private final int httpStatusCode;

    private final ServiceError serviceError;

    public HttpServiceError(int httpStatusCode, ServiceError serviceError) {
        this.httpStatusCode = httpStatusCode;
        this.serviceError = serviceError;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public ServiceError getServiceError() {
        return serviceError;
    }
}
