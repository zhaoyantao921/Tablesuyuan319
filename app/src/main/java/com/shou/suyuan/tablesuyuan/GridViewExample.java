package com.shou.suyuan.tablesuyuan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.daimajia.swipe.util.Attributes;
import com.shou.suyuan.tablesuyuan.adapter.GridViewAdapter;

public class GridViewExample extends Activity{
/*2016.10.18第一个版本*/
    public static GridViewExample gridViewExample;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gridViewExample=this;
        setContentView(R.layout.gridview);
        final GridView gridView = (GridView)findViewById(R.id.gridview);
        final GridViewAdapter adapter = new GridViewAdapter(this);

        adapter.setMode(Attributes.Mode.Multiple);
        gridView.setAdapter(adapter);
        gridView.setSelected(true);

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("onItemLongClick","长按操作，位置："+position);
                /*AlertDialog.Builder dialog=new AlertDialog.Builder(GridViewExample.this);
                dialog.setTitle("长按操作-池塘："+position);
                dialog.show();*/
                Intent intent=new Intent(GridViewExample.this,DialogActivity.class);
                startActivity(intent);
                return false;
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Log.e("onItemClick","点击操作-池塘："+position);
                /*AlertDialog.Builder dialog=new AlertDialog.Builder(GridViewExample.this);
                dialog.setTitle("点击操作-池塘："+position);
                dialog.show();*/
                Intent intent=new Intent(GridViewExample.this,DialogActivity1.class);
                startActivity(intent);

            }


        });
        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("onItemSelected","被选择操作，位置："+position);
                //这个目前失效
                AlertDialog.Builder dialog=new AlertDialog.Builder(GridViewExample.this);
                dialog.setTitle("被选择操作-池塘："+position);
                dialog.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }
}
