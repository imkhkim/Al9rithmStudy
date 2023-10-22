select writer_id, nickname, total_sales
from  (
          select writer_id, sum(price) total_sales
          from USED_GOODS_BOARD
          where status = 'DONE'
          group by writer_id
          having sum(price) >= 700000
      ) as b join USED_GOODS_USER u on b.writer_id = u.user_id

order by total_sales