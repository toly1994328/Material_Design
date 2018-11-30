##### 零、前言
```
虽然网上已经有了很多Material Design系列的文章,但是动眼和动手是有本质区别的  
虽然有很好的文章，但不太系统，既然要总结Material Design，那就写一个系列吧，可以说`尽吾所能，纳百家之长`  
Material Design本身倒不难，就是有点烦，小东西太多,核心的难点要数`Behavior`了  
心态要放好:要相信Material Design是为了帮助开发者的,而不是谷歌闲着没事弄个东西刁难我们  
所有的代码都我都亲自测试过，文章的语言也尽量用我的话来叙述，大量的动图和图片也是我一个一个截的

属性介绍以xml里为主,代码中动态设置使用`setXXX`即可，如有需要，可自理(多选模式：类名.模式名)
```
so：[项目源码：Github----Android_Material_Design_Test](https://github.com/toly1994328/Android_Material_Design_Test)你看着办吧

---
##### 本系列文章一览：

- [Android材料设计Material Design 开篇前言](https://www.jianshu.com/p/80d187226e57)
- [Android材料设计之ToolBar+CardView+沉浸标题栏](https://www.jianshu.com/p/e930c152fbf2)
- [Android材料设计之FloatingActionButton+Snackbar+SheetX3](https://www.jianshu.com/p/f6a7fc11b2f9)
- [Android材料设计之BottomNavigationBar+TabLayout](https://www.jianshu.com/p/2c3291132b54)
- [Android材料设计之AppBarLayout+CoordinatorLayout](https://www.jianshu.com/p/e930c152fbf2)
- [Android材料设计之CollapsingToolbarLayout+Palette](https://www.jianshu.com/p/3d2103418ce3)
- [Android材料设计之DrawerLayout+NavigationView+TextInputLayout](https://www.jianshu.com/p/2bad5db92ec2)
- [Android材料设计之Behavior攻坚战](https://www.jianshu.com/p/720152b0d230)


---

#### 一、本篇是干嘛的(开场不能low)----`点将台`

##### 1.[ToolBar资料卡片](https://www.jianshu.com/p/e930c152fbf2)：

```
国籍：View
城市：ViewGroup
爱好：招揽小弟、统筹协调
一句话：哥是老大，就座在上面，你不服?
额外依赖：无
```

![toolbar常用属性.png](https://upload-images.jianshu.io/upload_images/9414344-6dae0861ce34f2b7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



---
##### 2.[CardView资料卡片](https://www.jianshu.com/p/e930c152fbf2)：

```
国籍：View
城市：ViewGroup(FrameLayout)
爱好：梳妆打扮，圆角阴影
一句话：姐怎么能这么好看...
额外依赖：implementation 'com.android.support:cardview-v7:27.1.1'
```

![CardView.gif](https://upload-images.jianshu.io/upload_images/9414344-5cb92c24319bc468.gif?imageMogr2/auto-orient/strip)

---

##### 3.[FloatingActionButton资料卡片](https://www.jianshu.com/p/f6a7fc11b2f9)：

```
国籍：View
城市：ImageView
爱好：游离不定、抱大腿、随用随到
一句话：没关系，我小，不碍事
额外依赖：implementation 'com.android.support:design:27.1.1'
```

![fab的属性.png](https://upload-images.jianshu.io/upload_images/9414344-a6de24ab507015d9.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


---

##### 4.[Snackbar资料卡片](https://www.jianshu.com/p/f6a7fc11b2f9)：

```
国籍：非View
城市：BaseTransientBottomBar
爱好：show
一句话：虽然我不是View，但我体内燃烧着View的灵魂(FrameLayout之魂)
额外依赖：implementation 'com.android.support:design:27.1.1'
```

![fab_sna.gif](https://upload-images.jianshu.io/upload_images/9414344-307e27fb88db8504.gif?imageMogr2/auto-orient/strip)


---
##### 5.[bottom_sheet资料卡片](https://www.jianshu.com/p/f6a7fc11b2f9)：

```
国籍：非View
城市：Behavior族
爱好：暗杀、潜藏、show
一句话：哥是迷一样的存在----Behavior族
额外依赖：implementation 'com.android.support:design:27.1.1'
```

![状态监听.gif](https://upload-images.jianshu.io/upload_images/9414344-fbc3412c8f5b3266.gif?imageMogr2/auto-orient/strip)


---

##### 6.[BottomNavigationBar资料卡片](https://www.jianshu.com/p/2c3291132b54)：

```
国籍：View
城市：FrameLayout
爱好：切换状态
一句话：最佳底栏就是我，TabLayout别跟我抢
额外依赖：implementation 'com.ashokvarma.android:bottom-navigation-bar:1.2.0'
```

![颜色.png](https://upload-images.jianshu.io/upload_images/9414344-0da75cd8e2d89f7a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![](https://upload-images.jianshu.io/upload_images/9414344-768ab47badaf8360.gif?imageMogr2/auto-orient/strip) | ![mode_fixed.gif](https://upload-images.jianshu.io/upload_images/9414344-804d7f331f0e6c6f.gif?imageMogr2/auto-orient/strip)
---|---


---

##### 7.[TabLayout资料卡片](https://www.jianshu.com/p/2c3291132b54)：

```
国籍：View
城市：FrameLayout
爱好：切换状态
一句话：老娘上得厨房，下得厅堂
额外依赖：implementation 'com.android.support:design:27.1.1'
```

![tablayout.png](https://upload-images.jianshu.io/upload_images/9414344-6ad19ed15b310f71.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


---

##### 8-1.[AppBarLayout资料卡片](https://www.jianshu.com/p/e930c152fbf2)：

```
国籍：View
城市：ViewGroup(LinearLayout)
爱好：装东西、酷炫
一句话：别绑架我，我不是大佬，Behavior才是...
额外依赖：implementation 'com.android.support:design:27.1.1'
```

##### 8-2.[CoordinatorLayout资料卡片](https://www.jianshu.com/p/e930c152fbf2)：

```
国籍：View
城市：ViewGroup
爱好：军师，调兵遣将
一句话：运筹帷幄之中，决胜千里之外
额外依赖：implementation 'com.android.support:design:27.1.1'
```

![](https://upload-images.jianshu.io/upload_images/9414344-a38bdc0810bdf307.gif?imageMogr2/auto-orient/strip)|![](https://upload-images.jianshu.io/upload_images/9414344-52d184dc98f852e5.gif?imageMogr2/auto-orient/strip)
---|---

---

##### 9.[CollapsingToolbarLayout资料卡片](https://www.jianshu.com/p/3d2103418ce3)：

```
国籍：View
城市：ViewGroup(LinearLayout)
爱好：潮流、碰撞
一句话：AppBarLayout是我哥,ToolBar是我弟，我怕你?
额外依赖：implementation 'com.android.support:design:27.1.1'
```

![CollapsingToolbarLayout1.gif](https://upload-images.jianshu.io/upload_images/9414344-e26f05d617f615bd.gif?imageMogr2/auto-orient/strip) | ![CollapsingToolbarLayout.gif](https://upload-images.jianshu.io/upload_images/9414344-fc9275b3b9d6d788.gif?imageMogr2/auto-orient/strip)
---|---

---

##### 10.[DrawerLayout资料卡片](https://www.jianshu.com/p/2bad5db92ec2)：

```
国籍：View
城市：ViewGroup
爱好：装东西
一句话：孰愿随孤，开疆拓土...
额外依赖：implementation 'com.android.support:design:27.1.1'
```

![DrawerLayout.gif](https://upload-images.jianshu.io/upload_images/9414344-d3a0505e27a03734.gif?imageMogr2/auto-orient/strip)


---

##### 11.[NavigationView资料卡片](https://www.jianshu.com/p/2bad5db92ec2):

```
国籍：View
城市：ViewGroup(FrameLayout)
爱好：装东西
一句话：我就是我，不一样的自我
额外依赖：implementation 'com.android.support:design:27.1.1'
```


![NavigationView.png](https://upload-images.jianshu.io/upload_images/9414344-c8cd00da23f5d3c3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

---
##### 12.[TextInputLayout资料卡片](https://www.jianshu.com/p/2bad5db92ec2)：

```
国籍：View
城市：ViewGroup(LinearLayout)
爱好：装东西
一句话：输入框的最佳神辅助
额外依赖：implementation 'com.android.support:design:27.1.1'
```
![字符个数监听.gif](https://upload-images.jianshu.io/upload_images/9414344-0d440a34066c1ace.gif?imageMogr2/auto-orient/strip)

---

##### 13.[最强战将：Behavior资料卡片](https://www.jianshu.com/p/720152b0d230)

```
国籍：Behavior神秘种族
城市：Behavior神秘领地
爱好：联动
一句话：军师CoordinatorLayout麾下最强战将,没有之一
额外依赖：implementation 'com.android.support:design:27.1.1'
```

![联动.gif](https://upload-images.jianshu.io/upload_images/9414344-3434b5b9ff92a618.gif?imageMogr2/auto-orient/strip)


---
#### 二、资源文件

##### 1.常用颜色一览：

![常用颜色.png](https://upload-images.jianshu.io/upload_images/9414344-9e9f403394d79c11.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##### 2.测试Text样式抽取

```
    <!--测试用的TextView通用属性-->
    <style name="TVTestCenter">
        <item name="android:layout_width">match_parent</item>
        <item name="android:layout_height">100dp</item>
        <item name="android:gravity">center</item>
        <item name="android:textSize">18sp</item>
        <item name="android:text">Test-测试文字</item>
        <item name="android:background">#6096F3</item>
        <item name="android:textColor">#fff</item>
    </style>
```

##### 3.常用尺寸

```
    <dimen name="dp_2">2dp</dimen>
    <dimen name="dp_4">4dp</dimen>
    <dimen name="dp_8">8dp</dimen>
    <dimen name="dp_16">16dp</dimen>
    <dimen name="dp_24">24dp</dimen>
    <dimen name="dp_32">32dp</dimen>
    <dimen name="dp_48">48dp</dimen>
    <dimen name="dp_56">56dp</dimen>
    <dimen name="dp_64">64dp</dimen>
    <dimen name="dp_72">72dp</dimen>
    <dimen name="dp_88">88dp</dimen>
    <dimen name="dp_200">200dp</dimen>

    <dimen name="sp_12">12sp</dimen>
    <dimen name="sp_14">14sp</dimen>
    <dimen name="sp_16">16sp</dimen>
    <dimen name="sp_18">18sp</dimen>

    <dimen name="px_1">1px</dimen>
```

##### 4.资源图标位置：

```
test\src\main\res\drawable
```

##### 5.图片资源位置

```
app\src\main\res\mipmap-xhdpi
```


---


#### 后记：捷文规范

##### 2.更多关于我

笔名 | QQ|微信|爱好
---|---|---|---|
张风捷特烈 | 1981462002|zdl1994328|语言
 [我的github](https://github.com/toly1994328)|[我的简书](https://www.jianshu.com/u/e4e52c116681)|[我的掘金](https://juejin.im/user/5b42c0656fb9a04fe727eb37)|[个人网站](http://www.toly1994.com)

##### 3.声明
>1----本文由张风捷特烈原创,转载请注明  
2----欢迎广大编程爱好者共同交流  
3----个人能力有限，如有不正之处欢迎大家批评指证，必定虚心改正   
4----看到这里，我在此感谢你的喜欢与支持

---

![icon_wx_200.png](https://upload-images.jianshu.io/upload_images/9414344-8a0c95a090041a0d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
