package com.jask.codelissianassignment.screens.movies_list_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems


@Composable
fun NewsListScreen() {

    val viewModel: NewsListViewModel = hiltViewModel()

    val articles = viewModel.getBreakingNews().collectAsLazyPagingItems()

    Surface(modifier = Modifier.padding(10.dp)) {

        articles.apply {
            //can manage states here
            when {
                loadState.append is LoadState.Loading -> {
                    ProgressBar()
                }
            }
        }

        Column {

        LazyColumn {
                items(count = articles.itemCount) { index ->
                    MovieListLazyColumn(
                        title = articles[index]?.title,
                        content = articles[index]?.content
                    )
                }
        }
        }
    }
}

//composable
@Composable
fun ProgressBar() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator()
    }
}

@Composable
fun MovieListLazyColumn(
    title: String?,
    content: String?
){

    Column(
        modifier = Modifier.padding(top = 4.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "$title",
            style = MaterialTheme.typography.titleLarge
        )
        Text(text = "$content",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(2.dp))
        Divider(modifier = Modifier.height(2.dp))
    }
}

@Composable
@Preview
fun NewsListPreview(){
    //NewsListScreen()
    //MovieListLazyColumn()
}