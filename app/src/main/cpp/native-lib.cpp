#include <jni.h>
#include <string>
#include <sstream>
#include "temperature.h"

extern "C"

jstring
Java_com_example_soham_qualcommandroid_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject, /* this */
        jdouble temp) {
    double tp = temp;

    std::string hello = "Hello from C++ ";//+Temperature::getInstance(temp).getTemp();


    return env->NewStringUTF(hello.c_str());
}
