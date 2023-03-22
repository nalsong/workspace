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
WHERE EMP_NO = ?;






