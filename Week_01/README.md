学习笔记

一、查缺补漏：

未掌握的数据结构：链表

未掌握的算法：递归

目前对这两个难点的理解：

链表：需要多写多练，掌握套路，比如交换链表的两个结点的代码，要记住；环形链表，通过快慢指针来解题

递归：写递归的三个要点（网上看的）：1.明确递归函数的功能；2.找出递归结束的条件，如爬楼梯这个题目，递归结束的条件是n <= 2；3.找出函数的等价关系式，如

int f(int n){
    // 1.先写递归结束条件
    if(n <= 2){
        return 1;
    }
    // 2.接着写等价关系式
    return f(n-1) + f(n - 2);
}
后续用这个方法继续练习

二、解题思路

拿到题目，懵逼的时候：
1.暴力解法
2.找最近重复子问题（大部分都是for while循环，这个方法感觉很有用！）

三、优化算法的思维

1.升维度
2.空间换时间

四、刷题方法

不要死磕，过遍数更重要！