//
// Created by Soham on 10/3/2016.
//
#include "temperature.h"

Temperature& Temperature::getInstance(double temp){
    static Temperature instance(temp);
    return instance;
}

