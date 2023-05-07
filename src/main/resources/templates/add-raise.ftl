<#import "partitials/common.ftl" as c>
<#import "partitials/default-container.ftl" as k>

<@c.page>
    <@k.page_default>
        <form method="post" action="add-raise.ftl">
            <#if isTour>
                <input type="number" min="1" name="countOfDays" placeholder="Длительность(дн.)">
            <#else >
                <input type="hidden" name="countOfDays" value="0">
            </#if>
            <input type="date" name="date" placeholder="Дата">
            <input type="number" name="cost" placeholder="Стоимость">
            <input type="submit" value="Добавить">
        </form>
    </@k.page_default>
</@c.page>