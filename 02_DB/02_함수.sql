-- 함수 : 컬럼의 값을 읽어서 연산 결과를 반환

-- 단일행 함수 :  N개의 행의 값을 전달하여 N개의 결과를 반환

-- 그룹 함수 : N개의 행의 값을 하나의 그룹으로 묶어 그룹 수 만큼의 결과를 반환 

-- 함수는 SELECT절, WHERE절, ORDER BY절, HAVING절 사용 가능


/*********************** 단일행 함수 ***************************/

--<문자열 관련 함수>

-- LENGTH(문자열 | 컬럼명) : 문자열 길이 반환
SELECT 'HELLO WORLD', LENGTH ('HELLO WORLD') FROM DUAL;
													--> DUAL: 가짜 테이블
-- EMPLOYEE테이블에서 이메일이 12글자인 사원의 이름, 이메일 조회
SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE LENGTH(EMAIL) = 12;


-- EMPLOYEE테이블에서 이메일 길이 오름차순으로 조회
SELECT EMP_NAME , EMAIL 
FROM EMPLOYEE
ORDER BY LENGTH(EMAIL) ASC; 

----------------------------------------------------

-- INSTR(문자열 | 컬럼명, '찾을 문자열' [, 찾을 시작 위치 [, 순번]])
-- 찾을 시작 위치부터 지정된 순번째에 찾을 문자열의 시작 위치 반환

-- 문자열에서 맨 앞에 있는 B의 위치를 조회
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA', 'B') FROM DUAL; --3


-- 문자열을 5번째 부터 검색하여 처음 찾는 B의 위치 조회
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA', 'B', 5) FROM DUAL; --9 
						--	  123456789


-- 문자열을 5번째 부터 검색하여 두번째로 찾는 B의 위치 조회
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA', 'B', 5, 2) FROM DUAL; --10 
						--	  1234567890


--EMPLOYEE테이블에서 사원명, 이메일, 이메일 중 '@' 위치 조회
SELECT EMP_NAME, EMAIL, INSTR(EMAIL, '@')
FROM EMPLOYEE;

-------------------------------------------------------

--SUBSTR(문자열 | 컬럼명, 시작위치 [, 길이])
-- 문자열을 시작 위치부터 지정된 길이 만큼 잘라내서 반환
-- 길이 미작성 시 시작 위치부터 끝까지 잘라내서 반환

SELECT SUBSTR('ABCDEF', 3, 3) FROM DUAL; --CDE

SELECT SUBSTR('ABCDEF', 3) FROM DUAL; --CDEF




-- EMPLOYEE테이블에서 사원명과 사원의 이메일 아이디만 조회
-- 아이디 오름차순 정렬

-- 1. 컬럼명 사용
SELECT EMP_NAME, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) 아이디
FROM EMPLOYEE
ORDER BY SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1);


-- 2. 별칭 사용
SELECT EMP_NAME, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) 아이디
FROM EMPLOYEE
ORDER BY 아이디;


--------------------------------------------------------------------

-- TRIM( [[옵션] 문자열 | 컬럼명 FROM] 문자열 | 컬럼명)
-- 주어진 문자열의 앞쪽|뒤쪽|양쪽에 존재하는 지정된 문자를 제거

-- 옵션 : LEADING(앞쪽), TRAILING(뒤쪽), BOTH(양쪽, 기본값)

-- 예제1
SELECT '     K H     ', 
TRIM(LEADING ' ' FROM '     K H     '),
TRIM(TRAILING ' ' FROM '     K H     '),
TRIM(BOTH ' ' FROM '     K H     ')
FROM DUAL;


--예제2
SELECT '#####K H#####', 
TRIM(LEADING '#' FROM '#####K H#####'),
TRIM(TRAILING '#' FROM '#####K H#####'),
TRIM(BOTH '#' FROM '#####K H#####')
FROM DUAL;


--예제3
--문자열 앞 뒤 공백을 제거(해당용도로 많이 사용됨)
SELECT TRIM('     K H     ') FROM DUAL; -- 'K H'


