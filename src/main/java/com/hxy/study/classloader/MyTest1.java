package com.hxy.study.classloader;

/*
    对于静态字段来说，只有直接定义了该字段的类才会被初始化，在该例子中，主动使用了类MyParent1，但是并没有主动使用MyChild1，所以MyChild1不会初始化
    当一个类在初始化时，要求其父类全部都要先进行初始化操作
    -XX:+TraceClassLoading jvm参数，用于追踪类的加载信息并打印出来
 */
public class MyTest1
{
    public static void main(String[] args)
    {
        System.out.println(MyChild1.str);
    }
}

class MyParent1
{
    public static String str = "hello world";

    //静态代码块在jvm加载类的‘初始化’阶段执行
    static
    {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1
{
    public static String str2="welcome";

    static
    {
        System.out.println("MyChild1 static block");
    }
}