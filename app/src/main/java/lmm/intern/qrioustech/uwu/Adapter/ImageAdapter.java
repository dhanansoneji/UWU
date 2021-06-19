package lmm.intern.qrioustech.uwu.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import lmm.intern.qrioustech.uwu.Model.ImageModel;
import lmm.intern.qrioustech.uwu.R;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    List<ImageModel> imageList;
    Context context;

    public ImageAdapter(List<ImageModel> imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View new_layout= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_child_1,viewGroup,false);

        ImageAdapter.ViewHolder n_l = new ImageAdapter.ViewHolder(new_layout);

        return n_l;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ViewHolder viewHolder, int i) {
        viewHolder.image.setImageResource(imageList.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }
}
