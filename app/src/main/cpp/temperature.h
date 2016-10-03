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
    static Temperature& getInstance();
    std::string&  getTemp() { return temp; }

private:
    std::string temp;
    Temperature():temp("1"){
    }
    Temperature(double);
    Temperature(Temperature&);
};

#endif //QUALCOMMANDROID_TRANSFORM_H
