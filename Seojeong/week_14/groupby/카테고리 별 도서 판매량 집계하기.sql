-- 코드를 입력하세요
SELECT category, sum(sales)
from book_sales bs join book b
                        on bs.book_id = b.book_id
where year(sales_Date) = 2022 and month(sales_Date) = 1
group by b.category
order by b.category