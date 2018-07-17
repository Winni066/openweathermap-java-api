/*
 * Copyright (c) 2018 Alexey Zinchenko
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

package by.prominence.openweathermap.api.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Objects;

public class Rain {

    @JSONField(name = "3h")
    // Rain volume for the last 3 hours
    private byte rainVolumeLast3Hrs;

    public byte getRainVolumeLast3Hrs() {
        return rainVolumeLast3Hrs;
    }

    public void setRainVolumeLast3Hrs(byte rainVolumeLast3Hrs) {
        this.rainVolumeLast3Hrs = rainVolumeLast3Hrs;
    }

    public String getUnit() {
        return "mm";
    }

    @Override
    public String toString() {
        return "Rain(last 3 hrs): " + rainVolumeLast3Hrs + ' ' + getUnit();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rain rain = (Rain) o;
        return rainVolumeLast3Hrs == rain.rainVolumeLast3Hrs;
    }

    @Override
    public int hashCode() {

        return Objects.hash(rainVolumeLast3Hrs);
    }
}