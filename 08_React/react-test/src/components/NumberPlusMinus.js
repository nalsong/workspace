import React, { useState } from 'react';

function NumberPlusMinus(){

    const [count, setCount] = useState(0);

    const handleClick = () => {
        setCount( () => count -1);
    };

    const handleClick1 = () => {
        setCount( () => count +1);
    };



    return (
        <>
            {/* <div>
                <button  class="minus"onClick={handleClick}>-</button>
                <h1>{count}</h1>
                <button class="plus" onClick={handleClick1}>+</button>
            </div> */}
        </>
    )


};
export default NumberPlusMinus;
