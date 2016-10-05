//
// Created by Soham on 10/3/2016.
//
#include "temperature.h"

Temperature& Temperature::getInstance(){
    static Temperature instance;
    return instance;
}

std::vector<int> Temperature::getFarenheit(std::vector<int> cel){
    std::vector<int> result;
    for(int i=0; i<cel.size();++i) {
        //result.push_back((far[i] - 32) * 5 / 9);
        result.push_back((cel[i]*9)/5+32 );
    }
    return result;
}

