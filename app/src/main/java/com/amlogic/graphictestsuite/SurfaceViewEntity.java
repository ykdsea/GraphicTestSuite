/*
 * Copyright (c) 2017 Amlogic, Inc. All rights reserved.
 *
 * This source code is subject to the terms and conditions defined in the
 * file 'LICENSE' which is part of this source code package.
 *
 * Description:
 */

package com.amlogic.graphictestsuite;

import java.io.Serializable;

/**
 * 实例化 surface_view_param
 */
class SurfaceViewEntity implements Serializable {

    private int count;
    private float alpha;
    private String position;
    private String size;
    private String format;
    private String render;
    private String frame;
    private String interval;

    SurfaceViewEntity() {
    }

    void setCount(int count) {
        this.count = count;
    }

    String getPosition() {
        return position;
    }

    void setPosition(String position) {
        this.position = position;
    }

    String getSize() {
        return size;
    }

    void setSize(String size) {
        this.size = size;
    }

    String getFormat() {
        return format;
    }

    void setFormat(String format) {
        this.format = format;
    }

    float getAlpha() {
        return alpha;
    }

    void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    String getRender() {
        return render;
    }

    void setRender(String render) {
        this.render = render;
    }

    String getFrame() {
        return frame;
    }

    void setFrame(String frame) {
        this.frame = frame;
    }

    String getInterval() {
        return interval;
    }

    void setInterval(String interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        return "layers" + count + ": position: " + position + "; size: " + size
                + "; format: " + format + "; alpha: " + alpha + "; render: " + render
                + "; frame: " + frame + "; interval: " + interval + ";";
    }
}
