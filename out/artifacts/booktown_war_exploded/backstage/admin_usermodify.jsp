<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<%@ include file="admin_menu.jsp" %>

<!DOCTYPE html>
<!--End 左侧导航-->


<!--头部信息-->
<header class="lyear-layout-header">

    <nav class="navbar navbar-default">
        <div class="topbar">

            <div class="topbar-left">
                <div class="lyear-aside-toggler">
                    <span class="lyear-toggler-bar"></span>
                    <span class="lyear-toggler-bar"></span>
                    <span class="lyear-toggler-bar"></span>
                </div>
                <span class="navbar-page-title"> <a href="admin_index.jsp">后台首页</a> -> <a href="/booktown/backstage/admin_findUserByPageServlet">用户管理</a> -> 修改用户</span>
            </div>

            <ul class="topbar-right">
                <li class="dropdown dropdown-profile">
                    <a href="javascript:void(0)" data-toggle="dropdown">
                        <img class="img-avatar img-avatar-48 m-r-10" src="images/users/avatar.jpg" alt="后台系统"/>
                        <span>后台系统 <span class="caret"></span></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-right">
                        <li><a href="adminMassage.html"><i class="mdi mdi-account"></i> 个人信息</a></li>
                        <li><a href="adminUpdatePwd.html"><i class="mdi mdi-lock-outline"></i> 修改密码</a></li>
                        <li><a href="javascript:void(0)"><i class="mdi mdi-delete"></i> 清空缓存</a></li>
                        <li class="divider"></li>
                        <li><a href="adminLogin.html"><i class="mdi mdi-logout-variant"></i> 退出登录</a></li>
                    </ul>
                </li>
                <!--切换主题配色-->
                <li class="dropdown dropdown-skin">
                    <span data-toggle="dropdown" class="icon-palette"><i class="mdi mdi-palette"></i></span>
                    <ul class="dropdown-menu dropdown-menu-right" data-stopPropagation="true">
                        <li class="drop-title"><p>主题</p></li>
                        <li class="drop-skin-li clearfix">
                  <span class="inverse">
                    <input type="radio" name="site_theme" value="default" id="site_theme_1" checked>
                    <label for="site_theme_1"></label>
                  </span>
                            <span>
                    <input type="radio" name="site_theme" value="dark" id="site_theme_2">
                    <label for="site_theme_2"></label>
                  </span>
                            <span>
                    <input type="radio" name="site_theme" value="translucent" id="site_theme_3">
                    <label for="site_theme_3"></label>
                  </span>
                        </li>
                        <li class="drop-title"><p>LOGO</p></li>
                        <li class="drop-skin-li clearfix">
                  <span class="inverse">
                    <input type="radio" name="logo_bg" value="default" id="logo_bg_1" checked>
                    <label for="logo_bg_1"></label>
                  </span>
                            <span>
                    <input type="radio" name="logo_bg" value="color_2" id="logo_bg_2">
                    <label for="logo_bg_2"></label>
                  </span>
                            <span>
                    <input type="radio" name="logo_bg" value="color_3" id="logo_bg_3">
                    <label for="logo_bg_3"></label>
                  </span>
                            <span>
                    <input type="radio" name="logo_bg" value="color_4" id="logo_bg_4">
                    <label for="logo_bg_4"></label>
                  </span>
                            <span>
                    <input type="radio" name="logo_bg" value="color_5" id="logo_bg_5">
                    <label for="logo_bg_5"></label>
                  </span>
                            <span>
                    <input type="radio" name="logo_bg" value="color_6" id="logo_bg_6">
                    <label for="logo_bg_6"></label>
                  </span>
                            <span>
                    <input type="radio" name="logo_bg" value="color_7" id="logo_bg_7">
                    <label for="logo_bg_7"></label>
                  </span>
                            <span>
                    <input type="radio" name="logo_bg" value="color_8" id="logo_bg_8">
                    <label for="logo_bg_8"></label>
                  </span>
                        </li>
                        <li class="drop-title"><p>头部</p></li>
                        <li class="drop-skin-li clearfix">
                  <span class="inverse">
                    <input type="radio" name="header_bg" value="default" id="header_bg_1" checked>
                    <label for="header_bg_1"></label>
                  </span>
                            <span>
                    <input type="radio" name="header_bg" value="color_2" id="header_bg_2">
                    <label for="header_bg_2"></label>
                  </span>
                            <span>
                    <input type="radio" name="header_bg" value="color_3" id="header_bg_3">
                    <label for="header_bg_3"></label>
                  </span>
                            <span>
                    <input type="radio" name="header_bg" value="color_4" id="header_bg_4">
                    <label for="header_bg_4"></label>
                  </span>
                            <span>
                    <input type="radio" name="header_bg" value="color_5" id="header_bg_5">
                    <label for="header_bg_5"></label>
                  </span>
                            <span>
                    <input type="radio" name="header_bg" value="color_6" id="header_bg_6">
                    <label for="header_bg_6"></label>
                  </span>
                            <span>
                    <input type="radio" name="header_bg" value="color_7" id="header_bg_7">
                    <label for="header_bg_7"></label>
                  </span>
                            <span>
                    <input type="radio" name="header_bg" value="color_8" id="header_bg_8">
                    <label for="header_bg_8"></label>
                  </span>
                        </li>
                        <li class="drop-title"><p>侧边栏</p></li>
                        <li class="drop-skin-li clearfix">
                  <span class="inverse">
                    <input type="radio" name="sidebar_bg" value="default" id="sidebar_bg_1" checked>
                    <label for="sidebar_bg_1"></label>
                  </span>
                            <span>
                    <input type="radio" name="sidebar_bg" value="color_2" id="sidebar_bg_2">
                    <label for="sidebar_bg_2"></label>
                  </span>
                            <span>
                    <input type="radio" name="sidebar_bg" value="color_3" id="sidebar_bg_3">
                    <label for="sidebar_bg_3"></label>
                  </span>
                            <span>
                    <input type="radio" name="sidebar_bg" value="color_4" id="sidebar_bg_4">
                    <label for="sidebar_bg_4"></label>
                  </span>
                            <span>
                    <input type="radio" name="sidebar_bg" value="color_5" id="sidebar_bg_5">
                    <label for="sidebar_bg_5"></label>
                  </span>
                            <span>
                    <input type="radio" name="sidebar_bg" value="color_6" id="sidebar_bg_6">
                    <label for="sidebar_bg_6"></label>
                  </span>
                            <span>
                    <input type="radio" name="sidebar_bg" value="color_7" id="sidebar_bg_7">
                    <label for="sidebar_bg_7"></label>
                  </span>
                            <span>
                    <input type="radio" name="sidebar_bg" value="color_8" id="sidebar_bg_8">
                    <label for="sidebar_bg_8"></label>
                  </span>
                        </li>
                    </ul>
                </li>
                <!--切换主题配色-->
            </ul>

        </div>
    </nav>

