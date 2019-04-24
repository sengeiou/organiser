package com.example.f_project.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.f_project.fragments.complete.CompleteTasksFragmentView
import com.example.f_project.fragments.unfinished.UnfinishedTasksFragmentView

class TasksPagerAdapter(fm: FragmentManager,val projectId:Long) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> UnfinishedTasksFragmentView.newInstance(projectId)
            else -> CompleteTasksFragmentView()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "НЕЗАВЕРШЕННЫЕ"
            else -> "ЗАВЕРШЕННЫЕ"
        }
    }
}