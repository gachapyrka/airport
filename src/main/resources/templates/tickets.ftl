<#include "partitials/security.ftl">
<#import "partitials/common.ftl" as c>
<#import "partitials/default-container.ftl" as k>

<@c.page>
    <@k.page_default>
        <h5>Ваша персональная скидка - ${discount} %</h5>
        <table>
            <thead>
            <th>Город</th>
            <th>Дата</th>
            <th>Стоимость</th>
            <th>Количество</th>
            <th></th>
            </thead>
            <tbody>
            <#list tickets as ticket>
                <tr>
                    <td>${ticket.raise.to.name}</td>
                    <td>${ticket.raise.date}</td>
                    <td>${ticket.raise.cost* (100.0 - discount)/100.0 } руб.</td>
                    <td>${ticket.count }</td>
                    <td>
                        <#if ticket.raise.countOfDays==0>
                            <form method="get" action="/raises/${ticket.raise.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                <input type="submit" value="Подробнее">
                            </form>
                        <#else>
                            <form method="get" action="/tours/${ticket.raise.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                <input type="submit" value="Подробнее">
                            </form>
                        </#if>
                        <form method="get" action="/tickets/buy/${ticket.id}">
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <input type="submit" value="Купить">
                        </form>
                        <form method="post" action="/tickets/delete/${ticket.id}">
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <input type="submit" value="Удалить">
                        </form>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </@k.page_default>
</@c.page>