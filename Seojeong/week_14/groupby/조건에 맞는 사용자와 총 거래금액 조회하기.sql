-- 코드를 입력하세요
select user_id, nickname, total_sales
from used_goods_user users
         join (SELECT writer_id, sum(price) as total_sales
               from used_goods_board
               where status = 'done'
               group by writer_id) as res
              on users.user_id = res.writer_id
where total_sales >= 700000
order by total_sales