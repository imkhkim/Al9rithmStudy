-- 코드를 입력하세요
SELECT warehouse_id, warehouse_name, address, ifnull(FREEZER_YN, 'N')
from food_warehouse
where substr(address, 1, 3) = '경기도'
order by warehouse_id