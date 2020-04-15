package com.exercise.baseskill.design.proxy.staticproxy;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 18:26
 * @Description : 静态代理
 */
// 接口
public interface IStar {
    void show();
}

// 真实对象
class YangMi implements IStar{

    @Override
    public void show() {
        System.out.println("杨幂表演");
    }
}

// 代理类需要有真实对象的控制权 (引用)
class ProxyManager implements IStar{

    private IStar star;

    public ProxyManager(IStar star) {
        this.star = star;
    }

    @Override
    public void show() {
        System.out.println("代理人安排演出地点");
        star.show();
        System.out.println("代理人收演出费用");
    }
}

class TestStaticProxy{
    public static void main(String[] args) {
        IStar star = new YangMi();
        ProxyManager proxyManager = new ProxyManager(star);
        proxyManager.show();
    }
}

