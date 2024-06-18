package com.example.JPA.LearnJPA.service;

import com.example.JPA.LearnJPA.enity.Attachment;
import com.example.JPA.LearnJPA.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AttachmentServiceImplementation implements AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Override
    public void saveFile(Attachment attachment) throws Exception {
        attachmentRepository.save(attachment);
    }

    @Override
    public Attachment downloadFile(Long id) throws Exception {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            return optionalAttachment.get();
        } else {
            throw new Exception("Id Not Found");
        }
    }



}
