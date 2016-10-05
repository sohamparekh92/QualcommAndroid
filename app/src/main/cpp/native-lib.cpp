#include <jni.h>
#include <string>
#include <sstream>
#include <vector>
#include "temperature.h"

extern "C"

jstring
Java_com_example_soham_qualcommandroid_MainActivity_getTempJNI(JNIEnv* env, jobject, jintArray j_temp_far) {

    std::vector<int> temp_far;
    std::vector<int> temp_cel;

    int len= env->GetArrayLength(j_temp_far);
    jint *body = env->GetIntArrayElements(j_temp_far, 0);

    for(int i=0;i<len;++i){
        temp_far.push_back(body[i]);
    }

    temp_cel = Temperature::getInstance().getCelsius(temp_far);
    std::ostringstream resultstream;

    for(int i=0; i<temp_cel.size();++i) {
        resultstream << temp_cel[i] << " ";
    }

    std::string result = resultstream.str()+" - Celsius";
    return env->NewStringUTF(result.c_str());
}
