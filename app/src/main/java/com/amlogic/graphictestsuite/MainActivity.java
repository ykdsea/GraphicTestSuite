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
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化View
        initView();
    }

    private void initView() {
        Button button0, button4;
        button0 = (Button) findViewById(R.id.button0);
        button4 = (Button) findViewById(R.id.button4);

        button0.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.button0:
                intent = new Intent(this, ForceDefaultOrientation.class);
                break;
            case R.id.button4:
                intent = new Intent(this, ComposerTest.class);
                break;
            default:
                intent = null;
                break;
        }
        startActivity(intent);
    }

}
