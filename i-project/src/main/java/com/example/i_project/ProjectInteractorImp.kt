package com.example.i_project

import android.annotation.SuppressLint
import android.util.Log
import com.example.i_project.data.ProjectRepository
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.PublishSubject
import ru.surfstudio.standard.domain.project.Task
import javax.inject.Inject


class ProjectInteractorImp @Inject constructor(private val projectRepository: ProjectRepository)
    : ProjectInteractor {
    override fun subscribeToUpdateTasks(): PublishSubject<Boolean> {
        return updateProjectProgressSubject
    }

    private var projectId: Long? = null
    private val PROJECT_INTERACTOR = "ProjectInteractor"

    override fun calculateProjectsProgress(projectId: Long): Observable<Int>? {
        this.projectId = projectId
        val completedTaskObservable = projectRepository.loadCompletedTasks(projectId)
        val unfinishedTaskObservable = projectRepository.loadUnfinishedTasks(projectId)
        val projectProgressObservable = Observable.combineLatest(completedTaskObservable,
                unfinishedTaskObservable,
                object : BiFunction<List<Task>, List<Task>, Int> {
                    override fun apply(completedTask: List<Task>, unfinishedTask: List<Task>): Int {
                        return calculateProjectsPercent(completedTask, unfinishedTask)
                    }
                })
        return projectProgressObservable
    }

    private fun calculateProjectsPercent(completedTask: List<Task>, unfinishedTask: List<Task>): Int {
        val completedTaskCount = completedTask.size
        val unfinishedTaskCount = unfinishedTask.size
        val allTaskCount = completedTaskCount + unfinishedTaskCount
        val projectProgressPercent = completedTaskCount * 100 / allTaskCount
        return projectProgressPercent
    }


    override fun deleteTask(taskToDelete: Task) {
        projectRepository.deleteTask(taskToDelete)
    }

    private val completeTaskSubject = PublishSubject.create<Task>()
    private val unfinishTaskSubject = PublishSubject.create<Task>()
    private val updateProjectProgressSubject = PublishSubject.create<Boolean>()

    @SuppressLint("LogNotTimber")
    override fun doNotCompleteTask(taskToUnfinish: Task) {
        taskToUnfinish.isCompleted = false
        projectRepository.doNotCompleteTask(taskToUnfinish)
                .subscribe({
                    unfinishTaskSubject.onNext(taskToUnfinish)
                    updateProjectProgressSubject.onNext(true)
                }, {
                    Log.e(PROJECT_INTERACTOR, it.message)
                })

    }


    override fun subscribeToUnfinishedTask(): PublishSubject<Task> {
        return unfinishTaskSubject
    }

    override fun loadCompletedTasks(projectId: Long): Observable<List<Task>> {
        return projectRepository.loadCompletedTasks(projectId)
    }

    override fun subscribeToCompleteTask(): PublishSubject<Task> {
        return completeTaskSubject
    }

    @SuppressLint("LogNotTimber")
    override fun completeTask(taskToComplete: Task) {
        taskToComplete.isCompleted = true
        projectRepository.completeTask(taskToComplete)
                .subscribe({
                    completeTaskSubject.onNext(taskToComplete)
                    updateProjectProgressSubject.onNext(true)
                }, {
                    Log.e(PROJECT_INTERACTOR, it.message)
                })

    }

    override fun loadTask(taskId: Long?): Observable<Task> {
        return projectRepository.loadTask(taskId)
    }

    override fun loadUnfinishedTasks(projectId: Long): Observable<List<Task>> {
        return projectRepository.loadUnfinishedTasks(projectId)
    }
}