select car_id, if(car_id in (
    select distinct car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where '2022-10-16' between start_date and end_date
), '대여중', '대여 가능') as `availability`
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by car_id desc;