#include <iostream>
#include <vector>
#include <list>
using namespace std;
	
int main () {
	int array[10] = {}; // Creates a 0-initialized array of size 10
	array[0] = 5; // Sets the element at index 0 to 5
	for (int i = 0; i < 10; ++i)
	   cout << array[i] << " "; // Prints the array
	cout << endl;
	
	vector<int> vector1(10); // Creates a 0-initialized vector of size 10
	vector1.push_back(5); // Adds 5 to the end of the vector
	
	vector<int> vector2(vector1.begin(), vector1.end()); // Creates a vector containing the same elements as vector1
	for (int i : vector2)
	   cout << i << " "; // Prints the vector
	cout << endl;
	
	list<int> list; // Creates an empty linked list
	list.push_back(5); // Adds 5 to the end of the linked list
}