--------------------------------------------------------

-- REPLACE(문자열 | 컬럼명, 찾을 문자열, 바꿀 문자열)
-- 찾을 문자열을 바꿀 문자열로 변경하여 문자열을 반환
SELECT REPLACE(NATIONAL_NAME, '한국', '대한민국')  
FROM NATIONAL;






---------------------------------------------------------
---------------------------------------------------------

-- <숫자 관련 함수>

-- MOD(숫자 | 컬럼명, 숫자 | 컬럼명) : 나머지 값 반환 
SELECT EMP_NAME, MOD(SALARY, 1000000) 
FROM EMPLOYEE;

-- ABS(숫자 | 컬럼명) : 절대값
SELECT ABS(10), ABS(-10) FROM DUAL;

-- CEIL(숫자 | 컬럼명) : 올림
-- FLOOR(숫자 | 컬럼명) : 내림
--> 둘 다 소수검 첫째 자리에서 처리 -> 정수 결과 반환

SELECT 123.5, CEIL(123.5), FLOOR(123.5) FROM DUAL;



-----------------------------------------------------

-- ROUND(숫자 | 컬럼명 [,소수점 위치]) : 반올림
-- 소수점 위치 지정 x : 첫째 자리에서 반올림 -> 정수 반환
-- 소수점 위치 지정 o : 
--  1) 양수 : 지정된 위치의 소수점까지 표현
--  2) 음수 : 지정된 위치의 정수 자리수까지 표현

SELECT 123.456,
	ROUND(123.456), -- 소수점 첫째자리에서 반올림
	ROUND(123.456, 1), -- 소수점 첫째자리까지 표현
	ROUND(123.456, 2), -- 소수점 둘째자리까지 표현
	ROUND(123.456, 0), -- 소수점 0번째자리까지 표현 -> 정수
	ROUND(123.456, -1), -- 소수점 -1번째자리까지 표현 -> 정수 1의 자리에서 반올림
	ROUND(123.456, -2) -- 소수점 -2번째자리까지 표현 -> 정수 10의 자리에서 반올림
FROM DUAL;

-------------------------------------------------------------------

-- TRUNC(숫자 | 컬럼명 [, 소수점 위치]) : 잘라내기, 버림, 절삭


SELECT TRUNC(123.456),
	TRUNC(123.456, 1),
	TRUNC(123.456, -1)
FROM DUAL;



SELECT EMP_NAME, TRUNC(SALARY, -6) || '원 이상' 급여
FROM EMPLOYEE;



 -- FLOOR와 TRUNC차이점
SELECT FLOOR(-123.5), TRUNC(-123.5)
FROM DUAL;




-----------------------------------------------------------
-----------------------------------------------------------

--<날짜 관련 함수>

-- SYSDATE : 시스템에 현재 시간(년, 월, 일, 시 , 분, 초) 반환
--SYSTIMESTAMP : SYSDATE 반환값 + MS 단위 추가
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL; 
-- SYSDATE: 2023-03-07 12:22:46.000 
-- SYSTIMESTAMP : 2023-03-07 12:22:46.894 +0900


--------------------------------------------------------------

-- MONTHS_BETWEEN(날짜, 날짜) : 두 날짜의 개월 수 차이를 반환
SELECT '약' || ROUND(MONTHS_BETWEEN('2023/07/14', '2023/02/06')) || '개월' 훈련기간
FROM DUAL;


-- EMPLOYEE 테이블에서 사원의 이름, 입사일, 근무 N년차, 근속 개월 수
SELECT EMP_NAME, HIRE_DATE
	, CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)/12) "근속 N년차"
	, FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) "근속 개월 수"
FROM EMPLOYEE;


--------------------------------------------------------------------

-- ADD_MONTHS(날짜, 숫자) : 날짜에 숫자만큼의 개월 수를 더하여 반환
SELECT ADD_MONTHS(SYSDATE, -1), SYSDATE, ADD_MONTHS(SYSDATE, 1)
FROM DUAL;


