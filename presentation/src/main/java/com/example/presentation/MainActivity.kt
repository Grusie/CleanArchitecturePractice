package com.example.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.presentation.base.BaseActivity
import com.example.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.recyclerView.adapter = GithubAdapter()

        binding.submitBtn.setOnClickListener {
            val owner = binding.ownerEditText.text.toString()
            if(owner.isNotEmpty()) viewModel.getGithubRepositories(owner)
        }

        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.githubRepositories.observe(this) {
            (binding.recyclerView.adapter as GithubAdapter).setItems(it)
        }
    }
}