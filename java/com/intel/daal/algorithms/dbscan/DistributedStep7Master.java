/* file: DistributedStep7Master.java */
/*******************************************************************************
* Copyright 2014-2021 Intel Corporation
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
*******************************************************************************/

/**
 * @ingroup dbscan_distributed
 * @{
 */
package com.intel.daal.algorithms.dbscan;

import com.intel.daal.utils.*;
import com.intel.daal.algorithms.AnalysisDistributed;
import com.intel.daal.algorithms.Precision;
import com.intel.daal.services.DaalContext;

/**
 * <a name="DAAL-CLASS-ALGORITHMS__DBSCAN__DISTRIBUTEDSTEP7MASTER"></a>
 * @brief Runs the DBSCAN algorithm in the seventh step of the distributed processing mode
 */
public class DistributedStep7Master extends AnalysisDistributed {
    public  DistributedStep7MasterInput input;     /*!< %Input data */
    public  Method                     method;     /*!< Computation method for the algorithm */
    private Precision                  precision;  /*!< Precision of intermediate computations */

    /** @private */
    static {
        LibUtils.loadLibrary();
    }

    /**
     * Constructs the DBSCAN algorithm by copying input objects and parameters
     * of another DBSCAN algorithm
     * @param context   Context to manage the algorithm
     * @param other     An algorithm to be used as the source to initialize the input objects
     *                  and parameters of the algorithm
     */
    public DistributedStep7Master(DaalContext context, DistributedStep7Master other) {
        super(context);
        this.method = other.method;
        precision = other.precision;

        this.cObject = cClone(other.cObject, precision.getValue(), this.method.getValue());

        input     = new DistributedStep7MasterInput(getContext(), cGetInput     (cObject, precision.getValue(), method.getValue()));
    }

    /**
     * Constructs the DBSCAN algorithm
     * @param context         Context to manage the algorithm
     * @param cls             Data type to use in intermediate computations for the algorithm,
     *                        Double.class or Float.class
     * @param method          Computation method of the algorithm, @ref Method
     */
    public DistributedStep7Master(DaalContext context, Class<? extends Number> cls, Method method) {
        super(context);

        this.method = method;
        if (cls != Double.class && cls != Float.class) {
            throw new IllegalArgumentException("type unsupported");
        }

        if (this.method != Method.defaultDense) {
            throw new IllegalArgumentException("method unsupported");
        }

        if (cls == Double.class) {
            precision = Precision.doublePrecision;
        } else {
            precision = Precision.singlePrecision;
        }

        this.cObject = cInit(precision.getValue(), this.method.getValue());

        input = new DistributedStep7MasterInput(getContext(), cGetInput(cObject, precision.getValue(), method.getValue()));
    }

    /**
     * Runs the DBSCAN algorithm
     * @return  Partial results of the DBSCAN algorithm
     */
    @Override
    public DistributedPartialResultStep7 compute() {
        super.compute();
        return new DistributedPartialResultStep7(getContext(), cGetPartialResult(cObject, precision.getValue(), method.getValue()));
    }

    /**
     * Registers user-allocated memory to store partial results of the DBSCAN algorithm
     * @param partialResult         Structure to store partial results of the DBSCAN algorithm
     */
    public void setPartialResult(DistributedPartialResultStep7 partialResult) {
        cSetPartialResult(cObject, precision.getValue(), method.getValue(), partialResult.getCObject());
    }

    /**
     * Returns the newly allocated DBSCAN algorithm with a copy of input objects
     * and parameters of this DBSCAN algorithm
     * @param context   Context to manage the algorithm
     *
     * @return The newly allocated algorithm
     */
    @Override
    public DistributedStep7Master clone(DaalContext context) {
        return new DistributedStep7Master(context, this);
    }

    private native long cInit(int precision, int method);
    private native long cGetInput(long addr, int precision, int method);
    private native long cGetPartialResult(long addr, int precision, int method);
    private native void cSetPartialResult(long addr, int precision, int method, long cResult);
    private native long cClone(long addr, int precision, int method);
}
/** @} */