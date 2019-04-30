package com.example.i_project

import com.example.i_project.data.ProjectRepository
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import ru.surfstudio.standard.domain.project.Task
import javax.inject.Inject


class ProjectInteractorImp @Inject constructor(private val projectRepository: ProjectRepository)
    : ProjectInteractor {
    override fun deleteTask(taskToDelete: Task) {
        projectRepository.deleteTask(taskToDelete)
    }

    private val completeTaskSubject = PublishSubject.create<Task>()
    private val unfinishTaskSubject = PublishSubject.create<Task>()

    override fun doNotCompleteTask(taskToUnfinish: Task) {
        taskToUnfinish.isCompleted = false
        projectRepository.doNotCompleteTask(taskToUnfinish)
        unfinishTaskSubject.onNext(taskToUnfinish)
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

    //TODO реализовать запросы в бд
    override fun completeTask(taskToComplete: Task) {
        taskToComplete.isCompleted = true
        projectRepository.completeTask(taskToComplete)
        completeTaskSubject.onNext(taskToComplete)
    }

    override fun loadTask(taskId: Long?): Observable<Task> {
        return projectRepository.loadTask(taskId)
    }

    override fun loadUnfinishedTasks(projectId: Long): Observable<List<Task>> {
        return projectRepository.loadUnfinishedTasks(projectId)
    }
}