<#import "partitials/common.ftl" as c>
<#import "partitials/default-container.ftl" as k>

<@c.page>
    <@k.page_default>
        <strong>Куда:</strong><select  style="display: grid" form="in" name="to">
        <#list places as place>
            <option value="${place.name}">${place.name}</option>
        </#list>
        </select>
        <form method="post" id="in" action="add-raise">
            <strong>Дата:</strong><input type="date" required="true" name="date">
            <strong>Стоимость:</strong><input type="number" required="true" name="cost" min="1">
            <strong>Номер самолета:</strong><input type="text" required="true" minlength="8" name="number">
            <#if springMacroRequestContext.requestUri?contains("/add-tour")>
                <strong>Длительность(дн.):</strong><input type="number" required="true" min="1" name="countOfDays">
            <#else >
                <input type="hidden" name="countOfDays" value="0">
            </#if>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="submit" value="Добавить">
        </form>
    </@k.page_default>
</@c.page>