package com.example.studentinformationsystem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.List;

public class ButtonAdaptor extends BaseAdapter {

    private LayoutInflater myInflater;
    private List<Button> buttons;

    public ButtonAdaptor(Activity activity, List<Button> b){
        myInflater =(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.buttons = b;
    }
    @Override
    public int getCount() {
        return buttons.size();
    }

    @Override
    public Object getItem(int i) {
        return buttons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView;

        rowView = myInflater.inflate(R.layout.button_activity, null);
        Button btn =(Button) rowView.findViewById(R.id.btnOfLayout);

        Button btns = buttons.get(i);
        btn.setText(btns.getText());
        btn.setId(btns.getId());

        return rowView;
    }
}
