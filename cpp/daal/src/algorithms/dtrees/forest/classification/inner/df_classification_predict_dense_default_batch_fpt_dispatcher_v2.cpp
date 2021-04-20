/* file: df_classification_predict_dense_default_batch_fpt_dispatcher_v2.cpp */
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
//  Implementation of decision forest classification prediction algorithm container -- a class
//  that contains fast decision forest prediction kernels
//  for supported architectures.
//--
*/

#include "df_classification_predict_dense_default_batch_container_v2.h"

namespace daal
{
namespace algorithms
{
__DAAL_INSTANTIATE_DISPATCH_CONTAINER(decision_forest::classification::prediction::interface2::BatchContainer, batch, DAAL_FPTYPE,
                                      decision_forest::classification::prediction::defaultDense)
}
} // namespace daal