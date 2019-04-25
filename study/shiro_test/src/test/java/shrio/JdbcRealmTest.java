package shrio;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;


/**
 * @author ：shizhonghuai
 * @date ：2019/3/10 17:19
 * @description： TODO
 * @modified By：
 * @version: 1.0$
 */
public class JdbcRealmTest {

    DruidDataSource dataSource = new DruidDataSource();
    {
        dataSource.setUrl("jdbc:mysql://localhost:3306/shiro_test");
        dataSource.setUsername("root");
        dataSource.setPassword("");
    }

    @Test
    public void JdbcRealmTest(){


        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);

        String sql = "select password from test_users where username = ?";
        jdbcRealm.setAuthenticationQuery(sql);

        String checkSql = "select test_roles from test_users_roles where test_username = ?";
        jdbcRealm.setUserRolesQuery(checkSql);

        String roleSql = "select test_permissions from test_permissions where test_roles = ?";
        jdbcRealm.setPermissionsQuery(roleSql);


        //获取SecurityManage环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //主体提交请求验证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("hong","654321");

        subject.login(token);

        System.out.println("isAuthenticated::"+subject.isAuthenticated());

        subject.checkRoles("user");

        subject.checkPermission("read");
//        subject.checkPermissions("delete","update");


    }
}
