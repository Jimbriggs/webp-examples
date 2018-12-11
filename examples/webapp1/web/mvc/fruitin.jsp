<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<html>
    <head><title>Fruit example input page</title></head>
    <body>
        <form action="/webapp1/showFruit">
            <p>Type of fruit:
                <select name="type">
                    <option value="apple">Apple</option>
                    <option value="banana">Banana</option>
                    <option value="orange">Orange</option>
                </select>
            <p>Colour: 
                <select name="colour">
                    <option value="Red" selected>Red</option>
                    <option value="Green">Green</option>
                    <option value="Yellow">Yellow</option>
                    <option value="Purple">Purple</option>
                </select>
            </p>
            <p>Condition: 
                <select name="condition">
                    <option value="fresh" selected>fresh</option>
                    <option value="stale">stale</option>
                    <option value="past its best">past its best</option>
                </select>
            </p>
            <p>
                <input type='submit' value='Go'>
            </p>
        </form>     
    </body>
</html>
