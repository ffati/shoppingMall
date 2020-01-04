package com.example.studyvue.util.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName LoginSecurity
 * @Description TODO
 * @Author ff
 * @Date 2019/12/18 16:13
 * @ModifyDate 2019/12/18 16:13
 * @Version 1.0
 */
@EnableWebSecurity
public class LoginSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private MyAccessDenied myAccessDenied;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);

        http.authorizeRequests()

                .antMatchers("/home/page").permitAll()
                .antMatchers("/shopCart/**").hasRole("ADMIN")
                //.anyRequest().authenticated()
                .and()
                .exceptionHandling()
                /*.accessDeniedHandler(myAccessDenied)//无权限自定义拦截器处理*/
                .accessDeniedPage("/security/accessDenied")//无权限返回页面
                .and()
                .formLogin()
                .usernameParameter("phone").passwordParameter("pnum").loginPage("/login")//自定义参数
                .permitAll()
                .failureUrl("/loginError")
                .and()
                .logout().logoutSuccessUrl("/home/page")
                ;

    }



    // 密码加密方式

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //从数据库校验
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());


/*        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("admin");*/
    }
}
