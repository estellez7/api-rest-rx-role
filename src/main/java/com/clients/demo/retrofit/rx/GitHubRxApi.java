package com.clients.demo.retrofit.rx;

import com.clients.demo.model.entity.ClientEntity;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubRxApi {

    /**
     * List Clients
     * @return ClientDTO clients
     */
    @GET("client/{id}")
    Single<ClientEntity> findById(@Path("id") Integer id);

}
