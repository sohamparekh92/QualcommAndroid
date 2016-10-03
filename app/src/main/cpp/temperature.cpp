//
// Created by Soham on 10/3/2016.
//
#include "temperature.h"

static Temperature& Temperature::getInstance(){
    static Temperature instance;
    return instance;
}

