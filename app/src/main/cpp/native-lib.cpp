#include <jni.h>
#include <string>
#include <sstream>
#include <vector>
#include "temperature.h"

extern "C"

jstring
Java_com_example_soham_qualcommandroid_MainActivity_getTempJNI(
        JNIEnv* env,
        jobject, /* this */
        jintArray j_temp_far) {

    std::vector<int> temp_far;
    int len= env->GetArrayLength(j_temp_far);
    //int a = env->GetIntArrayElements()

    jint *body = env->GetIntArrayElements(j_temp_far, 0);
    std::ostringstream resultstream;
    resultstream<<len;

    std::string result = resultstream.str()+" - Size";

    return env->NewStringUTF(result.c_str());
}
