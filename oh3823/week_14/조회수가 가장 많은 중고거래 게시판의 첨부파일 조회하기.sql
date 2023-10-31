select concat('/home/grep/src/', board_id, '/',  file_id, file_name, file_ext) as file_path
from USED_GOODS_BOARD b join USED_GOODS_FILE f using(board_id)
where views = (
    select max(views)
    from USED_GOODS_BOARD
)
order by file_id desc;