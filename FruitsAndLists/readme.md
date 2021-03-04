Значит называться она будет "Списки и фрукты". Порядок выполнения:
1. Нагуглить и прочитать про scala case class/class/trait/abstract class/object. Железно понимать чем они отличаются. Прочитать про объекты компаньоны, метод apply в них. Особое внимание уделить case class. В качестве первого упражнения написать такой class чтобы он обладал всеми фичами "кейс класса". Что получается и вопросы присылай/задавай сразу.

2. Погуглить и прочитать про алгебраические типы данных(algebraic data types/ ADT). Задать мне все появившиеся вопросы. Прочитать про наследование если не знаешь что это такое.

3. Написать с помощью знаний обретенных выше такую вот модель данных:
       Яблоко которое есть Фрукт внутри которого есть Int семечек,
       Яблоко которое есть Фрукт, но без семечек(пустое)

4. Можешь попробовать сама по полной аналогии с 3: Написать свой односвязный список для содержания Int.
    Подсказка: Пустой список есть Список
                         СписокСЭлементомInt есть список. Он содержит Int(элемент) и Список(хвост)

4*. оснастить свой список методом apply, чтобы я мог создать твой список вот так: MyIntList(1,2,3,4,5)
Для 4* придется еще почитать про pattern-matching, который должен уже активно появиться на этапе изучения case class

5. Реализовать
def myListHeadOption(list: MyIntList): MyIntOption

6. Реализовать
def myListMap(list: MyIntList, foo: Int => Int): MyIntList

7. Реализовать
def myOptionMap(opt: MyIntOption, foo: Int => Int): MyIntOption
New

8. Реализовать
def myListPure(i: Int): MyIntList
def myOptionPure(i: Int): MyIntOption

9. Реализовать
def myListFlatMap(list: MyIntList, foo: Int => MyIntList): MyIntList
def myOptionFlatMap(opt: MyIntOption, foo: Int => MyIntOption): MyIntOption