-- LAST_DAY(날짜) : 해당 월의 마지막 날짜를 반환
SELECT LAST_DAY(SYSDATE), LAST_DAY('2023/04/01') 
FROM DUAL;

--(응용)다음날 1일 반환
SELECT LAST_DAY(SYSDATE), LAST_DAY('2023/04/01') +1
FROM DUAL;


-------------------------------------------------------------------

-- EXTRACT( YEAR | MONTH | DAY FROM 날짜 )
-- 날짜에서 년 | 월 | 일을 추출하여 정수로 반환

--EMPLOYEE테이블에서 각 사원의 이름, 입사 년, 월, 일 조회
-- 단, 2000년 이상 입사 사원만 조회
SELECT EMP_NAME 이름,
	EXTRACT (YEAR FROM HIRE_DATE) 년,
	EXTRACT (MONTH FROM HIRE_DATE) 월,
	EXTRACT (DAY FROM HIRE_DATE) 일
FROM EMPLOYEE
WHERE EXTRACT (YEAR FROM HIRE_DATE) >= 2000
ORDER BY 년;


---------------------------------------------------------

--<형변환 함수>

-- 문자열(CHAR) <-> 숫자(NUMBER)
-- 문자열(CHAR) <-> 날짜(DATE)
-- 숫자(NUMBER) --> 날짜(DATE)

/*TO CHAR(날짜 | 숫자[, 포맷]) : 문자열로 변환
 * 
 * 숫자 -> 문자열
 * 포맷
 * 1) 9 : 숫자 한 칸을 의미, 오른쪽 정렬
 * 2) 0 : 숫자 한 칸을 의미, 오른쪽 정렬, 빈 칸에 0을 추가
 * 3) L : 현재 시스템이나 DB에 설정된 나라의 화폐기호
 * 4) , : 숫자의 자릿수 구분
 * 
 * */

SELECT 1234, 
	TO_CHAR(1234, '99999'),
	TO_CHAR(1234, '00000')
FROM DUAL;



SELECT 1000000,
	TO_CHAR(1000000, 'L9999999'), 
	TO_CHAR(1000000, '$9999999'),
	TO_CHAR(1000000, '$9,999,999')	
FROM DUAL;



--EMPLOYEE테이블에서 사번, 이름, 연봉 조회(\100,000,000 형식으로 조회)
SELECT EMP_ID , EMP_NAME,
	TO_CHAR(SALARY * 12, 'L999,999,999') 연봉
FROM EMPLOYEE;



--오류 
--숫자를 문자열로 바꿀때 칸 수가 충분하지 않으면 '#'으로 채워짐
SELECT EMP_ID , EMP_NAME,
	TO_CHAR(SALARY * 12, 'L9,999,999') 연봉
FROM EMPLOYEE;





/*날짜 -> 문자열
 * YY  : 년도(짧게) EX) 23
 * YYYY: 년도(길게) EX) 2023
 * 
 * RR  : 년도(짧게) EX) 23
 * RRRR: 년도(길게) EX) 2023
 * 
 * MM : 월 
 * DD : 일
 * 
 * AM/PM : 오전/오후
 * 
 * HH  : 시간(12시간)
 * HH24: 시간(24시간)
 * MI  : 분
 * SS  : 초
 * 
 * DAY : 요일(전체) EX) 월요일, MONDAY
 * DY  : 요일(짧게) EX) 월, MON
 * 
 * */


SELECT SYSDATE, TO_CHAR(SYSDATE, 'AM HH:MI:SS') FROM DUAL; 

SELECT SYSDATE, TO_CHAR(SYSDATE, 'YY-MM-DD DAY HH:MI:SS') FROM DUAL; 

SELECT SYSDATE, TO_CHAR(SYSDATE, 'YY-MM-DD DY HH:MI:SS') FROM DUAL; 


-- * 포맷에 포함되지 않는 글자는 " "의 내부에 작성 *
-- 2023년 03월 07일 화요일
SELECT TO_CHAR(SYSDATE, 'YYYY년') FROM DUAL; 
-- ORA-01821: 날짜 형식이 부적합합니다

