<#import "partitials/common.ftl" as c>

<@c.page>
    <#list users as user>
        <div>Hello, ${user.username}</div>
        <div>ps, ${user.username}</div>
    </#list>
</@c.page>