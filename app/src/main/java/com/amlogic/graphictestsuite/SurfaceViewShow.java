/*
 * Copyright (c) 2017 Amlogic, Inc. All rights reserved.
 *
 * This source code is subject to the terms and conditions defined in the
 * file 'LICENSE' which is part of this source code package.
 *
 * Description:
 */

package com.amlogic.graphictestsuite;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfaceViewShow extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private SurfaceHolder surfaceHolder;
    private Canvas canvas;      //绘图的 canvas
    private boolean isDrawing;  //子线程标志位

    public SurfaceViewShow(Context context) {
        this(context, null);
    }

    public SurfaceViewShow(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SurfaceViewShow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isDrawing = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isDrawing = false;
    }

    @Override
    public void run() {
        while (isDrawing) {
            drawSomething();
        }
    }


    //界面绘制
    private void drawSomething() {
        try {
            //获得 canvas 对象
            canvas = surfaceHolder.lockCanvas();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (canvas != null) {
                //释放 canvas 对象并提交画布
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
