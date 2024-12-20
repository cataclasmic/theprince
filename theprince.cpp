#include "theprince.h"

void Peasant::deal(Peasant p)
{
  int allMoney = money + p.money;
  money = allMoney/2 + 1;
  p.money = allMoney/2 + 1;
}

int main()
{
}; 
