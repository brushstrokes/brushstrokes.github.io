#include <iostream>
#include <set>
#include <unordered_map>
using namespace std;

// Both set and map both have an ordered version and an unordered version.
int main () {
   set<int> set; // Creates an empty set
   set.insert(3); // Adds 3
   cout << set.count(3); // Prints 1 if the set contains 3, otherwise 0
   for (int i : set) // Prints the set (the elements are sorted because it's an ordered set)
      cout << i << " ";
   set.erase(3); // Removes 3 from the set
   cout << endl;
   
   unordered_map<int, int> map; // Creates an empty unordered_map
   map[3] = 5; // Adds key 3 with value 5
   map[3] = 7; // Updates the value of key 3 to 7
   cout << map.count(3); // Prints 1 if the set contains key 3, otherwise 0
   for (auto i : map) // Prints the unordered_map (the keys are not sorted because it's an unordered_map)
      cout << i.first << "=" << i.second << " ";
   map.erase(3); // Removes key 3 from the map
}
