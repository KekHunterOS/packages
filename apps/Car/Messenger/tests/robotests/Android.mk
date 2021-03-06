#############################################################
# Car Messenger Robolectric test target.                    #
#############################################################
LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := CarMessengerRoboTests

LOCAL_SRC_FILES := $(call all-java-files-under, src)

LOCAL_RESOURCE_DIR := \
    $(LOCAL_PATH)/res

LOCAL_JAVA_RESOURCE_DIRS := config

# Include the testing libraries
LOCAL_JAVA_LIBRARIES := \
    robolectric_android-all-stub \
    Robolectric_all-target \
    mockito-robolectric-prebuilt \
    truth-prebuilt

LOCAL_INSTRUMENTATION_FOR := CarMessengerApp

LOCAL_MODULE_TAGS := optional

include $(BUILD_STATIC_JAVA_LIBRARY)

#############################################################
# Car Messenger runner target to run the previous target.   #
#############################################################
include $(CLEAR_VARS)

LOCAL_MODULE := RunCarMessengerRoboTests

LOCAL_JAVA_LIBRARIES := \
    CarMessengerRoboTests \
    robolectric_android-all-stub \
    Robolectric_all-target \
    mockito-robolectric-prebuilt \
    truth-prebuilt

LOCAL_TEST_PACKAGE := CarMessengerApp

LOCAL_INSTRUMENT_SOURCE_DIRS := $(dir $(LOCAL_PATH))../src

include external/robolectric-shadows/run_robotests.mk