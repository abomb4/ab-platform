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

import org.springframework.security.access.AccessDecisionVoter
import org.springframework.security.access.ConfigAttribute
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority

open class MyVoter : AccessDecisionVoter<Any> {

    override fun supports(attribute: ConfigAttribute): Boolean {
        return true
    }
    override fun supports(clazz: Class<*>): Boolean {
        return true
    }

    override fun vote(authentication: Authentication?, `object`: Any, attributes: Collection<ConfigAttribute>): Int {
        if (authentication == null) {
            return AccessDecisionVoter.ACCESS_DENIED
        }
        var result = AccessDecisionVoter.ACCESS_ABSTAIN
        val authorities = extractAuthorities(authentication)

        for (attribute in attributes) {
            if (this.supports(attribute)) {
                result = AccessDecisionVoter.ACCESS_DENIED

                // Attempt to find a matching granted authority
                for (authority in authorities) {
                    if (attribute.attribute == authority.authority) {
                        return AccessDecisionVoter.ACCESS_GRANTED
                    }
                }
            }
        }

        return result
    }

    internal open fun extractAuthorities(authentication: Authentication): Collection<GrantedAuthority> {
        return authentication.getAuthorities()
    }
}
