/*
 * Copyright (C) 2014, BeautySight Inc. All rights reserved.
 */

package com.beautysight.pplogs.domain;

import com.beautysight.common.bizapp.domain.ValueObject;
import com.beautysight.common.bizapp.utils.PreconditionUtils;
import com.google.common.base.Optional;

/**
 * 地理位置
 *
 * @author chenlong
 * @since 1.0
 */
public class GeoLocation extends ValueObject {

    private static final Float smallerLonBound = Float.valueOf(-180);
    private static final Float biggerLonBound = Float.valueOf(180);
    private static final Float smallerLatBound = Float.valueOf(-90);
    private static final Float biggerLatBound = Float.valueOf(90);

    private Float lon;
    private Float lat;

    @Override
    public void validate(Optional<String> fieldPrefix) {
        PreconditionUtils.between(smallerLonBound, biggerLonBound, prefixTo("lon", fieldPrefix), lon);
        PreconditionUtils.between(smallerLatBound, biggerLatBound, prefixTo("lat", fieldPrefix), lat);
    }

}