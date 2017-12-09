package java1.design.pattern.decorator;

/**
 * @Author zhaojw
 * @Date 2017/12/9 18:38
 */
public abstract class Finery implements Person{

    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public void show() {
        person.show();
    }
}
