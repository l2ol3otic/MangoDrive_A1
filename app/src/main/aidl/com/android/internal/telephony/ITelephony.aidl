// ITelephony.aidl
package com.android.internal.telephony;

// Declare any non-default types here with import statements

interface ITelephony {
    boolean endCall();
    void answerRingingCall();
    void silenceRinger();
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
