<#import "partitials/common.ftl" as c>
<#import "partitials/default-container.ftl" as k>

<@c.page>
    <@k.page_default>
        <form method="post" action="/tickets/buy/${ticket.id}">
            <strong>Идентификационный номер паспорта:</strong><input type="text" required="true" name="passportId" minlength="11" maxlength="42">
            <strong>ФИО:</strong><input type="text" required="true" name="credentials">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="submit" value="Купить">
        </form>
    </@k.page_default>
</@c.page>