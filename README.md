# 日常学习记录

> java相关日常学习记录，包含一些java版本新特性，算法题实现，通过java的写一些数据结构，以及多线程相关实践。

### algorithm 算法相关题

- HappyNumber 判断是否为快乐数字
- Sort 两种快速排序的实现
- lru实现
  - LRUMap 基于双向链表实现
  - LRULinkedMap 基于LinkedHashMap重写removeEldestEntry的实现

### aop 动态代理实现原理

- dynamicproxy 基于jdk实现动态代理
- staticproxy 一个静态代理

### classload 自定义实现类加载器

### datastructure 数据结构

- 栈的实现
  - TableStack 基于数组实现栈
- 链表的实现
  - BothWayLinkedList 双向链表
  - DoublePointLinkedList 双端链表
  - OrderLinkedList 有序的链表
  - SingleLinkedList 单向链表

### java7test java7相关新特性demo

### java8test java8相关新特性demo

- 新时间类 LocalDate LocalDateTime LocalTime 
- 自定义实现获取下一个工作日的日期

### NIO 手写NIO server

### reflect 反射demo

- 基于反射实现序列化，反序列化

### thread 线程相关代码demo

- DealLock 实现一个死锁
- SynchronizedDemo synchronized使用形式
- ThreadNoLockPrintOddEvenNumber 无锁实现交替打印基偶数
- ThreadNotifyPrintOddEvenNumber 利用线程间通讯来打印奇偶数
- TwoThreadPrintOddEvenNumber 两个线程交替打印奇偶数
- ThreadStatus 线程的各种状态测试