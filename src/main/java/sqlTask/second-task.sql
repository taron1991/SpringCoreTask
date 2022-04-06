Есть таблица pupils и её скрипт

create table pupils(
    id serial primary key,
    full_name text,
    university text,
    salary_by_university int
);

insert into pupils(id, full_name, university, salary_by_university) values (1, 'Александров Б.А', 'РУДН', 2500);
insert into pupils(id, full_name, university, salary_by_university) values (2, 'Бортанков М.С', 'МИРЭА', 2700);
insert into pupils(id, full_name, university, salary_by_university) values (3, 'Аркинян Т.С', 'МИРЭА', 2400);
insert into pupils(id, full_name, university, salary_by_university) values (4, 'Александров Б.А', 'МГТУ им.Баумана', 5500);
insert into pupils(id, full_name, university, salary_by_university) values (5, 'Булинко В.К', 'МИРЭА', 2300);
insert into pupils(id, full_name, university, salary_by_university) values (6, 'Арсентьев Н.А', 'МГТУ им.Баумана', 5230);
insert into pupils(id, full_name, university, salary_by_university) values (7, 'Волоков А.М', 'МГТУ Станкин', 4400);
insert into pupils(id, full_name, university, salary_by_university) values (8, 'Секров В.К', 'МИРЭА', 2100);
insert into pupils(id, full_name, university, salary_by_university) values (9, 'Волков Д.А', 'МГТУ Станкин', 4850);

Найти среднее значение стипендии для каждого ВУЗа превышающее 4000.
Вывести вуз и среднее значение стипендии в отсортированном виде (в порядке возрастания, по стипендии)
======================================================================================================