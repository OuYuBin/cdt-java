// Copyright (c) 2011 The Chromium Authors. All rights reserved.
// This program and the accompanying materials are made available
// under the terms of the Eclipse Public License v1.0 which accompanies
// this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html

package org.chromium.sdk.internal.wip.protocol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.chromium.sdk.internal.protocolparser.JsonProtocolModelParseException;
import org.chromium.sdk.internal.protocolparser.dynamicimpl.DynamicParserImpl;
import org.chromium.sdk.internal.wip.protocol.input.GeneratedParserInterfaceList;
import org.chromium.sdk.internal.wip.protocol.input.WipCommandResponse;
import org.chromium.sdk.internal.wip.protocol.input.WipEvent;
import org.chromium.sdk.internal.wip.protocol.input.WipProtocolParser;
import org.chromium.sdk.internal.wip.protocol.input.WipTabList;

/**
 * A dynamic implementation of a WebInspector protocol parser.
 */
public class WipDynamicParser {
  public static DynamicParserImpl<WipProtocolParser> create() {
    Class<?>[] baseTypes = {
        WipEvent.class, WipEvent.Data.class,
        WipCommandResponse.class, WipCommandResponse.Data.class,
        WipCommandResponse.Success.class, WipCommandResponse.Error.class,
        WipCommandResponse.Error.ErrorInfo.class,

        // Tab list protocol interfaces.
        WipTabList.class, WipTabList.TabDescription.class
    };
    Class<?>[] generatedTypes = GeneratedParserInterfaceList.LIST;

    List<Class<?>> classList = new ArrayList<Class<?>>();
    classList.addAll(Arrays.asList(baseTypes));
    classList.addAll(Arrays.asList(generatedTypes));
    try {
      return new DynamicParserImpl<WipProtocolParser>(WipProtocolParser.class, classList,
          Collections.<DynamicParserImpl<?>>emptyList(), true);
    } catch (JsonProtocolModelParseException e) {
      throw new RuntimeException(e);
    }
  }
}
