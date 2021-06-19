package lmm.intern.qrioustech.uwu.Adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

import lmm.intern.qrioustech.uwu.Model.CategoryModel;
import lmm.intern.qrioustech.uwu.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    @NonNull
    private

    List<CategoryModel> list;
    private Context context;
    ImageView previousImage;
    TextView previousText;
    public static int first;

    public CategoryAdapter(@NonNull Context context,@NonNull List<CategoryModel> objects,int first) {
        this.context = context;
        this.list = objects;
        this.first = first;
    }

    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View new_layout= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_text_spinner,viewGroup,false);

        CategoryAdapter.ViewHolder n_l = new CategoryAdapter.ViewHolder(new_layout);

        return n_l;
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryAdapter.ViewHolder viewHolder, int i) {


        viewHolder.imageView.setImageResource(list.get(i).getIcon());
        viewHolder.c_name.setText(list.get(i).getCategory());

        if(i==0 && first==0) {
            viewHolder.imageView.setColorFilter(ContextCompat.getColor(context, R.color.selected));
            viewHolder.c_name.setTextColor(ContextCompat.getColor(context, R.color.selected));first = 1;
            previousImage=viewHolder.imageView;
            previousText=viewHolder.c_name;
        }

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(previousImage==viewHolder.imageView)) {
                    viewHolder.imageView.setColorFilter(ContextCompat.getColor(context, R.color.selected));
                    viewHolder.c_name.setTextColor(ContextCompat.getColor(context, R.color.selected));
                    previousImage.setColorFilter(ContextCompat.getColor(context, R.color.category));
                    previousText.setTextColor(ContextCompat.getColor(context, R.color.category));
                    previousImage = viewHolder.imageView;
                    previousText = viewHolder.c_name;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        TextView c_name;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.cat_select);
            imageView = itemView.findViewById(R.id.cat_icon);
            c_name=itemView.findViewById(R.id.cust_view);

        }
    }
}
