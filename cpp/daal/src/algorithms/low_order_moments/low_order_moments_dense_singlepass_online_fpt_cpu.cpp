/* file: low_order_moments_dense_singlepass_online_fpt_cpu.cpp */
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

/*
//++
//  Implementation of low order moments kernel.
//--
*/

#include "src/externals/service_ittnotify.h"
DAAL_ITTNOTIFY_DOMAIN(lom.dense.singlepass.online);

#include "src/algorithms/low_order_moments/low_order_moments_container.h"
#include "src/algorithms/low_order_moments/low_order_moments_online_impl.i"

namespace daal
{
namespace algorithms
{
namespace low_order_moments
{
namespace interface1
{
template class OnlineContainer<DAAL_FPTYPE, singlePassDense, DAAL_CPU>;
}
namespace internal
{
template class LowOrderMomentsOnlineKernel<DAAL_FPTYPE, singlePassDense, DAAL_CPU>;
}
} // namespace low_order_moments
} // namespace algorithms
} // namespace daal