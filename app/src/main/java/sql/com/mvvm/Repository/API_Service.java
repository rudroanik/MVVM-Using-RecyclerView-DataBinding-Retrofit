package sql.com.mvvm.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import sql.com.mvvm.Model.Post;

public interface API_Service {

    @GET("/posts")
    Call<List<Post>> getAllPost();
}
