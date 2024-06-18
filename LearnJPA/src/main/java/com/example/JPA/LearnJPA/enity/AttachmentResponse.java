package com.example.JPA.LearnJPA.enity;


public class AttachmentResponse {

    private String fileName;
    private String downloadUrl;
    private String error;

    private AttachmentResponse(AttachmentResponseBuilder builder){
        this.fileName = builder.fileName;
        this.downloadUrl = builder.downloadUrl;
        this.error = builder.error;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public String getError() {
        return error;
    }

    public String getFileName() {
        return fileName;
    }
    public static  class AttachmentResponseBuilder{
        private String fileName;
        private String downloadUrl;
        private String error;

        public AttachmentResponseBuilder setDownloadUrl(String downloadUrl) {
            this.downloadUrl = downloadUrl;
            return this;
        }

        public AttachmentResponseBuilder setError(String error) {
            this.error = error;
            return this;
        }

        public AttachmentResponseBuilder setFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }
        public AttachmentResponse build(){
            return new AttachmentResponse(this);
        }
    }
}
