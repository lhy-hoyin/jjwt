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
package io.jsonwebtoken.impl.security

import io.jsonwebtoken.security.MalformedKeyException
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.fail

class EcPrivateJwkFactoryTest {

    @Test
    void testDMissing() {
        def values = ['kty': 'EC', 'crv': 'P-256', 'x': BigInteger.ONE, 'y': BigInteger.ONE]
        try {
            def ctx = new DefaultJwkContext(DefaultEcPrivateJwk.FIELDS)
            ctx.putAll(values)
            new EcPrivateJwkFactory().createJwkFromValues(ctx)
            fail()
        } catch (MalformedKeyException expected) {
            String msg = "EC JWK is missing required 'd' (ECC Private Key) value."
            assertEquals msg, expected.getMessage()
        }
    }
}