SELECT TO_CHAR(SYSDATE, 'YYYY"년"') FROM DUAL; 


SELECT TO_CHAR(SYSDATE, 'YYYY"년" MM"월" DD"일" DAY') TODAY FROM DUAL; 


--EMPLOYEE 테이블에서 모든 사원의 입사일을 '2023년 03월 07일 (화)' 형식으로 조회
SELECT EMP_NAME, 
	TO_CHAR (HIRE_DATE, 'RRRR"년" MM"월" DD"일" (DY)' ) 
FROM EMPLOYEE;


-------------------------------------


-- TO_DATE(문자열, 숫자[, 포맷])
--> 문자열이나 숫자를 지정된 포맷의 날짜 형식으로 해석하여 DATE타입으로 반환

SELECT '2023-03-07', TO_DATE('2023-03-07') FROM DUAL;


SELECT TO_DATE('2023년 03월 07일', 'YYYY"년" MM"월" DD"일" ') 
FROM DUAL;


-- 숫자 -> 날짜
SELECT 20230308, TO_DATE(20230308) FROM DUAL;


/* 날짜 패턴 Y, R의 차이점*/
-- 년도를 짧게 해석하는 경우 
-- 50미만 : Y, R 둘 다 앞부분에 현재세기(21C == 2000년대)를 적용
-- 50이상 : Y ==  현재세기(2000년대)
--		   R == 이전세기(1900년대)

--1949-01-15
--1950-01-15
SELECT TO_DATE('490115', 'YYMMDD'),
	   TO_DATE('490115', 'RRMMDD'),
	   TO_DATE('500115', 'YYMMDD'),
	   TO_DATE('500115', 'RRMMDD')
FROM DUAL;


-----------------------------------------------------------

-- TO_NUMBER(문자열[, 포맷]) : 문자열 -> 숫자

SELECT TO_NUMBER('$1,500', '$9,999') FROM DUAL;



------------------------------------------------------------

-- <NULL 처리 함수>

-- 1) NVL(컬럼명, 컬럼 값이 NULL일 경우 바꿀 값)
-- 컬럼값이 NULL일 경우 지정된 값으로 변경

-- EMPLOYEE 테이블에서 이름, 급여, 보너스 조회, 급여+보너스 조회

/* DB에서 NULL과 연산하는 경우 모든 결과는 NULL */

SELECT EMP_NAME, SALARY, NVL(BONUS, 0), SALARY*NVL(BONUS, 0)
FROM EMPLOYEE;


-- ORA-01722: 수치가 부적합합니다
SELECT EMP_NAME, SALARY, NVL(BONUS, '가나다'), SALARY*NVL(BONUS, 0)
FROM EMPLOYEE;



-- 2) NVL2(컬럼명, NULL 없는 경우 값, NULL 있는 경우 값)

-- EMPLOYEE 테이블에서 기존에 보너스를 받지 못했던 사원은 0.3으로 변경
-- 기존에 받았던 사원은 기존 보너스 +0.2으로 변경
SELECT EMP_NAME, BONUS, NVL2(BONUS, BONUS + 0.2 , 0.3) "변경된 BONUS" 
FROM EMPLOYEE;





-- 3/9
-----------------------------------------------------------------------

--<선택함수>
-- 여러가지 경우에 따라 알맞은 결과를 선택하는 함수
-- (if, switch문과 비슷)

-- DECODE(계산식|컬럼명, 조건1, 결과1, 조건2, 결과2, 조건3, 결과3,... [, 아무것도 일치하지 않을 때])
-- 비교하는 식 또는 컬럼의 값이 일치하는 조건이 있으면 
-- 해당 조건의 결과를 반환
-- 만약 일치하는 경우가 없으면 제일 끝 값([, 아무것도 일치하지 않을 때])을 반환
-- 자바의 switch문과 유사



