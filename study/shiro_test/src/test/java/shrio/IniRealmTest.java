package shrio;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;


/**
 * @author ：shizhonghuai
 * @date ：2019/3/10 16:48
 * @description： TODO
 * @modified By：
 * @version: 1.0$
 */
public class IniRealmTest {

    @Test
    public void TestIniRealm(){

        IniRealm iniRealm = new IniRealm("classpath:user.ini");

        //构建SecurityManage对象
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);

        //主体提交请求认证
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("huai","123456");

        //登录认证
        subject.login(token);
        System.out.println("login:"+subject.isAuthenticated());

        //角色认证
        subject.checkRole("admin");

        //权限认证
        subject.checkPermission("user:update");

    }


}
