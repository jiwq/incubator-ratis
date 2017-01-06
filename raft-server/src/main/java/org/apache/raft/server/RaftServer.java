/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.raft.server;

import org.apache.raft.protocol.RaftClientAsynchronousProtocol;
import org.apache.raft.protocol.RaftClientProtocol;
import org.apache.raft.server.protocol.RaftServerProtocol;
import org.apache.raft.statemachine.StateMachine;

import java.io.Closeable;

/** Raft server interface */
public interface RaftServer extends Closeable, RaftServerProtocol,
    RaftClientProtocol, RaftClientAsynchronousProtocol {
  /** @return the server ID. */
  String getId();

  /** Set server RPC service. */
  void setServerRpc(RaftServerRpc serverRpc);

  /** Start this server. */
  void start();

  /**
   * Returns the StateMachine instance.
   * @return the StateMachine instance.
   */
  StateMachine getStateMachine();
}
