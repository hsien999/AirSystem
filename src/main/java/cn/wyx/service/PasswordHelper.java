package cn.wyx.service;

import cn.wyx.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

/**
 * 自定义密码加密
 *
 * @Author: wyx
 * @Date: 2019/7/2 17:21
 * @Version 1.0
 */
@Component
public class PasswordHelper {

    //实例化RandomNumberGenerator对象，用于生成一个随机数
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    //散列算法名称
    private String algorithmName = "MD5";
    //散列迭代次数
    private int hashInterations = 2;

    public RandomNumberGenerator getRandomNumberGenerator() {
        return randomNumberGenerator;
    }

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public String getAlgorithName() {
        return algorithmName;
    }

    public void setAlgorithName(String algorithName) {
        this.algorithmName = algorithName;
    }

    public int getHashInterations() {
        return hashInterations;
    }

    public void setHashInterations(int hashInterations) {
        this.hashInterations = hashInterations;
    }

    /**
     * 自定义的密码加密算法(MD5(MD5(pass)+salt))
     *
     * @param user
     */
    public void encryptPassword(User user) {
        if (user.getUserPass() != null) {
            //对user对象设置salt盐值,是randomNumberGenerator生成的随机数
            user.setUserSalt(randomNumberGenerator.nextBytes().toHex());

            //调用SimpleHash指定散列算法参数：1、算法名称；2、用户输入的密码；3、盐值（随机生成的）；4、迭代次数
            String newPassword = new SimpleHash(
                    algorithmName,
                    user.getUserPass(),
                    ByteSource.Util.bytes(user.getCredentialsSalt()),
                    hashInterations).toHex();
            System.out.println("newpass = " + newPassword);
            user.setUserPass(newPassword);
        }
    }
}
