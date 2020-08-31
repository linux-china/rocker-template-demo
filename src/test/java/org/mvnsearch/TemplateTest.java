package org.mvnsearch;

import com.fizzed.rocker.BindableRockerModel;
import com.fizzed.rocker.Rocker;
import com.fizzed.rocker.RockerModel;
import org.junit.jupiter.api.Test;

/**
 * template test
 *
 * @author linux_china
 */
public class TemplateTest {

    /**
     * template render test
     */
    @Test
    public void testApp() {
        RockerModel model = templates.Index.template("good", "title");
        System.out.println(model.render().toString());
        BindableRockerModel model2 = Rocker.template("templates/Index.rocker.html").bind("title", "welcome").bind("content", "demo");
        System.out.println(model2.render().toString());
    }
}
