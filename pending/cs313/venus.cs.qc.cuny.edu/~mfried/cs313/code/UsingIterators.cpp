#include <iostream>
#include <list>
using namespace std;
	
int main () {
   list<int> list; // Creates an empty linked list
   for (int i = 1; i <= 10; ++i) // Adds the numbers from 1-10 to the list
      list.push_back(i);
   
   for (auto it = list.begin(); it != list.end(); ++it) // Prints the list with an iterator
      cout << *it << " ";
   cout << endl;
   
   for (auto it = list.begin(); it != list.end(); ++it) // Removes all even numbers from the list
      if (*it % 2 == 0)
         list.erase(it++);
   
   for (int i : list) // Prints the list with a for-each loop
      cout << i << " ";
}
