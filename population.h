#include <list>
#include <string>

class Attribute
{
};

class Conservative : Attribute
{
 public:
  Conservative(){}
  float stiffUpperLip = 0.5;
}; 

class Radical : Attribute
{
 public:
  Radical(){}
  float crazy = 0.5;
}; 

class Pop
{
 public:
  Pop(int size, std::list<Attribute> attrs) : _size(size), _attrs(attrs)
  {}
 private:
  int _size;
  int _id;
  std::list<Attribute> _attrs;
};
