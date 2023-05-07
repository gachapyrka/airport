<#macro page_default>
    <div style="background-image: url('https://phonoteka.org/uploads/posts/2021-04/thumbs/1617680324_4-p-fon-goluboi-gradient-4.png');
            height: calc(100vh - 64px);
            background-size: cover;
            position: relative;">
        <div class="container">
            <#nested>
        </div>
    </div>
</#macro>

<#macro page_index>
    <div style="background-image: url('https://mirpozitiva.ru/wp-content/uploads/2019/11/1477494785_belyi-samolet-1568x980.jpg');
                height: calc(100vh - 64px);
                background-size: cover;
                position: relative;">
        <#nested>
    </div>
</#macro>