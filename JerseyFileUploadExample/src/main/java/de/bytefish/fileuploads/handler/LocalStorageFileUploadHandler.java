// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package de.bytefish.fileuploads.handler;

import de.bytefish.fileuploads.exceptions.FileUploadException;
import de.bytefish.fileuploads.model.files.HttpFile;
import de.bytefish.fileuploads.model.errors.ServiceError;
import de.bytefish.fileuploads.model.request.FileUploadRequest;
import de.bytefish.fileuploads.model.response.FileUploadResponse;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class LocalStorageFileUploadHandler implements IFileUploadHandler {

    private void internalWriteFile(InputStream stream, String fileName) {
        try {
                Files.copy(stream, Paths.get(fileName));
        } catch(Exception e) {
            throw new FileUploadException(new ServiceError("storingFileError", "Error writing file"), String.format("Writing File '%s' failed", fileName), e);
        }
    }

    @Override
    public FileUploadResponse handle(FileUploadRequest request) {

        // Early exit, if there is no Request:
        if(request == null) {
            throw new FileUploadException(new ServiceError("missingFile", "Missing File data"), String.format("Missing Parameter: request"));
        }

        // Get the HttpFile:
        HttpFile httpFile = request.getHttpFile();

        // Early exit, if the Request has no data assigned:
        if(httpFile == null) {
            throw new FileUploadException(new ServiceError("missingFile", "Missing File data"), String.format("Missing Parameter: request"));
        }

        // We don't override existing files, create a new UUID File name:
        String targetFileName = UUID.randomUUID().toString();

        // Write it to Disk:
        internalWriteFile(httpFile.getStream(), targetFileName);

        return new FileUploadResponse(targetFileName);
    }
}
