#include <list>
#include <string>

class Attribute
{
};

class Conservative : public Attribute
{
 public:
  Conservative(float stiffUpperLip) : _stiffUpperLip(stiffUpperLip)
  {}
  float _stiffUpperLip;
}; 

class Radical : public Attribute
{
 public:
  Radical(float crazy) : _crazy(crazy)
  {}
  float _crazy;
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
