package com.app.AidNearby.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileStorageService {

    private static final String UPLOAD_DIR = "uploads/";

    public String storeFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("File is empty");
        }

        // Upewnij się, że katalog istnieje
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Zapisz plik na serwerze
        File savedFile = new File(UPLOAD_DIR + file.getOriginalFilename());
        file.transferTo(savedFile);

        return savedFile.getAbsolutePath();
    }
}