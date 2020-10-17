/*
 * Copyright (C) 2019 The Android Open Source Project
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

package com.android.car.dialer.testutils;

import com.android.car.telephony.common.Contact;
import com.android.car.telephony.common.InMemoryPhoneBook;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

import java.util.HashMap;
import java.util.Map;

/**
 * Shadow class for {@link InMemoryPhoneBook}.
 */
@Implements(InMemoryPhoneBook.class)
public class ShadowInMemoryPhoneBook {

    private Map<String, Contact> contactMap = new HashMap<>();

    /**
     * Adds phone number and contact pairs to the map.
     */
    public void add(String number, Contact contact) {
        contactMap.put(number, contact);
    }

    /**
     * Returns a ViewModel from the map.
     */
    @Implementation
    public Contact lookupContactEntry(String number) {
        return contactMap.get(number);
    }
}