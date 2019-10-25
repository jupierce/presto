/*
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
package io.prestosql.orc;

import io.airlift.units.DataSize;

import static io.airlift.units.DataSize.Unit.MEGABYTE;
import static java.util.Objects.requireNonNull;

public class OrcReaderOptions
{
    private static final boolean DEFAULT_BLOOM_FILTERS_ENABLED = false;
    private static final DataSize DEFAULT_MAX_MERGE_DISTANCE = new DataSize(1, MEGABYTE);
    private static final DataSize DEFAULT_MAX_BUFFER_SIZE = new DataSize(8, MEGABYTE);
    private static final DataSize DEFAULT_TINY_STRIPE_THRESHOLD = new DataSize(8, MEGABYTE);
    private static final DataSize DEFAULT_STREAM_BUFFER_SIZE = new DataSize(8, MEGABYTE);
    private static final DataSize DEFAULT_MAX_BLOCK_SIZE = new DataSize(16, MEGABYTE);
    private static final boolean DEFAULT_LAZY_READ_SMALL_RANGES = true;

    private final boolean bloomFiltersEnabled;

    private final DataSize maxMergeDistance;
    private final DataSize maxBufferSize;
    private final DataSize tinyStripeThreshold;
    private final DataSize streamBufferSize;
    private final DataSize maxBlockSize;
    private final boolean lazyReadSmallRanges;

    public OrcReaderOptions()
    {
        bloomFiltersEnabled = DEFAULT_BLOOM_FILTERS_ENABLED;
        maxMergeDistance = DEFAULT_MAX_MERGE_DISTANCE;
        maxBufferSize = DEFAULT_MAX_BUFFER_SIZE;
        tinyStripeThreshold = DEFAULT_TINY_STRIPE_THRESHOLD;
        streamBufferSize = DEFAULT_STREAM_BUFFER_SIZE;
        maxBlockSize = DEFAULT_MAX_BLOCK_SIZE;
        lazyReadSmallRanges = DEFAULT_LAZY_READ_SMALL_RANGES;
    }

    private OrcReaderOptions(
            boolean bloomFiltersEnabled,
            DataSize maxMergeDistance,
            DataSize maxBufferSize,
            DataSize tinyStripeThreshold,
            DataSize streamBufferSize,
            DataSize maxBlockSize,
            boolean lazyReadSmallRanges)
    {
        this.maxMergeDistance = requireNonNull(maxMergeDistance, "maxMergeDistance is null");
        this.maxBufferSize = requireNonNull(maxBufferSize, "maxBufferSize is null");
        this.tinyStripeThreshold = requireNonNull(tinyStripeThreshold, "tinyStripeThreshold is null");
        this.streamBufferSize = requireNonNull(streamBufferSize, "streamBufferSize is null");
        this.maxBlockSize = requireNonNull(maxBlockSize, "maxBlockSize is null");
        this.lazyReadSmallRanges = requireNonNull(lazyReadSmallRanges, "lazyReadSmallRanges is null");
        this.bloomFiltersEnabled = bloomFiltersEnabled;
    }

    public boolean isBloomFiltersEnabled()
    {
        return bloomFiltersEnabled;
    }

    public DataSize getMaxMergeDistance()
    {
        return maxMergeDistance;
    }

    public DataSize getMaxBufferSize()
    {
        return maxBufferSize;
    }

    public DataSize getTinyStripeThreshold()
    {
        return tinyStripeThreshold;
    }

    public DataSize getStreamBufferSize()
    {
        return streamBufferSize;
    }

    public DataSize getMaxBlockSize()
    {
        return maxBlockSize;
    }

    public boolean isLazyReadSmallRanges()
    {
        return lazyReadSmallRanges;
    }

    public OrcReaderOptions withBloomFiltersEnabled(boolean bloomFiltersEnabled)
    {
        return new OrcReaderOptions(
                bloomFiltersEnabled,
                maxMergeDistance,
                maxBufferSize,
                tinyStripeThreshold,
                streamBufferSize,
                maxBlockSize,
                lazyReadSmallRanges);
    }

    public OrcReaderOptions withMaxMergeDistance(DataSize maxMergeDistance)
    {
        return new OrcReaderOptions(
                bloomFiltersEnabled,
                maxMergeDistance,
                maxBufferSize,
                tinyStripeThreshold,
                streamBufferSize,
                maxBlockSize,
                lazyReadSmallRanges);
    }

    public OrcReaderOptions withMaxBufferSize(DataSize maxBufferSize)
    {
        return new OrcReaderOptions(
                bloomFiltersEnabled,
                maxMergeDistance,
                maxBufferSize,
                tinyStripeThreshold,
                streamBufferSize,
                maxBlockSize,
                lazyReadSmallRanges);
    }

    public OrcReaderOptions withTinyStripeThreshold(DataSize tinyStripeThreshold)
    {
        return new OrcReaderOptions(
                bloomFiltersEnabled,
                maxMergeDistance,
                maxBufferSize,
                tinyStripeThreshold,
                streamBufferSize,
                maxBlockSize,
                lazyReadSmallRanges);
    }

    public OrcReaderOptions withStreamBufferSize(DataSize streamBufferSize)
    {
        return new OrcReaderOptions(
                bloomFiltersEnabled,
                maxMergeDistance,
                maxBufferSize,
                tinyStripeThreshold,
                streamBufferSize,
                maxBlockSize,
                lazyReadSmallRanges);
    }

    public OrcReaderOptions withMaxReadBlockSize(DataSize maxBlockSize)
    {
        return new OrcReaderOptions(
                bloomFiltersEnabled,
                maxMergeDistance,
                maxBufferSize,
                tinyStripeThreshold,
                streamBufferSize,
                maxBlockSize,
                lazyReadSmallRanges);
    }

    // TODO remove config option once efficacy is proven
    @Deprecated
    public OrcReaderOptions withLazyReadSmallRanges(boolean lazyReadSmallRanges)
    {
        return new OrcReaderOptions(
                bloomFiltersEnabled,
                maxMergeDistance,
                maxBufferSize,
                tinyStripeThreshold,
                streamBufferSize,
                maxBlockSize,
                lazyReadSmallRanges);
    }
}
