package com.example.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NotesViewHolder> {
     //RelativeLayout context;
    Context context;
    List<Notes> list;
    NotesClickListener listener;


    public NoteListAdapter(Context context, List<Notes> list, NotesClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }



    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new NotesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.notelayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
       /// holder.imageViewicon.setImageResource(list.get(position).getImage());
       // holder.imageViewicon.setSelected(true);
holder.txtview_title.setText(list.get(position).getTitle());
//holder.txtview_title.setSelected(true);
        holder.txtview_note.setText(list.get(position).getNotes());
        //holder.txtview_note.setSelected(true);
       // if(list.get(position).pin)
       // {
       //     holder.imagepin.setImageResource(R.drawable.baseline_check_24);
      //  }
       // else{
       //     holder.imagepin.setImageResource(0);
      //  }
       // holder.notes_container.setOnClickListener(new View.OnClickListener() {
       //     @Override
       //     public void onClick(View view) {
        //        listener.onClick(list.get(holder.getAdapterPosition()));

        //    }
    //    });
//holder.notes_container.setOnLongClickListener(new View.OnLongClickListener() {
  //  @Override
   // public boolean onLongClick(View view) {
   ///     listener.onLongClick(list.get(holder.getAdapterPosition()),holder.notes_container);
    //    return true;
   // }
//});



    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class NotesViewHolder extends RecyclerView.ViewHolder{
    CardView notes_container;
    ImageView imageViewicon , imagepin;
    TextView txtview_title;
    TextView txtview_note;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
       // notes_container=itemView.findViewById(R.id.notes_container);
        txtview_title=itemView.findViewById(R.id.txtview_title);
        txtview_note=itemView.findViewById(R.id.txtview_note);
       // imageViewicon=itemView.findViewById(R.id.imageViewicon);
      //  imagepin=itemView.findViewById(R.id.imagepin);


    }
}
