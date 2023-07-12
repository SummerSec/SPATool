
<h1 align="center" >SPATool</h1>
<h3 align="center" >静态程序分析工具 主要生成方法的CFG和.java文件的AST</h3>
 <p align="center">
    <a href="https://github.com/SummerSec/SPATool"></a>
    <a href="https://github.com/SummerSec/SPATool"><img alt="template" src="https://img.shields.io/badge/SPATool-green"></a>
    <a href="https://github.com/SummerSec/SPATool"><img alt="Forks" src="https://img.shields.io/github/forks/SummerSec/SPATool"></a>
     <a href="https://github.com/SummerSec/SPATool"><img alt="Release" src="https://img.shields.io/github/release/SummerSec/SPATool.svg"></a>
  <a href="https://github.com/SummerSec/SPATool"><img alt="Stars" src="https://img.shields.io/github/stars/SummerSec/SPATool.svg?style=social&label=Stars"></a>
     <a href="https://github.com/SummerSec"><img alt="Follower" src="https://img.shields.io/github/followers/SummerSec.svg?style=social&label=Follow"></a>
     <a href="https://github.com/SummerSec"><img alt="Visitor" src="https://visitor-badge.laobi.icu/badge?page_id=SummerSec.SPATool"></a>
	<a href="https://twitter.com/SecSummers"><img alt="SecSummers" src="https://img.shields.io/twitter/follow/SecSummers.svg"></a>
	<a xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://visitor-badge.laobi.icu"><rect fill="rgba(0,0,0,0)" height="20" width="49.6"/></a>
	<a xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://visitor-badge.laobi.icu"><rect fill="rgba(0,0,0,0)" height="20" width="17.0" x="49.6"/></a>
	</p>
  

## 📝 TODO

- [ ] Class文件生成IR
- [ ] IR文件生成CFG
- [ ] 命令行模式

---
## 🐉 来龙去脉

未来这段时间可能会在静态分析领域上继续研究，这是但新手小白会面对**CFG**（Control-Flow-Graph控制流图）和**AST**（Abstract Syntax Tree抽象语法树）怎么看都不知道的问题，导致无从下手。以此这是这款工具诞生的契机，目前工具使用的是Soot生成CFG，使用JavaParser生成AST。



---
## ⚡下载安装

* 第一步必须下载安装[Graphviz](https://graphviz.org/download/)，并配置环境变量。

​	下载地址：[https://graphviz.org/download/](https://graphviz.org/download/)，参考配置如下。

![image-20220214201824399](https://img.sumsec.me/24u1824ec24u1824ec.png)

> 检测是否配置成功，执行命令`dot -h`

![image-20220214201909412](https://img.sumsec.me/9u199ec9u199ec.png)

* GitHub Release 下载

    [https://github.com/SummerSec/SPATool/releases](https://github.com/SummerSec/SPATool/releases)

* CDN历史版本下载页面

    [https://spat.sumsec.me/version.html](https://spat.sumsec.me/version.html)



---
## 🎬 使用方法

**效果页面**

![image-20220214154214904](https://img.sumsec.me/22u4222ec22u4222ec.png)

**GUI使用说明**

* [AST模块使用说明](https://spat.sumsec.me/ASTREADME.html)

* [CFG模块使用说明](https://spat.sumsec.me/CFGREADME.html)

**Cli使用说明**

* [CLIREADME](CLIREADME.md)





----




## 🅱️ 免责声明

该工具仅用于安全自查检测

由于传播、利用此工具所提供的信息而造成的任何直接或者间接的后果及损失，均由使用者本人负责，作者不为此承担任何责任。

本人拥有对此工具的修改和解释权。未经网络安全部门及相关部门允许，不得善自使用本工具进行任何攻击活动，不得以任何方式将其用于商业目的。

该工具只授权于企业内部进行问题排查，请勿用于非法用途，请遵守网络安全法，否则后果作者概不负责

----

![as](https://starchart.cc/SummerSec/SPATool.svg)
