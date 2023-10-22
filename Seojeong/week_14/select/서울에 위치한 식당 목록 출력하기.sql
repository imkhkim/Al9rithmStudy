-- 코드를 입력하세요
SELECT info.rest_id,
       info.rest_name,
       info.food_type,
       info.favorites,
       info.address,
       round(avg(review_score), 2) score
from rest_info info
         join rest_review review
              on info.rest_id = review.rest_id
where substr(info.address, 1, 2) = '서울'
group by rest_name
order by score desc, favorites desc;