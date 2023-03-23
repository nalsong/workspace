--현재 재직중인 사원의
--사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일
--직급코드 오름차순으로 조회

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, PHONE, EMAIL 
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE ENT_YN = 'N'
ORDER BY DEPT_CODE;





--현재 퇴직한 사원의
--사번, 이름, 전화번호, 이메일, 퇴사일을
--퇴사일 오름차순으로 조회
SELECT EMP_ID, EMP_NAME, PHONE, EMAIL, HIRE_DATE
FROM EMPLOYEE
WHERE ENT_YN = 'Y'
ORDER BY HIRE_DATE;



--사번을 입력 받아 일치하는 사원의  
--사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일, 입사일, 퇴직여부 조회
--단, 사번이 일치하는 사원이 없으면
--"사번이 일치하는 사원이 없습니다" 출력

SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY, PHONE, EMAIL, ENT_YN
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE EMP_ID = '200';


-- 사원 정보 추가
--사번(EMP_ID) -> SEQ_EMP_ID SEQUENCE 사용




--이메일, 전화번호, 급여, 보너스 수정
--단, 사번이 일치하는 사원이 없으면
--"사번이 일치하는 사원이 없습니다" 출력
UPDATE EMPLOYEE 
SET EMAIL = ?,
	PHONE = ?,
	SALARY = ?,
	BONUS = ?
WHERE EMP_ID = ?;







-- 사번을 입력 받아 일치하는 사원 삭제
-- 사번을 입력 받은 후 정말 삭제할 것인지 Y/N을 입력 받아 
-- Y인 경우에만 삭제, N인 경우 취소
-- 사번이 일치하는 사원이 없으면
--  "사번이 일치하는 사원이 없습니다" 출력
				
DELETE FROM EMPLOYEE
WHERE EMP_ID = ? ;










-- ENT_YN -> 'Y' , ENT_DATE -> SYSDATE로 수정
				
-- 사번을 입력 받은 후 정말 퇴직 처리할 것인지 Y/N을 입력 받아 
-- Y인 경우에만 퇴직 처리, N인 경우 취소
				
-- 사번이 일치하지 않거나 이미 퇴직 처리된 사원이면
-- "사번이 일치하는 않거나, 이미 퇴직된 사원입니다." 출력

-----------------------------------------------


-- 입력 받은 사번의 사원이 존재하지 않으면  0
-- 사원은 있는데 퇴직처리된 사원이면 1
-- 사원도 있고, 재직중인 사원이면 2 조회


--선택함수 DECODE/CASE
SELECT CASE 
		-- 존재하지 않는 사원?
		WHEN (SELECT COUNT(*) DROM EMPLOYEE WHERE EMP_ID = 222) = 0
		THEN 0
		
		-- 존재하지만 퇴직한 사원?
		WHEN (SELECT COUNT(*) DROM EMPLOYEE 
				WHERE EMP_ID = 222 AND ENT_YN = 'Y') = 1
		THEN 1
		
		-- 존재는 하지만 퇴직하지 않은 사원!
		ELSE 2
	END "CHECK"
FROM DUAL;




--8.
--가장 최근(입사일이 늦은) 사원 5명의
--사번, 이름, 부서명, 입사일을
--입사일 내림차순으로 조회

-- ROWNUM, 인라인뷰(FROM절 서브쿼리)

SELECT * FROM 
	(SELECT EMP_ID , EMP_NAME, HIRE_DATE
			, NVL(DEPT_TITLE, '부서없음') DEPT_TITLE
	FROM EMPLOYEE
	LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
	ORDER BY HIRE_DATE DESC)
WHERE ROWNUM <= 5;




--각 부서별
--부서명, 인원 수, 급여 평균
--부서코드 오름차순 조회


SELECT DEPT_CODE, NVL(DEPT_TITLE,'부서없음') DEPT_TITLE, COUNT(*) 인원, FLOOR(AVG(SALARY)) 평균
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY DEPT_CODE, DEPT_TITLE
ORDER BY DEPT_CODE;






















