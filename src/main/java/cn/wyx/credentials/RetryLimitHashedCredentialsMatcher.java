package cn.wyx.credentials;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wyx
 * @Date: 2019/7/2 17:50
 * @Version 1.0
 * <p>
 * 密码重试次数限制
 * HashedCredentialsMatcher只用于密码验证，且可以提供自己的salt，而不是随机生成salt，且生成密码散列值的算法需要自己写.
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    //匹配用户输入的token的凭证（未加密）与系统提供的凭证（已加密）
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String) token.getPrincipal();

        //return count+1
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if (retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        //尝试登陆次数超过5次锁定
        if (retryCount.incrementAndGet() == 5) {
            throw new ExcessiveAttemptsException();
        } else if (retryCount.incrementAndGet() > 5) {
            throw new LockedAccountException();
        }

        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            //clear retry count
            passwordRetryCache.remove(username);
        }

        return matches;
    }
}
