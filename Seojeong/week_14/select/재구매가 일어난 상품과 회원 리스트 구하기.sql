-- 코드를 입력하세요


select distinct s1.user_id, s1.product_id
from online_sale s1 join online_sale s2
                         on s1.online_sale_id != s2.online_sale_id
and s1.user_id = s2.user_id
and s1.product_id = s2.product_id
order by s1.user_id, s1.product_id desc ;