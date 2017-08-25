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
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetSurfaceViewParam extends Activity implements View.OnClickListener {

    //用于封装 surface_param
    SurfaceViewEntity surfaceViewParam = new SurfaceViewEntity();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surface_parameter);

        initView();
    }

    private void initView() {
        Button but1, but2;
        but1 = (Button) findViewById(R.id.discard_parameter_setting);
        but2 = (Button) findViewById(R.id.apply_parameter_setting);

        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.discard_parameter_setting:
                this.setResult(RESULT_CANCELED, intent);
                this.finish();
                break;
            case R.id.apply_parameter_setting:
                putData(intent);
                this.setResult(RESULT_OK, intent);
                this.finish();
                break;
            default:
                break;
        }
    }

    //将返回数据存入Intent
    private void putData(Intent intent) {
        packageData();
        intent.putExtra("surfaceViewParam", surfaceViewParam);
    }

    //将 surface_param 封装成 surfaceViewParam 在 activity 之间传递
    private void packageData() {
        //接收输入的 surface_parameter 各参数
        String position, size, format, render, frame, interval;
        float alpha;

        EditText editText;
        editText = (EditText) findViewById(R.id.edit_surface_position) ;
        position = editText.getText().toString();
        editText = (EditText) findViewById(R.id.edit_surface_size) ;
        size = editText.getText().toString();
        editText = (EditText) findViewById(R.id.edit_surface_format) ;
        format = editText.getText().toString();
        editText = (EditText) findViewById(R.id.edit_surface_layer_alpha) ;
        alpha = Float.parseFloat(editText.getText().toString());
        editText = (EditText) findViewById(R.id.edit_surface_render_type) ;
        render = editText.getText().toString();
        editText = (EditText) findViewById(R.id.edit_surface_refresh_frames) ;
        frame = editText.getText().toString();
        editText = (EditText) findViewById(R.id.edit_surface_refresh_interval) ;
        interval = editText.getText().toString();

        surfaceViewParam.setPosition(position);
        surfaceViewParam.setSize(size);
        surfaceViewParam.setFormat(format);
        surfaceViewParam.setAlpha(alpha);
        surfaceViewParam.setRender(render);
        surfaceViewParam.setFrame(frame);
        surfaceViewParam.setInterval(interval);
    }
}
