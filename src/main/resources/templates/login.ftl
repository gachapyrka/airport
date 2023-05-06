<#import "partitials/common.ftl" as c>
<#import "partitials/login.ftl" as l>
<@c.page>
    Вход
    <@l.login "/login" />
    <a href="/registration">Регистрация</a>
</@c.page>