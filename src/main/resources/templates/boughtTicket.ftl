<#import "partitials/common.ftl" as c>
<#import "partitials/login.ftl" as l>
<#import "partitials/default-container.ftl" as k>

<@c.page>
    <@k.page_default>
        <h4>Информация</h4>
        <#list tickets as ticket>
            <strong>Откуда:</strong> Минск, Беларусь<p/>
            <strong>Куда:</strong> ${ticket.ticket.raise.to.name}<p/>
            <strong>Номер самолета:</strong> ${ticket.ticket.raise.number}<p/>
            <strong>Стоимость:</strong> ${ticket.ticket.raise.cost} руб.<p/>
            <#if ticket.ticket.raise.countOfDays!=0>
                <strong>Длительность:</strong> ${ticket.ticket.raise.countOfDays} дней<p/>
            </#if>
            <strong>Вылет:</strong> ${ticket.ticket.raise.date}<p/>
            <strong>Количество:</strong> ${ticket.ticket.count}<p/>
            <strong>На имя:</strong> ${ticket.credentials}<p/>
            <strong>Куплен:</strong> ${ticket.buyDate}<p/>
            <a href="/history">Назад</a>
        </#list>

    </@k.page_default>
</@c.page>