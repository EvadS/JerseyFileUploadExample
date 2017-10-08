// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package de.bytefish.fileuploads.handler;

import de.bytefish.fileuploads.exceptions.FileUploadException;
import de.bytefish.fileuploads.model.FileUploadResult;
import de.bytefish.fileuploads.model.HttpFile;
import de.bytefish.fileuploads.model.ServiceError;
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
    public FileUploadResult handle(HttpFile httpFile) {
        if(httpFile == null) {
            throw new FileUploadException(new ServiceError("missingFile", "Missing File data"), String.format("Missing Parameter: httpFile"));
        }

        // We don't override existing files, create a new UUID File name:
        String fileName = UUID.randomUUID().toString();

        // Write it to Disk:
        internalWriteFile(httpFile.getStream(), fileName);

        return new FileUploadResult(fileName);
    }
}
