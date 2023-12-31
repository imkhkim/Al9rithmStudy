-- 23.10.22.
SELECT HISTORY_ID, ROUND(DAILY_FEE * (100 - 
                CASE
                    WHEN (DATEDIFF(END_DATE, START_DATE) + 1) >= 90
                    THEN (SELECT DISCOUNT_RATE FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE CAR_TYPE = '트럭' AND DURATION_TYPE = '90일 이상')
                
                    WHEN (DATEDIFF(END_DATE, START_DATE) + 1) >= 30
                    THEN (SELECT DISCOUNT_RATE FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE CAR_TYPE = '트럭' AND DURATION_TYPE = '30일 이상')
                    
                    WHEN (DATEDIFF(END_DATE, START_DATE) + 1) >= 7
                    THEN (SELECT DISCOUNT_RATE FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE CAR_TYPE = '트럭' AND DURATION_TYPE = '7일 이상')
                             
                    ELSE 0
                END
                ) * 0.01 * (DATEDIFF(END_DATE, START_DATE) + 1), 0) AS FEE
FROM CAR_RENTAL_COMPANY_CAR JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY USING(CAR_ID)
WHERE CAR_TYPE = '트럭'
ORDER BY FEE DESC, HISTORY_ID DESC;
