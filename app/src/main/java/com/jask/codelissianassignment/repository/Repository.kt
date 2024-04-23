package com.jask.codelissianassignment.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.jask.codelissianassignment.network.ApiService
import com.jask.codelissianassignment.paging.NewsSource
import javax.inject.Inject


class Repository @Inject constructor(private val apiService: ApiService) {

    fun getNews() = Pager(
        config = PagingConfig(
            pageSize = 10,
        ),
        pagingSourceFactory = {
            NewsSource(apiService)
        }
    ).flow
}