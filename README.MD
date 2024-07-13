# Итоговая контрольная работа #

  ## Информация о проекте

### Необходимо организовать систему учета для питомника в котором живут домашние и Pack animals 

## Задание  

### Операционные системы и виртуализация (Linux)

## 1. Использование команды cat в Linux

- Создать два текстовых файла: "Pets"(Домашние животные) и "Pack animals"(вьючные животные), используя команду `cat` в терминале Linux. В первом файле перечислить собак, кошек и хомяков. Во втором — лошадей, верблюдов и ослов.

┏━[17:21:22]  
┃ /home/catcher

┗━➤  cat > pet.txt

┏━[17:23:40]  
┃ /home/catcher

┗━➤  cat > pack_animals.txt

- Объединить содержимое этих двух файлов в один и просмотреть его содержимое.

┏━[17:35:09]  
┃ /home/catcher

┗━➤  cat pet.txt pack_animals.txt > animals.txt 

- Переименовать получившийся файл в "Human Friends".

┏━[17:35:54]  
┃ /home/catcher

┗━➤  mv animals.txt human_friends.txt 

## 2. Работа с директориями в Linux

- Создать новую директорию и переместить туда файл "Human Friends".

┏━[17:41:58]  
┃ /home/catcher

┗━➤  mkdir animal_nursery

┏━[17:46:01]  
┃ /home/catcher

┗━➤  mv human_friends.txt animal_nursery/


## 3. Работа с MySQL в Linux. “Установить MySQL на вашу вычислительную машину ”

- Подключить дополнительный репозиторий MySQL и установить один из пакетов из этого репозитория.

┏━[18:17:55]  
┃ /home/catcher

┗━➤  sudo apt-get update

┏━[08:38:04]  
┃ /home/catcher

