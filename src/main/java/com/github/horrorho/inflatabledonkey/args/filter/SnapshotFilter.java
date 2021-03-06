/*
 * The MIT License
 *
 * Copyright 2016 Ahseya.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.horrorho.inflatabledonkey.args.filter;

import com.github.horrorho.inflatabledonkey.data.backup.Snapshot;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import javax.annotation.concurrent.Immutable;

/**
 *
 * @author Ahseya
 */
@Immutable
public final class SnapshotFilter implements Predicate<Snapshot> {

    private final Optional<Long> dateMin;

    public SnapshotFilter(Optional<Long> dateMin) {
        this.dateMin = Objects.requireNonNull(dateMin);
    }

    @Override
    public boolean test(Snapshot snapshot) {
        long timestamp = snapshot.timestamp().getEpochSecond();
        return dateMin.map(v -> timestamp >= v).orElse(true);
    }
}
