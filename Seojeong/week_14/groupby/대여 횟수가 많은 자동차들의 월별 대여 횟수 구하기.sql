-- 코드를 입력하세요
select month(start_Date) as month, car_id, count(*) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in (select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where year(start_Date) = 2022
  and month(start_date) between 8 and 10
    group by car_id
    having count(car_id) >= 5)
  and year(start_Date) = 2022
  and month(start_date) between 8 and 10
group by month, car_id
order by month, car_id desc;