--EMPLOYEE 테이블에서 모든 사원 사번, 이름 성별 조회(DECODE사용)
SELECT EMP_ID, EMP_NAME,
	DECODE( SUBSTR(EMP_NO, 8, 1) , '1', '남자', '2', '여자' ) 성별	
FROM EMPLOYEE;


--EMPLOYEE 테이블에서 
-- 직급코드가 'J7'인 직원은 급여 +급여의 10%
-- 직급코드가 'J6'인 직원은 급여의 15%
-- 직급코드가 'J5'인 직원은 급여의 20%
-- 나머지 직급코드의 직원은 급여의 5% 지급
-- 사원명, 직급코드, 기존급여, 지급급여를 조회
SELECT EMP_NAME , JOB_CODE , SALARY 기존급여,
	DECODE(JOB_CODE, 
		'J7', SALARY + (SALARY * 0.1),
		'J6', SALARY * 1.15,
		'J5', SALARY * 1.2,
		SALARY  * 1.05
	) 지급급여
FROM EMPLOYEE;

----------------------------------------------------------

-- CASE
--	WHEN 조건1 THEN 결과1 
--	WHEN 조건2 THEN 결과2
--	WHEN 조건3 THEN 결과3
--	...
--	ELSE 결과
-- END

-- DECODE는 계산식|컬럼값이 딱 떨어지는 경우에만 사용가능
-- CASE는 게산식|컬럼값을 범위로 지정가능


/*
SELECT EMP_ID, EMP_NAME,
	CASE
		WHEN 조건 THEN 결과
	END
FROM EMPLOYEE;
*/



--EMPLOYEE 테이블에서 모든 사원 사번, 이름 성별 조회(CASE사용)
SELECT EMP_ID, EMP_NAME,
	CASE
		WHEN SUBSTR(EMP_NO, 8, 1) = '1' THEN '남자'
		WHEN SUBSTR(EMP_NO, 8, 1) = '2' THEN '여자'
	END 성별
FROM EMPLOYEE;


--EMPLOYEE 테이블에서 사번, 이름, 급여, 구분을 조회
-- 구분은 받는 급여에 따라 초급, 중급, 고급으로 조회
-- 급여 500만 이상 = '고급'
-- 급여 300만 이상 ~ 500만 미만 = '중급'
-- 급여 300만 미만 = '초급'

-- 단, 부서코드는 D6인 사원만 직급코드 오름차순으로 조회

--이것도 가능1
SELECT EMP_ID, EMP_NAME , SALARY,
	CASE 
		WHEN SALARY >= 5000000 THEN '고급'
		WHEN SALARY >= 3000000 AND SALARY < 5000000 THEN '중급'
		ELSE '초급'
	END 구분
FROM EMPLOYEE
WHERE DEPT_CODE ='D6'
ORDER BY JOB_CODE /*ASC*/; --오름차순 생략가능


--이것도 가능2
SELECT EMP_ID, EMP_NAME , SALARY,
	CASE 
		WHEN SALARY >= 5000000 THEN '고급'
		WHEN SALARY >= 3000000 THEN '중급'
		ELSE '초급'
	END 구분
FROM EMPLOYEE
WHERE DEPT_CODE ='D6'
ORDER BY JOB_CODE /*ASC*/; --오름차순 생략가능


-----------------------------------------------------------------
------------------------------------------------------------------


/*********************** 그룹함수 *****************************/

-- SUM(숫자가 기록된 컬럼명) : 합계

-- 모든 사원읜 급여 합
SELECT SUM(SALARY) FROM EMPLOYEE; 


-- 부서코드가 'D9'인 사원들의 급여 합
SELECT SUM(SALARY) 
FROM EMPLOYEE
WHERE DEPT_CODE  = 'D9';




-- AVG(숫자가 기록된 컬럼명) : 평균

-- 모든 사원의 급여 평균 조회
SELECT ROUND(AVG(SALARY),1)
FROM EMPLOYEE;

