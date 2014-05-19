package com.example.musarium;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class BoxAdapter extends BaseAdapter {
  Context ctx;
  LayoutInflater lInflater;
  ArrayList<User> objects;
  BoxAdapter(Context context, ArrayList<User> products) {
    ctx = context;
    objects = products;
    lInflater = (LayoutInflater) ctx
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }
  // ���-�� ���������
  @Override
  public int getCount() {
    return objects.size();
  }

  // ������� �� �������
  @Override
  public Object getItem(int position) {
    return objects.get(position);
  }

  // id �� �������
  @Override
  public long getItemId(int position) {
    return position;
  }

  // ����� ������
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    // ���������� ���������, �� �� ������������ view
    View view = convertView;
    if (view == null) {
      view = lInflater.inflate(R.layout.item, parent, false);
    }

    User p = getUser(position);

    // ��������� View � ������ ������ ������� �� �������: ������������, ����
    // � ��������
    ((TextView) view.findViewById(R.id.userName)).setText(p.name);
    ((TextView) view.findViewById(R.id.numberMP)).setText("" + p.mp);
    ((TextView) view.findViewById(R.id.textTime)).setText("" + p.time);

    ((ImageView) view.findViewById(R.id.avatar)).setImageResource(p.avatar);


    return view;
  }

  // ����� �� �������
User getUser (int position) {
    return ((User) getItem(position));
  }


}