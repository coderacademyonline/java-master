package java1.design.pattern.proxy.staticproxy;

/**
 * @Author zhaojw
 * @Date 2017/12/9 20:48
 *
 * 被追求者
 *
 */
public class SchoolGirl {

    private String name;

    public SchoolGirl(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
