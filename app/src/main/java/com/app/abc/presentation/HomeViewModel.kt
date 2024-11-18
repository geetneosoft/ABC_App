package com.app.abc.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.abc.data.error_handling.ResponseHandler
import com.app.abc.data.model.News
import com.app.abc.domain.model.Category
import com.app.abc.domain.model.Filter
import com.app.abc.domain.model.Occurrence
import com.app.abc.domain.usecase.AnalysisUseCase
import com.app.abc.domain.usecase.FilterCategoryWiseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val filterCategoryWiseUseCase: FilterCategoryWiseUseCase,
    private val analysisUseCase: AnalysisUseCase
) : ViewModel(){

    companion object{
        private const val TAG = "HomeViewModel"
    }

    private val _bottomSheetState = MutableStateFlow(false)
    val bottomSheetState = _bottomSheetState

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery

    private val _charAnalysis = MutableStateFlow<Occurrence>(Occurrence(0, emptyMap()))
    val charAnalysis  = _charAnalysis

    private val _newsList: MutableStateFlow<News?> = MutableStateFlow(News(emptyList()))
    val newsList: StateFlow<News?> = _newsList

    private val _currentCategory: MutableStateFlow<Category> = MutableStateFlow(Category.Business)


    private fun getListOfData(){
        viewModelScope.launch{
            when(val response = filterCategoryWiseUseCase.execute(Filter(_searchQuery.value,_currentCategory.value))){
                is ResponseHandler.Success<*> -> {
                    if(response.data is News){
                        _newsList.emit(response.data)
                    }else _newsList.emit(News(emptyList()))
                }
                is ResponseHandler.Error<Throwable> -> {
                    _newsList.emit(null)
                }
            }
        }

    }

    val getCarouselData = Category.entries.toMutableList()

    fun carouselChanged(position: Int) {
        _currentCategory.value = Category.entries[position]
        _searchQuery.value = ""
        getListOfData()
    }

    fun onQueryChanged(newText: String) {
        _searchQuery.value=newText
        getListOfData()
    }

    fun getAnalysisOccurrence(){
        viewModelScope.launch{
            val data = analysisUseCase.execute(_newsList.value)
            _charAnalysis.emit(data)
        }
    }
    fun bottomSheetState(state:Boolean){
        _bottomSheetState.value = state
    }
}