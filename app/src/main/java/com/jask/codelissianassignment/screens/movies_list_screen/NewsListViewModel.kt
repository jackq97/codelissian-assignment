package com.jask.codelissianassignment.screens.movies_list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.jask.codelissianassignment.model.Article
import com.jask.codelissianassignment.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class NewsListViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    fun getBreakingNews(): Flow<PagingData<Article>> = repository.getNews().cachedIn(viewModelScope)
}