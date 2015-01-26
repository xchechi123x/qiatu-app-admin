<div>
    <form id="form_add_recommend_hotel" class="easyui-form" method="post" data-options="novalidate:true">
        <div>
            <table cellpadding="5">
                <tr>
                    <td>
                        <div>
                            <div style="float: left">
                                <span style="margin-right: 8px;font-size: 12px">酒店名称:</span>
                                <input class="easyui-textbox" type="text"
                                       name="hotelName"
                                       data-options="required:true"
                                        />
                            </div>
                            <div style="float: left;margin-left: 5px">
                                <span>推荐标题：</span>
                                <input class="easyui-textbox" style="width: 220px" type="text"
                                       name="recommendTitle"
                                       data-options="required:true"/></div>
                            <div style="float: left;margin-left: 5px">
                                <span>推荐日期：</span>
                                <input type="text" class="easyui-datebox" data-options="required:true"
                                       name="recommendTime"/>
                            </div>
                            <div style="float: left;margin-left: 5px">
                                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="add_add_recommend_reason()">添加推荐理由</a>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <div id="recommend_reasons">
        </div>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submit_recommend_hotel()">保存推荐酒店</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="form_clear('form_add_recommend_hotel')">重新填写信息</a>
        </div>
    </form>
</div>


<script type="text/javascript">
    var reason_index = 0;

    $(document).ready(function () {
        for (var i = 0; i < 3; i++) {
            init_recommend_reason(i);
            reason_index += 1;
        }
    });

    function init_recommend_reason(i) {

        $.get("/recommend/images/list", function (result) {
            var replace_reason_icon = result.replace(/rid/g, i);
            var text = template.recommend_hotel_template.template_txt.replace(/{number}/g, i + 1).replace(/{rid}/g, i).replace(/{recommend_icon}/g, replace_reason_icon);
            $('#recommend_reasons').append(text);
        });
    }

    function add_add_recommend_reason() {
        $.get("/recommend/images/list", function (result) {
            var replace_reason_icon = result.replace(/rid/g, reason_index);
            var text = template.recommend_hotel_template.template_txt.replace(/{number}/g, reason_index + 1).replace(/{rid}/g, reason_index).replace(/{recommend_icon}/g, replace_reason_icon);
            $('#recommend_reasons').append(text);
            reason_index += 1;
        });
    }

    function submit_recommend_hotel() {
        $('#form_add_recommend_hotel').form('submit', {
            url: constant.add_recommend_hotel_link,
            onSubmit: function () {
                return $(this).form('enableValidation').form('validate');
            },
            success: function (data) {
                var data_json = JSON.parse(data);
                if (data_json.result == "success") {
                    $('#recommend_hotel_window').window('close');
                    $('#recommend_hotel_list').datagrid('reload');
                    $.messager.show({msg: constant.save_recommend_success_message});
                }
            }
        });
    }
</script>