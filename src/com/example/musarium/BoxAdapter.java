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
  // кол-во элементов
  @Override
  public int getCount() {
    return objects.size();
  }

  // элемент по позиции
  @Override
  public Object getItem(int position) {
    return objects.get(position);
  }

  // id по позиции
  @Override
  public long getItemId(int position) {
    return position;
  }

  // пункт списка
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    // используем созданные, но не используемые view
    View view = convertView;
    if (view == null) {
      view = lInflater.inflate(R.layout.item, parent, false);
    }

    User p = getUser(position);

    // заполняем View в пункте списка данными из товаров: наименование, цена
    // и картинка
    ((TextView) view.findViewById(R.id.userName)).setText(p.name);
    ((TextView) view.findViewById(R.id.numberMP)).setText("" + p.mp);
    ((TextView) view.findViewById(R.id.textTime)).setText("" + p.time);

    ((ImageView) view.findViewById(R.id.avatar)).setImageResource(p.avatar);


    return view;
  }

  // товар по позиции
User getUser (int position) {
    return ((User) getItem(position));
  }


}