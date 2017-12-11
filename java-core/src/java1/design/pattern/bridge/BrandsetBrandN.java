package java1.design.pattern.bridge;

/**
 * @Author zhaojw
 * @Date 2017/12/11 22:21
 *
 * 本类：RefinedAbstraction
 *
 */
public class BrandsetBrandN extends HandsetBrand {

    @Override
    public void run() {
        handsetSoft.run();
    }
}
