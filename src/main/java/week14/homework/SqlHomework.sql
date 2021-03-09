-- 1. Să se selecteze deptno, enume, job și sal pentru angajatii care au sef-ul cu id-ul 7902.
use hr;

SELECT department_id, name, salary FROM employee WHERE mgr=7902;

-- 4. Să se selecteze numele, funcția și venitul lunar pentru toți angajații care au venitul lunar mai mare de 2000. Venitul lunar este o funcție care are formula salariu + ifnull(comision, 0)

SELECT name, job, salary FROM employee WHERE salary > 2000;

-- 5.Să se selecteze id-ul angajatului, numele, funcția și data angajării pentru toți angajații care au aceași funcție și au venit în firmă după o anumită dată.
SELECT id, name, job, hiredate FROM employee WHERE (YEAR(hiredate) > 1981);

-- 6. Să se adauge 10 noi angajati.

INSERT INTO employee VALUES
(9001, 'CEHAN', 'MANAGER', 7902, '2015-07-01', 6600, 2568, 20),
(9002, 'LAJOS', 'SALESMAN', 7782, '2015-03-01', 2600, 568, 20),
(9003, 'STEFAN', 'SALESMAN', 7782, '2006-06-21', 2000, 258, 20),
(9004, 'BOGDAN', 'CLERK', 7902, '2020-07-06', 1600, 256, 30),
(9005, 'ELENA', 'ANALYST', 7698, '2018-02-01', 4600, 568, 30),
(9006, 'ANDREEA', 'CLERK', 7698, '2013-07-01', 5600, null, 40),
(9007, 'NICK', 'SALERSMAN', 7566, '2012-08-01', 900, 1000, 40),
(9008, 'ROLAND', 'MANAGER', 7788, '2010-07-21', 1600, 835, 10),
(9009, 'DRAGOS', 'CLERK', 7782, '2005-11-07', 3200, NULL, 10),
(9010, 'RALUCA', 'ANALYST', 7782, '2002-07-18', 3000, 256, 10);

-- 7. Să se calculeze o primă de 15% pentur toți angajații din departamentul 20.
SELECT id,
       name,
       job,
       salary,
       (salary * 0.15) AS prima
FROM employee WHERE department_id = 20;


-- 8. Să se selecteze id-ul și numele departamentului din tabela departamente.
SELECT id, name FROM department;

-- 9. Să se selecteze id-ul, numele, funcția și data angajării pentru toți angajații din firmă. Ordonați descrescător în funcție de id. Concatenați id-ul cu numele.
SELECT CONCAT(id, ' ', name) AS IdAndName, job, hiredate FROM employee ORDER BY id DESC ;

-- 10. Să se selecteze id-ul, numele, fucția și venitul lunar pentru toți angajatii din firmă. Să se adauge la select o coloană goală care să se numească semnătura. Concatenați id-ul cu numele. Ordonați după departament.
SELECT CONCAT(id,' ', name) AS IdAndName,  job, salary, ('         ') AS signature FROM employee ORDER BY department_id;

-- 11. Să se selecteze numele și funcția angajaților.

SELECT name, job FROM employee;

-- 12. Să se facă o listă cu numele departamentului și codul acestuia. Ordonați după numele departamentului.
SELECT name, id FROM department ORDER BY name;

-- 13. Să se selecteze toți angajații care au funcția manager. Ordonați după id-ul departamentului
SELECT name FROM employee WHERE job = 'manager' ORDER BY department_id;

-- 14. Selectați toate persoanele care s-au angajat intr-o anumită perioadă aleasa de voi.
SELECT * FROM employee WHERE (YEAR(hiredate) IN (1980, 1981));

-- 15. Să se listeze id-ul, numele, funcția, venitul lunar pentru angajații care au următoarele id-uri: 7499,7902, 7876
SELECT id, name, job, salary FROM employee WHERE id IN (7499, 7902, 7876);

-- 16. Să se selecteze toate persoanele care au fost angajate în anul 1980
SELECT * FROM employee WHERE (YEAR(hiredate) = 1980);

-- 17. Să se selecteze toate persoanele al căror nume începe cu litera F și numele funcției are 7 caractere.
SELECT * FROM employee WHERE ((name LIKE 'F%') AND (LENGTH(job) = 7));

-- 18. Să se listeze angajații din departamentul 20 care nu au primit comision.
SELECT name FROM employee WHERE ((department_id = 20) AND (comm IS NULL));

-- 19. Să se listeze angajații care au primit comision și au funcția SALESMAN

SELECT name FROM employee WHERE ((comm IS NOT NULL ) AND (job = 'salesman'));

-- 20. Să se selecteze toți angajații care au funcția MANAGER și salariul peste 1500 și toți angajații care au funcția ANALYST.
SELECT * FROM employee WHERE ((job = 'manager' AND salary > 1500) OR job = 'analyst');

-- 21. Selectați toți angajații care s-au angajat înainte de anul 1982 și nu au primit comision.
SELECT * FROM employee WHERE ((YEAR(hiredate) < 1982) AND (comm IS NULL));

-- 22. Selectați toți angajații care au salariul peste 3000 și nu au șefi, ordonați după departament.
SELECT * FROM employee WHERE ((salary > 3000) AND (mgr IS NULL));

-- 23. Selectați numele, funcția și venitul anual al angajaților care nu au funcția MANAGER pentru un departament ales de voi.
SELECT name, job, salary FROM employee WHERE ((job = 'manager') AND (department_id = 10));

-- 24. Selectați departamentul, numele, data angajării și salariul tuturor persoanelor angajate în anul 1981 din două departamente alese de voi.
SELECT department.name, employee.name, employee.hiredate, employee.salary FROM department, employee WHERE ((YEAR(hiredate) = 1981) AND department_id IN (10, 20));



select * from employee;