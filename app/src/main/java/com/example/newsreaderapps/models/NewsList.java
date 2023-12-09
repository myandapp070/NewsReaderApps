package com.example.newsreaderapps.models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NewsList {
    private String status;
    private int totalResults;
    private List<Article> articles;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}