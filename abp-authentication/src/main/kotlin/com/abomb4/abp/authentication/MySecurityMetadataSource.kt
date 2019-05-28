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

import org.springframework.security.access.ConfigAttribute
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource
import org.springframework.security.web.util.matcher.RequestMatcher
import java.util.*

/**
 * Custom [org.springframework.security.access.ConfigAttribute] provider
 *
 * @author yangrl14628 2019-05-27
 */
open class MySecurityMetadataSource(val requestMap: LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>)
    : DefaultFilterInvocationSecurityMetadataSource(requestMap) {

    override fun getAttributes(obj: Any?): MutableCollection<ConfigAttribute> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
