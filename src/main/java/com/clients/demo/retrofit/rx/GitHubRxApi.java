package com.clients.demo.retrofit.rx;

import com.clients.demo.model.dto.ClientDTO;
import com.clients.demo.model.entity.ClientEntity;
import com.clients.demo.retrofit.models.Contributor;
import com.clients.demo.retrofit.models.Repository;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

import java.util.List;

public interface GitHubRxApi {

    /**
     * List GitHub repositories of user
     * @param user GitHub Account
     * @return GitHub repositories
     */
    @GET("users/{user}/repos")
    Observable<List<Repository>> listRepos(@Path("user") String user);

    /**
     * List Clients
     * @return ClientDTO clients
     */
    @GET("clients")
    Observable<List<ClientEntity>> listClients();

    /**
     * List Contributors of a GitHub Repository
     * @param user GitHub Account
     * @param repo GitHub Repository
     * @return GitHub Repository Contributors
     */
    @GET("repos/{user}/{repo}/contributors")
    Observable<List<Contributor>> listRepoContributors(@Path("user") String user, @Path("repo") String repo);

}
