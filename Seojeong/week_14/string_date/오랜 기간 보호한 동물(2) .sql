-- 코드를 입력하세요
SELECT ins.animal_id, ins.name
from animal_outs outs join animal_ins ins
                           on outs.animal_id = ins.animal_id
order by datediff(outs.datetime, ins.datetime) desc
    limit 2