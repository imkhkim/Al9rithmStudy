select animal_id, name
from animal_outs
where animal_id not in (
    select distinct ai.animal_id
    from animal_ins ai
)