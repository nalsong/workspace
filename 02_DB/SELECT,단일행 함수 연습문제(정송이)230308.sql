/*1. EMPLOYEE 테이블에서 사원명, 입사일-오늘, 오늘-입사일 조회
단, 입사일-오늘의 별칭은 "근무일수1", 
오늘-입사일의 별칭은 "근무일수2"로 하고
모두 정수(내림)처리, 양수가 되도록 처리
*/
SELECT EMP_NAME, 
		FLOOR(ABS(HIRE_DATE-SYSDATE)) 근무일수1, 
		FLOOR(ABS(SYSDATE-HIRE_DATE)) 근무일수2		
FROM EMPLOYEE;


/*정답*/
SELECT EMP_NAME "사원명", 
		FLOOR(ABS(HIRE_DATE-SYSDATE)) "근무일수1", 
		FLOOR(ABS(SYSDATE-HIRE_DATE)) "근무일수2"		
FROM EMPLOYEE;




/*2. EMPLOYEE 테이블에서 사번이 홀수인 사원의
사번, 이름, 이메일, 전화번호 조회*/
SELECT EMP_ID, EMP_NAME, EMAIL, PHONE 
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2) = 1; 


/*정답*/
SELECT EMP_ID, EMP_NAME, EMAIL, PHONE 
FROM EMPLOYEE
WHERE SUBSTR(EMP_ID, -1, 1) IN(1,3,5,7,9); --이런 방법도 있다!




/*3. EMPLOYEE 테이블에서 근무한지 20년 이상인 사원의 모든 정보 조회
*/
SELECT *
FROM EMPLOYEE
WHERE CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)/12)>=20; 

/*정답*/
SELECT *
FROM EMPLOYEE
WHERE MONTHS_BETWEEN(SYSDATE, HIRE_DATE)/12>=20; --이런 방법도 있다!

SELECT *
FROM EMPLOYEE
WHERE EXTRACT (YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)>=20; --이런 방법도 있다!




/*4. EMPLOYEE 테이블에서 사원명과 주민번호를 조회
단, 주민번호 9번째 자리부터 끝까지는 '*'문자로 채움
예 : 홍길동 771120-1*******/

SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO,1,8),14,'*') 
FROM EMPLOYEE;


/*정답*/
--이런 방법도 있다!
SELECT EMP_NAME, REPLACE (EMP_NO , SUBSTR(EMP_NO,9),'******') 주민등록번호 
FROM EMPLOYEE;

--이런 방법도 있다!
SELECT EMP_NAME, SUBSTR(EMP_NO,1,8) || '******' 주민등록번호 
FROM EMPLOYEE;

--이런 방법도 있다!
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO,1,8),14,'*') 주민등록번호
FROM EMPLOYEE;



/*  5. EMPLOYEE 테이블에서 사원명, 직급코드, 연봉(원) 조회
단, 연봉은 보너스가 적용된 1년치 급여 + ￦57,000,000 으로 표시
(급여 + (급여 * 보너스) )* 12  */

SELECT EMP_NAME, JOB_CODE,
	TO_CHAR( (SALARY+ (SALARY*NVL(BONUS, 0)))*12, 'L999,999,999') AS "연봉(원)"
FROM EMPLOYEE;

/*정답*/
--위와 같음



/*6. EMPLOYEE 테이블에서
부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 사원의
사번 사원명 부서코드 입사일 조회*/
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE 
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D5' OR DEPT_CODE = 'D9')
AND EXTRACT(YEAR FROM HIRE_DATE) = 2004;

/*정답*/
--이런 방법도 있다!
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE 
FROM EMPLOYEE
WHERE DEPT_CODE IN('D5','D9')
AND EXTRACT(YEAR FROM HIRE_DATE) = 2004;  


--이런 방법도 있다!
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE 
FROM EMPLOYEE
WHERE DEPT_CODE IN('D5','D9')
AND TO_CHAR(HIRE_DATE, 'YYYY')='2004'; 



/*7. EMPLOYEE 테이블에서 사원명, 입사일, 입사한 달의 근무일수 조회
단, 입사한 날도 근무일수에 포함해서 +1 할 것
*/

SELECT EMP_NAME, HIRE_DATE, 
	EXTRACT(DAY FROM(LAST_DAY(HIRE_DATE)))-EXTRACT(DAY FROM HIRE_DATE)+1 "입사한 달의 근무 일수"
FROM EMPLOYEE;

/*정답*/
--이런 방법도 있다!
SELECT EMP_NAME, HIRE_DATE, 
	LAST_DAY(HIRE_DATE) - HIRE_DATE +1 "입사한 달의 근무 일수"
FROM EMPLOYEE;





/*8. EMPLOYEE 테이블에서 사원명, 부서코드, 생년월일, 만 나이 조회
단, 생년월일은 주민번호에서 추출해서 ㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산.*/
SELECT EMP_NAME, DEPT_CODE, 
--	TO_CHAR( TO_DATE(SUBSTR(EMP_NO, 1, INSTR(EMP_NO, '-')-1)),'YY"년" MM"월" DD"일"') "생년월일"
	TO_CHAR( TO_DATE(SUBSTR(EMP_NO, 1, 6)) , 'YY"년" MM"월" DD"일"') "생년월일",
--	(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1,INSTR(EMP_NO, '-')-1)))) "만 나이" <-틀린 것
--	TRUNC((SYSDATE - TO_DATE(SUBSTR(EMP_NO, 1,INSTR(EMP_NO, '-')-1)))/365)"만 나이" <- 오차가 생기므로 정확한 방식은 아님.
--	FLOOR(MONTHS_BETWEEN(SYSDATE,TO_DATE(SUBSTR(EMP_NO, 1,INSTR(EMP_NO, '-')-1)))/12) "만 나이"
	FLOOR((TO_CHAR(SYSDATE,'YYYYMMDD')-TO_CHAR(TO_DATE(SUBSTR(EMP_NO, 1,6)), 'YYYYMMDD'))/10000) "만나이"
FROM EMPLOYEE;





/*정답*/

-- 생년월일 구하는 방법 이런 방법도 있다!!
SELECT 
	TO_CHAR( TO_DATE(SUBSTR(EMP_NO, 1, 6)) , 'YY"년" MM"월" DD"일"') "생년월일"
FROM EMPLOYEE;


SELECT 
	SUBSTR(EMP_NO, 1, 2) || '년 ' ||
	SUBSTR(EMP_NO, 3, 2) || '월 ' ||
	SUBSTR(EMP_NO, 5, 2) || '일'	생년월일	
FROM EMPLOYEE;


-- 만나이 구하는 법 
SELECT 
	FLOOR(MONTHS_BETWEEN(SYSDATE,TO_DATE(SUBSTR(EMP_NO, 1, 6)))/12) "만 나이"
FROM EMPLOYEE;











