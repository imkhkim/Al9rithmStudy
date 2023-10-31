select distinct car_id
from CAR_RENTAL_COMPANY_CAR r join CAR_RENTAL_COMPANY_RENTAL_HISTORY h using(car_id)
where month(start_date) = 10 and car_type = '세단'
order by car_id desc;