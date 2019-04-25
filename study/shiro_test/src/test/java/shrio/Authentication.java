package shrio;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ：shizhonghuai
 * @date ：Created in 2019/3/10 16:20
 * @description：AuthenticationTest
 * @modified By：
 * @version: $
 */
public class Authentication {


    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void setUser(){
        simpleAccountRealm.addAccount("huai","23333");
    }

    /**
     * create by: shizhonghuai
     * description: TODO
     * create time: 2019/3/10 13:36
     *
     * @return
     */
    @Test
    public void TestAuthentication(){

        //构建SecurityManage对象
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //主体提交请求认证
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("huai","23333");
        subject.login(token);

        System.out.println("login:"+subject.isAuthenticated());

        subject.logout();

        System.out.println("logout:"+subject.isAuthenticated());


    }
}
