<#include "partitials/security.ftl">
<#import "partitials/common.ftl" as c>
<#import "partitials/default-container.ftl" as k>

<@c.page>
    <@k.page_default>
        <h3>${message?ifExists}</h3>
        <form method="post" action="/statistics/send">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="submit" value="Отправить на email">
        </form>
        <h2>Рейтинг перелетов по городам:</h2>
        <table>
            <thead>
            <th>Город</th>
            <th>Количество</th>
            </thead>
            <tbody>
            <#list raises as raise>
                <tr>
                    <td>${raise.to.name}</td>
                    <td>${raise.countOfDays }</td>
                </tr>
            </#list>
            </tbody>
        </table>
        <p/>
        <p/>
        <h2>Рейтинг туров:</h2>
        <table>
            <thead>
            <th>Город, страна</th>
            <th>Количество</th>
            </thead>
            <tbody>
            <#list tours as tour>
                <tr>
                    <td>${tour.to.name}</td>
                    <td>${tour.countOfDays }</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </@k.page_default>
</@c.page>