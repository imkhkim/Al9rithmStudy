SELECT CAR_ID,
    IF(
        SUM(
            IF(START_DATE <= DATE('2022-10-16') 
              AND END_DATE >= DATE('2022-10-16'),1,0)
        ) 
        >= 1,
       "대여중","대여 가능") AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC
