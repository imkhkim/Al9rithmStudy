-- 23.10.22.
SELECT DISTINCT CAR_ID
FROM CAR_RENTAL_COMPANY_CAR JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY USING (CAR_ID)
WHERE CAR_TYPE = '세단'
AND START_DATE LIKE '2022-10%'
ORDER BY CAR_ID DESC;
