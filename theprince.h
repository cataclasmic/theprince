#include <list>
#include <string>

class Attribute
{
 public:
  string name;
};

class Conservative : Attribute
{
 public:
  string name = "conservative";
}; 

class Pop
{
 public:
  int size;
  int id;
  std::list<Attribute> attrs;
  Pop() {
  }
};
