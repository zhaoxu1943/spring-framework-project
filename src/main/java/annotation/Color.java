package annotation;

import java.lang.annotation.*;

/**
 * "@interface" 声明一个注解
 *
 * @author zhaoxu
 * @className Color
 * @projectName spring-framework-project
 * @date 2021/1/21 9:04
 */
//这个注解只是用来标注生成javadoc的时候是否会被记录,无代码层面作用
@Documented
//保留至运行时,DL需要在运行时进行依赖查找 而不是编译时
//比如那种slf4j的注解(lombok),是source级别的注解,编译完即丢弃
@Retention(RetentionPolicy.RUNTIME)
//target指注解标注的位置,TYPE指,类,接口,枚举
// Class, interface (including annotation type), or enum declaration */
@Target(ElementType.TYPE)
public @interface Color {
}
