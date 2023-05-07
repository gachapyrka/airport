<#import "partitials/common.ftl" as c>
<#import "partitials/login.ftl" as l>
<#import "partitials/default-container.ftl" as k>
<@c.page>
    <@k.page_default>
        Пользователи:
        <table>
            <thead>
            <th>Логин</th>
            <th>Роль</th>
            <th></th>
            </thead>
        </table>
        <tbody>
        <#list usrs as usr>
            <tr>
                <td>${usr.username}</td>
                <td>${usr.role.name()}</td>
            </tr>
        </#list>
        </tbody>
    </@k.page_default>
</@c.page>