<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" type="text/css" href="../themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/icon.css">
    <link href="../themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../js/constant.js"></script>
    <script type="text/javascript" src="../js/html_template.js"></script>
    <script type="text/javascript" src="../js/index.js"></script>

    <script type="text/javascript" src="../js/umeditor.config.js"></script>
    <script type="text/javascript" src="../js/editor.min.js"></script>
    <script type="text/javascript" src="../locale/zh-cn/zh-cn.js"></script>
    <title>杭州恰途科技APP后台应用管理</title>


</head>

<body class="easyui-layout">
<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:0px">杭州恰途科技</div>
<div data-options="region:'west',split:true,title:'管理选项菜单'" style="width:150px;padding:0px;">
    <div class="easyui-accordion" style="width:143px;height: auto">
        <div title="文章管理" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;height: inherit">

            <a href="#" class="easyui-linkbutton" data-options="plain:true" onclick="load_article_list()">发现文章列表管理</a>

        </div>
        <div title="推荐酒店信息管理" data-options="iconCls:'icon-help'" style="padding:10px;">
            <a href="#" class="easyui-linkbutton" data-options="plain:true"
               onclick="load_recommend_hotel_list()">推荐酒店管理</a>
        </div>
    </div>
</div>
<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
<div data-options="region:'center',title:''">
    <div id="tabs" class="easyui-tabs" style="width:auto;height:auto;">
        <div title="管理基础信息" style="display:none;">
            tab1
        </div>
    </div>
</div>



</body>
</html>