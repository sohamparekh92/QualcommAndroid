//
// Created by Soham on 10/3/2016.
//

#ifndef QUALCOMMANDROID_TEMPERATURE_H
#define QUALCOMMANDROID_TEMPERATURE_H

#include <iostream>
#include <cstring>
#include <vector>
//Temperature is a Singleton class.
//Conversion logic is handled by the Temperature class
class Temperature
{
public:
    static Temperature& getInstance();
    std::vector<int> getFahrenheit(std::vector<int> );
    int getFahrenheit(int );

private:
    Temperature(){}
    Temperature(Temperature&);
};

#endif //QUALCOMMANDROID_TEMPERATURE_H
