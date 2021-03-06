// Copyright (c) 2009 The Chromium Authors. All rights reserved.
// This program and the accompanying materials are made available
// under the terms of the Eclipse Public License v1.0 which accompanies
// this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html

package org.chromium.sdk.internal.v8native.protocol.output;

import org.chromium.sdk.internal.v8native.DebuggerCommand;

/**
 * Represents a "backtrace" V8 request message.
 */
public class BacktraceMessage extends DebuggerMessage {

  /**
   * @param fromFrame nullable frame range start (0 by default)
   * @param toFrame nullable frame range end (last frame by default)
   * @param inlineRefs whether to inline object refs
   */
  public BacktraceMessage(Integer fromFrame, Integer toFrame, boolean inlineRefs) {
    super(DebuggerCommand.BACKTRACE.value);
    putArgument("fromFrame", fromFrame);
    putArgument("toFrame", toFrame);
    if (inlineRefs) {
      putArgument("inlineRefs", inlineRefs);
    }
  }
}
