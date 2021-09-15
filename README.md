# little-spring: 从0到1手写 spring 框架精髓

little-spring 是一个手动一点一点代码实现的迷你版本的 spring 框架，目前实现的功能有：

1. 自动从 xml 配置文件注册 bean
2. 支持从classpath、文件系统、URL加载配置文件
3. 支持 bean 的属性自动注入
4. 支持 bean 的构造函数自动初始化：反射机制、Cglib机制
5. 支持 bean 的定义