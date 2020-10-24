package com.practical.work;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private ArrayList<BooklistItem> bBookList;
    private AdapterView.OnItemClickListener bListener;

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_booklist_item, parent, false);
        BookViewHolder svh = new BookViewHolder(v, bListener);
        return svh;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        this.bListener = listener;
    }
    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        BooklistItem currentItem = bBookList.get(position);
        holder.mTextViewLine1.setText(currentItem.getLine1());
        holder.mTextViewLine2.setText(currentItem.getLine2());
    }
    public BookAdapter(ArrayList<BooklistItem> subjectList) {
        bBookList = subjectList;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewLine1;
        public TextView mTextViewLine2;
        public BookViewHolder(@NonNull View itemView, AdapterView.OnItemClickListener bListener) {
            super(itemView);
            mTextViewLine1 = itemView.findViewById(R.id.textview_line1);
            mTextViewLine2 = itemView.findViewById(R.id.textview_line_2);
        }
    }
}
