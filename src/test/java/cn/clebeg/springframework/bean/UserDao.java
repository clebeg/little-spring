package cn.clebeg.springframework.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static final Map<String, Integer> userInfo = new HashMap<>();

    static {
        userInfo.put("u1", 18);
        userInfo.put("u2", 20);
        userInfo.put("u3", 22);
    }

    public Integer queryUserAge(String uid) {
        return userInfo.get(uid);
    }
}
