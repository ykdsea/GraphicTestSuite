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
import android.os.Bundle;
import android.support.annotation.Nullable;

public class ForceDefaultOrientation extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_0001);
    }
}
