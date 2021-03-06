/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.messaging.simp.user;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class TestSimpUser implements SimpUser {

	private String name;

	private Map<String, SimpSession> sessions = new HashMap<>();


	public TestSimpUser(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Set<SimpSession> getSessions() {
		return new HashSet<>(this.sessions.values());
	}

	@Override
	public boolean hasSessions() {
		return !this.sessions.isEmpty();
	}

	@Override
	public SimpSession getSession(String sessionId) {
		return this.sessions.get(sessionId);
	}

	public void addSessions(TestSimpSession... sessions) {
		for (TestSimpSession session : sessions) {
			session.setUser(this);
			this.sessions.put(session.getId(), session);
		}
	}

}
