/*
 * SuperSlide v2.1.1 
 * 轻松解决网站大部分特效展示问题
 * 详尽信息请看官网：http://www.SuperSlide2.com/
 *
 * Copyright 2011-2013, 大话主席
 *
 * 请尊重原创，保留头部版权
 * 在保留版权的前提下可应用于个人或商业用途

 * v2.1.1：修复当调用多个SuperSlide，并设置returnDefault:true 时返回defaultIndex索引错误

 */
!function (b) {
    b.fn.slide = function (a) {
        return b.fn.slide.defaults = {
            type: "slide",
            effect: "fade",
            autoPlay: !1,
            delayTime: 500,
            interTime: 2500,
            triggerTime: 150,
            defaultIndex: 0,
            titCell: ".hd li",
            mainCell: ".bd",
            targetCell: null,
            trigger: "mouseover",
            scroll: 1,
            vis: 1,
            titOnClassName: "on",
            autoPage: !1,
            prevCell: ".prev",
            nextCell: ".next",
            pageStateCell: ".pageState",
            opp: !1,
            pnLoop: !0,
            easing: "swing",
            startFun: null,
            endFun: null,
            switchLoad: null,
            playStateCell: ".playState",
            mouseOverStop: !0,
            defaultPlay: !0,
            returnDefault: !1
        }, this.each(function () {
            var ag = b.extend({}, b.fn.slide.defaults, a), aj = b(this), am = ag.effect, ap = b(ag.prevCell, aj),
                at = b(ag.nextCell, aj), aw = b(ag.pageStateCell, aj), az = b(ag.playStateCell, aj),
                aC = b(ag.titCell, aj), aF = aC.size(), aI = b(ag.mainCell, aj), aK = aI.children().size(),
                aM = ag.switchLoad, aO = b(ag.targetCell, aj), aQ = parseInt(ag.defaultIndex),
                aS = parseInt(ag.delayTime), aU = parseInt(ag.interTime);
            parseInt(ag.triggerTime);
            var aT, aX = parseInt(ag.scroll), aZ = parseInt(ag.vis),
                a1 = "false" == ag.autoPlay || 0 == ag.autoPlay ? !1 : !0,
                a3 = "false" == ag.opp || 0 == ag.opp ? !1 : !0,
                a5 = "false" == ag.autoPage || 0 == ag.autoPage ? !1 : !0,
                a7 = "false" == ag.pnLoop || 0 == ag.pnLoop ? !1 : !0,
                a9 = "false" == ag.mouseOverStop || 0 == ag.mouseOverStop ? !1 : !0,
                ac = "false" == ag.defaultPlay || 0 == ag.defaultPlay ? !1 : !0,
                ae = "false" == ag.returnDefault || 0 == ag.returnDefault ? !1 : !0, ah = 0, ak = 0, an = 0, aq = 0,
                au = ag.easing, ax = null, aA = null, aD = null, aG = ag.titOnClassName,
                aJ = aC.index(aj.find("." + aG)), aL = aQ = -1 == aJ ? aQ : aJ, aN = aQ, aP = aQ,
                aR = aK >= aZ ? 0 != aK % aX ? aK % aX : aX : 0,
                aV = "leftMarquee" == am || "topMarquee" == am ? !0 : !1, aW = function () {
                    b.isFunction(ag.startFun) && ag.startFun(aQ, aF, aj, b(ag.titCell, aj), aI, aO, ap, at)
                }, aY = function () {
                    b.isFunction(ag.endFun) && ag.endFun(aQ, aF, aj, b(ag.titCell, aj), aI, aO, ap, at)
                }, a0 = function () {
                    aC.removeClass(aG), ac && aC.eq(aN).addClass(aG)
                };
            if ("menu" == ag.type) {
                return ac && aC.removeClass(aG).eq(aQ).addClass(aG), aC.hover(function () {
                    aT = b(this).find(ag.targetCell);
                    var c = aC.index(b(this));
                    aA = setTimeout(function () {
                        switch (aQ = c, aC.removeClass(aG).eq(aQ).addClass(aG), aW(), am) {
                            case"fade":
                                aT.stop(!0, !0).animate({opacity: "show"}, aS, au, aY);
                                break;
                            case"slideDown":
                                aT.stop(!0, !0).animate({height: "show"}, aS, au, aY)
                        }
                    }, ag.triggerTime)
                }, function () {
                    switch (clearTimeout(aA), am) {
                        case"fade":
                            aT.animate({opacity: "hide"}, aS, au);
                            break;
                        case"slideDown":
                            aT.animate({height: "hide"}, aS, au)
                    }
                }), ae && aj.hover(function () {
                    clearTimeout(aD)
                }, function () {
                    aD = setTimeout(a0, aS)
                }), void 0
            }
            if (0 == aF && (aF = aK), aV && (aF = 2), a5) {
                if (aK >= aZ) {
                    if ("leftLoop" == am || "topLoop" == am) {
                        aF = 0 != aK % aX ? (0 ^ aK / aX) + 1 : aK / aX
                    } else {
                        var a2 = aK - aZ;
                        aF = 1 + parseInt(0 != a2 % aX ? a2 / aX + 1 : a2 / aX), 0 >= aF && (aF = 1)
                    }
                } else {
                    aF = 1
                }
                aC.html("");
                var a4 = "";
                if (1 == ag.autoPage || "true" == ag.autoPage) {
                    for (var a6 = 0; aF > a6; a6++) {
                        a4 += "<li>" + (a6 + 1) + "</li>"
                    }
                } else {
                    for (var a6 = 0; aF > a6; a6++) {
                        a4 += ag.autoPage.replace("$", a6 + 1)
                    }
                }
                aC.html(a4);
                var aC = aC.children()
            }
            if (aK >= aZ) {
                aI.children().each(function () {
                    b(this).width() > an && (an = b(this).width(), ak = b(this).outerWidth(!0)), b(this).height() > aq && (aq = b(this).height(), ah = b(this).outerHeight(!0))
                });
                var a8 = aI.children(), ba = function () {
                    for (var c = 0; aZ > c; c++) {
                        a8.eq(c).clone().addClass("clone").appendTo(aI)
                    }
                    for (var c = 0; aR > c; c++) {
                        a8.eq(aK - c - 1).clone().addClass("clone").prependTo(aI)
                    }
                };
                switch (am) {
                    case"fold":
                        aI.css({position: "relative", width: ak, height: ah}).children().css({
                            position: "absolute",
                            width: an,
                            left: 0,
                            top: 0,
                            display: "none"
                        });
                        break;
                    case"top":
                        aI.wrap('<div class="tempWrap" style="overflow:hidden; position:relative; height:' + aZ * ah + 'px"></div>').css({
                            top: -(aQ * aX) * ah,
                            position: "relative",
                            padding: "0",
                            margin: "0"
                        }).children().css({height: aq});
                        break;
                    case"left":
                        aI.wrap('<div class="tempWrap" style="overflow:hidden; position:relative; width:' + aZ * ak + 'px"></div>').css({
                            width: aK * ak,
                            left: -(aQ * aX) * ak,
                            position: "relative",
                            overflow: "hidden",
                            padding: "0",
                            margin: "0"
                        }).children().css({"float": "left", width: an});
                        break;
                    case"leftLoop":
                    case"leftMarquee":
                        ba(), aI.wrap('<div class="tempWrap" style="overflow:hidden; position:relative; width:' + aZ * ak + 'px"></div>').css({
                            width: (aK + aZ + aR) * ak,
                            position: "relative",
                            overflow: "hidden",
                            padding: "0",
                            margin: "0",
                            left: -(aR + aQ * aX) * ak
                        }).children().css({"float": "left", width: an});
                        break;
                    case"topLoop":
                    case"topMarquee":
                        ba(), aI.wrap('<div class="tempWrap" style="overflow:hidden; position:relative; height:' + aZ * ah + 'px"></div>').css({
                            height: (aK + aZ + aR) * ah,
                            position: "relative",
                            padding: "0",
                            margin: "0",
                            top: -(aR + aQ * aX) * ah
                        }).children().css({height: aq})
                }
            }
            var s = function (c) {
                var d = c * aX;
                return c == aF ? d = aK : -1 == c && 0 != aK % aX && (d = -aK % aX), d
            }, aa = function (e) {
                var i = function (f) {
                    for (var g = f; aZ + f > g; g++) {
                        e.eq(g).find("img[" + aM + "]").each(function () {
                            var h = b(this);
                            if (h.attr("src", h.attr(aM)).removeAttr(aM), aI.find(".clone")[0]) {
                                for (var n = aI.children(), o = 0; o < n.size(); o++) {
                                    n.eq(o).find("img[" + aM + "]").each(function () {
                                        b(this).attr(aM) == h.attr("src") && b(this).attr("src", b(this).attr(aM)).removeAttr(aM)
                                    })
                                }
                            }
                        })
                    }
                };
                switch (am) {
                    case"fade":
                    case"fold":
                    case"top":
                    case"left":
                    case"slideDown":
                        i(aQ * aX);
                        break;
                    case"leftLoop":
                    case"topLoop":
                        i(aR + s(aP));
                        break;
                    case"leftMarquee":
                    case"topMarquee":
                        var j = "leftMarquee" == am ? aI.css("left").replace("px", "") : aI.css("top").replace("px", ""),
                            k = "leftMarquee" == am ? ak : ah, l = aR;
                        if (0 != j % k) {
                            var m = Math.abs(0 ^ j / k);
                            l = 1 == aQ ? aR + m : aR + m - 1
                        }
                        i(l)
                }
            }, ad = function (e) {
                if (!ac || aL != aQ || e || aV) {
                    if (aV ? aQ >= 1 ? aQ = 1 : 0 >= aQ && (aQ = 0) : (aP = aQ, aQ >= aF ? aQ = 0 : 0 > aQ && (aQ = aF - 1)), aW(), null != aM && aa(aI.children()), aO[0] && (aT = aO.eq(aQ), null != aM && aa(aO), "slideDown" == am ? (aO.not(aT).stop(!0, !0).slideUp(aS), aT.slideDown(aS, au, function () {
                        aI[0] || aY()
                    })) : (aO.not(aT).stop(!0, !0).hide(), aT.animate({opacity: "show"}, aS, function () {
                        aI[0] || aY()
                    }))), aK >= aZ) {
                        switch (am) {
                            case"fade":
                                aI.children().stop(!0, !0).eq(aQ).animate({opacity: "show"}, aS, au, function () {
                                    aY()
                                }).siblings().hide();
                                break;
                            case"fold":
                                aI.children().stop(!0, !0).eq(aQ).animate({opacity: "show"}, aS, au, function () {
                                    aY()
                                }).siblings().animate({opacity: "hide"}, aS, au);
                                break;
                            case"top":
                                aI.stop(!0, !1).animate({top: -aQ * aX * ah}, aS, au, function () {
                                    aY()
                                });
                                break;
                            case"left":
                                aI.stop(!0, !1).animate({left: -aQ * aX * ak}, aS, au, function () {
                                    aY()
                                });
                                break;
                            case"leftLoop":
                                var f = aP;
                                aI.stop(!0, !0).animate({left: -(s(aP) + aR) * ak}, aS, au, function () {
                                    -1 >= f ? aI.css("left", -(aR + (aF - 1) * aX) * ak) : f >= aF && aI.css("left", -aR * ak), aY()
                                });
                                break;
                            case"topLoop":
                                var f = aP;
                                aI.stop(!0, !0).animate({top: -(s(aP) + aR) * ah}, aS, au, function () {
                                    -1 >= f ? aI.css("top", -(aR + (aF - 1) * aX) * ah) : f >= aF && aI.css("top", -aR * ah), aY()
                                });
                                break;
                            case"leftMarquee":
                                var g = aI.css("left").replace("px", "");
                                0 == aQ ? aI.animate({left: ++g}, 0, function () {
                                    aI.css("left").replace("px", "") >= 0 && aI.css("left", -aK * ak)
                                }) : aI.animate({left: --g}, 0, function () {
                                    aI.css("left").replace("px", "") <= -(aK + aR) * ak && aI.css("left", -aR * ak)
                                });
                                break;
                            case"topMarquee":
                                var h = aI.css("top").replace("px", "");
                                0 == aQ ? aI.animate({top: ++h}, 0, function () {
                                    aI.css("top").replace("px", "") >= 0 && aI.css("top", -aK * ah)
                                }) : aI.animate({top: --h}, 0, function () {
                                    aI.css("top").replace("px", "") <= -(aK + aR) * ah && aI.css("top", -aR * ah)
                                })
                        }
                    }
                    aC.removeClass(aG).eq(aQ).addClass(aG), aL = aQ, a7 || (at.removeClass("nextStop"), ap.removeClass("prevStop"), 0 == aQ && ap.addClass("prevStop"), aQ == aF - 1 && at.addClass("nextStop")), aw.html("<span>" + (aQ + 1) + "</span>/" + aF)
                }
            };
            ac && ad(!0), ae && aj.hover(function () {
                clearTimeout(aD)
            }, function () {
                aD = setTimeout(function () {
                    aQ = aN, ac ? ad() : "slideDown" == am ? aT.slideUp(aS, a0) : aT.animate({opacity: "hide"}, aS, a0), aL = aQ
                }, 300)
            });
            var af = function (c) {
                ax = setInterval(function () {
                    a3 ? aQ-- : aQ++, ad()
                }, c ? c : aU)
            }, ai = function (c) {
                ax = setInterval(ad, c ? c : aU)
            }, al = function () {
                a9 || (clearInterval(ax), af())
            }, ao = function () {
                (a7 || aQ != aF - 1) && (aQ++, ad(), aV || al())
            }, ar = function () {
                (a7 || 0 != aQ) && (aQ--, ad(), aV || al())
            }, av = function () {
                clearInterval(ax), aV ? ai() : af(), az.removeClass("pauseState")
            }, ay = function () {
                clearInterval(ax), az.addClass("pauseState")
            };
            if (a1 ? aV ? (a3 ? aQ-- : aQ++, ai(), a9 && aI.hover(ay, av)) : (af(), a9 && aj.hover(ay, av)) : (aV && (a3 ? aQ-- : aQ++), az.addClass("pauseState")), az.click(function () {
                az.hasClass("pauseState") ? av() : ay()
            }), "mouseover" == ag.trigger ? aC.hover(function () {
                var c = aC.index(this);
                aA = setTimeout(function () {
                    aQ = c, ad(), al()
                }, ag.triggerTime)
            }, function () {
                clearTimeout(aA)
            }) : aC.click(function () {
                aQ = aC.index(this), ad(), al()
            }), aV) {
                if (at.mousedown(ao), ap.mousedown(ar), a7) {
                    var aB, aE = function () {
                        aB = setTimeout(function () {
                            clearInterval(ax), ai(0 ^ aU / 10)
                        }, 150)
                    }, aH = function () {
                        clearTimeout(aB), clearInterval(ax), ai()
                    };
                    at.mousedown(aE), at.mouseup(aH), ap.mousedown(aE), ap.mouseup(aH)
                }
                "mouseover" == ag.trigger && (at.hover(ao, function () {
                }), ap.hover(ar, function () {
                }))
            } else {
                at.click(ao), ap.click(ar)
            }
        })
    }
}(jQuery), jQuery.easing.jswing = jQuery.easing.swing, jQuery.extend(jQuery.easing, {
    def: "easeOutQuad", swing: function (f, g, h, i, j) {
        return jQuery.easing[jQuery.easing.def](f, g, h, i, j)
    }, easeInQuad: function (f, g, h, i, j) {
        return i * (g /= j) * g + h
    }, easeOutQuad: function (f, g, h, i, j) {
        return -i * (g /= j) * (g - 2) + h
    }, easeInOutQuad: function (f, g, h, i, j) {
        return (g /= j / 2) < 1 ? i / 2 * g * g + h : -i / 2 * (--g * (g - 2) - 1) + h
    }, easeInCubic: function (f, g, h, i, j) {
        return i * (g /= j) * g * g + h
    }, easeOutCubic: function (f, g, h, i, j) {
        return i * ((g = g / j - 1) * g * g + 1) + h
    }, easeInOutCubic: function (f, g, h, i, j) {
        return (g /= j / 2) < 1 ? i / 2 * g * g * g + h : i / 2 * ((g -= 2) * g * g + 2) + h
    }, easeInQuart: function (f, g, h, i, j) {
        return i * (g /= j) * g * g * g + h
    }, easeOutQuart: function (f, g, h, i, j) {
        return -i * ((g = g / j - 1) * g * g * g - 1) + h
    }, easeInOutQuart: function (f, g, h, i, j) {
        return (g /= j / 2) < 1 ? i / 2 * g * g * g * g + h : -i / 2 * ((g -= 2) * g * g * g - 2) + h
    }, easeInQuint: function (f, g, h, i, j) {
        return i * (g /= j) * g * g * g * g + h
    }, easeOutQuint: function (f, g, h, i, j) {
        return i * ((g = g / j - 1) * g * g * g * g + 1) + h
    }, easeInOutQuint: function (f, g, h, i, j) {
        return (g /= j / 2) < 1 ? i / 2 * g * g * g * g * g + h : i / 2 * ((g -= 2) * g * g * g * g + 2) + h
    }, easeInSine: function (f, g, h, i, j) {
        return -i * Math.cos(g / j * (Math.PI / 2)) + i + h
    }, easeOutSine: function (f, g, h, i, j) {
        return i * Math.sin(g / j * (Math.PI / 2)) + h
    }, easeInOutSine: function (f, g, h, i, j) {
        return -i / 2 * (Math.cos(Math.PI * g / j) - 1) + h
    }, easeInExpo: function (f, g, h, i, j) {
        return 0 == g ? h : i * Math.pow(2, 10 * (g / j - 1)) + h
    }, easeOutExpo: function (f, g, h, i, j) {
        return g == j ? h + i : i * (-Math.pow(2, -10 * g / j) + 1) + h
    }, easeInOutExpo: function (f, g, h, i, j) {
        return 0 == g ? h : g == j ? h + i : (g /= j / 2) < 1 ? i / 2 * Math.pow(2, 10 * (g - 1)) + h : i / 2 * (-Math.pow(2, -10 * --g) + 2) + h
    }, easeInCirc: function (f, g, h, i, j) {
        return -i * (Math.sqrt(1 - (g /= j) * g) - 1) + h
    }, easeOutCirc: function (f, g, h, i, j) {
        return i * Math.sqrt(1 - (g = g / j - 1) * g) + h
    }, easeInOutCirc: function (f, g, h, i, j) {
        return (g /= j / 2) < 1 ? -i / 2 * (Math.sqrt(1 - g * g) - 1) + h : i / 2 * (Math.sqrt(1 - (g -= 2) * g) + 1) + h
    }, easeInElastic: function (i, j, k, l, m) {
        var n = 1.70158, o = 0, p = l;
        if (0 == j) {
            return k
        }
        if (1 == (j /= m)) {
            return k + l
        }
        if (o || (o = 0.3 * m), p < Math.abs(l)) {
            p = l;
            var n = o / 4
        } else {
            var n = o / (2 * Math.PI) * Math.asin(l / p)
        }
        return -(p * Math.pow(2, 10 * (j -= 1)) * Math.sin((j * m - n) * 2 * Math.PI / o)) + k
    }, easeOutElastic: function (i, j, k, l, m) {
        var n = 1.70158, o = 0, p = l;
        if (0 == j) {
            return k
        }
        if (1 == (j /= m)) {
            return k + l
        }
        if (o || (o = 0.3 * m), p < Math.abs(l)) {
            p = l;
            var n = o / 4
        } else {
            var n = o / (2 * Math.PI) * Math.asin(l / p)
        }
        return p * Math.pow(2, -10 * j) * Math.sin((j * m - n) * 2 * Math.PI / o) + l + k
    }, easeInOutElastic: function (i, j, k, l, m) {
        var n = 1.70158, o = 0, p = l;
        if (0 == j) {
            return k
        }
        if (2 == (j /= m / 2)) {
            return k + l
        }
        if (o || (o = m * 0.3 * 1.5), p < Math.abs(l)) {
            p = l;
            var n = o / 4
        } else {
            var n = o / (2 * Math.PI) * Math.asin(l / p)
        }
        return 1 > j ? -0.5 * p * Math.pow(2, 10 * (j -= 1)) * Math.sin((j * m - n) * 2 * Math.PI / o) + k : 0.5 * p * Math.pow(2, -10 * (j -= 1)) * Math.sin((j * m - n) * 2 * Math.PI / o) + l + k
    }, easeInBack: function (g, h, i, j, k, l) {
        return void 0 == l && (l = 1.70158), j * (h /= k) * h * ((l + 1) * h - l) + i
    }, easeOutBack: function (g, h, i, j, k, l) {
        return void 0 == l && (l = 1.70158), j * ((h = h / k - 1) * h * ((l + 1) * h + l) + 1) + i
    }, easeInOutBack: function (g, h, i, j, k, l) {
        return void 0 == l && (l = 1.70158), (h /= k / 2) < 1 ? j / 2 * h * h * (((l *= 1.525) + 1) * h - l) + i : j / 2 * ((h -= 2) * h * (((l *= 1.525) + 1) * h + l) + 2) + i
    }, easeInBounce: function (f, g, h, i, j) {
        return i - jQuery.easing.easeOutBounce(f, j - g, 0, i, j) + h
    }, easeOutBounce: function (f, g, h, i, j) {
        return (g /= j) < 1 / 2.75 ? i * 7.5625 * g * g + h : 2 / 2.75 > g ? i * (7.5625 * (g -= 1.5 / 2.75) * g + 0.75) + h : 2.5 / 2.75 > g ? i * (7.5625 * (g -= 2.25 / 2.75) * g + 0.9375) + h : i * (7.5625 * (g -= 2.625 / 2.75) * g + 0.984375) + h
    }, easeInOutBounce: function (f, g, h, i, j) {
        return j / 2 > g ? 0.5 * jQuery.easing.easeInBounce(f, 2 * g, 0, i, j) + h : 0.5 * jQuery.easing.easeOutBounce(f, 2 * g - j, 0, i, j) + 0.5 * i + h
    }
});