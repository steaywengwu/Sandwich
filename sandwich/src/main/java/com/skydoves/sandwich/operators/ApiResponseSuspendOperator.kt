/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.sandwich.operators

import com.skydoves.sandwich.ApiResponse

/**
 * @author skydoves (Jaewoong Eum)
 *
 * ApiResponseSuspendOperator operates on an [ApiResponse] which should be handled in the suspension scope.
 * This allows you to handle success and error response instead of the [com.skydoves.sandwich.suspendOnSuccess],
 * [com.skydoves.sandwich.suspendOnError], [com.skydoves.sandwich.suspendOnException] transformers.
 * This operator can be applied globally as a singleton instance, or on each [ApiResponse] one by one.
 */
abstract class ApiResponseSuspendOperator<T> : SandwichOperator {

  /**
   * Operates the [ApiResponse.Success] for handling successful responses if the request succeeds.
   *
   * @param apiResponse The successful response.
   */
  abstract suspend fun onSuccess(apiResponse: ApiResponse.Success<T>)

  /**
   * Operates the [ApiResponse.Failure.Error] for handling error responses if the request failed.
   *
   * @param apiResponse The failed response.
   */
  abstract suspend fun onError(apiResponse: ApiResponse.Failure.Error<T>)

  /**
   * Operates the [ApiResponse.Failure.Exception] for handling exception responses if the request get an exception.
   *
   * @param apiResponse The exception response.
   */
  abstract suspend fun onException(apiResponse: ApiResponse.Failure.Exception<T>)
}
