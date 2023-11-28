package com.clients.demo.retrofit.rx;

import com.clients.demo.model.entity.ClientEntity;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class RxService {

    private final GitHubRxApi gitHubApi;

    public RxService(@Value("${base-path-clients}") String baseUrlClients) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrlClients)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        gitHubApi = retrofit.create(GitHubRxApi.class);
    }

    //TODO: Check throw - circuit breaker
    public Single<ClientEntity> findById(Integer id) {
        return gitHubApi.findById(id);
    }
}
