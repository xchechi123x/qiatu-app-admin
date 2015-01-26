<table>
    <tr>
    <#list reasonImageList as image>
        <td><input type='radio' name='reason[rid].imgId' value='${image.id}'/></td>
        <td><img width='16px' height='18px' src='${image.url}'></td>
    </#list>
    </tr>
</table>