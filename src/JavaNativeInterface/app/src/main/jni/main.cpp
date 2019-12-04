//
// Created by user0 on 2019-11-21.
//

#include <jni.h>
#include <string>

#include "com_example_jnitest_HelloNDK.h"

JNIEXPORT jstring JNICALL Java_com_example_jnitest_HelloNDK_stringFromJNI
  (JNIEnv *env,
  jobject /* this */) {

    std::string hello = "It comes from C++";
    return env->NewStringUTF(hello.c_str());
  }