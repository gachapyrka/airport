<#include "partitials/security.ftl">
<#import "partitials/common.ftl" as c>
<#import "partitials/default-container.ftl" as k>

<@c.page>
    <@k.page_default>
        <h3>${message?ifExists}</h3>
        <table>
            <thead>
            <th>Город</th>
            <th>Дата</th>
            <th>Количество</th>
            <th>Дата покупки</th>
            <th></th>
            </thead>
            <tbody>
            <#list tickets as ticket>
                <tr>
                    <td>${ticket.ticket.raise.to.name}</td>
                    <td>${ticket.ticket.raise.date}</td>
                    <td>${ticket.ticket.count }</td>
                    <td>${ticket.buyDate }</td>
                    <td>
                        <form method="get" action="/history/${ticket.id}">
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <input type="submit" value="Подробнее">
                        </form>
                        <form method="get" action="/history/download/${ticket.id}">
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <input type="submit" value="Скачать">
                        </form>
                        <form method="post" action="/history/send/${ticket.id}">
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <input type="submit" value="Отправить на email">
                        </form>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </@k.page_default>
</@c.page>