-- 모든 사원의 급여 합과 평균 조회
SELECT SUM(SALARY) 합계, 
	   ROUND(AVG(SALARY),1) 평균
FROM EMPLOYEE;
--> 그룹 함수 여러 개를 동시 작성 가능



-- MAX(컬럼명) : 해당 컬럼의 최대 값
-- MIN(컬럼명) : 해당 컬럼의 최소 값
--> 타입 제한 X(숫자: 대/소, 문자열: 문자순서, 날짜: 과거 < 미래)

SELECT MIN(SALARY), MAX(SALARY),
	MIN(EMP_NAME), MAX(EMP_NAME),
	MIN(HIRE_DATE), MAX(HIRE_DATE)
FROM EMPLOYEE;


----------------------------------------------------------------


-- COUNT(* | 컬럼명) : 조회된 행의 개수를 반환
-- COUNT(*)    : NULL을 포함한 모든 행의 개수를 반환
-- COUNT(컬럼명) : 지정된 컬럼의 값이 NULL인 경우를 제외한 행의 개수를 반환
-- COUNT(DISTINCT 컬럼명) : 지정된 컬럼에서 중복된 값을 제외한 행의 개수를 반환





-- EMPLOYEE 테이블에 존재하는 모든 사원의 수
SELECT COUNT(*) FROM EMPLOYEE; --23

-- EMPLOYEE 테이블에서 부서코드가 있는 사원의 수
SELECT COUNT(DEPT_CODE) FROM EMPLOYEE; --21

SELECT COUNT(*) 
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL; -- 이렇게도 가능


-- EMPLOYEE 테이블에 존재하는 직급코드의 개수
SELECT COUNT(DISTINCT JOB_CODE) -- 7(중복을 제외하고 카운트)
FROM EMPLOYEE;




-- EMPLOYEE 테이블의 남자사원 수 조회


SELECT COUNT(*)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1)='1';



-- EMPLOYEE 테이블의 여자사원 수 조회

SELECT COUNT(*)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1)='2';




-- EMPLOYEE 테이블의 남자사원 수 여자사원 수 조회

--COUNT이용
SELECT COUNT(DECODE(SUBSTR(EMP_NO,8,1), '1', 1, 0)) "남자사원수", --0 또는 NULL 둘 다 사용 가능
	   COUNT(DECODE(SUBSTR(EMP_NO,8,1), '2', 1, 0)) "여자사원수" --0 또는 NULL 둘 다 사용 가능
FROM EMPLOYEE;


SELECT COUNT(DECODE(SUBSTR(EMP_NO,8,1), '1', 1, NULL)) "남자사원수", --0 또는 NULL 둘 다 사용 가능
	   COUNT(DECODE(SUBSTR(EMP_NO,8,1), '2', 1, NULL)) "여자사원수" --0 또는 NULL 둘 다 사용 가능
FROM EMPLOYEE;



--SUM이용

SELECT SUM(DECODE(SUBSTR(EMP_NO,8,1), '1', 1, 0)) "남자사원수", --0 또는 NULL 둘 다 사용 가능
	   SUM(DECODE(SUBSTR(EMP_NO,8,1), '2', 1, 0)) "여자사원수" --0 또는 NULL 둘 다 사용 가능
FROM EMPLOYEE;


SELECT SUM(DECODE(SUBSTR(EMP_NO,8,1), '1', 1, NULL)) "남자사원수", --0 또는 NULL 둘 다 사용 가능
	   SUM(DECODE(SUBSTR(EMP_NO,8,1), '2', 1, NULL)) "여자사원수" --0 또는 NULL 둘 다 사용 가능
FROM EMPLOYEE;



-- 서브쿼리 이용한 방법
SELECT 
	(SELECT COUNT(*) FROM EMPLOYEE
	WHERE SUBSTR(EMP_NO, 8, 1) = '1') "남자 사원 수",

	(SELECT COUNT(*) FROM EMPLOYEE
	WHERE SUBSTR(EMP_NO, 8, 1) = '2') "여자 사원 수"
FROM DUAL;


---------------------------------



