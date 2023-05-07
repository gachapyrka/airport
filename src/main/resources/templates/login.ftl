<#import "partitials/common.ftl" as c>
<#import "partitials/login.ftl" as l>
<#import "partitials/default-container.ftl" as k>

<@c.page>
    <@k.page_default>
        Вход
        <@l.login "/login" />
        <a href="/registration">Регистрация</a>
    </@k.page_default>
</@c.page>