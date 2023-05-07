<#import "partitials/common.ftl" as c>

<#import "partitials/default-container.ftl" as k>

<@c.page>
    <@k.page_default>
        <#list raises as raise>
            <div>From:, ${raise.from.name}</div>
            <div>To: ${raise.to.name}</div>
            <div>Date: ${raise.date}</div>
            <div>Cost: ${raise.cost}</div>
            <div>Number: ${raise.number}</div>
            <#if raise.countOfDays != 0>
                <div>CountOfDays: ${raise.countOfDays}</div>
            </#if>
        </#list>
    </@k.page_default>
</@c.page>