</header>
<!--页面主要内容-->
<main class="lyear-layout-content">

    <div class="container-fluid">

        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">

                        <form method="post" action="${pageContext.request.contextPath}/backstage/admin_douserupdateServlet" class="site-form">
                            <input type="hidden" name="userStatus" value="${user.USER_STATUS}">
<%--                            <input type="hidden" name="id" value="${user.USER_ID}">--%>
                            <input type="hidden" name="currentPage" value="${userPb.currentPage}">
                            <div class="form-group">
                                <label class="col-xs-12" for="example-text-id" >用户名</label>
                                <div class="col-xs-12">
                                    <input class="form-control" id="example-text-id" type="text" value="${user.USER_ID}" name="username">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-xs-12" for="example-text-input">用户姓名</label>
                                <div class="col-xs-12">
                                    <input class="form-control" type="text" id="example-text-input" value="${user.USER_NAME}" name="name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-12" for="example-text-pwd">登录密码</label>
                                <div class="col-xs-12">
                                    <input class="form-control" type="text" id="example-text-pwd" value="${user.USER_PASSWORD}" name="password">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-12">性别</label>
                                <div class="col-xs-12">
                                    <label class="checkbox-inline" for="example-inline-checkbox1">
                                        <input type="radio" id="example-inline-checkbox1" name="sex" value="T"
                                              ${user.USER_SEX=='T'?"checked":""} >
                                        男
                                    </label>
                                    <label class="checkbox-inline" for="example-inline-checkbox2">
                                        <input type="radio" id="example-inline-checkbox2" name="sex" value="F" ${user.USER_SEX=='F'?"checked":""}>
                                        女
                                    </label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-xs-12" for="example-text-birth">出生日期</label>
                                <div class="col-xs-12">
                                    <input class="form-control" type="text" id="example-text-birth" value="${user.USER_BIRTHDAY}" name="birthday">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-12" for="example-text-email">电子邮箱</label>
                                <div class="col-xs-12">
                                    <input class="form-control" type="text" id="example-text-email" value="${user.USER_EMAIL}" name="email">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-xs-12" for="example-text-moi">手机号码</label>
                                <div class="col-xs-12">
                                    <input class="form-control" type="text" id="example-text-moi" value="${user.USER_MOBLE}"
                                           name="mobile">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-12" for="example-text-address" >收获地址</label>
                                <div class="col-xs-12">
                                    <input class="form-control" type="text" id="example-text-address" value="${user.USER_MOBLE}"
                                           name="address">
                                </div>
                            </div>


                            <button type="submit" class="btn btn-primary" style="margin-left: 20px">提交</button>
                            <button type="submit" class="btn btn-primary" style="margin-left: 20px">返回</button>
                        </form>

                    </div>
                </div>
            </div>

        </div>

    </div>

</main>
<!--End 页面主要内容-->
</div>
</div>

<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap-3.3.4.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>
</body>
</html>
