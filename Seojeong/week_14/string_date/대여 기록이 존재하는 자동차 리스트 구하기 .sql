-- 코드를 입력하세요
SELECT distinct c.car_id
from car_rental_company_rental_history h join car_rental_company_car c
                                              on h.car_id = c.car_id
where month(h.start_date) = 10 and
    c.car_type = '세단'
order by c.car_id desc