package lmm.intern.qrioustech.uwu.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import lmm.intern.qrioustech.uwu.Model.ChatModel;
import lmm.intern.qrioustech.uwu.R;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    List<ChatModel> list;
    Context context;

    public ChatAdapter(List<ChatModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View new_layout= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_model,viewGroup,false);

        ChatAdapter.ViewHolder n_l = new ChatAdapter.ViewHolder(new_layout);

        return n_l;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ViewHolder viewHolder, int i) {

        if(list.get(i).getStatus()==0){
            viewHolder.side.setGravity(Gravity.START);
            viewHolder.name.setText(list.get(i).getName());
            viewHolder.msg.setText(list.get(i).getMsg());
        }else {
            viewHolder.side.setGravity(Gravity.END);
            viewHolder.name.setText(list.get(i).getName());
            viewHolder.msg.setText(list.get(i).getMsg());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,msg;
        LinearLayout side;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            msg = itemView.findViewById(R.id.msg);
            side = itemView.findViewById(R.id.side);

        }
    }
}
