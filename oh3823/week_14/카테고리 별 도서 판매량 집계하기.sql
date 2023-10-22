select category, sum(sales) as total_sales
from BOOK b natural join BOOK_SALES
where sales_date like '2022-01%'
group by category
order by category