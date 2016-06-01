

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import static org.junit.Assert.*

class DockerPluginTest {
    @Test
    public void dockerPluginAddsDockerTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        project.pluginManager.apply 'docker'

        assertTrue(project.tasks.dockerPs instanceof ListContainersTask)
        assertTrue(project.tasks.dockerBuild instanceof BuildImageTask)
        assertTrue(project.tasks.dockerTag instanceof TagImageTask)
        assertTrue(project.tasks.dockerPush instanceof PushImageTask)
    }
}
