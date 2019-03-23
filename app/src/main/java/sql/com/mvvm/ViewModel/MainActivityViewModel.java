package sql.com.mvvm.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import sql.com.mvvm.Model.Post;
import sql.com.mvvm.Repository.PostRepository;

public class MainActivityViewModel extends AndroidViewModel {

    private PostRepository postRepository;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        postRepository = new PostRepository(application);
    }

    public MutableLiveData<List<Post>> getAllPostFromDB(){

        return postRepository.getPostsFromDB();
    }

    public  MutableLiveData<Boolean> getDataIsLoaded(){
        return postRepository.getIsLoaded();
    }
}
