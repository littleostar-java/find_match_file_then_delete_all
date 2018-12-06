package demo;

import util.StaticUtilTool;

import java.io.File;
import java.io.IOException;

public class Sample {

    public static void main(String[] args) throws IOException {
        String root_path = "C:" + File.separator + "WebstormProjects";

        StaticUtilTool tool = new StaticUtilTool();
        tool.do_delete_by_path(root_path, "node_modules");
    }

}
