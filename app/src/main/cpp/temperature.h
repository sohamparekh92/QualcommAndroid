//
// Created by Soham on 10/3/2016.
//

#ifndef QUALCOMMANDROID_TRANSFORM_H
#define QUALCOMMANDROID_TRANSFORM_H

#include <iostream>
#include <cstring>
//Temperature is a Singleton class.
class Temperature
{
public:
    static Temperature& getInstance(double);
    double  getTemp() { return temp; }

private:
    double temp;
    Temperature(double t):temp(t){
    }
    Temperature();
    Temperature(Temperature&);
};

#endif //QUALCOMMANDROID_TRANSFORM_H
