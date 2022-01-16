package com.ddona.jetpack.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ddona.jetpack.model.Passenger

class PassengerDataSource(
    private val passengerApi: PassengerApi
) : PagingSource<Int, Passenger>() {
    override fun getRefreshKey(state: PagingState<Int, Passenger>): Int? {
        return state.anchorPosition?.let { position ->
            val anchorPage = state.closestPageToPosition(position)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Passenger> {
        return try {
            val nextPage = params.key ?: 0
            val response = passengerApi.getPassengerData(nextPage)
            LoadResult.Page(
                data = response.data,
                prevKey = if (nextPage > 0) nextPage - 1 else null,
                nextKey = if (nextPage < response.totalPages) nextPage + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}