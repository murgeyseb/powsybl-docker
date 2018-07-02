/**
 * Copyright (c) 2018, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.docker.app;

import com.powsybl.gse.app.GseApp;
import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * @author Sebastien Murgey <sebastien.murgey at rte-france.com>
 */
public final class FldApp {

    private FldApp() {
    }

    public static void main(String[] args) {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();

        GseApp.main(args);
    }
}
