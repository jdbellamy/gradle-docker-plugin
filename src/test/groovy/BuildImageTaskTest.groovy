

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertTrue

class BuildImageTaskTest {
    @Test
    public void canAddBuildTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('dockerBuild', type: BuildImageTask)
        assertTrue(task instanceof BuildImageTask)
    }

    @Test
    public void canBuildImage() {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('dockerBuild', type: BuildImageTask)
    }
}
