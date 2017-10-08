// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package de.bytefish.fileuploads.model.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceError {
    private final String code;
    private final String message;

    public ServiceError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }
}
