/*
 * Copyright (c) 2017 Amlogic, Inc. All rights reserved.
 *
 * This source code is subject to the terms and conditions defined in the
 * file 'LICENSE' which is part of this source code package.
 *
 * Description:
 */

package com.amlogic.graphictestsuite;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

public class SurfaceViewActivity extends Activity {

    private int layer = 1;      //记录当前绘制第几层 layer
    private SurfaceViewShow showSurfaceView;
    private String position, size, format, render, frame, interval;
    private int position_x, position_y, size_width, size_height;
    private float alpha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surface_view);
        getSurfaceParam();
    }

    //从宿主 activity 取得每个 surfaceViewParam
    private void getSurfaceParam() {
        int count;
        SurfaceViewEntity surfaceViewParam;  //临时保存 activity 传递的 surfaceViewParam 实例
        Intent intent = getIntent();
        count = intent.getIntExtra("layers_total", 0);

        //由于 queue 的先入先出原则，需要从 layer_1 开始取
        while (layer <= count) {
            surfaceViewParam = (SurfaceViewEntity) intent.getSerializableExtra("layers" + layer);
            drawSurfaceView(surfaceViewParam);
            ++layer;
        }
    }

    //逐层绘制 surfaceView
    private void drawSurfaceView(SurfaceViewEntity surfaceViewParam) {
        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        showSurfaceView = new SurfaceViewShow(this);
        getParams(surfaceViewParam);
        addContentView(showSurfaceView, layoutParams);
    }

    //根据 surfaceViewParam 实例提取每个 param
    private void getParams(SurfaceViewEntity surfaceViewParam) {
        position = surfaceViewParam.getPosition();
        size = surfaceViewParam.getSize();
        format = surfaceViewParam.getFormat();
        alpha = surfaceViewParam.getAlpha();
        render = surfaceViewParam.getRender();
        frame = surfaceViewParam.getFrame();
        interval = surfaceViewParam.getInterval();

        formatParams();
    }

    //格式化数据，便于使用
    private void formatParams() {
        String[] subString = position.split(",");
        position_x = Integer.parseInt(subString[0]);
        position_y = Integer.parseInt(subString[1]);
        subString = size.split(",");
        size_width = Integer.parseInt(subString[0]);
        size_height = Integer.parseInt(subString[1]);
        //surfaceView 实际的宽高需要计算偏移量
        size_width += position_x;
        size_height += position_y;

        formatSurfaceView();
    }

    //根据 params 绘制 surfaceView
    private void formatSurfaceView() {
        int color = getColor(layer);
        showSurfaceView.setBackgroundColor(color);
        showSurfaceView.setX(position_x);
        showSurfaceView.setY(position_y);
        showSurfaceView.setRight(size_width);
        showSurfaceView.setBottom(size_height);
        showSurfaceView.setAlpha(alpha);
    }

    //设置不同的 layer 不同的背景色
    private int getColor(int count) {
        int color;
        count %= 2;
        switch (count) {
            case 0:
                color = Color.BLUE;
                break;
            case 1:
                color = Color.YELLOW;
                break;
            default:
                color = Color.WHITE;
                break;
        }
        return color;
    }
}
