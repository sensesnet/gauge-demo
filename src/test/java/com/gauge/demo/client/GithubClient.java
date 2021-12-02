package com.gauge.demo.client;

import com.gauge.demo.config.FeignConfig;
import com.gauge.demo.model.Company;
import com.gauge.demo.model.Follower;
import com.gauge.demo.model.Repo;
import com.gauge.demo.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "github-api", url = "${api.client.url.github}", configuration = FeignConfig.class)
public interface GithubClient {

    @GetMapping("/users/{username}")
    User getUser(@PathVariable("username") String username);

    @GetMapping("/users/{username}/repos")
    List<Repo> getRepos(@PathVariable("username") String username);

    @GetMapping("/orgs/{company}/repos")
    List<Repo> getCompanyRepos(@PathVariable("company") String company);

    @GetMapping("/orgs/{company}")
    Company getCompany(@PathVariable("company") String company);

    @GetMapping("users/{username}/followers")
    List<Follower> getFollowers(@PathVariable("username") String username);
}
