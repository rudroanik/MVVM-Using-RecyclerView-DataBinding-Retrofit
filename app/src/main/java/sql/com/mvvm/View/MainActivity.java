package sql.com.mvvm.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import sql.com.mvvm.Model.Post;
import sql.com.mvvm.R;
import sql.com.mvvm.View.Adapter.PostAdapter;
import sql.com.mvvm.ViewModel.MainActivityViewModel;
import sql.com.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    private MainActivityViewModel mainActivityViewModel;
    private ArrayList<Post> posts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        initializeRecyclerView();
        getPosts();
    }

    private void initializeRecyclerView() {
        posts = new ArrayList<>();
        activityMainBinding.recyclerViewID.setLayoutManager(new LinearLayoutManager(this));

    }

    private void getPosts() {

        mainActivityViewModel.getAllPostFromDB().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(@Nullable List<Post> posts) {
                activityMainBinding.recyclerViewID.setAdapter(new PostAdapter((ArrayList<Post>) posts));
            }
        });
        getIsLoaded();
    }

    public  void getIsLoaded(){

        mainActivityViewModel.getDataIsLoaded().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean == true){
                    activityMainBinding.progressBarID.setVisibility(View.GONE);
                }
            }
        });
    }


}
