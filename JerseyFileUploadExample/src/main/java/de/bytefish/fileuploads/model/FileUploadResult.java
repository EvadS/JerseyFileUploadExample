// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package de.bytefish.fileuploads.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileUploadResult {

    private final String identifier;

    public FileUploadResult(String identifier) {
        this.identifier = identifier;
    }

    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }
}
