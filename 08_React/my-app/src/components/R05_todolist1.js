import React, { useState } from 'react'; // imrs


// useState 복습
const InputName = () => {

    // state : 컴포넌트의 상태
    // useState : 컴포넌트의 상태를 관리 -> state 변화가 감지되면 컴포넌드를 리렌더링


    const [name, setName] = useState('');
    // name : 변수명
    // setName : name 변수의 setter역할
    // useState('') : name변수에 대입되는 초기값을 ''(빈칸)으로 지정 

    return (
        <div>
            <p>이름을 입력하세요</p>
            <input type="text" onChange={ e =>setName(e.target.value) }/>
            <h3>{name}</h3>
        </div>
    );
};



const TodoList1 = () => {

    // 할일을 저장할 변수
    // -> 상태가 변하면 컴포넌트(TodoList1)을 리렌더링
    const [todos, setTodos] = useState([
        { text : '프로젝트', completed : true },
        { text : '대장이 밥주기', completed : false}
    ]);


    console.log(todos);

    // 할 일 입력 컴포넌트
    const InputTodo = () =>{
        const [inputText, setInputText] = useState('');

        // 버튼 클릭 시 할 일 추가
        const addTodo = () => {
            const newTodo = { text : inputText , completed : false };

            // 전개연산자 (...) -> 가장 바깥의 [](대괄호)가 사라짐
            // ...[a, b, c] -> a,b,c
            // todos에 newTodos를 추가한 객체배열 newRodos
            const newTodos = [ ...todos, newTodo ];

            // 새로운 객체배열 newTodos를 rodos에 대입
            // -> 상태 변화 인식 -> 리렌더링 진행
            setTodos(newTodos);
            setInputText(''); // 입력된 할 일 삭제


        };

        return (
            <div>
                <h4>할 일 추가</h4>
                <input type='text' onChange={ e =>setInputText(e.target.value) } />
                <button onClick={addTodo}>추가하기</button>
            </div>
        );
    };


    // 체크박스 값 변경 시 
    const todoChange = index => {

        const newTodos = [...todos]; // todos를 풀어서 새로운 배열 생성
                                                        // 전개 연산자를 이용한 배열 깊은 복사

        // boolean값 반대로 변경해서 대입
        newTodos[index].completed = !newTodos[index].completed;

        setTodos(newTodos);
    }



    return(
        <>
            <InputName/>
            <hr/>

            <h1>Todo List1</h1>

            {/* 입력 */}
            <InputTodo/>

            {/* 할 일 목록 */}
            {/* 
                배열.map( (배열요소, 인덱스)=>{ return 값; } ) 
                -> 기존 배열을 이용해서 새로운 배열을 만드는 함수
                -> 새로운 배열의 요소는 map에서 return 되는 값으로 이루어짐    
            */}

            <ul>
                {todos.map( (todo, index) => {
                    return(
                        // key 속성 : 배열 (list) 출력 시 요소를 구분하는 key값
                        <li key={index}>
                            <input type='checkbox' 
                                        checked={todo.completed}
                                        onChange={ ()=>{ todoChange(index) } }
                            />
                            <span className={todo.completed ? 'completed' : ''}>
                                {todo.text}
                            </span>
                        </li>
                    );
                } )}
            </ul>

        </>
    );

};

// 외부에서 해당 파일 import시 TodoList1 함수를 내보내는 기본 값으로 지정
export default TodoList1;

