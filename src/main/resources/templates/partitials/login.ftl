<#macro login path>
    <form action="${path}" method="post">
        <div><label> Логин : <input type="email" required="true" name="username"/> </label></div>
        <div><label> Пароль: <input type="password" required="true" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Вход"/></div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Выход"/>
    </form>
</#macro>