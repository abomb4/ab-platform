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

package com.abomb4.abp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer

/**
 *
 * @author yangrl14628 2019-05-14
 */
@SpringBootApplication
@EnableResourceServer
@ComponentScan("com.abomb4.abp")
open class UserServiceMain

fun main(args: Array<String>) {
    runApplication<UserServiceMain>(*args)
}
