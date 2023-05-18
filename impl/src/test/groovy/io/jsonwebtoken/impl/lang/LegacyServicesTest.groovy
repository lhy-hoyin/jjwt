/*
 * Copyright (C) 2021 jsonwebtoken.io
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
package io.jsonwebtoken.impl.lang

import io.jsonwebtoken.lang.UnknownClassException
import org.junit.Test

class LegacyServicesTest {

    @Test(expected = UnknownClassException)
    void serviceNotFoundTest() {
        // try to load a class that will NOT have any services, i.e. this test class.
        LegacyServices.loadFirst(LegacyServicesTest)
    }
}
