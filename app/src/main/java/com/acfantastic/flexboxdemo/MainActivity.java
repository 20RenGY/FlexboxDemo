package com.acfantastic.flexboxdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private MyAdapter myAdapter;
    private final String FlexBox = "FlexBox";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        myAdapter = new MyAdapter(getDataList());
        //设置布局管理器
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        //flexDirection 属性决定主轴的方向（即项目的排列方向）。类似 LinearLayout 的 vertical 和 horizontal。
        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW); //主轴为水平方向，起点在左端。
        //flexWrap 默认情况下 Flex 跟 LinearLayout 一样，都是不带换行排列的，但是flexWrap属性可以支持换行排列。
        flexboxLayoutManager.setFlexWrap(FlexWrap.WRAP); //按正常方向换行
        //justifyContent 属性定义了项目在主轴上的对齐方式。
        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START); //交叉轴的起点对齐。
        recyclerView.setLayoutManager(flexboxLayoutManager);
        recyclerView.setAdapter(myAdapter);
    }


    /**
     * 获取数据
     */
    private ArrayList<String> getDataList() {
        ArrayList<String> dataList = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(5);
            String data = FlexBox;
            for (int x = 0; x < randomNumber; x++) {
                data += FlexBox;
            }
            dataList.add(data);
        }
        return dataList;
    }
}