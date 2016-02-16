/*
 * Copyright 2016 Open Networking Laboratory
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
package org.onosproject.store.primitives.impl;

import org.onosproject.store.primitives.DistributedPrimitiveCreator;
import org.onosproject.store.primitives.TransactionId;
import org.onosproject.store.service.TransactionContext;
import org.onosproject.store.service.TransactionContextBuilder;
/**
 * Default Transaction Context Builder.
 */
public class NewDefaultTransactionContextBuilder extends TransactionContextBuilder {

    private final TransactionId transactionId;
    private final DistributedPrimitiveCreator base;
    private final DistributedPrimitiveCreator federated;
    private final TransactionCoordinator transactionCoordinator;

    public NewDefaultTransactionContextBuilder(TransactionId transactionId,
            DistributedPrimitiveCreator base,
            DistributedPrimitiveCreator federated,
            TransactionCoordinator transactionCoordinator) {
        this.transactionId = transactionId;
        this.base = base;
        this.federated = federated;
        this.transactionCoordinator = transactionCoordinator;
    }

    @Override
    public TransactionContext build() {
        return new NewDefaultTransactionContext(transactionId,
                this.partitionsDisabled() ? base : federated,
                transactionCoordinator);
    }
}