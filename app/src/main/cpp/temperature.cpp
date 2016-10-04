//
// Created by Soham on 10/3/2016.
//
#include "temperature.h"

Temperature& Temperature::getInstance(){
    static Temperature instance;
    return instance;
}

std::vector<int> Temperature::getCelsius(std::vector<int> far){
    std::vector<int> result;
    for(int i=0; i<far.size();++i) {
        result.push_back((far[i] - 32) * 5 / 9);
    }
    return result;
}

