package com.rapidminer.entity;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Request {

    @Id
    private String id;
    private List<Map<String,Object>> rawContent;
    private List<Map<String,Object>> contentMedianByLabel;
    private LocalDateTime dateTime;

    public Request() {
    }

    public Request(List<Map<String, Object>> rawContent, List<Map<String, Object>> contentMedianByLabel, LocalDateTime dateTime) {
        this.rawContent = rawContent;
        this.contentMedianByLabel = contentMedianByLabel;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Map<String, Object>> getRawContent() {
        return rawContent;
    }

    public void setRawContent(List<Map<String, Object>> rawContent) {
        this.rawContent = rawContent;
    }

    public List<Map<String, Object>> getContentMedianByLabel() {
        return contentMedianByLabel;
    }

    public void setContentMedianByLabel(List<Map<String, Object>> contentMedianByLabel) {
        this.contentMedianByLabel = contentMedianByLabel;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