┗━➤  wget [https://repo.mysql. com/mysql-apt-config_0.8.9-1_all.deb](https://repo.mysql.com/mysql-apt-config_0.8.9-1_all.deb)

┏━[08:47:46]  
┃ /home/catcher

┗━➤  sudo apt list 'sql*'

┏━[08:40:47]  
┃ /home/catcher

┗━➤  sudo apt-get install mysql-server

┏━[08:53:26]  
┃ /home/catcher

┗━➤  systemctl status mysql.service

┏━[09:09:45]  
┃ /home/catcher

┗━➤  sudo mysql -u root -p


## 4. Управление deb-пакетами

- Установить и затем удалить deb-пакет, используя команду `dpkg`.

**dpkg** — пакетный менеджер в Debian-подобных системах. Главное отличие от утилиты apt состоит в том, что dpkg работает только с локальными пакетами, он не умеет искать и устанавливать пакеты из репозиториев.

Просмотр списка пакетов:

┏━[09:14:24]  
┃ /home/catcher

┗━➤  dpkg -l

┏━[09:57:21]  
┃ /home/catcher

┗━➤  cd Загрузки

┏━[10:01:35]  
┃ /home/catcher/Загрузки

┗━➤  ll
итого 134M
-rw-rw-r-- 1 catcher catcher 104M июн 21 09:59 google-chrome-stable\_current\_amd64.deb

-rw-rw-r-- 1 catcher catcher  31M июн 19 18:42 signed.tar.gz

┏━[10:01:41]  
┃ /home/catcher/Загрузки

┗━➤  sudo dpkg -i google-chrome-stable\_current\_amd64.deb    


- Удаление пакета:

┏━[10:09:52]  
┃ /home/catcher

┗━➤  sudo dpkg --remove google-chrome-stable 


## Объектно-ориентированное программирование ## 

## 6. Диаграмма классов ##

- Создать диаграмму классов с родительским классом "Животные", и двумя подклассами: "Pets" и "Pack animals".


 ## 7. Работа с MySQL (Задача выполняется в случае успешного выполнения задачи “Работа с MySQL в Linux. “Установить MySQL на вашу машину”

- В ранее подключенном MySQL создать базу данных с названием "Human Friends".

mysql> **CREATE DATABASE IF NOT EXISTS HumanFriends;**

Query OK, 1 row affected (0,01 sec)

mysql> <a name="_hlk170321743"></a>**USE HumanFriends;**

Database changed

- Создать таблицы, соответствующие иерархии из вашей диаграммы классов.

- Заполнить таблицы данными о животных, их командах и датами рождения.

mysql> **CREATE TABLE animals**

-> (

-> Id INT AUTO_INCREMENT PRIMARY KEY,  

-> Animal_class VARCHAR(50)

-> );

Query OK, 0 rows affected (0,10 sec)

mysql> **INSERT INTO animals (Animal\_class)**

-> VALUES ('pets'),

-> ('pack animals');  

Query OK, 2 rows affected (0,03 sec)

Records: 2  Duplicates: 0  Warnings: 0

***

mysql> **CREATE TABLE pets**

-> (

-> Id INT AUTO_INCREMENT PRIMARY KEY,

->     Pet_class VARCHAR (50),

->     Animal_id INT,

->    FOREIGN KEY (Animal_id) REFERENCES animals (Id) ON DELETE CASCADE ON UPDATE CASCADE

-> );

Query OK, 0 rows affected (0,11 sec)

mysql> **INSERT INTO pets (Pet_class, Animal_id)**

->VALUES ('Dog', 1),

-> ('Cat', 1),  

-> ('Hamster', 1); 

Query OK, 3 rows affected (0,02 sec)

Records: 3  Duplicates: 0  Warnings: 0

***

mysql> **CREATE TABLE pack_animals**

-> (

-> Id INT AUTO\_INCREMENT PRIMARY KEY,

->     Pack_animal_class VARCHAR (50),

->    Animal_id INT,

->    FOREIGN KEY (Animal_id) REFERENCES animals (Id) ON DELETE CASCADE ON UPDATE CASCADE

-> );

Query OK, 0 rows affected (0,13 sec)

mysql> **INSERT INTO pack_animals (Pack_animal_class, Animal_id)**

-> VALUES ('Horse', 2),

-> ('Camel', 2),  

-> ('Donkey', 2); 

Query OK, 3 rows affected (0,05 sec)

Records: 3  Duplicates: 0  Warnings: 0

***


mysql> **CREATE TABLE dogs**

-> (       
->    Id INT AUTO_INCREMENT PRIMARY KEY, 
->    Name VARCHAR(50), 
->    Birthday DATE,
->    Commands VARCHAR(50),
->    Pet_id INT,
->    Foreign KEY (Pet_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
-> );

Query OK, 0 rows affected (0,11 sec)

mysql> **INSERT INTO dogs (Name, Birthday, Commands, Pet_id)**

-> VALUES ('Арчик', '2014-01-01', 'фас, лежать, сидеть, голос', 1),

-> ('Бублик', '2020-02-02', 'лежать, ко мне, дай лапу', 1),  

-> ('Шарик', '2022-03-03', 'сидеть, лежать, служить', 1);

Query OK, 3 rows affected (0,01 sec)

Records: 3  Duplicates: 0  Warnings: 0

***

mysql> **CREATE TABLE cats**

-> (       

->    Id INT AUTO_INCREMENT PRIMARY KEY, 

->    Name VARCHAR(50), 

->    Birthday DATE,

->    Commands VARCHAR(50),

->     Pet_id int,

->    Foreign KEY (Pet_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE

-> );

Query OK, 0 rows affected (0,16 sec)

mysql> **INSERT INTO cats (Name, Birthday, Commands, Pet\_id)**

-> VALUES ('Тося', '2014-01-01', <a name="_hlk170066388"></a>'ко мне,  дай лапу',  2),
-> ('Филимон', '2024-02-02', 'аппорт, брысь', 2),  
-> ('Пухляшек', '2020-03-03', 'кис-кис, брысь', 2); 

Query OK, 3 rows affected (0,03 sec)

Records: 3  Duplicates: 0  Warnings: 0

***

mysql> **CREATE TABLE hamsters**

-> (       
->    Id INT AUTO_INCREMENT PRIMARY KEY, 
->    Name VARCHAR(50), 
->    Birthday DATE,
->    Commands VARCHAR(50),

->    Pet_id int,

->    Foreign KEY (Pet_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE

-> );

Query OK, 0 rows affected (0,11 sec)

mysql> **INSERT INTO hamsters (Name, Birthday, Commands, Pet\_id)**

-> VALUES ('Лосяш', '2023-01-01', 'ко мне', 3),
-> ('Крыска', '2020-02-02', 'умри', 3),  
-> ('Квадратик', '2023-01-11', 'служи', 3);

Query OK, 3 rows affected (0,04 sec)

Records: 3  Duplicates: 0  Warnings: 0

***

mysql> **CREATE TABLE horses**

-> (       

->    Id INT AUTO_INCREMENT PRIMARY KEY, 
->    Name VARCHAR(50), 
->    Birthday DATE,
->    Commands VARCHAR(50),
->    Pack\_animal\_id int,
->    Foreign KEY (Pack_animal\_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
-> );

Query OK, 0 rows affected (0,13 sec)

mysql> **INSERT INTO horses (Name, Birthday, Commands, Pack\_animal\_id)**

-> VALUES ('Гнедой', '2019-01-01', 'рысь, шагом, но', 1),
-> ('Рыжик', '2023-02-02', 'но, пошел, стоять', 1),  
-> ('Ворон', '2024-03-03', 'шагом, тише, но', 1); 

Query OK, 3 rows affected (0,03 sec)

Records: 3  Duplicates: 0  Warnings: 0

***

mysql> **CREATE TABLE camels**

-> (       
->    Id INT AUTO_INCREMENT PRIMARY KEY, 
->    Name VARCHAR(50), 
->    Birthday DATE,
->    Commands VARCHAR(50),
->    Pack\_animal\_id int,
->    Foreign KEY (Pack_animal_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
-> );

Query OK, 0 rows affected (0,13 sec)

mysql> **INSERT INTO camels (Name, Birthday, Commands, Pack_animal_id)**

-> VALUES ('Плевок', '2023-01-01', 'сидеть, стоять, вперед', 2),
-> ('Горбатый', '2022-02-02', 'сидеть, стоять, ко мне', 2),  
-> ('Нюхнюх', '2014-03-03', 'сидеть, стоять, лежать', 2);

Query OK, 3 rows affected (0,03 sec)

Records: 3  Duplicates: 0  Warnings: 0

***

mysql> **CREATE TABLE donkeys**

-> (       

->    Id INT AUTO_INCREMENT PRIMARY KEY, 

->    Name VARCHAR(50), 

->    Birthday DATE,

->    Commands VARCHAR(50),

->    Pack_animal_id int,

->    Foreign KEY (Pack_animal_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE

-> );

Query OK, 0 rows affected (0,11 sec)

mysql> **INSERT INTO donkeys (Name, Birthday, Commands, Pack_animal_id)**

-> VALUES ('Вихрь', '2019-01-01', 'сидеть, стоять, лежать', 3),

-> ('Пушок', '2022-02-02', 'ко мне, стоять, вперед', 3),  

-> ('Бурый', '2023-03-03', 'шагом, голос, назад', 3);

Query OK, 3 rows affected (0,01 sec)

Records: 3  Duplicates: 0  Warnings: 0

***
- Удалить записи о верблюдах и объединить таблицы лошадей и ослов.

mysql> SET SQL_SAFE_UPDATES = 0;

Query OK, 0 rows affected (0,00 sec)

mysql> DELETE FROM camels;

Query OK, 3 rows affected (0,02 sec)

mysql> SET SQL_SAFE_UPDATES = 1;

Query OK, 0 rows affected (0,00 sec)

mysql> SELECT * FROM camels;

Empty set (0,00 sec)

mysql> SELECT Name, Birthday, Commands FROM horses

-> UNION ALL SELECT  Name, Birthday, Commands FROM donkeys;
***
- Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.

mysql> CREATE TEMPORARY TABLE allAnimals AS

->    SELECT *, 'dog' as class FROM dogs

->    UNION SELECT *, 'cat' AS class FROM cats

->    UNION SELECT *, 'hamster' AS class FROM hamsters

->    UNION SELECT *, 'horse' AS class FROM horses

->    UNION SELECT *, 'donkey' AS class FROM donkeys;

Query OK, 15 rows affected (0,00 sec)

Records: 15  Duplicates: 0  Warnings: 0


mysql> CREATE TABLE youngAnimals AS

-> SELECT Name, Birthday, Commands, class, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_in_month

-> FROM allAnimals WHERE Birthday BETWEEN ADDDATE(CURDATE(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(),INTERVAL -1 YEAR);

Query OK, 6 rows affected (0,09 sec)

Records: 6  Duplicates: 0  Warnings: 0

- Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.

-> SELECT h.Name, h.Birthday, h.Commands, pa.Pack_animal_class, ya.Age_in_month 

-> FROM horses h

-> LEFT JOIN youngAnimals ya ON ya.Name = h.Name

-> LEFT JOIN pack_animals pa ON pa.Id = h.Pack_animal_id

-> UNION 

-> SELECT d.Name, d.Birthday, d.Commands, pa.Pack_animal_class, ya.Age_in_month 

-> FROM donkeys d 

-> LEFT JOIN youngAnimals ya ON ya.Name = d.Name

-> LEFT JOIN pack_animals pa ON pa.Id = d.Pack_animal_id

-> UNION

-> SELECT c.Name, c.Birthday, c.Commands, p.Pet_class, ya.Age_in_month 

-> FROM cats c

-> LEFT JOIN youngAnimals ya ON ya.Name = c.Name

-> LEFT JOIN pets p ON p.Id = c.Pet_id

-> UNION

-> SELECT d.Name, d.Birthday, d.Commands, p.Pet_class, ya.Age_in_month 

-> FROM dogs d

-> LEFT JOIN youngAnimals ya ON ya.Name = d.Name

-> LEFT JOIN pets p ON p.Id = d.Pet_id

-> UNION

-> SELECT hm.Name, hm.Birthday, hm.Commands, p.Pet_class, ya.Age_in_month 

-> FROM hamsters hm

-> LEFT JOIN youngAnimals ya ON ya.Name = hm.Name

-> LEFT JOIN pets p ON p.Id = hm.Pet_id;
***
# 8. ООП и Java

- Создать иерархию классов в Java, который будет повторять диаграмму классов созданную в задаче 6 (Диаграмма классов) .

# 9. Программа-реестр домашних животных

- Написать программу на Java, которая будет имитировать реестр домашних животных. 

Должен быть реализован следующий функционал:

   ## 9.1. Добавление нового животного

Реализовать функциональность для добавления новых животных в реестр.       
Животное должно определяться в правильный класс (например, "собака", "кошка", "хомяк" и т.д.)

##  9.2. Список команд животного

Вывести список команд, которые может выполнять добавленное животное (например, "сидеть", "лежать").

##  9.3. Обучение новым командам

Добавить возможность обучать животных новым командам.

##   9.4 Вывести список животных по дате рождения

##   9.5. Навигация по меню

Реализовать консольный пользовательский интерфейс с меню для навигации между вышеуказанными функциями.

# 10. Счетчик животных

Создать механизм, который позволяет вывести на экран общее количество созданных животных любого типа (Как домашних, так и вьючных), то есть при создании каждого нового животного счетчик увеличивается на “1”. 
