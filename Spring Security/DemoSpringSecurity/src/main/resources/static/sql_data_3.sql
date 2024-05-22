create database employee_directory;

use spring_boot;-- 



CREATE TABLE emp (
  emp_name VARCHAR(50),
  emp_salary DECIMAL(10,2)
);

SELECT * FROM (
  SELECT emp_name, emp_salary, DENSE_RANK() OVER (ORDER BY emp_salary DESC) AS r
  FROM emp
) AS subquery
WHERE r = 2;

select * from emp ORDER BY emp_salary 
DESC limit 4,1;
select * from emp;

-- select top 3 * from emp where emp_salary in (
-- elect distinct emp_salary from emp order by emp_salary desc); 



SELECT MIN(sal) FROM emp WHERE emp_salary IN (
  SELECT DISTINCT emp_salary
  FROM emp
  ORDER BY emp_salary DESC
  LIMIT 4
);


INSERT INTO emp (emp_name, emp_salary) VALUES
('Shubham Thakur', 50000.00),
('Aman Chopra', 60000.50),
('Naveen Tulasi', 75000.75),
('Bhavika uppala', 45000.25),
('Nishant jain', 80000.00);