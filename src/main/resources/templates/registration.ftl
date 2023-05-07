<#import "partitials/common.ftl" as c>
<#import "partitials/login.ftl" as l>
<#import "partitials/default-container.ftl" as k>

<@c.page>
    <@k.page_default>
        Регистрация
        {$message?ifExists}
        <@l.login "/registration" />
    </@k.page_default>
</@c.page>