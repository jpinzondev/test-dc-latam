DROP TABLE IF EXISTS employees;
CREATE TABLE employees(
  id              INTEGER  NOT NULL PRIMARY KEY,
  employee_name   VARCHAR(19) NOT NULL,
  employee_salary INTEGER  NOT NULL,
  employee_age    INTEGER  NOT NULL,
  profile_image   VARCHAR(30)
);