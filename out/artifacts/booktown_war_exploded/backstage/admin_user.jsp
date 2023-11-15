<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ include file="admin_menu.jsp" %>
<%--引用标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <span class="navbar-page-title"> <a href="admin_index.jsp">后台首页</a> -> <a
                        href="/booktown/backstage/admin_findUserByPageServlet">用户管理</a></span>
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
                    <form class="form-inline"
                          action="${pageContext.request.contextPath}/backstage/admin_findUserByPageServlet"
                          method="post">
                        <div class="form-group">
                            <label class="sr-only" for="example-if-id">用户ID</label>
                            <input class="form-control" type="text" id="example-if-id" value="${condition.USER_ID[0]}"
                                   name="USER_ID" placeholder="请输入用户ID">
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="example-if-address">用户姓名</label>
                            <input class="form-control" type="text" id="example-if-address"
                                   value="${condition.USER_NAME[0]}" name="USER_NAME" placeholder="用户姓名">
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="example-if-email">邮箱</label>
                            <input class="form-control" type="text" id="example-if-email"
                                   value="${condition.USER_EMAIL[0]}" name="USER_EMAIL" placeholder="请输入邮箱..">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-default" type="submit">查询</button>
                        </div>
                    </form>
                    <div class="card-toolbar clearfix">

                    </div>
                    <form action="/booktown/backstage/admin_delServlet" method="post" id="myform">
                        <div class="card-body">

                            <h5><a href="admin_useradd.jsp">添加用户</a>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<a
                                    href="javascript:delmore('你确定要删除这些用户么','myform');">批量删除</a>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<a
                                    href="">更新排序</a></h5>

                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th>
                                            <label class="lyear-checkbox checkbox-primary">
                                                <input type="checkbox" id="check-all"><span></span>
                                            </label>
                                        </th>
                                        <th>ID</th>
                                        <th>姓名</th>
                                        <th>姓别</th>
                                        <th>EMAIL</th>
                                        <th>手机</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>

                                    <c:forEach var="u" items="${userPb.list}">
                                        <tbody>
                                        <tr>
                                            <td>
                                                <label class="lyear-checkbox checkbox-primary">
                                                    <input type="checkbox" name="id[]"
                                                           value="${u.USER_ID }"><span></span>
                                                </label>
                                            </td>
                                            <td>${u.USER_ID }</td>
                                            <td>${u.USER_NAME }</td>
                                            <td>${u.USER_SEX=='T'?'男':'女' }</td>
                                            <td>${u.USER_EMAIL }</td>
                                            <td>${u.USER_MOBLE }</td>
                                            <td>
                                                <a class="link-update"
                                                   href="admin_touserupdate?id=${u.USER_ID}&currentPage=${userPb.currentPage}">修改</a>
                                                <c:if test="${u.USER_STATUS == 1}">
                                                    <a class="link-del"
                                                       href="javascript:Delete('你确定要删除用户【${u.USER_NAME}】么', '/booktown/backstage/admin_delServlet?id=${u.USER_ID}&currentPage=${currentPage}');">删除</a>
                                                </c:if>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </c:forEach>
                                    <script>
                                        function delmore(mess, formname) {
                                            if (confirm(mess)) {
                                                var form = document.getElementById(formname);
                                                form.submit();
                                            }
                                            ;
                                        }

                                        function Delete(mess, url) {
                                            if (confirm(mess)) {
                                                location.href = url;
                                                <%--window.location.href='/booktown/backstage/admin_douserdelServlet?id=${u.USER_ID}&currentPage=${currentPage}';--%>

                                            }
                                            ;
                                        };
                                    </script>
                                </table>
                                <!--  圆角边框 -->
                                <nav>
                                    <ul class="pagination pagination-circle ">
                                        <c:if test="${userPb.currentPage == 1}"><li class="disabled"></c:if>

                                        <c:if test="${userPb.currentPage != 1}"><li></c:if>

                                        <a href="${pageContext.request.contextPath}/backstage/admin_findUserByPageServlet?currentPage=${userPb.currentPage-1}&rows=5&USER_ID=${condition.USER_ID[0]}&USER_NAME=${condition.USER_NAME[0]}&USER_EMAIL=${condition.USER_EMAIL[0]}">
                                            <span><i class="mdi mdi-chevron-left"></i></span>
                                        </a>
                                        </li>

                                        <c:forEach begin="1" end="${userPb.totalPage}" var="i">
                                            <c:if test="${userPb.currentPage == i}"><li class="active"><a href="${pageContext.request.contextPath}/backstage/admin_findUserByPageServlet?currentPage=${i}&rows=5">${i}</a></li></c:if>
                                            <c:if test="${userPb.currentPage != i}"><li><a href="${pageContext.request.contextPath}/backstage/admin_findUserByPageServlet?currentPage=${i}&rows=5&rows=5&USER_ID=${condition.USER_ID[0]}&USER_NAME=${condition.USER_NAME[0]}&USER_EMAIL=${condition.USER_EMAIL[0]}">${i}</a></li></c:if>
                                        </c:forEach>
                                        <li><a href="${pageContext.request.contextPath}/backstage/admin_findUserByPageServlet?currentPage=${userPb.currentPage+1 > userPb.totalPage ? userPb.totalPage : userPb.currentPage+1}&rows=5&rows=5&USER_ID=${condition.USER_ID[0]}&USER_NAME=${condition.USER_NAME[0]}&USER_EMAIL=${condition.USER_EMAIL[0]}">
                                                <span><i class="mdi mdi-chevron-right"></i></span>
                                            </a>
                                        </li>
                                        <span style="">共${userPb.totalCount}条记录，共页${userPb.totalPage}</span>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </form>
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