// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package de.bytefish.fileuploads.handler;


import de.bytefish.fileuploads.model.FileUploadResult;
import de.bytefish.fileuploads.model.HttpFile;

public interface IFileUploadHandler {

    FileUploadResult handle(HttpFile httpFile);

}
