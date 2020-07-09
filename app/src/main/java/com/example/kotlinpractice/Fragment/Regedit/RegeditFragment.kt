package com.example.kotlinpractice.Fragment.Regedit

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinpractice.R

class RegeditFragment : Fragment() {

    companion object {
        fun newInstance() = RegeditFragment()
    }

    private lateinit var viewModel: RegeditViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.regedit_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegeditViewModel::class.java)
        // TODO: Use the ViewModel
    }

}