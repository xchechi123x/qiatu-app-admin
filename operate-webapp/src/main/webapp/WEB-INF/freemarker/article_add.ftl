<div class="easyui-panel" style="width:586px;height: 564px">
    <div>
        <form id="form_add_article" class="easyui-form" method="post" data-options="novalidate:true">
            <input id="aid" type="hidden" name="id"></input>
            <table cellpadding="5">
                <tr>
                    <td>文章标题</td>
                    <td><input class="easyui-textbox" type="text" name="title" data-options="required:true"></input>
                    </td>
                </tr>
                <tr>
                    <td>文章子标题</td>
                    <td><input class="easyui-textbox" type="text" name="subTitle" data-options="required:true"></input>

                    </td>
                </tr>
                <tr>
                    <td>文章内容</td>
                    <td>
                        <textarea id="add_edit_${time_id}" name="textBody"></textarea>
                    </td>

                </tr>
            </table>
        </form>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submit_add_article()">更新文章</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="form_clear(this)">从写文章</a>
        </div>
    </div>
</div>

<script type="text/javascript">

    var article_add_edit;

    $(document).ready(function () {
        article_add_edit = UM.getEditor("add_edit_${time_id}");
        article_add_edit.setContent("");
    });

    function submit_add_article() {
        $('#form_add_article').form('submit', {
            url: constant.add_article_link,
            onSubmit: function () {
                return $(this).form('enableValidation').form('validate');
            },
            success: function (data) {
                var data_json = JSON.parse(data);
                if (data_json.result == "success") {
                    $('#add_article_window').window('close');
                    $('#article_list').datagrid('reload');
                    article_add_edit.destory();
                    $.messager.show({msg: constant.save_article_success_message});
                }
            }
        });
    }

</script>