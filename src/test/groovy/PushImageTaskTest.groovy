

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertTrue

class PushImageTaskTest {
    @Test
    public void canAddTagTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('dockerPush', type: PushImageTask)
        assertTrue(task instanceof PushImageTask)
    }

}
