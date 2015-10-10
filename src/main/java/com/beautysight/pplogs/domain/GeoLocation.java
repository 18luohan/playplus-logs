/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.pplogs.domain;

import com.beautysight.common.domain.DomainVO;
import com.beautysight.common.utils.PreconditionUtils;

/**
 * 地理位置
 *
 * @author chenlong
 * @since 1.0
 */
public class GeoLocation extends DomainVO {

    private static final Float smallerLonBound = Float.valueOf(-180);
    private static final Float biggerLonBound = Float.valueOf(180);
    private static final Float smallerLatBound = Float.valueOf(-90);
    private static final Float biggerLatBound = Float.valueOf(90);

    private Float lon;
    private Float lat;

    public void validate() {
        PreconditionUtils.between(smallerLonBound, biggerLonBound, "loc.lon", lon);
        PreconditionUtils.between(smallerLatBound, biggerLatBound, "loc.lat", lat);
    }

}