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

package com.abomb4.abp.authentication.controller

import com.abomb4.abp.authentication.DemoPermissions
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
open class DemoController {

    @GetMapping("/")
    fun the(model: Model): Map<String, String> {
        model["title"] = "The"
        val map = HashMap<String, String>()
        map.put("the", "the")
        return map
    }

    @GetMapping("/protected/res1")
    @PreAuthorize("hasAuthority('"+DemoPermissions.PROTECTED_RES_1+"')")
    fun res1(model: Model): Map<String, Any> {
        model["title"] = "The"
        val map = HashMap<String, Any>()
        map.put("success", true)
        map.put("message", "You have accessed the protected resource 1!")
        return map
    }

    @GetMapping("/protected/res2")
    @PreAuthorize("hasAuthority('"+DemoPermissions.PROTECTED_RES_2+"')")
    fun res2(model: Model): Map<String, Any> {
        model["title"] = "The"
        val map = HashMap<String, Any>()
        map.put("success", true)
        map.put("message", "You have accessed the protected resource 2!")
        return map
    }
}
