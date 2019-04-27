package com.example.i_project

import android.util.Log
import com.example.i_project.data.ProjectRepository
import io.reactivex.Observable
import ru.surfstudio.standard.domain.project.Task
import javax.inject.Inject
import io.reactivex.subjects.PublishSubject



class ProjectInteractorImp @Inject constructor(private val projectRepository: ProjectRepository):ProjectInteractor {
    private val completeTaskSubject = PublishSubject.create<Task>()
    override fun subscribeToCompleteTask(): PublishSubject<Task> {
        return completeTaskSubject
    }

    //TODO реализовать запросы в бд
    override fun completeTask(taskToComplete: Task) {
        completeTaskSubject.onNext(taskToComplete)
    }

    override fun loadTask(taskId: Long?): Observable<Task> {
        return projectRepository.loadTask(taskId)
    }

    override fun loadTasks(projectId: Long): Observable<List<Task>> {
        return  projectRepository.loadTasks(projectId)
    }
}