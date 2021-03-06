/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.javascript2.editor.hint;

import org.netbeans.modules.csl.api.Rule;
import org.netbeans.modules.javascript2.editor.hints.UndocumentedParameterRule;

/**
 * Checks undocumented parameter.
 *
 * @author Martin Fousek <marfous@netbeans.org>
 */
public class JsUndocumentedParameterTest extends HintTestBase {

    public JsUndocumentedParameterTest(String testName) {
        super(testName);
    }

    private Rule createRule() {
        return new UndocumentedParameterRule();
    }

    public void testNoHintForNoComment() throws Exception {
        checkHints(this, createRule(), "testfiles/hints/undocumentedParameter1.js", null);
    }

    public void testHintForEmptyComment() throws Exception {
        checkHints(this, createRule(), "testfiles/hints/undocumentedParameter2.js", null);
    }

    public void testHintForNotCompletedComment() throws Exception {
        checkHints(this, createRule(), "testfiles/hints/undocumentedParameter3.js", null);
    }
}
