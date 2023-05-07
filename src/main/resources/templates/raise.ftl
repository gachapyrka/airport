<#import "partitials/common.ftl" as c>
<#import "partitials/login.ftl" as l>
<#import "partitials/default-container.ftl" as k>

<@c.page>
    <@k.page_default>
        <h4>Информация</h4>
        <strong>Откуда:</strong> Минск, Беларусь<p/>
        <strong>Куда:</strong> ${raise.to.name}<p/>
        <strong>Номер самолета:</strong> ${raise.number}<p/>
        <strong>Стоимость:</strong> ${raise.cost} руб.<p/>
        <strong>Вылет:</strong> ${raise.date}<p/>
        <#if springMacroRequestContext.requestUri?contains("/tours")>
            <strong>Длительность:</strong> ${raise.countOfDays} дней<p/>
            <a href="/tours">Назад</a>
        <#else>
            <a href="/raises">Назад</a>
        </#if>

    </@k.page_default>
</@c.page>