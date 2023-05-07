<#import "navbar.ftl" as n>

<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <link rel="stylesheet" href="G:\Projects\CourseWorks\3.2\airport\src\main\java\com\example\airport\styles\index.css">
        <title>Авиалейс</title>
    </head>
    <body>
    <@n.navbar></@n.navbar>
    <#nested>
    </body>
    </html>
</#macro>