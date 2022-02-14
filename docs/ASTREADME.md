## AST模块使用方法

### 界面

![image-20220214165915431](https://cdn.jsdelivr.net/gh/SummerSec/Images/15u5915ec15u5915ec.png)



---

### 生成AST的两种方式 

#### 选择Java文件

1. 第一步点击**Select File**按钮，选择文件，选择文件先换成Java。

![image-20220214170236867](https://cdn.jsdelivr.net/gh/SummerSec/Images/36u236ec36u236ec.png)

2. 选择目标文件，点击**Generate**按钮。自动生成图片，并单出图片窗口。

![image-20220214170430607](https://cdn.jsdelivr.net/gh/SummerSec/Images/30u430ec30u430ec.png)



----



#### 输入Java内容

1. 输入整个类的内容，点击**Generate**按钮

![image-20220214170623697](https://cdn.jsdelivr.net/gh/SummerSec/Images/23u623ec23u623ec.png)

2. 生成图片，自动弹窗口。

![image-20220214170754621](https://cdn.jsdelivr.net/gh/SummerSec/Images/54u754ec54u754ec.png)





---

### 保存图片

同[CFG模块一致](https://spat.sumsec.me/CFGREADME.html)

![image-20220214171214475](https://cdn.jsdelivr.net/gh/SummerSec/Images/14u1214ec14u1214ec.png)

---

### 保存AST文件

1. 选择保存AST文件类型。

    ![image-20220214171326813](https://cdn.jsdelivr.net/gh/SummerSec/Images/26u1326ec26u1326ec.png)

2. 第二步，点击Save AST File按钮

![image-20220214171359588](https://cdn.jsdelivr.net/gh/SummerSec/Images/59u1359ec59u1359ec.png)

选择保存路径

![image-20220214173006323](https://cdn.jsdelivr.net/gh/SummerSec/Images/6u306ec6u306ec.png)





---

### 测试DEMO代码

**DEMO1**

```java
public class FizzBuzz {

    public void printFizzBuzz(int k){
        if (k%15==0)
            System.out.println("FizzBuzz");
        else if (k%5==0)
            System.out.println("Buzz");
        else if (k%3==0)
            System.out.println("Fizz");
        else
            System.out.println(k);
    }

    public void fizzBuzz(int n){
        for (int i=1; i<=n; i++)
            printFizzBuzz(i);
    }
}

```

DEMO2

```java
public class tmethod637400787345300 {
    public static void main(String[] var0) {
        System.out.println(System.getenv("PATH").toLowerCase().contains("graphviz"));
    }

    public tmethod637400787345300() {
    }
}

```



