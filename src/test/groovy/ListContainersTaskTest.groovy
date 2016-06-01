

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertTrue

class ListContainersTaskTest {
    @Test
    public void canAddPsTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('dockerPs', type: ListContainersTask)
        assertTrue(task instanceof ListContainersTask)
    }

    @Test
    public void canListContainers() {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('dockerPs', type: ListContainersTask)

    }
}
