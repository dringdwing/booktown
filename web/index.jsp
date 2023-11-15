<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>书城</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<style>
    * {
        list-style: none;
    }
</style>
<body>
<!------------------------------head------------------------------>
<%@ include file="header.jsp" %>
<!-------------------------banner--------------------------->
<iframe allow="autoplay" hidden frameborder="no" border="0" marginwidth="0" marginheight="0" width=330 height=86
        src="//music.163.com/outchain/player?type=2&id=167850&auto=1&height=66"></iframe>
<div class="block_home_slider">
    <div id="home_slider" class="flexslider">
        <ul class="slides">
            <li>
                <div class="slide"><img src="img/banner1.png"/></div>
            </li>
            <li>
                <div class="slide"><img src="img/banner2.png"/></div>
            </li>
            <li>
                <div class="slide"><img src="img/banner3.png"/></div>
            </li>
        </ul>
    </div>
</div>
<!------------------------------thImg------------------------------>
<div class="thImg">
    <div class="clearfix">
        <a href="#"><img src="images/product/1.jpg"/></a>
        <a href="#"><img src="images/product/3e.jpg"/></a>
        <a href="#"><img src="images/product/Linux1.jpg"/></a></div>
</div>
<!------------------------------news------------------------------>
<div class="news">

    <div class="wrapper">
        <h2><img src="img/ih1.jpg"/></h2>
        <div class="people">
            <%--  <div class="wrapper"><h2><img src="img/ih3.jpg"/></h2>--%>
            <%--            <div class="pList clearfix tran">--%>
            <div class="proList wrapper clearfix">
                <c:forEach var="p" items="${list}">
                    <li><a href="selectproductview?id=${p.PRODUCT_ID}">
                        <dl>
                            <dt><img src="images/product/${p.PRODUCT_FILENAME }"></dt>
                            <dd>【正品保障】${p.PRODUCT_NAME }</dd>
                            <dd>￥${p.PRODUCT_PRICE }.00</dd>
                        </dl>
                    </a></li>
                </c:forEach>
            </div>
        </div>
    </div>

</div>
<!--返回顶部-->
<div class="gotop"><a href="cart.jsp">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.jsp">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div><!-------------------login--------------------------><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span
                    class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span
                    class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span
                    class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span
                    class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">最家家居&copy;2013-2017公司版权所有 京ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：400-800-8200，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p></div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});</script>
</body>
</html>