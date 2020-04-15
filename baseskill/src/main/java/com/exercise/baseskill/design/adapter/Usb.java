package com.exercise.baseskill.design.adapter;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/15 0015 19:06
 * @Description :
 */
public interface Usb {
    void isUsb();
}

interface Ps2{
    void isPs2();
}

class Usber implements Usb{

    @Override
    public void isUsb() {
        System.out.println("USB口");
    }
}


//======================对象适配器
class UsbObjectAdapter extends Usber implements Ps2{
    private Usber usb;
    public UsbObjectAdapter(Usber usber) {
        this.usb = usber;
    }
    @Override
    public void isPs2() {
        super.isUsb();
    }
}

class TestAdapter{
    public static void main(String[] args) {
        Usber usber = new Usber();
        Ps2 ps2 = new UsbObjectAdapter(usber);
        ps2.isPs2();
    }
}

//===================类适配器
//class UsbAdapter extends Usber implements Ps2{
//    @Override
//    public void isPs2() {
//        super.isUsb();
//    }
//}
//
//class TestAdapter{
//    public static void main(String[] args) {
//        Ps2 ps2 = new UsbAdapter();
//        ps2.isPs2();
//    }
//}