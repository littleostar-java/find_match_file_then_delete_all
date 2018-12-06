package demo;

import util.StaticUtilTool;

import java.io.File;
import java.io.IOException;

public class Sample {

    // 1 need a root_path
    // 2 default delete name is "node_modules"

    public static void main(String[] args) throws IOException {
        String root_path = "C:" + File.separator + "WebstormProjects";

        StaticUtilTool tool = new StaticUtilTool();
        tool.do_delete_by_path( root_path, "node_modules"); // it's ok

        // ---------------------------------------------------------------------------
        // test, result is success
//        String del_name = "新建文本文档.txt"; // like demo
//        tool.delete_NodeModule_ByPath(root_path, del_name);
        // ---------------------------------------------------------------------------

    }

}
