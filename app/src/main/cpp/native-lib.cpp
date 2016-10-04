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
    std::ostringstream strx;
    strx<<temp;
    //std::string tp =
    std::string hello = "Hello from C++ "+strx.str();//+Temperature::getInstance(temp).getTemp();

    return env->NewStringUTF(hello.c_str());
}
