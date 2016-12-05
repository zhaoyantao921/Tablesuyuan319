package com.shou.suyuan.tablesuyuan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.BaseSwipeAdapter;
import com.shou.suyuan.tablesuyuan.DialogActivity2;
import com.shou.suyuan.tablesuyuan.DialogActivity3;
import com.shou.suyuan.tablesuyuan.DialogActivity4;
import com.shou.suyuan.tablesuyuan.DialogActivity5;
import com.shou.suyuan.tablesuyuan.DialogActivity6;
import com.shou.suyuan.tablesuyuan.GridViewExample;
import com.shou.suyuan.tablesuyuan.R;
//向GridView 放数据的adapter
//继承自BaseSwipeAdapter

/*这个实例涉及的操作  setMode
* final GridViewAdapter adapter = new GridViewAdapter(this);
  adapter.setMode(Attributes.Mode.Multiple);
  gridView.setAdapter(adapter);
* */
public class GridViewAdapter extends BaseSwipeAdapter {

    private Context mContext;

    public GridViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public View generateView(final int position, ViewGroup parent) {
        //填充GridView的每一个item的原料
        View v=LayoutInflater.from(mContext).inflate(R.layout.grid_item, null);

        SwipeLayout swipeLayout=(SwipeLayout)v.findViewById(getSwipeLayoutResourceId(position));
        swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
                //滑动打开的时候  有震动效果
                YoYo.with(Techniques.Tada).duration(500).delay(200).playOn(layout.findViewById(R.id.op_huanshui));
                YoYo.with(Techniques.Tada).duration(500).delay(300).playOn(layout.findViewById(R.id.op_yongyao));
                YoYo.with(Techniques.Tada).duration(500).delay(400).playOn(layout.findViewById(R.id.op_touerliao));
                YoYo.with(Techniques.Tada).duration(500).delay(500).playOn(layout.findViewById(R.id.op_toumiao));
                YoYo.with(Techniques.Tada).duration(500).delay(600).playOn(layout.findViewById(R.id.op_fubiaoguanli));
                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.huadongseting));
            }
        });

       v.findViewById(R.id.op_huanshui).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               /*Toast.makeText(mContext,"换水操作编号："+position,Toast.LENGTH_SHORT).show();*/
               /**/
               Intent intent =new Intent(GridViewExample.gridViewExample, DialogActivity2.class);
               GridViewExample.gridViewExample.startActivity(intent);
           }
       });
        v.findViewById(R.id.op_yongyao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Toast.makeText(mContext,"用药操作编号："+position,Toast.LENGTH_SHORT).show();*/
                Intent intent =new Intent(GridViewExample.gridViewExample, DialogActivity3.class);
                GridViewExample.gridViewExample.startActivity(intent);
            }
        });
        v.findViewById(R.id.op_touerliao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Toast.makeText(mContext,"投饵料操作编号："+position,Toast.LENGTH_SHORT).show();*/
                Intent intent =new Intent(GridViewExample.gridViewExample, DialogActivity4.class);
                GridViewExample.gridViewExample.startActivity(intent);
            }
        });
        v.findViewById(R.id.op_toumiao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Toast.makeText(mContext,"投苗操作编号："+position,Toast.LENGTH_SHORT).show();*/
                Intent intent =new Intent(GridViewExample.gridViewExample, DialogActivity5.class);
                GridViewExample.gridViewExample.startActivity(intent);
            }
        });
        v.findViewById(R.id.op_fubiaoguanli).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Toast.makeText(mContext,"浮标管理操作编号："+position,Toast.LENGTH_SHORT).show();*/
                Intent intent =new Intent(GridViewExample.gridViewExample, DialogActivity6.class);
                GridViewExample.gridViewExample.startActivity(intent);
            }
        });
        return v;
    }

    @Override
    public void fillValues(int position, View convertView) {
        //converview 为上层的视图
        TextView t = (TextView)convertView.findViewById(R.id.position);
        t.setText("池塘编号"+(position + 1 ));
     /*   ImageView imageView =(ImageView) convertView.findViewById(R.id.huadongseting);*/
        YoYo.with(Techniques.ZoomIn).duration(500).delay(100).playOn(convertView.findViewById(R.id.im_chitang));
        YoYo.with(Techniques.ZoomIn).duration(500).delay(200).playOn(convertView.findViewById(R.id.im_yangzhizhonglei));
        YoYo.with(Techniques.ZoomIn).duration(500).delay(300).playOn(convertView.findViewById(R.id.im_shuizhiyujing));
        YoYo.with(Techniques.ZoomIn).duration(500).delay(400).playOn(convertView.findViewById(R.id.im_erliaojishi));
        YoYo.with(Techniques.ZoomIn).duration(500).delay(500).playOn(convertView.findViewById(R.id.im_huanshuijishi));
        YoYo.with(Techniques.ZoomIn).duration(500).delay(600).playOn(convertView.findViewById(R.id.im_gengduocaozuo));
    }

    @Override
    public int getCount() {
        return 5;//初始化池塘
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
