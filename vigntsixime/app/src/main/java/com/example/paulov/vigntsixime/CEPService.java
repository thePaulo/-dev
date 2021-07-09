package com.example.paulov.vigntsixime;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CEPService {
    //@GET("59152250/json/")
    //Call<CEP> recuperarCEP();

    @GET("{cep}/json/")
    Call<CEP> recuperarCEP(@Path("cep") String cep);
}
