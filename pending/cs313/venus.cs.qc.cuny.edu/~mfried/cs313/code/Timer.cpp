#include <iostream>
#include <ctime>
#include <list>
#include <vector>
using namespace std;
   
int main () {
   clock_t start, end;
   
   vector<int> v;
   start = clock();
   for (int i = 1; i <= 10000000; ++i)
      v.push_back(i);
   end = clock();
   cout << "vector: " << (double)(end-start)/CLOCKS_PER_SEC << endl;
   
   list<int> l;
   start = clock();
   for (int i = 1; i <= 10000000; ++i)
      l.push_back(i);
   end = clock();
   cout << "list: " << (double)(end-start)/CLOCKS_PER_SEC << endl;
}
