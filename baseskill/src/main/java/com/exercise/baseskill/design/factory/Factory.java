package com.exercise.baseskill.design.factory;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 18:02
 * @Description : 工厂方法模式
 * 相比简单工厂的优点:
 *   更符合开-闭原则
 *   符合单一职责原则
 *   不使用静态工厂方法，可以形成基于继承的等级结构
 *   参考文档：https://blog.csdn.net/weixin_40834464/article/details/82958187?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-23&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-23
 */
abstract class Factory{
    public abstract Product Manufacture();

    public static void main(String[] args) {
        //客户要产品A
        FactoryA mFactoryA = new FactoryA();
        mFactoryA.Manufacture().Show();

        //客户要产品B
        FactoryB mFactoryB = new FactoryB();
        mFactoryB.Manufacture().Show();

        //客户要产品C
        FactoryC factoryC = new FactoryC();
        factoryC.Manufacture().Show();
    }
}


class FactoryA extends Factory {

    @Override
    public Product Manufacture() {
        return new ProductA();
    }
}

class FactoryB extends Factory {

    @Override
    public Product Manufacture() {
        return new ProductB();
    }
}

abstract class Product{
    public abstract void Show();
}

class ProductA extends  Product {

    //具体产品A类
    @Override
    public void Show() {
        System.out.println("生产出了产品A");
    }
}

class ProductB extends Product {

    //具体产品B类
    @Override
    public void Show() {
        System.out.println("生产出了产品B");
    }
}

class FactoryC extends Factory{
    @Override
    public Product Manufacture() {
        return new ProductC();
    }
}

class ProductC extends Product{
    @Override
    public void Show() {
        System.out.println("生产出了产品C");
    }
}