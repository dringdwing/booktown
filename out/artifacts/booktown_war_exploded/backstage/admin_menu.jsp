<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<%--<!DOCTYPE html>--%>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>书城后台管理</title>
    <link rel="icon" href="favicon.ico" type="image/ico">
    <link rel="stylesheet" href="css/bootstrap-3.3.4.css">
    <link rel="stylesheet" href="css/materialdesignicons.min.css">
    <link rel="stylesheet" href="css/style.min.css">
</head>
<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <!--左侧导航-->
        <aside class="lyear-layout-sidebar">

            <!-- logo -->
            <div id="logo" class="sidebar-header">
<%--                <a href="admin_index.jsp"><img src="images/logo-sidebar.png" title="LightYear" alt="LightYear"/></a>--%>
                <a href="admin_index.jsp"><span style="font-size: 24px;display: block;margin: 16px 10px">书城后台管理</span></a>
            </div>
            <div class="lyear-layout-sidebar-scroll">

                <nav class="sidebar-main">
                    <ul class="nav nav-drawer">
                        <li class="nav-item active"><a href="admin_index.jsp"><i class="mdi mdi-home"></i> 后台首页</a></li>

                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-language-javascript"></i>常规操作</a>
                            <ul class="nav nav-subnav">
                                <li><a href="/booktown/backstage/admin_findUserByPageServlet">用户管理</a></li>
                                <li><a href="/booktown/backstage/admin_cateselectServlet">分类管理</a></li>
                                <li><a href="/booktown/backstage/admin_productselect">图书管理</a></li>
                                <li><a href="admin_order.jsp">订单管理</a></li>
                                <li><a href="admin_message.jsp">留言管理</a></li>
                                <li><a href="admin_news.jsp">新闻管理</a></li>
                            </ul>
                        </li>
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-format-align-justify"></i>系统管理</a>
                            <ul class="nav nav-subnav">
                                <li><a href="">系统设置</a></li>
                                <li><a href="">清理缓存</a></li>
                                <li><a href="">数据备份</a></li>
                                <li><a href="">数据还原</a></li>
                            </ul>
                        </li>


                        </li>
                    </ul>
                </nav>

                <div class="sidebar-footer">
                    <p class="copyright">Copyright &copy; 2019. All rights reserved. More Templates </p>
                </div>
            </div>

        </aside>
        <!--End 左侧导航-->


        <!--End 头部信息-->
        <!--End 头部信息-->
