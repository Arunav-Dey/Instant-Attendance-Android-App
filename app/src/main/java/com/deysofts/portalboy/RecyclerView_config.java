package com.deysofts.portalboy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_config {
    private Context mContext;
    private DataAdapter mDataAdapter;
    private Button fetch_data;

    public void setConfig(RecyclerView recyclerView,Context context,List<helper> help,List<String> keys)
    {
        mContext=context;
        mDataAdapter=new DataAdapter(help,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mDataAdapter);



    }

    class DataItemView extends RecyclerView.ViewHolder
    {
       private TextView name_texView;
       private TextView attendance_textView;
       private TextView figure_textView;



       private String key;

       public DataItemView(ViewGroup parent)
       {
           super(LayoutInflater.from(mContext).inflate(R.layout.data_list_item,parent,false));

           name_texView=(TextView)itemView.findViewById(R.id.name_textView);
           attendance_textView=(TextView)itemView.findViewById(R.id.attendance_textView);
           figure_textView=(TextView)(TextView)itemView.findViewById(R.id.figure_textView);



       }

       public void bind(helper help,String key)
       {
           name_texView.setText(help.getName());
           attendance_textView.setText(help.getAttendance());
           figure_textView.setText(help.getFigure());

           this.key=key;
       }

    }

    class DataAdapter extends RecyclerView.Adapter<DataItemView>
    {
        private List<helper> mDataList;
        private List<String> mKeys;

        public DataAdapter() {
            super();
        }

        @NonNull
        @Override
        public DataItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new DataItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull DataItemView holder, int position) {
            holder.bind(mDataList.get(position),mKeys.get(position));


        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }

        public DataAdapter(List<helper> mDataList, List<String> mKeys) {
            this.mDataList = mDataList;
            this.mKeys = mKeys;


        }




        }
    }





