## CFG模块使用说明

### CFG模块使用须知

由于是Soot的特性，每次使用CFG模块之后，如果需要再次使用得重新启动该程序。后面会提供cli模式，可以完美解决该问题。

> 尝试过很多方法去解决该问题，可惜目前网上没有解决方法。自己也想过修改内存的方式，可惜目前无法解决。

---



### 界面

![image-20220214154442628](https://cdn.jsdelivr.net/gh/SummerSec/Images/42u4442ec42u4442ec.png)



----

### CFG生成有两种方式



#### 选择类文件

1. 第一步

![image-20220214154747324](https://cdn.jsdelivr.net/gh/SummerSec/Images/47u4747ec47u4747ec.png)

2. 第二步选择class文件

![image-20220214155828749](https://cdn.jsdelivr.net/gh/SummerSec/Images/28u5828ec28u5828ec.png)

3. 第三步点击**Generate**按钮

    如果是命令行启动可以在控制台看到日子信息

    ![image-20220214161721181](https://cdn.jsdelivr.net/gh/SummerSec/Images/21u1721ec21u1721ec.png)

    如果是直接启动的话可以在应用启动目录的**datas/logs/app.log**查看日志信息

4. 第四步，查看CFG，默认是生成所有的方法的CFG图。可以自由调节图片大小。

![image-20220214162844240](https://cdn.jsdelivr.net/gh/SummerSec/Images/44u2844ec44u2844ec.png)

![image-20220214162850306](https://cdn.jsdelivr.net/gh/SummerSec/Images/50u2850ec50u2850ec.png)



---

#### 输入方法内容动态生成类文件进而生成方法的CFG

1. 第一步输入方法内容，但这种方法局限性很大。并不是通用的，通用的是采用类文件的方法。

![image-20220214164359927](https://cdn.jsdelivr.net/gh/SummerSec/Images/59u4359ec59u4359ec.png)

2. 第二步选择**GraphType**，点击**Generate**按钮（选择类文件模式也是一样。前面忘记提了

![image-20220214164633673](https://cdn.jsdelivr.net/gh/SummerSec/Images/33u4633ec33u4633ec.png)

3. 第三步，自动生成CFG图片。

![image-20220214164918798](https://cdn.jsdelivr.net/gh/SummerSec/Images/18u4918ec18u4918ec.png)



---

### 图片保存

1.第一步点击Export Image按钮，选择保存的路径。

![image-20220214165329917](https://cdn.jsdelivr.net/gh/SummerSec/Images/29u5329ec29u5329ec.png)

![image-20220214165401612](https://cdn.jsdelivr.net/gh/SummerSec/Images/1u541ec1u541ec.png)

2. 第二步自动保存路径，并弹出成功信息。

    ![image-20220214165418364](https://cdn.jsdelivr.net/gh/SummerSec/Images/18u5418ec18u5418ec.png)

    3. 查看是否保存成功

    ![image-20220214165510615](https://cdn.jsdelivr.net/gh/SummerSec/Images/10u5510ec10u5510ec.png)



---

### DOT文件保存

同保存图片一样。

![image-20220214165549358](https://cdn.jsdelivr.net/gh/SummerSec/Images/49u5549ec49u5549ec.png)