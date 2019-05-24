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

package com.abomb4.abp.authentication

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.util.*

/**
 *
 * @author yangrl14628 2019-05-21
 */
class MyAuthenticationProvider : AuthenticationProvider {
    @Throws(AuthenticationException::class)
    override fun authenticate(authentication: Authentication): Authentication? {
        val name = authentication.principal.toString()
        val password = authentication.credentials.toString()

        // 利用alex用户名登录，不管密码是什么都可以，伪装成admin用户
        if (name == "alex") {
            val authorityCollection = ArrayList<GrantedAuthority>()
            authorityCollection.add(SimpleGrantedAuthority(DemoPermissions.PROTECTED_RES_1))
            return UsernamePasswordAuthenticationToken("admin", password, authorityCollection)
        } else {
            return null
        }
    }

    override fun supports(authentication: Class<*>): Boolean {
        return authentication == UsernamePasswordAuthenticationToken::class.java
    }
}
