package java1.design.pattern.bridge;

/**
 * @Author zhaojw
 * @Date 2017/12/11 22:19
 *
 * 本类：；Abstraction
 *
 */
public abstract class HandsetBrand {
    //手机软件类
    protected HandsetSoft handsetSoft;

    /**
     * 品牌需要关注软件。所以可在机器中安装软件（即设置手机软件），以备运行
     *
     * 手机品牌与手机软件是聚合关系，手机品牌包含手机软件，
     *
     * @param handsetSoft
     */
    public void setHandsetSoft(HandsetSoft handsetSoft) {
        this.handsetSoft = handsetSoft;
    }

    public  abstract void run();
}
