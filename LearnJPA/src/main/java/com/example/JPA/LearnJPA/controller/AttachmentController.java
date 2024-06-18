package com.example.JPA.LearnJPA.controller;

import com.example.JPA.LearnJPA.enity.Attachment;
import com.example.JPA.LearnJPA.enity.AttachmentResponse;
import com.example.JPA.LearnJPA.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.IOException;

@RestController
@RequestMapping("/v1/file")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;


    @PostMapping("/upload")
    public AttachmentResponse uploadFile(@RequestParam("file") MultipartFile file) throws Exception {

        try {
            Attachment attachment = new Attachment();
            attachment.setFileName(file.getOriginalFilename());
            attachment.setFileType(file.getContentType());
            attachment.setData(file.getBytes());

            attachmentService.saveFile(attachment);
            return new AttachmentResponse.AttachmentResponseBuilder()
                    .setFileName(file.getOriginalFilename())
                    .setError(null)
                    .build();
        }catch (IOException e){
            return new AttachmentResponse.AttachmentResponseBuilder()
                    .setFileName(null)
                    .setDownloadUrl(null)
                    .setError(e.getMessage())
                    .build();
        }

    }

    @GetMapping("/download/{id}")
    public AttachmentResponse download(@PathVariable("id") Long id) throws Exception {
       try {
            Attachment attachment = attachmentService.downloadFile(id);

            String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/v1/file/download/")
                    .path(attachment.getId().toString())
                    .toUriString();

            return new AttachmentResponse.AttachmentResponseBuilder()
                    .setFileName(attachment.getFileName())
                    .setDownloadUrl(downloadUrl)
                    .setError(null)
                    .build();

        }catch (Exception e){
            return new AttachmentResponse.AttachmentResponseBuilder()
                    .setFileName(null)
                    .setDownloadUrl(null)
                    .setError(e.getMessage())
                    .build();

        }
    }
}
