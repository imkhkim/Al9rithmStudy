select r.food_type, r.rest_id, r.rest_name, r2.max_favorites
from rest_info r join (select food_type, max(favorites) max_favorites
                       from rest_info
                       group by food_type
) as r2 on r.food_type = r2.food_type and r.favorites = r2.max_favorites
order by r.food_type desc;