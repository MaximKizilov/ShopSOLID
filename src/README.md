### Magics, DRY, SOLID

#### Вашему вниманию мясной магазин из глубинки

1. Magics: метод String generateOrderNumber()  использует поля класса

2. DRY: разделено что я смог на методы которые вызываются в ходе работы программы в соответсвующих методах не
   повторяется.

3. SOLID:
    - S: Классы разделены по каталогам как разграничение ответственности, и каждый выполняет свою роль
    - О: все по каталогам, кроме Main, модификаторы доступа предпологают использование гетеров и сетеров
    - L: Все "мясные" классы наследуются от Мeat, тип которого можно назначать потомкам
    - I: 2 интерфейса от которых имплементируются соотв. классы, соблюдение контракта. Хотел создать 3 разных
      интерфейса  
      и имплементировать и корзину и магазин от каждого но понял что я еще так не умею
    - D: Если можно отнести к этому MeatStore
  