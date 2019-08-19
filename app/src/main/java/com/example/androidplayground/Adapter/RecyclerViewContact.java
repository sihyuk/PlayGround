package com.example.androidplayground.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidplayground.Model.Contact;
import com.example.androidplayground.R;

import java.util.List;

public class RecyclerViewContact extends RecyclerView.Adapter<RecyclerViewContact.MyViewHolder> {

    private List<Contact> contacts;

    public RecyclerViewContact(List<Contact> contacts) {
        this.contacts = contacts;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(contacts.get(position).getName());
        holder.emailid.setText(contacts.get(position).getEmailid());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, emailid;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvname);
            emailid = itemView.findViewById(R.id.tvemailid);
        }
    }
}
