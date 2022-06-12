import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.StepsDefinition;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.*;

public class StoryRunner extends JUnitStories {

    @Override
    // Creation Story Loader
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(codeLocationFromClass(this.getClass()))
                        .withFormats(CONSOLE, TXT, HTML));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new StepsDefinition());
    }

    @Override
    protected List<String> storyPaths() {
        StoryFinder finder = new StoryFinder();
        return finder.findPaths(codeLocationFromClass(this.getClass()).getFile(), Collections.singletonList("**/*.story"), Arrays.asList(""));
    }
}