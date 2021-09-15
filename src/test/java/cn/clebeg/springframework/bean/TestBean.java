package cn.clebeg.springframework.bean;

public class TestBean {
    private String name;
    private int age;
    private String hobby;

    private UserDao userDao;

    public TestBean() {
    }

    public TestBean(String name) {
        this.name = name;
    }

    public TestBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.printf("hello, every one, my name is %s, my age is %d, you hobby is %s\n", name, age, hobby);
    }

    public Integer queryUserAge() {
       return userDao.queryUserAge(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
