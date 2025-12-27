package com.biblioLectum.proyectoGrupo02.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadFileService {

    private final String CARPETA = "images/";

    public String guardarImagen(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String nombreUnico = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

            byte[] bytes = file.getBytes();
            Path path = Paths.get(CARPETA + nombreUnico);
            Files.write(path, bytes);

            return nombreUnico;
        }
        return "default.jpg";
    }


    public void eliminarImagen(String nombre){
        if(nombre != null && !nombre.equals("default.jpg")){
            try {
                Path rootPath = Paths.get(CARPETA + nombre);
                Files.deleteIfExists(rootPath);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
