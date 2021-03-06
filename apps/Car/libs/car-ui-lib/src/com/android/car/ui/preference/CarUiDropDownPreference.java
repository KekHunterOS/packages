/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.car.ui.preference;

import android.content.Context;
import android.util.AttributeSet;

import androidx.preference.DropDownPreference;

import com.android.car.ui.R;

/**
 * This class extends the base {@link DropDownPreference} class. Adds the drawable icon to
 * the preference.
 */
public class CarUiDropDownPreference extends DropDownPreference {

    private final Context mContext;

    public CarUiDropDownPreference(Context context) {
        super(context);
        mContext = context;
    }

    public CarUiDropDownPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public CarUiDropDownPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }

    public CarUiDropDownPreference(Context context, AttributeSet attrs, int defStyleAttr,
            int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
    }

    /**
     * Instead of displaying a drop-down that is not car optimized, have drop-down preferences
     * mirror the behavior of list preferences.
     */
    @Override
    protected void onClick() {
        getPreferenceManager().showDialog(this);
    }

    @Override
    public void onAttached() {
        super.onAttached();

        boolean showChevron = mContext.getResources().getBoolean(
                R.bool.car_ui_preference_show_chevron);

        if (!showChevron) {
            return;
        }

        setWidgetLayoutResource(R.layout.car_ui_preference_chevron);
    }
}
