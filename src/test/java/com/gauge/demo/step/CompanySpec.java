package com.gauge.demo.step;

import com.gauge.demo.client.GithubClient;
import com.gauge.demo.model.Company;
import com.gauge.demo.model.Repo;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Component
public class CompanySpec {

    private DataStore dataStore = DataStoreFactory.getSpecDataStore();
    private final GithubClient githubClient;

    public CompanySpec(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    @Step("query company <company> from github and get details")
    public void getCompany(String company) {
        dataStore.put("companyName", company);
        Company comp = githubClient.getCompany(company);
        assertThat(comp.getLogin().equals(company));
        System.out.println(comp.toString());
        dataStore.put("countPublicRepos", comp.getPublicRepos());
    }


    @Step("query company <company> repos from github and get repos count")
    public void getCompanyRepo(String company) {
        String companyName = (String) dataStore.get("companyName");
        int repoCount = (int) dataStore.get("countPublicRepos");
        List<Repo> companyRepos = githubClient.getCompanyRepos(companyName);
        assertThat(companyRepos.size() == repoCount);
        System.out.println(companyRepos.toString());
    }
}
