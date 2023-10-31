-- 코드를 입력하세요
SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
FROM (SELECT * FROM ANIMAL_INS WHERE SEX_UPON_INTAKE LIKE 'Intact%') A, ANIMAL_OUTS B
WHERE A.ANIMAL_ID = B.ANIMAL_ID AND B.SEX_UPON_OUTCOME NOT LIKE 'Intact%'
ORDER BY A.ANIMAL_ID
;
