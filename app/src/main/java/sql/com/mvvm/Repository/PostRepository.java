package sql.com.mvvm.Repository;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sql.com.mvvm.Model.Post;

public class PostRepository {

    private MutableLiveData<List<Post>> postListMutableLiveData;
    private MutableLiveData<Boolean>dataIsLoaded;
    private Application application;
    API_Service service;

    public PostRepository(Application application) {
        this.application = application;
        if (postListMutableLiveData== null){

            postListMutableLiveData = new MutableLiveData<>();
            dataIsLoaded= new MutableLiveData<>();
        }
        service = RetrofitClass.getRetrofitInstance().create(API_Service.class);

    }

    public MutableLiveData<List<Post>> getPostsFromDB(){


        Call<List<Post>> postResponseCall = service.getAllPost();

        postResponseCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.code()==200){
                    List<Post> posts = response.body();
                    postListMutableLiveData.setValue(posts);
                    dataIsLoaded.setValue(true);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
        return postListMutableLiveData;
    }

    public MutableLiveData<List<Post>> getPostsByUserIdFromDB(){


        Call<List<Post>> postResponseCall = service.getPostByUserID(1);

        postResponseCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.code()==200){
                    List<Post> posts = response.body();
                    postListMutableLiveData.setValue(posts);
                    dataIsLoaded.setValue(true);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
        return postListMutableLiveData;
    }

    public MutableLiveData<Boolean> getIsLoaded(){

        return dataIsLoaded;
    }
}
