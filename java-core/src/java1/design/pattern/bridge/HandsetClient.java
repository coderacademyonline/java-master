package java1.design.pattern.bridge;

/**
 * @Author zhaojw
 * @Date 2017/12/11 22:23
 */
public class HandsetClient {

    public static void main(String[] args){
        HandsetBrand brand=null;
        brand=new BrandsetBrandN();
        brand.setHandsetSoft(new HandsetGame());
        brand.run();
        brand.setHandsetSoft(new HandsetAddressList());
        brand.run();

        brand=new BrandsetBrandM();
        brand.setHandsetSoft(new HandsetAddressList());
        brand.run();
        brand.setHandsetSoft(new HandsetGame());
        brand.run();
    }
}
