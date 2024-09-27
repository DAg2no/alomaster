package com.principal.alomaster.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.Serial;


@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file"); // Obtiene el archivo
        String fileName = filePart.getSubmittedFileName();

        // Define la ruta donde se guardará la imagen
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        // Guarda el archivo
        filePart.write(uploadPath + File.separator + fileName);

        // Responde al cliente
        response.getWriter().print("Imagen subida correctamente: " + fileName);
    }
}