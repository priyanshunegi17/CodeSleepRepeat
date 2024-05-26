/* Write your T-SQL query statement below */
select e2.unique_id,e1.name
from EmployeeUNI e2
right join employees e1
on e1.id = e2.id;
