package apidez.com.lab1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import apidez.com.lab1.R;
import apidez.com.lab1.model.Post;

/**
 * Created by nongdenchet on 10/9/16.
 */

public class PostAdapter extends ArrayAdapter<Post> {
    private List<Post> mPosts;

    public PostAdapter(Context context, List<Post> posts) {
        super(context, -1);
        mPosts = posts;
    }

    @Override
    public int getCount() {
        return mPosts.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.item_post, parent, false);
        } else {
            view = convertView;
        }

        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tvUsername = (TextView) view.findViewById(R.id.tvUsername);
        viewHolder.tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        viewHolder.tvDate = (TextView) view.findViewById(R.id.tvDate);
        viewHolder.ivAvatar = (ImageView) view.findViewById(R.id.ivAvatar);
        viewHolder.ivImage = (ImageView) view.findViewById(R.id.ivImage);
        bindViewHolder(position, viewHolder);
        view.setTag(viewHolder);

        return view;
    }

    private void bindViewHolder(int position, ViewHolder viewHolder) {
        Post post = mPosts.get(position);
        viewHolder.tvUsername.setText(post.getUsername());
        viewHolder.tvDescription.setText(post.getDescription());
        viewHolder.tvDate.setText(post.getDate());
        loadImage(viewHolder.ivAvatar, post.getAvatar());
        loadImage(viewHolder.ivImage, post.getImage());
    }

    private void loadImage(ImageView imageView, String path) {
        Picasso.with(getContext())
                .load(path)
                .placeholder(R.drawable.placeholder)
                .into(imageView);

    }

    public class ViewHolder {
        public TextView tvUsername;
        public TextView tvDescription;
        public TextView tvDate;
        public ImageView ivAvatar;
        public ImageView ivImage;
    }
}
