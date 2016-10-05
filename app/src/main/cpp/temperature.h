//
// Created by Soham on 10/3/2016.
//

#ifndef QUALCOMMANDROID_TEMPERATURE_H
#define QUALCOMMANDROID_TEMPERATURE_H

#include <iostream>
#include <cstring>
#include <vector>
//Temperature is a Singleton class.
class Temperature
{
public:
    static Temperature& getInstance();
    std::vector<int> getFarenheit(std::vector<int> );
    int getFarenheit(int );

private:
    Temperature(){}
    Temperature(Temperature&);
};

#endif //QUALCOMMANDROID_TEMPERATURE_H
