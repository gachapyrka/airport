<#import "partitials/common.ftl" as c>
<#import "partitials/login.ftl" as l>

<@c.page>
    Регистрация
    {$message}
    <@l.login "/registration" />
</@c.page>