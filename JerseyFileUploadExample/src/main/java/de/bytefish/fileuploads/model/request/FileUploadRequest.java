// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package de.bytefish.fileuploads.model.request;

import de.bytefish.fileuploads.model.HttpFile;

public class FileUploadRequest {

    private final String title;
    private final String description;
    private final HttpFile httpFile;

    public FileUploadRequest(String title, String description, HttpFile httpFile) {
        this.title = title;
        this.description = description;
        this.httpFile = httpFile;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public HttpFile getHttpFile() {
        return httpFile;
    }
}
