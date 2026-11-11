#include <fstream>
#include <iostream>
using namespace std;

int main(int argc, char* argv[]) {
    ofstream test("./test.dmbk");

    for (int i = 1; i <= 111006; ++i)
        test << "FUCK OOP, FUCK HUST, FUCK EVERYONE T_T\n";

    test.close();
}