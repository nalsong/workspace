SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE FROM EMPLOYEE;


-- 부서명이 총무부인 부서에 존재하는 사원의 
-- 사번, 이름, 급여, 부서명을 사번 오름차순으로 조회 

SELECT EMP_ID, EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE = '총무부'
ORDER BY EMP_ID;

SELECT * FROM(
	SELECT EMP_ID, EMP_NAME, SALARY, NVL(DEPT_TITLE, 'null') DEPT_TITLE
	FROM EMPLOYEE
	LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
	ORDER BY EMP_ID
	)
WHERE DEPT_TITLE IS NULL;



-- 직급명을 입력 받아 일치하는 사원의
-- 부서명, 직급명, 이름, 이메일을  이름 오름 차순으로 조회


SELECT EMP_NAME, EMAIL, DEPT_TITLE, JOB_NAME 
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리';



SELECT NVL(DEPT_TITLE, '부서없음'), JOB_NAME, EMP_NAME, EMAIL 
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리'
ORDER BY EMP_NAME;














































































