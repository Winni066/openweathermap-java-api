/*
 * Copyright (c) 2019 Alexey Zinchenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.prominence.openweathermap.api.impl;

import com.github.prominence.openweathermap.api.MultipleResultCurrentWeatherAsyncRequestTerminator;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import com.github.prominence.openweathermap.api.model.Weather;
import com.github.prominence.openweathermap.api.utils.RequestUtils;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MultipleResultCurrentWeatherAsyncRequestTerminatorImpl implements MultipleResultCurrentWeatherAsyncRequestTerminator {

    private RequestUrlBuilder urlBuilder;
    private UnitSystem unitSystem;

    MultipleResultCurrentWeatherAsyncRequestTerminatorImpl(RequestUrlBuilder urlBuilder, UnitSystem unitSystem) {
        this.urlBuilder = urlBuilder;
        this.unitSystem = unitSystem;
    }

    @Override
    public CompletableFuture<List<Weather>> asJava() {
        return CompletableFuture.supplyAsync(() -> new CurrentWeatherResponseMapper(unitSystem).getList(getRawResponse()));
    }

    @Override
    public CompletableFuture<String> asJSON() {
        return CompletableFuture.supplyAsync(this::getRawResponse);
    }

    @Override
    public CompletableFuture<String> asXML() {
        urlBuilder.addRequestParameter("mode", "xml");
        return CompletableFuture.supplyAsync(this::getRawResponse);
    }

    @Override
    public CompletableFuture<String> asHTML() {
        urlBuilder.addRequestParameter("mode", "html");
        return CompletableFuture.supplyAsync(this::getRawResponse);
    }

    private String getRawResponse() {
        return RequestUtils.getResponse(urlBuilder.buildUrl());
    }
}
