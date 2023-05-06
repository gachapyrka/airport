<#import "partitials/common.ftl" as c>
<#import "partitials/login.ftl" as l>

<@c.page>
    <#if isAuthorized>
    <div>
        <@l.logout/>
    </div>
    </#if>
    <#list users as user>
        <div>Hello, ${user.username}</div>
        <div>ps, ${user.password}</div>
    </#list>
</@c.page>