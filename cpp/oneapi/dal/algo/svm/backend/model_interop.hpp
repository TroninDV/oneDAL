/*******************************************************************************
* Copyright 2020-2021 Intel Corporation
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

#pragma once

#include "oneapi/dal/backend/interop/common.hpp"
#include <daal/include/algorithms/multi_class_classifier/multi_class_classifier_model.h>

namespace oneapi::dal::svm::backend {

namespace daal_multiclass = daal::algorithms::multi_class_classifier;

class model_interop : public base {
public:
    virtual ~model_interop() = default;
};

template <typename DaalModel>
class model_interop_impl : public model_interop {
public:
    model_interop_impl(DaalModel& model) : daal_model_(model) {}

    const DaalModel get_model() const {
        return daal_model_;
    }

private:
    DaalModel daal_model_;
};

using model_interop_cls = model_interop_impl<daal_multiclass::ModelPtr>;

} // namespace oneapi::dal::svm::backend