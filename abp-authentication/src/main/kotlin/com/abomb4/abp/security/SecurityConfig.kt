/*
 * Copyright 2019 abomb4
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.abomb4.abp.security

import com.abomb4.abp.authentication.DemoPermissions
import com.abomb4.abp.authentication.MyAuthenticationProvider
import com.abomb4.abp.authentication.MyVoter
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.access.AccessDecisionVoter
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.authentication.HttpStatusEntryPoint
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


/**
 *
 * @author yangrl14628 2019-05-14
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
open class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/protected/res1").hasAuthority(DemoPermissions.PROTECTED_RES_1)
                .antMatchers("/protected/res2").hasAuthority(DemoPermissions.PROTECTED_RES_2)
                .anyRequest().denyAll()
//                .accessDecisionManager(accessDecisionManager())
                .and()
            .exceptionHandling()
                .defaultAuthenticationEntryPointFor(getRestAuthenticationEntryPoint(), AntPathRequestMatcher("/*"))
                .and()
            .authenticationProvider(MyAuthenticationProvider())
            .formLogin()
            // .logout().permitAll()
    }

    /**
     * Create an access decision manager, only explicit mark as 'PUBLIC' can accessed by anyone,
     * otherwise deny.
     */
//    @Bean
//    open fun accessDecisionManager(): AccessDecisionManager {
//        val list: List<AccessDecisionVoter<out Any>> = listOf(myVoter())
//        return UnanimousBased(list);
//    }

    @Bean
    open fun myVoter(): AccessDecisionVoter<Any> {
        return MyVoter()
    }

    private fun getRestAuthenticationEntryPoint(): AuthenticationEntryPoint {
        return HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)
    }
}

