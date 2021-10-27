package com.gauge.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Company {
    private String login;
    private String id;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("public_repos")
    private Integer publicRepos;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public Integer getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(Integer publicRepos) {
        this.publicRepos = publicRepos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(login, company.login) && Objects.equals(id, company.id) && Objects.equals(htmlUrl, company.htmlUrl) && Objects.equals(publicRepos, company.publicRepos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, id, htmlUrl, publicRepos);
    }

    @Override
    public String toString() {
        return "Company{" +
                "login='" + login + '\'' +
                ", id='" + id + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", publicRepos=" + publicRepos +
                '}';
    }
}
