import React, { useState } from 'react';


function InputPrint(){

    const [text, setText] = useState('');
    const[ inputText, setInputText] = useState('');
    
    
    
    return(
        <>
            <input type="text" onChange={e=> setInputText(e.target.value)}></input>
            <button onClick={()=>setText(text)}>보내기</button>
            <div>{inputText}</div>
        </>
    )

};

export default InputPrint;
