package com.example.JPA.LearnJPA.service;

import com.example.JPA.LearnJPA.enity.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    void saveFile(Attachment attachment) throws Exception;

    Attachment downloadFile(Long id) throws Exception;
}
