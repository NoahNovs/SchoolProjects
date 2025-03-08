package com.example.finalapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private static ArrayList<Reminder> localDataSet;
    private Context context;

    public CustomAdapter(ArrayList<Reminder> dataSet, Context context) {
        localDataSet = dataSet;
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title, desc, dateAndTime;
        private ImageView delete;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            title = view.findViewById(R.id.titleTxt);
            desc = view.findViewById(R.id.descTxt);
            dateAndTime = view.findViewById(R.id.dtTxt);
            delete = view.findViewById(R.id.trashImage);
            title.setOnClickListener(this);
            desc.setOnClickListener(this);
            dateAndTime.setOnClickListener(this);
            delete.setOnClickListener(this);
        }

        public TextView getTitle() {
            return title;
        }

        public TextView getDesc() {
            return desc;
        }

        public TextView getDateAndTime() {
            return dateAndTime;
        }

        @Override
        public void onClick(View v) {
            if(v.equals(title) || v.equals(desc) || v.equals(dateAndTime))
            {
                //put prefilled fields
                Intent intent = new Intent(v.getContext(),ReminderActivity.class);
                intent.putExtra("TITLE", localDataSet.get(getAdapterPosition()).getTitle());
                intent.putExtra("DESC", localDataSet.get(getAdapterPosition()).getDesc());
                intent.putExtra("DATE",localDataSet.get(getAdapterPosition()).getDate());
                intent.putExtra("TIME",localDataSet.get(getAdapterPosition()).getTime());
                intent.putExtra("POS", getAdapterPosition());

                Log.d("TAG", getAdapterPosition() + " position has been clicked");
                v.getContext().startActivity(intent);
            }
            //open dialog fragment for delete, add title in as well
            //to make sure the correct reminder is deleted
            else if(v.equals(delete))
            {
                FragmentActivity activity = (FragmentActivity)(context);
                deleteDialogFragment del = new deleteDialogFragment();
                Bundle args = new Bundle();
                args.putString("TITLE",localDataSet.get(getAdapterPosition()).getTitle());
                del.setArguments(args);
                del.show(activity.getSupportFragmentManager(), "fragment_alert");
            }
        }
    }
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item

        Log.d("MyRecyclerView", "onCreateViewHolder ");

        //show reminder
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.reminder, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTitle().setText(localDataSet.get(position).getTitle());
        viewHolder.getDesc().setText(localDataSet.get(position).getDesc());
        viewHolder.getDateAndTime().setText(localDataSet.get(position).getDate() + "\n" + localDataSet.get(position).getTime());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

