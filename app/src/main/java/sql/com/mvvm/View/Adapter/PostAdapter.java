package sql.com.mvvm.View.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sql.com.mvvm.Model.Post;
import sql.com.mvvm.R;
import sql.com.mvvm.databinding.ItemPostBinding;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private ArrayList<Post> posts;

    public PostAdapter(ArrayList<Post> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ItemPostBinding itemPostBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_post, viewGroup, false);

        return new ViewHolder(itemPostBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Post post = posts.get(i);
        viewHolder.itemPostBinding.textUserID.setText("User ID: " + post.getUserId());
        viewHolder.itemPostBinding.textPostID.setText("Post ID: " + post.getId());
        viewHolder.itemPostBinding.textTitleID.setText("Title: " + post.getTitle());
        viewHolder.itemPostBinding.textBodyID.setText("Body: " + post.getBody());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemPostBinding itemPostBinding;

        public ViewHolder(@NonNull ItemPostBinding itemView) {
            super(itemView.getRoot());
            itemPostBinding = itemView;
        }
    }
}
