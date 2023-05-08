<#include "partitials/security.ftl">
<#import "partitials/common.ftl" as c>
<#import "partitials/default-container.ftl" as k>

<@c.page>
    <@k.page_default>
        <#if known&&isAdmin>
            <#if springMacroRequestContext.requestUri?contains("/raises")>
                <a href="/add-raise">Добавить</a>

            <#else>
                <a href="/add-tour">Добавить</a>

            </#if>
        </#if>
        <#if springMacroRequestContext.requestUri?contains("/raises")>
            <p>Поиск:</p>
            <form method="get" action="/raises">
                <input type="text" name="filter" value="${filter}">
                <button type="submit">Найти</button>
            </form>
        <#else>
            <p>Поиск:</p>
            <form method="get" action="/tours">
                <input type="text" name="filter" value="${filter}">
                <button type="submit">Найти</button>
            </form>
        </#if>
        <table>
            <thead>
            <th>Город</th>
            <th>Дата</th>
            <th>Стоимость</th>
            <th></th>
            </thead>
            <tbody>
            <#list raises as raise>
                <tr>
                    <td>${raise.to.name}</td>
                    <td>${raise.date}</td>
                    <td>${raise.cost} руб.</td>
                    <td>
                        <#if raise.countOfDays==0>
                            <form method="get" action="/raises/${raise.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                <input type="submit" value="Подробнее">
                            </form>
                        <#else>
                            <form method="get" action="/tours/${raise.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                <input type="submit" value="Подробнее">
                            </form>
                        </#if>
                        <#if known&&!isAdmin>
                            <form method="post" action="/add-to-list/${raise.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                <input type="submit" value="В корзину">
                            </form>
                        </#if>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </@k.page_default>
</@c.page>