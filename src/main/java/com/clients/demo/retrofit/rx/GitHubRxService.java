package com.clients.demo.retrofit.rx;

import com.clients.demo.model.dto.ClientDTO;
import com.clients.demo.model.entity.ClientEntity;
import com.clients.demo.retrofit.models.Contributor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Single;

import java.util.List;

class GitHubRxService {

    private GitHubRxApi gitHubApi;

    GitHubRxService() {
        //Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api-rest-rx-production.up.railway.app/api/v1/").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        gitHubApi = retrofit.create(GitHubRxApi.class);
    }

    Observable<String> getTopContributors(String userName) {
        return gitHubApi.listRepos(userName).flatMapIterable(x -> x).flatMap(repo -> gitHubApi.listRepoContributors(userName, repo.getName())).flatMapIterable(x -> x).filter(c -> c.getContributions() > 100)
                .sorted((a, b) -> b.getContributions() - a.getContributions()).map(Contributor::getName).distinct();
    }

    Single<List<ClientEntity>> getClients() {
        return gitHubApi.listClients().toSingle();
    }
}
