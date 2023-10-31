select animal_id, ai.name
from animal_ins ai join animal_outs ao using(animal_id)
where ao.datetime < ai.datetime
order by ai.datetime;