#include <jni.h>
#include <string>
#include <sstream>
#include <vector>
#include "temperature.h"

extern "C"

//For Week days values
jstring
Java_com_example_soham_qualcommandroid_MainActivity_getTempJNI(JNIEnv* env, jobject, jintArray j_temp_c) {

    std::vector<int> temp_far;
    std::vector<int> temp_cel;

    int len= env->GetArrayLength(j_temp_c);
    jint *body = env->GetIntArrayElements(j_temp_c, 0);

    for(int i=0;i<len;++i){
        temp_cel.push_back(body[i]);
    }

    temp_far = Temperature::getInstance().getFarenheit(temp_cel);
    std::ostringstream resultstream;

    for(int i=0; i<temp_far.size();++i) {
        resultstream << temp_far[i] << " ";
    }

    std::string result = resultstream.str();
    return env->NewStringUTF(result.c_str());
}

//For Sensor Value
jint
Java_com_example_soham_qualcommandroid_MainActivity_getTempSingleJNI(JNIEnv* env, jobject, jint j_temp_c) {
    int result = 0;
   // result = Temperature::getInstance().getFarenheit(j_temp_c);
    return (jint)result;
}
