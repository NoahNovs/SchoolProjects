package com.example.notesapp;

import android.content.Intent;
import android.view.ViewGroup;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private static ArrayList<newNote> localDataSet;

    public CustomAdapter(ArrayList<newNote> dataSet) {
        localDataSet = dataSet;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView, textContent;
        private Button button;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.textTitle);
            textContent = view.findViewById(R.id.textView4);
            //button = view.findViewById(R.id.deleteButton);

            textView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    Log.d("TextView Click", "Element " + getAdapterPosition() + " clicked");
                    Intent intent = new Intent(v.getContext(),NoteActivity.class);
                    intent.putExtra("TITLE", localDataSet.get(getAdapterPosition()).getNoteTitle());
                    intent.putExtra("CONT", localDataSet.get(getAdapterPosition()).getNoteContent());
                    intent.putExtra("POS", getAdapterPosition());

                    v.getContext().startActivity(intent);
                }
            });

//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Log.d("ButtonClick", "Element " + getAdapterPosition() + " clicked");
//                    localDataSet.remove(getAdapterPosition());
//                    notifyItemRemoved(getAdapterPosition());
//                    notifyItemRangeChanged(getAdapterPosition(),localDataSet.size());
//                }
//            });
        }

        public TextView getTextView() {
            return textView;
        }

        public TextView getTextContent() {
            return textContent;
        }
    }
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item

        Log.d("MyRecyclerView", "onCreateViewHolder ");

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.example_note, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Log.d("MyRecyclerView", "onBindViewHolder " + position);
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView().setText(localDataSet.get(position).getNoteTitle());
        viewHolder.getTextContent().setText(localDataSet.get(position).getNoteContent());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
