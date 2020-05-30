package com.example.aralarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlarmListAdapter extends RecyclerView.Adapter<AlarmListAdapter.AlarmViewHolder> {

    class AlarmViewHolder extends RecyclerView.ViewHolder{
        private final TextView dateView;
        private final TextView timeView;
        private final Switch on;

        private AlarmViewHolder(View itemView){
            super(itemView);
            dateView = itemView.findViewById(R.id.txt_alarm_date);
            timeView = itemView.findViewById(R.id.txt_alarm_time);
            on = itemView.findViewById(R.id.switch_alarm);
        }
    }

    private final LayoutInflater mInflater;
    private List<Alarm> mAlarms;

    AlarmListAdapter(Context context) {mInflater = LayoutInflater.from(context);}

    @Override
    public AlarmViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = mInflater.inflate(R.layout.item_alarm, parent, false);
        return new AlarmViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlarmViewHolder holder, int position){
        if(mAlarms != null){
            Alarm current = mAlarms.get(position);
            holder.dateView.setText(current.getMDate());
            holder.timeView.setText(current.getMTime());
            holder.on.setChecked(current.isMOn());
        } else{
            holder.dateView.setText("No Date");
            holder.timeView.setText("No Time");
            holder.on.setChecked(false);
        }
    }

    void setAlarms(List<Alarm> alarms){
        mAlarms = alarms;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        if(mAlarms != null)
            return mAlarms.size();
        else return 0;
    }
}