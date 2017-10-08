// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package de.bytefish.fileuploads.provider;

public class RootPathProvider implements IRootPathProvider {

    private final String path;

    public RootPathProvider(String path) {
        this.path = path;
    }

    @Override
    public String getRootPath() {
        return path;
    }
}
